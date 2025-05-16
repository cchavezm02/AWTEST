package pe.edu.upc.llamapaytf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.llamapaytf.entities.ObjetivoAhorro;

import java.util.List;

@Repository
public interface IObjetivoAhorroRepository extends JpaRepository<ObjetivoAhorro,Integer> {
    List<ObjetivoAhorro> findByUser_IdUser(int userId);

    @Query(value = "SELECT u.name_user AS nombreUsuario, SUM(o.monto_actual) AS montoTotalAhorrado \n" +
            "FROM objetivo_ahorro o\n" +
            "INNER JOIN Users u ON o.usuario_id = u.id_user \n" +
            "GROUP BY u.name_user", nativeQuery = true)
    List<String[]> amountTotalByUser();

    @Query(value = "SELECT TO_CHAR(o.fecha_inicio, 'Month') AS mes, COUNT(*) \n" +
            "FROM objetivo_ahorro o \n" +
            "GROUP BY mes \n" +
            "ORDER BY MIN(o.fecha_inicio)", nativeQuery = true)
    List<String[]> contarObjetivosPorMes();

}
