package pe.edu.upc.llamapaytf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.llamapaytf.entities.Rol;

import java.util.List;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {

    //Buscar rol por tipo de rol
    @Query("SELECT r FROM Rol r WHERE r.TipoRol = :tipoRol")
    List<Rol> findRolesByTipoRol(@Param("tipoRol") String tipoRol);

    //Buscar rol por el id del usuario
    @Query("SELECT r FROM Rol r WHERE r.user.idUser = :userId")
    List<Rol> findRolesByUserId(@Param("userId") int userId);
}
