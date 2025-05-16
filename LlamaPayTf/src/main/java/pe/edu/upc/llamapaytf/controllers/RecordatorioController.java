package pe.edu.upc.llamapaytf.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.llamapaytf.dtos.RecordatorioDTO;
import pe.edu.upc.llamapaytf.entities.Recordatorio;
import pe.edu.upc.llamapaytf.servicesinterfaces.IRecordatorioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recordatorios")
public class RecordatorioController {
    @Autowired
    private IRecordatorioService rS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('CLIENTE', 'ADMIN','TESTER')")
    public List<RecordatorioDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, RecordatorioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('CLIENTE')")
    public void insertar(@RequestBody RecordatorioDTO dto) {
        ModelMapper m = new ModelMapper();
        Recordatorio re = m.map(dto, Recordatorio.class);
        rS.insertar(re);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('CLIENTE')")
    public void modificar (@RequestBody RecordatorioDTO dto) {
        ModelMapper m = new ModelMapper();
        Recordatorio re = m.map(dto, Recordatorio.class);
        rS.update(re);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('CLIENTE')")
    public void eliminar(@PathVariable("id") int id) {
        rS.delete(id);
    }

    @GetMapping("/buscar/{recordatorio}")
    @PreAuthorize("hasAnyAuthority('CLIENTE', 'ADMIN','TESTER')")
    public List<RecordatorioDTO> buscarPorRecordatorio(@PathVariable("recordatorio") String recordatorio) {
        return rS.buscarPorRecordatorio(recordatorio).stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, RecordatorioDTO.class);
        }).collect(Collectors.toList());
    }
}
