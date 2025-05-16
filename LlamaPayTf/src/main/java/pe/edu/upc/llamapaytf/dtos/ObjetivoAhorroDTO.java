package pe.edu.upc.llamapaytf.dtos;

import pe.edu.upc.llamapaytf.entities.User;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ObjetivoAhorroDTO {
    private int Objetivo_id;
    private String nombreMeta;
    private BigDecimal montoMeta;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private BigDecimal montoActual;
    private String estadoObjetivo;
    private User user;

    public int getObjetivo_id() {
        return Objetivo_id;
    }

    public void setObjetivo_id(int objetivo_id) {
        Objetivo_id = objetivo_id;
    }

    public String getNombreMeta() {
        return nombreMeta;
    }

    public void setNombreMeta(String nombreMeta) {
        this.nombreMeta = nombreMeta;
    }

    public BigDecimal getMontoMeta() {
        return montoMeta;
    }

    public void setMontoMeta(BigDecimal montoMeta) {
        this.montoMeta = montoMeta;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getMontoActual() {
        return montoActual;
    }

    public void setMontoActual(BigDecimal montoActual) {
        this.montoActual = montoActual;
    }

    public String getEstadoObjetivo() {
        return estadoObjetivo;
    }

    public void setEstadoObjetivo(String estadoObjetivo) {
        this.estadoObjetivo = estadoObjetivo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
