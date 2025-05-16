package pe.edu.upc.llamapaytf.dtos;

public class TiendaDTO {
    private int Tienda_id;
    private String Nombre_tienda;
    private String Direccion;

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
