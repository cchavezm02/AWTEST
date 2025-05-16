package pe.edu.upc.llamapaytf.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.llamapaytf.entities.TipoTransaccion;
import pe.edu.upc.llamapaytf.repositories.ITipoTransaccionRepository;
import pe.edu.upc.llamapaytf.servicesinterfaces.ITipoTransaccionService;

import java.util.List;

@Service
public class TipoTransaccionServiceImplement implements ITipoTransaccionService {
    @Autowired
    private ITipoTransaccionRepository tR;

    @Override
    public void insert(TipoTransaccion tt) {
        tR.save(tt);
    }

    @Override
    public void update(TipoTransaccion tt) {
        tR.save(tt);
    }

    @Override
    public void delete(int id) {
        tR.deleteById(id);
    }

    @Override
    public List<TipoTransaccion> list() {
        return tR.findAll();
    }

    @Override
    public TipoTransaccion listID(int id) {
        return tR.findById(id).orElse(new TipoTransaccion());
    }
}
