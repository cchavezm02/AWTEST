package pe.edu.upc.llamapaytf.dtos;

public class ProductoInfoDTO {
    private String nombre_producto;
    private int total_Unidades;
    private int precio_Producto;
    private String nombre_tienda;

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getTotal_Unidades() {
        return total_Unidades;
    }

    public void setTotal_Unidades(int total_Unidades) {
        this.total_Unidades = total_Unidades;
    }

    public int getPrecio_Producto() {
        return precio_Producto;
    }

    public void setPrecio_Producto(int precio_Producto) {
        this.precio_Producto = precio_Producto;
    }

    public String getNombre_tienda() {
        return nombre_tienda;
    }

    public void setNombre_tienda(String nombre_tienda) {
        this.nombre_tienda = nombre_tienda;
    }
}
