package pe.edu.upc.llamapaytf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.llamapaytf.entities.TipoCuenta;

import java.util.List;

@Repository
public interface ITipoCuentaRepository extends JpaRepository<TipoCuenta, Integer> {

    @Query("SELECT tc FROM TipoCuenta tc WHERE tc.user.idUser = ?1")
    List<TipoCuenta> findTipoCuentaByUserId(int userId);

    @Query("SELECT tc FROM TipoCuenta tc WHERE LOWER(tc.nombreTipoCuenta) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<TipoCuenta> buscarPorNombre(@Param("nombre") String nombre);


}
