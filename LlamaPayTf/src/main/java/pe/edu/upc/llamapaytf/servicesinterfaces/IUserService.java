package pe.edu.upc.llamapaytf.servicesinterfaces;

import pe.edu.upc.llamapaytf.entities.User;

import java.util.List;

public interface IUserService {
    public List<User> list();
    public void insertar (User u);
    public User listID(int id); //listar user por ID
    public void update(User u);
    public void delete(int id);
}
