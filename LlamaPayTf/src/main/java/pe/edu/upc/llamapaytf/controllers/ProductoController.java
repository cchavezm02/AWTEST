package pe.edu.upc.llamapaytf.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.llamapaytf.dtos.PrMetaCestaDTO;
import pe.edu.upc.llamapaytf.dtos.ProductoDTO;
import pe.edu.upc.llamapaytf.dtos.ProductoInfoDTO;
import pe.edu.upc.llamapaytf.entities.Producto;
import pe.edu.upc.llamapaytf.servicesinterfaces.IProductoService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private IProductoService pS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('CLIENTE', 'ADMIN','FINANZAS','TESTER')")
    public List<ProductoDTO> listar() {
        return pS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, ProductoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('CLIENTE')")
    public void insertar(@RequestBody ProductoDTO productoDTO) {
        ModelMapper m = new ModelMapper();
        Producto p = m.map(productoDTO, Producto.class);
        pS.insertar(p);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('CLIENTE')")
    public void modificar(@RequestBody ProductoDTO productoDTO) {
        ModelMapper m = new ModelMapper();
        Producto p = m.map(productoDTO, Producto.class);
        pS.update(p);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('CLIENTE')")
    public void eliminar(@PathVariable("id") int id) {
        pS.delete(id);
    }

    @GetMapping("/buscar/{producto}")
    @PreAuthorize("hasAnyAuthority('ADMIN','TESTER')")
    public List<ProductoDTO> buscarPorProducto(@PathVariable("producto") String producto) {
        return pS.buscarPorProducto(producto).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, ProductoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/objetivo_cesta")
    @PreAuthorize("hasAnyAuthority('CLIENTE', 'ADMIN','FINANZAS','TESTER')")
    public List<PrMetaCestaDTO> montosobjetivo() {
        List<String[]> fila = pS.montosobjetivo();
        List<PrMetaCestaDTO> dtoLista=new ArrayList<>();
        for(String[] columna: fila){
            PrMetaCestaDTO dto=new PrMetaCestaDTO();
            dto.setNombreusuario(columna[0]);
            dto.setMontototal(Integer.parseInt(columna[1]));
            dto.setMontoobjetivo(new BigDecimal(columna[2]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
    @GetMapping("/producto_precio_unidad")
    @PreAuthorize("hasAnyAuthority('ADMIN','FINANZAS','TESTER')")
    public List<ProductoInfoDTO> productosandpriceandunit() {
        List<String[]> fila = pS.productosandpriceandunit();
        List<ProductoInfoDTO> dtoLista=new ArrayList<>();
        for(String[] columna: fila){
            ProductoInfoDTO dto=new ProductoInfoDTO();
            dto.setNombre_producto(columna[0]);
            dto.setTotal_Unidades(Integer.parseInt(columna[1]));
            dto.setPrecio_Producto((int) Double.parseDouble(columna[2]));
            dto.setNombre_tienda(columna[3]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
