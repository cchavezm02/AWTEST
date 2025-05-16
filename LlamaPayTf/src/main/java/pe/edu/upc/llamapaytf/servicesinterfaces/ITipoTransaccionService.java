package pe.edu.upc.llamapaytf.servicesinterfaces;

import pe.edu.upc.llamapaytf.entities.TipoTransaccion;

import java.util.List;

public interface ITipoTransaccionService {
    public void insert(TipoTransaccion tt);
    public void update(TipoTransaccion tt);
    public void delete(int id);
    public List<TipoTransaccion> list();
    public TipoTransaccion listID(int id);
}
