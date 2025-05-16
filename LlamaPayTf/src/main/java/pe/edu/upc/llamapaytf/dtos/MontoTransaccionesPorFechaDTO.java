package pe.edu.upc.llamapaytf.dtos;

import java.time.LocalDate;

public class MontoTransaccionesPorFechaDTO {
    private LocalDate fecha;
    private Double montoTotal;

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }
}
