package pe.edu.upc.llamapaytf.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.llamapaytf.dtos.TipoTransaccionDTO;
import pe.edu.upc.llamapaytf.entities.TipoTransaccion;
import pe.edu.upc.llamapaytf.servicesinterfaces.ITipoTransaccionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipotransacciones")
public class TipoTransaccionController {
    @Autowired
    private ITipoTransaccionService tS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('CLIENTE', 'ADMIN','FINANZAS','TESTER')")
    public List<TipoTransaccionDTO> listar() {
        return tS.list().stream().map(t -> {
            ModelMapper m = new ModelMapper();
            return m.map(t, TipoTransaccionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody TipoTransaccionDTO dto) {
        ModelMapper m = new ModelMapper();
        TipoTransaccion tt = m.map(dto, TipoTransaccion.class);
        tS.insert(tt);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody TipoTransaccionDTO dto) {
        ModelMapper m = new ModelMapper();
        TipoTransaccion t = m.map(dto, TipoTransaccion.class);
        tS.update(t);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id) {
        tS.delete(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','FINANZAS','TESTER')")
    public TipoTransaccionDTO buscarPorId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        TipoTransaccionDTO dto = m.map(tS.listID(id), TipoTransaccionDTO.class);
        return dto;
    }
}
