package pe.edu.upc.llamapaytf.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransaccionInfoDTO {
    private String descripcion;
    private BigDecimal montoTransaccion;
    private LocalDate fechaTransaccion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getMontoTransaccion() {
        return montoTransaccion;
    }

    public void setMontoTransaccion(BigDecimal montoTransaccion) {
        this.montoTransaccion = montoTransaccion;
    }

    public LocalDate getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDate fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }
}
