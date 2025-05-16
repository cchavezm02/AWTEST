package pe.edu.upc.llamapaytf.dtos;

public class MetodoPagoDTO {
    private int idMetodoPago;
    private String nombreMetodoPago;
    private String tipoMetodoPago;
    private String descripcion;

    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getNombreMetodoPago() {
        return nombreMetodoPago;
    }

    public void setNombreMetodoPago(String nombreMetodoPago) {
        this.nombreMetodoPago = nombreMetodoPago;
    }

    public String getTipoMetodoPago() {
        return tipoMetodoPago;
    }

    public void setTipoMetodoPago(String tipoMetodoPago) {
        this.tipoMetodoPago = tipoMetodoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
