package pe.edu.upc.llamapaytf.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.llamapaytf.entities.Category;
import pe.edu.upc.llamapaytf.entities.Servicio;
import pe.edu.upc.llamapaytf.repositories.IServicioRepository;
import pe.edu.upc.llamapaytf.servicesinterfaces.IServicioService;

import java.util.List;

@Service
public class ServicioServiceImplement implements IServicioService {
    @Autowired
    private IServicioRepository sR;

    @Override
    public List<Servicio> list() {
        return sR.findAll();
    }

    @Override
    public void insertar(Servicio s) {
        sR.save(s);
    }

    @Override
    public List<Servicio> buscar(String n) {
        return sR.buscarCompania (n);
    }

    @Override
    public void update(Servicio s) {
        sR.save(s);
    }

    @Override
    public void delete(int id) {
        sR.deleteById(id);
    }

    @Override
    public List<String[]> FindServicebyCategory() {
        return sR.FindServicebyCategory();
    }

}
