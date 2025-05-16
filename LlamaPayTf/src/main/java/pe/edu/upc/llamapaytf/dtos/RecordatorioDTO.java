package pe.edu.upc.llamapaytf.dtos;

import pe.edu.upc.llamapaytf.entities.User;

import java.util.Date;

public class RecordatorioDTO {
    private int Recordatorio_id;
    private String nombreRecordatorio;
    private String Descripcion;
    private Date Fecha_Vencimiento;
    private String Monto_recordatorio;
    private String Estado_Recordatorio;
    private User user;

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
