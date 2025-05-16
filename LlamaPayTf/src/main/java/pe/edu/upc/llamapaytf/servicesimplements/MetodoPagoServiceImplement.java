package pe.edu.upc.llamapaytf.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.llamapaytf.entities.MetodoPago;
import pe.edu.upc.llamapaytf.repositories.IMetodoPagoRepository;
import pe.edu.upc.llamapaytf.servicesinterfaces.IMetodoPagoService;

import java.util.List;

@Service
public class MetodoPagoServiceImplement implements IMetodoPagoService {
    @Autowired
    private IMetodoPagoRepository mpR;

    @Override
    public List<MetodoPago> list() {
        return mpR.findAll();
    }

    @Override
    public void insertar(MetodoPago mp) {
        mpR.save(mp);
    }

    @Override
    public void update(MetodoPago mp) {
        mpR.save(mp);
    }

    @Override
    public void delete(int id) {
        mpR.deleteById(id);
    }

    @Override
    public MetodoPago listId(int id) {
        return mpR.findById(id).orElse(new MetodoPago());
    }
}
