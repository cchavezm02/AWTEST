package pe.edu.upc.llamapaytf.servicesinterfaces;

import pe.edu.upc.llamapaytf.entities.Category;

import java.util.List;

public interface ICategoryService {
    public List<Category> list();
    public void insertar (Category c); //metodo insertar
    public Category listID(int id); //listar server por ID
    public void update(Category c);
    public void delete(int id);
    public List<String[]>FindMontoByCategoryMesAndAnio(int mes, int anio);
    public List<String[]>FindMontoByCategoryAnio(int anio);
}
