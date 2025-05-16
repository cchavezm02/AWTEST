package pe.edu.upc.llamapaytf.dtos;

import java.time.LocalDate;

public class CantidadTransaccionesPorFechaDTO {
    private LocalDate fecha;
    private int cantidadTransacciones;

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getCantidadTransacciones() {
        return cantidadTransacciones;
    }

    public void setCantidadTransacciones(int cantidadTransacciones) {
        this.cantidadTransacciones = cantidadTransacciones;
    }
}
