package pe.edu.upc.llamapaytf.dtos;

import pe.edu.upc.llamapaytf.entities.MetodoPago;
import pe.edu.upc.llamapaytf.entities.Servicio;
import pe.edu.upc.llamapaytf.entities.TipoCuenta;
import pe.edu.upc.llamapaytf.entities.TipoTransaccion;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;


public class TransaccionDTO {
    private int idTransaccion;
    private Date fechaTransaccion;
    private BigDecimal montoTransaccion;
    private String descripcionTransaccion;
    private TipoCuenta tipocuenta;
    private MetodoPago metodopago;
    private Servicio servicio;
    private TipoTransaccion tipotransaccion;

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
