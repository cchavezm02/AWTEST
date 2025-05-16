package pe.edu.upc.llamapaytf.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.llamapaytf.entities.User;
import pe.edu.upc.llamapaytf.repositories.IUserRepository;
import pe.edu.upc.llamapaytf.servicesinterfaces.IUserService;

import java.util.List;

@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    private IUserRepository uR;

    @Override
    public List<User> list() {
        return uR.findAll();
    }

    //metodo insertar datos
    @Override
    public void insertar(User u) {
        uR.save(u);
    }

    //metodo buscar id
    @Override
    public User listID(int id) {
        return uR.findById(id).orElse(new User()); //busca el id y si no lo encuentra lo devuelve en blanco
    }

    //metodo actualizar datos
    @Override
    public void update(User u) {
        uR.save(u);
    }

    //metodo eliminar los atributos
    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

}
