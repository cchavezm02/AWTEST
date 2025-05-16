package pe.edu.upc.llamapaytf.servicesinterfaces;

import pe.edu.upc.llamapaytf.entities.TipoTransaccion;
import pe.edu.upc.llamapaytf.entities.Transaccion;

import java.math.BigDecimal;
import java.util.List;

public interface ITransaccionService {
    public void insert(Transaccion tr);
    public void update(Transaccion tr);
    public void delete(int id);
    public List<Transaccion> list();

    public List<String[]>contarTransaccionesPorFecha();
    public List<String[]>sumarMontosPorFecha();

    List<String[]> findByMontoMayorAndMes(BigDecimal monto, int mes);
    List<String[]> findByDescripcionAndMes(String descripcion, int mes);
    List<Transaccion> findByDescripcion(String descripcion);

}
