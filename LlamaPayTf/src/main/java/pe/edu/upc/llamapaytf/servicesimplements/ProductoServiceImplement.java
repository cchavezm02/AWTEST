package pe.edu.upc.llamapaytf.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.llamapaytf.entities.Producto;
import pe.edu.upc.llamapaytf.repositories.IProductoRepository;
import pe.edu.upc.llamapaytf.servicesinterfaces.IProductoService;

import java.util.List;

@Service
public class ProductoServiceImplement implements IProductoService {
    @Autowired
    private IProductoRepository pR;

    @Override
    public List<Producto> list() {
        return pR.findAll();
    }

    @Override
    public void insertar(Producto p) {
        pR.save(p);
    }

    @Override
    public List<Producto> buscarPorProducto(String producto) {
        return pR.buscarPorProducto(producto);
    }

    @Override
    public void update(Producto p) {
        pR.save(p);
    }

    @Override
    public void delete(int id) {
        pR.deleteById(id);
    }

    @Override
    public List<String[]> productosandpriceandunit() {
        return pR.productosandpriceandunit();
    }

    @Override
    public List<String[]> montosobjetivo() {
        return pR.montosobjetivo();
    }

}
