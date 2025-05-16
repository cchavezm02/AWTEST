package pe.edu.upc.llamapaytf.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.llamapaytf.entities.Category;
import pe.edu.upc.llamapaytf.repositories.ICategoryRepository;
import pe.edu.upc.llamapaytf.servicesinterfaces.ICategoryService;

import java.util.List;

@Service
public class CategoryServiceImplement implements ICategoryService {

    @Autowired
    private ICategoryRepository cR;

    @Override
    public List<Category> list() {
        return cR.findAll();
    }

    @Override
    public void insertar(Category c) {
        cR.save(c);
    }

    @Override
    public Category listID(int id) {
        return cR.findById(id).orElse(new Category());
    }

    @Override
    public void update(Category c) {
        cR.save(c);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public List<String[]> FindMontoByCategoryMesAndAnio(int mes, int anio) {
        return cR.FindMontoByCategoryMesAndAnio(mes,anio);
    }

    @Override
    public List<String[]> FindMontoByCategoryAnio(int anio) {
        return cR.FindMontoByCategoryAnio(anio);
    }

}
