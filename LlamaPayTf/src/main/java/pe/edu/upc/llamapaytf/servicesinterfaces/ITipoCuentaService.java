package pe.edu.upc.llamapaytf.servicesinterfaces;

import pe.edu.upc.llamapaytf.entities.Rol;
import pe.edu.upc.llamapaytf.entities.TipoCuenta;

import java.util.List;

public interface ITipoCuentaService {
    public List<TipoCuenta> list();
    public void insertar (TipoCuenta tipocuenta);
    public List<TipoCuenta> findTipoCuentaByUserId(int userId);
    public void update(TipoCuenta tc);
    public void delete(int id);
    List<TipoCuenta> buscarPorNombre(String nombre);
}
