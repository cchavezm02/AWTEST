package pe.edu.upc.llamapaytf.servicesinterfaces;

import pe.edu.upc.llamapaytf.entities.ObjetivoAhorro;

import java.util.List;

public interface IObjetivoAhorroService {
    void insertar(ObjetivoAhorro objetivoAhorro);
    void update(ObjetivoAhorro objetivoAhorro);
    void deleteById(int id);
    public List<ObjetivoAhorro> listar();

    //busquedas
    List<ObjetivoAhorro> buscarPorUsuario(int userId);
    List<String[]> obtenerMontoAhorradoXUsuario();
    List<String[]> contarObjetivosPorMes();
}
