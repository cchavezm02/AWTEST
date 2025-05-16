package pe.edu.upc.llamapaytf.dtos;

public class ServicioCategoriaDTO {
    public String nameCategory;
    public int cantidadServicio;

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getCantidadServicio() {
        return cantidadServicio;
    }

    public void setCantidadServicio(int cantidadServicio) {
        this.cantidadServicio = cantidadServicio;
    }
}
