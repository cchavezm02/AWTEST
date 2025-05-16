package pe.edu.upc.llamapaytf.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.llamapaytf.entities.Recordatorio;
import pe.edu.upc.llamapaytf.repositories.IRecordatorioRepository;
import pe.edu.upc.llamapaytf.servicesinterfaces.IRecordatorioService;

import java.util.List;
@Service
public class RecordatorioServiceImplement implements IRecordatorioService {

    @Autowired
    private IRecordatorioRepository rR;

    @Override
    public List<Recordatorio> list() {
        return rR.findAll();
    }

    @Override
    public void insertar(Recordatorio r) {
        rR.save(r);
    }

    @Override
    public List<Recordatorio> buscarPorRecordatorio(String rec) {
        return rR.buscarPorRecordatorio(rec);
    }

    @Override
    public void update(Recordatorio r) {
        rR.save(r);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }
}
