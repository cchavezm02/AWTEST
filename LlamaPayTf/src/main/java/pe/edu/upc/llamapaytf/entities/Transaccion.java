package pe.edu.upc.llamapaytf.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name="transaccion")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTransaccion;
    @Column(name = "fechaTransaccion",nullable = false)
    private Date fechaTransaccion;
    @Column(name = "montoTransaccion",nullable = false,precision = 10,scale = 2)
    private BigDecimal montoTransaccion;
    @Column(name = "descripcionTransaccion",nullable = false, length = 50)
    private String descripcionTransaccion;

    @ManyToOne
    @JoinColumn(name = "idTipoCuenta")
    private TipoCuenta tipocuenta;

    @ManyToOne
    @JoinColumn(name = "MetodoPago_id")
    private MetodoPago metodopago;

    @ManyToOne
    @JoinColumn(name = "idService")
    private Servicio servicio;

    @ManyToOne
    @JoinColumn(name = "tipoGastoId")
    private TipoTransaccion tipotransaccion;

    public Transaccion() {
    }

    public Transaccion(int idTransaccion, Date fechaTransaccion, BigDecimal montoTransaccion, String descripcionTransaccion, TipoCuenta tipocuenta, MetodoPago metodopago, Servicio servicio, TipoTransaccion tipotransaccion) {
        this.idTransaccion = idTransaccion;
        this.fechaTransaccion = fechaTransaccion;
        this.montoTransaccion = montoTransaccion;
        this.descripcionTransaccion = descripcionTransaccion;
        this.tipocuenta = tipocuenta;
        this.metodopago = metodopago;
        this.servicio = servicio;
        this.tipotransaccion = tipotransaccion;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public BigDecimal getMontoTransaccion() {
        return montoTransaccion;
    }

    public void setMontoTransaccion(BigDecimal montoTransaccion) {
        this.montoTransaccion = montoTransaccion;
    }

    public String getDescripcionTransaccion() {
        return descripcionTransaccion;
    }

    public void setDescripcionTransaccion(String descripcionTransaccion) {
        this.descripcionTransaccion = descripcionTransaccion;
    }

    public TipoCuenta getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(TipoCuenta tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    public MetodoPago getMetodopago() {
        return metodopago;
    }

    public void setMetodopago(MetodoPago metodopago) {
        this.metodopago = metodopago;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public TipoTransaccion getTipotransaccion() {
        return tipotransaccion;
    }

    public void setTipotransaccion(TipoTransaccion tipotransaccion) {
        this.tipotransaccion = tipotransaccion;
    }
}
