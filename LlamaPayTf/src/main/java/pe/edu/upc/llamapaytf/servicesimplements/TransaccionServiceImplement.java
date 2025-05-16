package pe.edu.upc.llamapaytf.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.llamapaytf.entities.Transaccion;
import pe.edu.upc.llamapaytf.repositories.ITransaccionRepository;
import pe.edu.upc.llamapaytf.servicesinterfaces.ITransaccionService;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransaccionServiceImplement implements ITransaccionService {
    @Autowired
    private ITransaccionRepository transaccionR;


    @Override
    public void insert(Transaccion tr) {
        transaccionR.save(tr);
    }

    @Override
    public void update(Transaccion tr) {
        transaccionR.save(tr);
    }

    @Override
    public void delete(int id) {
        transaccionR.deleteById(id);
    }

    @Override
    public List<Transaccion> list() {
        return transaccionR.findAll();
    }

    @Override
    public List<String[]> contarTransaccionesPorFecha() {
        return transaccionR.contarTransaccionesPorFecha();
    }

    @Override
    public List<String[]> sumarMontosPorFecha() {
        return transaccionR.sumarMontosPorFecha();
    }

    @Override
    public List<String[]> findByMontoMayorAndMes(BigDecimal monto, int mes) {
        return transaccionR.findByMontoMayorAndMes(monto, mes);
    }

    @Override
    public List<String[]> findByDescripcionAndMes(String descripcion, int mes) {
        return transaccionR.findByDescripcionAndMes(descripcion, mes);
    }

    @Override
    public List<Transaccion> findByDescripcion(String descripcion) {
        return transaccionR.findByDescripcion(descripcion);
    }
}
