package pe.edu.upc.llamapaytf.servicesinterfaces;

import pe.edu.upc.llamapaytf.entities.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> list();
    public void insertar(Producto p);
    public List<Producto> buscarPorProducto(String producto);
    public void update(Producto p);
    public void delete(int id);
    public List<String[]> productosandpriceandunit();
    public List<String[]> montosobjetivo();
}
