package pe.edu.upc.llamapaytf.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Producto_id;
    @Column(name = "Nombre_producto", nullable = false, length = 30)
    private String Nombre_producto;
    @Column(name = "Descripcion", nullable = false, length = 50)
    private String Descripcion;
    @Column(name = "Unidad_medida", nullable = false, length = 20)
    private String Unidad_medida;
    @Column(name = "Precio_Producto", nullable = false, length = 10)
    private int Precio_Producto;

    @ManyToOne
    @JoinColumn(name = "Usuario_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "Tienda_id", nullable = false)
    private Tienda tienda;

    public Producto() {
    }

    public Producto(int producto_id, String nombre_producto, String descripcion, String unidad_medida, int precio_Producto, User user, Tienda tienda) {
        Producto_id = producto_id;
        Nombre_producto = nombre_producto;
        Descripcion = descripcion;
        Unidad_medida = unidad_medida;
        Precio_Producto = precio_Producto;
        this.user = user;
        this.tienda = tienda;
    }

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
