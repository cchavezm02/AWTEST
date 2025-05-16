package pe.edu.upc.llamapaytf.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Tipotransaccion")
public class TipoTransaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TipoTransaccion_id")
    private int tipoGastoId;

    @Column(name = "Descripcion", nullable = false, length = 105)
    private String descripcion;

    // Constructor vacío
    public TipoTransaccion() {
    }

    // Constructor completo
    public TipoTransaccion(int tipoGastoId, String descripcion) {
        this.tipoGastoId = tipoGastoId;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getTipoGastoId() {
        return tipoGastoId;
    }

    public void setTipoGastoId(int tipoGastoId) {
        this.tipoGastoId = tipoGastoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
