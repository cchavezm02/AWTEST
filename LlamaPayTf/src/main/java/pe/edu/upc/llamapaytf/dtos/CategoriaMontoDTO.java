package pe.edu.upc.llamapaytf.dtos;

public class CategoriaMontoDTO {
    private String nameCategory;
    private Double totalGasto;

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Double getTotalGasto() {
        return totalGasto;
    }

    public void setTotalGasto(Double totalGasto) {
        this.totalGasto = totalGasto;
    }
}
