package pe.edu.upc.llamapaytf.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "TipoCuenta")
public class TipoCuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoCuenta;
    @Column(name = "nombreTipoCuenta", nullable = false, length = 50)
    private String nombreTipoCuenta;
    @Column(name = "numeroTipoCuenta", nullable = false, length = 20)
    private String numeroTipoCuenta;
    @Column(name = "tipodeCuenta", nullable = false, length = 50)
    private String tipodeCuenta;
    @Column(name = "saldoTipoCuenta", nullable = false, precision = 10, scale = 2)
    private BigDecimal saldoTipoCuenta;
    @Column(name = "monedaTipoCuenta", nullable = false, length = 10)
    private String monedaTipoCuenta;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    public TipoCuenta() {
    }

    public TipoCuenta(int idTipoCuenta, String nombreTipoCuenta, String numeroTipoCuenta, String tipodeCuenta, BigDecimal saldoTipoCuenta, String monedaTipoCuenta, User user) {
        this.idTipoCuenta = idTipoCuenta;
        this.nombreTipoCuenta = nombreTipoCuenta;
        this.numeroTipoCuenta = numeroTipoCuenta;
        this.tipodeCuenta = tipodeCuenta;
        this.saldoTipoCuenta = saldoTipoCuenta;
        this.monedaTipoCuenta = monedaTipoCuenta;
        this.user = user;
    }

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
