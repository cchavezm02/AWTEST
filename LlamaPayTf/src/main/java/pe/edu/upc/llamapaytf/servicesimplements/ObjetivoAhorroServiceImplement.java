package pe.edu.upc.llamapaytf.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.llamapaytf.entities.ObjetivoAhorro;
import pe.edu.upc.llamapaytf.repositories.IObjetivoAhorroRepository;
import pe.edu.upc.llamapaytf.servicesinterfaces.IObjetivoAhorroService;

import java.util.List;
@Service
public class ObjetivoAhorroServiceImplement implements IObjetivoAhorroService {
    @Autowired
    private IObjetivoAhorroRepository oaR;

    @Override
    public void insertar(ObjetivoAhorro objetivoAhorro) {
        oaR.save(objetivoAhorro);
    }

    @Override
    public void update(ObjetivoAhorro objetivoAhorro) {
        oaR.save(objetivoAhorro);
    }

    @Override
    public void deleteById(int id) {
        oaR.deleteById(id);
    }

    @Override
    public List<ObjetivoAhorro> listar() {
        return oaR.findAll();
    }

    @Override
    public List<ObjetivoAhorro> buscarPorUsuario(int userId) {
        return oaR.findByUser_IdUser(userId);
    }

    @Override
    public List<String[]> obtenerMontoAhorradoXUsuario() {
        return oaR.amountTotalByUser();
    }

    @Override
    public List<String[]> contarObjetivosPorMes() {
        return oaR.contarObjetivosPorMes();
    }
}
