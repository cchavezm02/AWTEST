package pe.edu.upc.llamapaytf.dtos;

import pe.edu.upc.llamapaytf.entities.Tienda;
import pe.edu.upc.llamapaytf.entities.User;

public class ProductoDTO {
    private int Producto_id;
    private String Nombre_producto;
    private String Descripcion;
    private String Unidad_medida;
    private int Precio_Producto;
    private User user;
    private Tienda tienda;

    public int getProducto_id() {
        return Producto_id;
    }

    public void setProducto_id(int producto_id) {
        Producto_id = producto_id;
    }

    public String getNombre_producto() {
        return Nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        Nombre_producto = nombre_producto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getUnidad_medida() {
        return Unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        Unidad_medida = unidad_medida;
    }

    public int getPrecio_Producto() {
        return Precio_Producto;
    }

    public void setPrecio_Producto(int precio_Producto) {
        Precio_Producto = precio_Producto;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
}
