package pe.edu.upc.llamapaytf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.llamapaytf.entities.Transaccion;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ITransaccionRepository extends JpaRepository<Transaccion,Integer> {
    //queries rodrigo
    @Query("SELECT t.fechaTransaccion, COUNT(t) FROM Transaccion t GROUP BY t.fechaTransaccion")
    List<String[]> contarTransaccionesPorFecha();

    @Query("SELECT t.fechaTransaccion, SUM(t.montoTransaccion) FROM Transaccion t GROUP BY t.fechaTransaccion")
    List<String[]> sumarMontosPorFecha();

    //queries joao
    //Buscar transacciones con monto mayor a un valor y por mes
    @Query(value = "SELECT * FROM transaccion WHERE monto_transaccion > :monto AND EXTRACT(MONTH FROM fecha_transaccion) = :mes", nativeQuery = true)
    List<String[]> findByMontoMayorAndMes(@Param("monto") BigDecimal monto, @Param("mes") int mes);

    //Buscar transacciones por descripción parcial y mes
    @Query(value = "SELECT * FROM transaccion WHERE LOWER(descripcion_transaccion) LIKE LOWER(CONCAT('%', :descripcion, '%')) AND EXTRACT(MONTH FROM fecha_transaccion) = :mes", nativeQuery = true)
    List<String[]> findByDescripcionAndMes(@Param("descripcion") String descripcion, @Param("mes") int mes);

    //Busqueda simple: Buscar transacciones solo por descripción parcial (sin mes)
    @Query(value = "SELECT * FROM transaccion WHERE LOWER(descripcion_transaccion) LIKE LOWER(CONCAT('%', :descripcion, '%'))", nativeQuery = true)
    List<Transaccion> findByDescripcion(@Param("descripcion") String descripcion);
}
