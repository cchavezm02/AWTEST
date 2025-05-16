package pe.edu.upc.llamapaytf.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.llamapaytf.dtos.TiendaDTO;
import pe.edu.upc.llamapaytf.entities.Tienda;
import pe.edu.upc.llamapaytf.servicesinterfaces.ITiendaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tiendas")
public class TiendaController {
    @Autowired
    private ITiendaService tS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('CLIENTE', 'ADMIN','FINANZAS','TESTER')")
    public List<TiendaDTO> listar() {
        return tS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, TiendaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody TiendaDTO dto) {
        ModelMapper m = new ModelMapper();
        Tienda t = m.map(dto, Tienda.class);
        tS.insertar(t);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody TiendaDTO dto) {
        ModelMapper m = new ModelMapper();
        Tienda t = m.map(dto, Tienda.class);
        tS.update(t);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id) {
        tS.delete(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','FINANZAS','TESTER')")
    public TiendaDTO buscarID(@PathVariable("id") int id) { //debe tener indicado que variable estara en la ruta
        ModelMapper m = new ModelMapper();
        TiendaDTO dto=m.map(tS.listarId(id),TiendaDTO.class);
        return dto;
    }
}
