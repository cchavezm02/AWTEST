package pe.edu.upc.llamapaytf.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.llamapaytf.entities.Rol;
import pe.edu.upc.llamapaytf.repositories.IRolRepository;
import pe.edu.upc.llamapaytf.servicesinterfaces.IRolService;

import java.util.List;
@Service
public class RolServiceImplement implements IRolService {
    @Autowired
    private IRolRepository roR;

    @Override
    public void insert(Rol rol) {
        roR.save(rol);
    }

    @Override
    public void deleteById(int id) {
        roR.deleteById(id);
    }

    @Override
    public void update(Rol rol) {
        roR.save(rol);
    }

    @Override
    public List<Rol> list() {
        return roR.findAll();
    }

    @Override
    public List<Rol> findRolesByTipoRol(String tipoRol) {
        return roR.findRolesByTipoRol(tipoRol);
    }

    @Override
    public List<Rol> findRolesByUserId(int userId) {
        return roR.findRolesByUserId(userId);
    }
}
