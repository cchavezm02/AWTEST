package pe.edu.upc.llamapaytf.dtos;

public class ObjetivosPorMesDTO {
    private String mes;
    private long cantidadObjetivos;

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public long getCantidadObjetivos() {
        return cantidadObjetivos;
    }

    public void setCantidadObjetivos(long cantidadObjetivos) {
        this.cantidadObjetivos = cantidadObjetivos;
    }
}
