package pe.edu.upc.llamapaytf.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.llamapaytf.dtos.CategoriaMontoDTO;
import pe.edu.upc.llamapaytf.dtos.CategoryDTO;
import pe.edu.upc.llamapaytf.entities.Category;
import pe.edu.upc.llamapaytf.servicesinterfaces.ICategoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
public class CategoryController {

    @Autowired
    private ICategoryService cS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('CLIENTE', 'ADMIN','FINANZAS','TESTER')")
    public List<CategoryDTO> listar() {
        return cS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, CategoryDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody CategoryDTO dto) {
        ModelMapper m = new ModelMapper();
        Category c = m.map(dto, Category.class);
        cS.insertar(c);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','FINANZAS','TESTER')")
    public CategoryDTO buscarID(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        CategoryDTO dto=m.map(cS.listID(id),CategoryDTO.class);
        return dto;
    }

    @GetMapping("/montoxcategoria")
    @PreAuthorize("hasAnyAuthority('ADMIN','FINANZAS','TESTER')")
    public List<CategoriaMontoDTO>buscarMontoCategoria(@RequestParam(required = false) Integer mes, @RequestParam(required = false) Integer anio) {
        List<CategoriaMontoDTO> dtoLista=new ArrayList<>();
        List<String[]> lista = new ArrayList<>();
        if (mes != null && anio == null) { //busqueda para el mes del año actual
            int anioActual = java.time.LocalDate.now().getYear();  // Obtenemos el año actual
            lista = cS.FindMontoByCategoryMesAndAnio(mes, anioActual);  // Buscar por mes y el año actual
        }
        else if (mes != null && anio != null) { //busqueda por mes y año
            lista = cS.FindMontoByCategoryMesAndAnio(mes, anio);
        }
        else if (mes == null && anio != null) { //busqueda solo por año
            lista = cS.FindMontoByCategoryAnio(anio);  // Buscar por solo el año
        }
        else { //retorno de vacio
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Debes proporcionar al menos el mes o el año.");
        }
        for(String[] columna:lista){
            CategoriaMontoDTO dto=new CategoriaMontoDTO();
            dto.setNameCategory(columna[0]);
            dto.setTotalGasto(Double.parseDouble(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody CategoryDTO dto){
        ModelMapper m = new ModelMapper();
        Category c = m.map(dto, Category.class);
        cS.update(c);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id){
        cS.delete(id);
    }



}
