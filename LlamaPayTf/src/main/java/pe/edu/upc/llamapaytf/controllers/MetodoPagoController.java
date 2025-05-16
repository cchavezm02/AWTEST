package pe.edu.upc.llamapaytf.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.llamapaytf.dtos.MetodoPagoDTO;
import pe.edu.upc.llamapaytf.entities.MetodoPago;
import pe.edu.upc.llamapaytf.servicesinterfaces.IMetodoPagoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/metodospagos")
public class MetodoPagoController {
    @Autowired
    private IMetodoPagoService mpS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('CLIENTE', 'ADMIN','FINANZAS','TESTER')")
    public List<MetodoPagoDTO> listar() {
        return mpS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, MetodoPagoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody MetodoPagoDTO dto) {
        ModelMapper m = new ModelMapper();
        MetodoPago mp = m.map(dto, MetodoPago.class);
        mpS.insertar(mp);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority( 'ADMIN','FINANZAS','TESTER')")
    public MetodoPagoDTO buscarID(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        MetodoPagoDTO dto=m.map(mpS.listId(id),MetodoPagoDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody MetodoPagoDTO dto){
        ModelMapper m = new ModelMapper();
        MetodoPago mp = m.map(dto, MetodoPago.class);
        mpS.update(mp);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id){
        mpS.delete(id);
    }

}
