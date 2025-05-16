package pe.edu.upc.llamapaytf.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "ObjetivoAhorro")
public class ObjetivoAhorro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Objetivo_id;
    @Column(name = "NombreMeta", nullable = false,length = 35)
    private String nombreMeta;
    @Column(name = "MontoMeta",nullable = false,length = 35)
    private BigDecimal montoMeta;
    @Column(name = "FechaInicio",nullable = false,length = 35)
    private LocalDate fechaInicio;
    @Column(name = "FechaFin",nullable = false,length = 35)
    private LocalDate fechaFin;
    @Column(name = "MontoActual",nullable = false,length = 35)
    private BigDecimal montoActual;
    @Column(name = "EstadoObjetivo",nullable = false,length = 35)
    private String estadoObjetivo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User user;

    public ObjetivoAhorro() {
    }

    public ObjetivoAhorro(int objetivo_id, String nombreMeta, BigDecimal montoMeta, LocalDate fechaInicio, LocalDate fechaFin, BigDecimal montoActual, String estadoObjetivo, User user) {
        Objetivo_id = objetivo_id;
        this.nombreMeta = nombreMeta;
        this.montoMeta = montoMeta;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.montoActual = montoActual;
        this.estadoObjetivo = estadoObjetivo;
        this.user = user;
    }

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
