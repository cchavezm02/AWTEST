package pe.edu.upc.llamapaytf.dtos;

import java.math.BigDecimal;

public class PrMetaCestaDTO {
    private String nombreusuario;
    private int montototal;
    private BigDecimal montoobjetivo;

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public int getMontototal() {
        return montototal;
    }

    public void setMontototal(int montototal) {
        this.montototal = montototal;
    }

    public BigDecimal getMontoobjetivo() {
        return montoobjetivo;
    }

    public void setMontoobjetivo(BigDecimal montoobjetivo) {
        this.montoobjetivo = montoobjetivo;
    }
}
