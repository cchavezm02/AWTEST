package pe.edu.upc.llamapaytf.dtos;

import pe.edu.upc.llamapaytf.entities.User;

import java.math.BigDecimal;

public class TipoCuentaDTO {
    private int idTipoCuenta;
    private String nombreTipoCuenta;
    private String numeroTipoCuenta;
    private String tipodeCuenta;
    private BigDecimal saldoTipoCuenta;
    private String monedaTipoCuenta;
    private User user;

    public int getIdTipoCuenta() {
        return idTipoCuenta;
    }

    public void setIdTipoCuenta(int idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public String getNombreTipoCuenta() {
        return nombreTipoCuenta;
    }

    public void setNombreTipoCuenta(String nombreTipoCuenta) {
        this.nombreTipoCuenta = nombreTipoCuenta;
    }

    public String getNumeroTipoCuenta() {
        return numeroTipoCuenta;
    }

    public void setNumeroTipoCuenta(String numeroTipoCuenta) {
        this.numeroTipoCuenta = numeroTipoCuenta;
    }

    public String getTipodeCuenta() {
        return tipodeCuenta;
    }

    public void setTipodeCuenta(String tipodeCuenta) {
        this.tipodeCuenta = tipodeCuenta;
    }

    public BigDecimal getSaldoTipoCuenta() {
        return saldoTipoCuenta;
    }

    public void setSaldoTipoCuenta(BigDecimal saldoTipoCuenta) {
        this.saldoTipoCuenta = saldoTipoCuenta;
    }

    public String getMonedaTipoCuenta() {
        return monedaTipoCuenta;
    }

    public void setMonedaTipoCuenta(String monedaTipoCuenta) {
        this.monedaTipoCuenta = monedaTipoCuenta;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
