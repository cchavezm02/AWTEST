package pe.edu.upc.llamapaytf.dtos;

public class MontoAhorradoxUsuarioDTO {
    private String nombreUsuario;
    private Double montoTotalAhorrado;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Double getMontoTotalAhorrado() {
        return montoTotalAhorrado;
    }

    public void setMontoTotalAhorrado(Double montoTotalAhorrado) {
        this.montoTotalAhorrado = montoTotalAhorrado;
    }
}
