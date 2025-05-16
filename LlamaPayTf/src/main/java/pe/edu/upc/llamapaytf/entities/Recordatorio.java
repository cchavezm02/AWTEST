package pe.edu.upc.llamapaytf.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Recordatorio")
public class Recordatorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Recordatorio_id;
    @Column(name = "nombreRecordatorio", nullable = false, length = 30)
    private String nombreRecordatorio;
    @Column(name = "Descripcion", nullable = false, length = 50)
    private String Descripcion;
    @Column(name = "Fecha_Vencimiento", nullable = false)
    private Date Fecha_Vencimiento;
    @Column(name = "Monto_recordatorio", nullable = false)
    private String Monto_recordatorio;
    @Column(name = "Estado_Recordatorio", nullable = false)
    private String Estado_Recordatorio;

    @ManyToOne
    @JoinColumn(name = "Usuario_id")
    private User user;

    public Recordatorio() {
    }

    public Recordatorio(int recordatorio_id, String nombreRecordatorio, String descripcion, Date fecha_Vencimiento, String monto_recordatorio, String estado_Recordatorio, User user) {
        Recordatorio_id = recordatorio_id;
        this.nombreRecordatorio = nombreRecordatorio;
        Descripcion = descripcion;
        Fecha_Vencimiento = fecha_Vencimiento;
        Monto_recordatorio = monto_recordatorio;
        Estado_Recordatorio = estado_Recordatorio;
        this.user = user;
    }

    public int getRecordatorio_id() {
        return Recordatorio_id;
    }

    public void setRecordatorio_id(int recordatorio_id) {
        Recordatorio_id = recordatorio_id;
    }

    public String getNombreRecordatorio() {
        return nombreRecordatorio;
    }

    public void setNombreRecordatorio(String nombreRecordatorio) {
        this.nombreRecordatorio = nombreRecordatorio;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Date getFecha_Vencimiento() {
        return Fecha_Vencimiento;
    }

    public void setFecha_Vencimiento(Date fecha_Vencimiento) {
        Fecha_Vencimiento = fecha_Vencimiento;
    }

    public String getMonto_recordatorio() {
        return Monto_recordatorio;
    }

    public void setMonto_recordatorio(String monto_recordatorio) {
        Monto_recordatorio = monto_recordatorio;
    }

    public String getEstado_Recordatorio() {
        return Estado_Recordatorio;
    }

    public void setEstado_Recordatorio(String estado_Recordatorio) {
        Estado_Recordatorio = estado_Recordatorio;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
