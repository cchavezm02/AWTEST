package pe.edu.upc.llamapaytf.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.llamapaytf.entities.TipoCuenta;
import pe.edu.upc.llamapaytf.repositories.ITipoCuentaRepository;
import pe.edu.upc.llamapaytf.servicesinterfaces.ITipoCuentaService;

import java.util.List;

@Service
public class TipoCuentaServiceImplement implements ITipoCuentaService {
    @Autowired
    private ITipoCuentaRepository tcR;
    @Override
    public List<TipoCuenta> list() {
        return tcR.findAll();
    }

    @Override
    public void insertar(TipoCuenta tipocuenta) {
        tcR.save(tipocuenta);
    }

    @Override
    public List<TipoCuenta> findTipoCuentaByUserId(int userId) {
        return tcR.findTipoCuentaByUserId(userId);
    }


    @Override
    public void update(TipoCuenta tc) {
        tcR.save(tc);
    }

    @Override
    public void delete(int id) {
        tcR.deleteById(id);
    }

    @Override
    public List<TipoCuenta> buscarPorNombre(String nombre) {
        return tcR.buscarPorNombre(nombre);
    }
}
