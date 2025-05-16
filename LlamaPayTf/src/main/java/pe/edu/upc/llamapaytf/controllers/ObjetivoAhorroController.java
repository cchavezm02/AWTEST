package pe.edu.upc.llamapaytf.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.llamapaytf.dtos.MontoAhorradoxUsuarioDTO;
import pe.edu.upc.llamapaytf.dtos.ObjetivoAhorroDTO;
import pe.edu.upc.llamapaytf.dtos.ObjetivosPorMesDTO;
import pe.edu.upc.llamapaytf.entities.ObjetivoAhorro;
import pe.edu.upc.llamapaytf.servicesinterfaces.IObjetivoAhorroService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ObjetivoAhorrado")
public class ObjetivoAhorroController {
    @Autowired
    private IObjetivoAhorroService oS;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('CLIENTE')")
    public void registrar(@RequestBody ObjetivoAhorroDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        ObjetivoAhorro oa = modelMapper.map(dto, ObjetivoAhorro.class);
        oS.insertar(oa);
    }

    @PutMapping("/actualizar")
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('CLIENTE')")
    public void actualizar(@RequestBody ObjetivoAhorroDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        ObjetivoAhorro oa = modelMapper.map(dto, ObjetivoAhorro.class);
        oS.update(oa);
    }
    @DeleteMapping("/Eliminar/{id}")
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('CLIENTE')")
    public void eliminar(@PathVariable int id) {
        oS.deleteById(id);
    }
    
    @GetMapping
    @PreAuthorize("hasAnyAuthority('CLIENTE', 'ADMIN','FINANZAS','TESTER')")
    public List<ObjetivoAhorro> listar() {
        return oS.listar().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x,ObjetivoAhorro.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/usuario/{userId}")
    @PreAuthorize("hasAnyAuthority('ADMIN','FINANZAS','TESTER')")
    public List<ObjetivoAhorroDTO> buscarPorUsuario(@PathVariable int userId) {
        return oS.buscarPorUsuario(userId).stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x,ObjetivoAhorroDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/total-ahorrado-por-usuario")
    @PreAuthorize("hasAnyAuthority('ADMIN','FINANZAS','TESTER')")
    public List<MontoAhorradoxUsuarioDTO> obtenerTotales() {
        List<String[]> datos = oS.obtenerMontoAhorradoXUsuario();
        return datos.stream().map(registro -> {
            MontoAhorradoxUsuarioDTO dto = new MontoAhorradoxUsuarioDTO();
            dto.setNombreUsuario(registro[0]);
            dto.setMontoTotalAhorrado(Double.parseDouble(registro[1]));
            return dto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/objetivos-por-mes")
    @PreAuthorize("hasAnyAuthority('ADMIN','FINANZAS','TESTER')")
    public List<ObjetivosPorMesDTO> obtenerObjetivosPorMes() {
        List<String[]> datos = oS.contarObjetivosPorMes();
        return datos.stream().map(registro -> {
            ObjetivosPorMesDTO dto = new ObjetivosPorMesDTO();
            dto.setMes(registro[0].trim()); // trim para quitar espacios extra de TO_CHAR
            dto.setCantidadObjetivos(Long.parseLong(registro[1]));
            return dto;
        }).collect(Collectors.toList());
    }
}
