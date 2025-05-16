package pe.edu.upc.llamapaytf.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Tienda")
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Tienda_id;
    @Column(name = "Nombre_tienda", nullable = false, length = 30)
    private String Nombre_tienda;
    @Column(name = "Direccion", nullable = false, length = 50)
    private String Direccion;

    public Tienda() {
    }

    public Tienda(int tienda_id, String nombre_tienda, String direccion) {
        Tienda_id = tienda_id;
        Nombre_tienda = nombre_tienda;
        Direccion = direccion;
    }

    public int getTienda_id() {
        return Tienda_id;
    }

    public void setTienda_id(int tienda_id) {
        Tienda_id = tienda_id;
    }

    public String getNombre_tienda() {
        return Nombre_tienda;
    }

    public void setNombre_tienda(String nombre_tienda) {
        Nombre_tienda = nombre_tienda;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
}
