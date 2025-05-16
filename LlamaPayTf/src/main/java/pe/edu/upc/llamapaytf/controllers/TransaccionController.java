package pe.edu.upc.llamapaytf.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.llamapaytf.dtos.*;
import pe.edu.upc.llamapaytf.entities.TipoCuenta;
import pe.edu.upc.llamapaytf.entities.Transaccion;
import pe.edu.upc.llamapaytf.servicesinterfaces.ITransaccionService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transacciones")

public class TransaccionController {
    @Autowired
    private ITransaccionService transaccionS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('CLIENTE', 'ADMIN','TESTER','FINANZAS')")
    public List<TransaccionDTO> listar() {
        return transaccionS.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, TransaccionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("registrar")
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('CLIENTE')")
    public void registrar(@RequestBody TransaccionDTO tr) {
        ModelMapper modelMapper = new ModelMapper();
        Transaccion trs = modelMapper.map(tr, Transaccion.class);
        transaccionS.insert(trs);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('CLIENTE')")
    public void eliminar(@PathVariable("id") int id) {
        transaccionS.delete(id);
    }

    @PutMapping("/actualizar")
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('CLIENTE')")
    public void actualizar(@RequestBody TransaccionDTO trd) {
        ModelMapper modelMapper = new ModelMapper();
        Transaccion tr = modelMapper.map(trd, Transaccion.class);
        transaccionS.update(tr);
    }

    @GetMapping("/cantidad-por-fecha")
    @PreAuthorize("hasAnyAuthority('ADMIN','TESTER','FINANZAS')")
    public List<CantidadTransaccionesPorFechaDTO> cantidadTransaccionesPorFecha() {
        return transaccionS.contarTransaccionesPorFecha().stream().map(fila -> {
            CantidadTransaccionesPorFechaDTO dto = new CantidadTransaccionesPorFechaDTO();
            dto.setFecha(LocalDate.parse(fila[0]));
            dto.setCantidadTransacciones(Integer.parseInt((fila[1])));
            return dto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/monto-por-fecha")
    @PreAuthorize("hasAnyAuthority('ADMIN','TESTER','FINANZAS')")
    public List<MontoTransaccionesPorFechaDTO> montoTransaccionesPorFecha() {
        return transaccionS.sumarMontosPorFecha().stream().map(fila -> {
            MontoTransaccionesPorFechaDTO dto = new MontoTransaccionesPorFechaDTO();
            dto.setFecha(LocalDate.parse(fila[0]));
            dto.setMontoTotal(Double.valueOf((fila[1])));
            return dto;
        }).collect(Collectors.toList());
    }
    @GetMapping("/descripcion/{descripcion}")
    @PreAuthorize("hasAnyAuthority('ADMIN','TESTER','FINANZAS')")
    public List<TransaccionDTO> buscarPorDescripcion(@PathVariable("descripcion") String descripcion) {
        return transaccionS.findByDescripcion(descripcion).stream().map(t -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(t, TransaccionDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/transacciones-monto-mes-joao")
    @PreAuthorize("hasAnyAuthority('ADMIN','TESTER','FINANZAS')")
    public List<TransaccionInfoDTO> transaccionesPorMontoYMes(@RequestParam BigDecimal monto, @RequestParam int mes) {
        List<TransaccionInfoDTO> dtoLista = new ArrayList<>();
        List<String[]> lista = transaccionS.findByMontoMayorAndMes(monto, mes);
        for (String[] columna : lista) {
            TransaccionInfoDTO dto = new TransaccionInfoDTO();
            dto.setDescripcion(columna[1]);
            dto.setFechaTransaccion(LocalDate.parse(columna[2]));
            dto.setMontoTransaccion(new BigDecimal(columna[3]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/transacciones-descripcion-mes-joao")
    @PreAuthorize("hasAnyAuthority('ADMIN','TESTER','FINANZAS')")
    public List<TransaccionInfoDTO> transaccionesPorDescripcionYMes(@RequestParam String descripcion, @RequestParam int mes) {
        List<TransaccionInfoDTO> dtoLista = new ArrayList<>();
        List<String[]> lista = transaccionS.findByDescripcionAndMes(descripcion, mes);
        for (String[] columna : lista) {
            TransaccionInfoDTO dto = new TransaccionInfoDTO();
            dto.setDescripcion(columna[1]);
            dto.setMontoTransaccion(new BigDecimal(columna[3]));
            dto.setFechaTransaccion(LocalDate.parse(columna[2]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
