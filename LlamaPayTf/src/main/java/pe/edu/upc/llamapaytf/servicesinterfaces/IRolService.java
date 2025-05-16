package pe.edu.upc.llamapaytf.servicesinterfaces;

import pe.edu.upc.llamapaytf.entities.Rol;

import java.util.List;

public interface IRolService {
    public void insert(Rol rol);
    public void deleteById(int id);
    public void update(Rol rol);
    public List<Rol> list();

    // Agrega estas dos líneas:
    public List<Rol> findRolesByTipoRol(String tipoRol);
    public List<Rol> findRolesByUserId(int userId);
}
