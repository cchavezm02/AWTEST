package pe.edu.upc.llamapaytf.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.llamapaytf.dtos.ServicioCategoriaDTO;
import pe.edu.upc.llamapaytf.dtos.ServicioDTO;
import pe.edu.upc.llamapaytf.entities.Servicio;
import pe.edu.upc.llamapaytf.servicesinterfaces.IServicioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/servicios")
public class ServicioController {
    @Autowired
    private IServicioService sS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('CLIENTE', 'ADMIN','FINANZAS','TESTER')")
    public List<ServicioDTO> listar() {
        return sS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, ServicioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/registra")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar (@RequestBody ServicioDTO dto) {
        ModelMapper m = new ModelMapper();
        Servicio s = m.map(dto, Servicio.class);
        sS.insertar(s);
    }

    @GetMapping("/busquedasPorCompania")
    @PreAuthorize("hasAnyAuthority( 'ADMIN','FINANZAS','TESTER')")
    public List<ServicioDTO>buscarCompania(@RequestParam String nameCompany){ //buscar servicio por compañia
        return sS.buscar(nameCompany).stream().map(z->{
            ModelMapper m = new ModelMapper();
            return m.map(z, ServicioDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/servicioxcategoria")
    @PreAuthorize("hasAnyAuthority('ADMIN','FINANZAS','TESTER')")
    public List<ServicioCategoriaDTO>cantidadServicioporCategoria() {
        List<ServicioCategoriaDTO> dtoLista=new ArrayList<>();
        List<String[]>lista=sS.FindServicebyCategory();
        for(String[] columna:lista){
            ServicioCategoriaDTO dto=new ServicioCategoriaDTO();
            dto.setNameCategory(columna[0]);
            dto.setCantidadServicio(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @PutMapping("/actualizar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody ServicioDTO dto){ //modificar los datos ingresados
        ModelMapper m = new ModelMapper();
        Servicio s = m.map(dto, Servicio.class);
        sS.update(s);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id){ //eliminar todos los atributos que yo elija
        sS.delete(id);
    }
}
