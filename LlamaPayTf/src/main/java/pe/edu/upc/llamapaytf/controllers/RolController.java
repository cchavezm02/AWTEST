package pe.edu.upc.llamapaytf.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.llamapaytf.dtos.RolDTO;
import pe.edu.upc.llamapaytf.entities.Rol;
import pe.edu.upc.llamapaytf.servicesinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
@PreAuthorize("hasAuthority('ADMIN')")

public class RolController {
    @Autowired
    private IRolService roS;

    @GetMapping
    public List<RolDTO> listar() {
        return roS.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("registrar")
    public void registrar(@RequestBody RolDTO rol) {
        ModelMapper modelMapper = new ModelMapper();
        Rol ros = modelMapper.map(rol, Rol.class);
        roS.insert(ros);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") int id) {
        roS.deleteById(id);
    }

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody RolDTO rol) {
        ModelMapper modelMapper = new ModelMapper();
        Rol r = modelMapper.map(rol, Rol.class);
        roS.update(r);
    }

    // Endpoint para obtener roles por TipoRol
    @GetMapping("/tipoRol/{tipoRol}")
    public List<RolDTO> obtenerRolesPorTipoRol(@PathVariable String tipoRol) {
        return roS.findRolesByTipoRol(tipoRol).stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }

    // Endpoint para obtener roles por user_id
    @GetMapping("/usuario/{userId}")
    public List<RolDTO> obtenerRolesPorUsuario(@PathVariable int userId) {
        return roS.findRolesByUserId(userId).stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }

}
