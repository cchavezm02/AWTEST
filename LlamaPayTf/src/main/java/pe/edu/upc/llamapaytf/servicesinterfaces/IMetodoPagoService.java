package pe.edu.upc.llamapaytf.servicesinterfaces;

import pe.edu.upc.llamapaytf.entities.MetodoPago;

import java.util.List;

public interface IMetodoPagoService {
    public List<MetodoPago> list();
    public void insertar(MetodoPago mp);
    public void update (MetodoPago mp);
    public void delete(int id);
    public MetodoPago listId(int id);
    //public List<MetodoPago> buscarPorNombre(String nombre);
}
