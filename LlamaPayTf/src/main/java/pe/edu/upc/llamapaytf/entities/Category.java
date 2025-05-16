package pe.edu.upc.llamapaytf.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategory;
    @Column(name = "nameCategory", nullable = false, length = 50)
    private String nameCategory;
    @Column(name = "typeCategory", nullable = false, length = 50)
    private String typeCategory;

    public Category() {
    }

    public Category(int idCategory, String nameCategory, String typeCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.typeCategory = typeCategory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getTypeCategory() {
        return typeCategory;
    }

    public void setTypeCategory(String typeCategory) {
        this.typeCategory = typeCategory;
    }
}
