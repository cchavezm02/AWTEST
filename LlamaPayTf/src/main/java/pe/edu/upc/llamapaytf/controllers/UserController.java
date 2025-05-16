package pe.edu.upc.llamapaytf.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.llamapaytf.dtos.UserDTO;
import pe.edu.upc.llamapaytf.dtos.UsuarioInfoDTO;
import pe.edu.upc.llamapaytf.entities.User;
import pe.edu.upc.llamapaytf.servicesinterfaces.IUserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private IUserService uS;

    @GetMapping
   @PreAuthorize("hasAnyAuthority('ADMIN','TESTER')")
    public List<UsuarioInfoDTO> listar() {
        return uS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x,UsuarioInfoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        User u = m.map(dto, User.class);
        uS.insertar(u);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','TESTER')")
    public UsuarioInfoDTO buscarID(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        UsuarioInfoDTO dto=m.map(uS.listID(id),UsuarioInfoDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('CLIENTE')")
    public void modificar(@RequestBody UserDTO dto){
        ModelMapper m = new ModelMapper();
        User u = m.map(dto, User.class);
        uS.update(u);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id){ //eliminar todos los atributos que yo elija
        uS.delete(id);
    }

}
