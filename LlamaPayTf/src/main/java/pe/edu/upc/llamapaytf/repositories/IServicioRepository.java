package pe.edu.upc.llamapaytf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.llamapaytf.entities.Servicio;

import java.util.List;

@Repository
public interface IServicioRepository extends JpaRepository<Servicio, Integer> {

    @Query("Select s from Servicio s where s.nameCompanyService like %:nCompania%")
    public List<Servicio> buscarCompania(@Param("nCompania") String nCompania);

    @Query(value = "SELECT c.name_category AS Categorias,COUNT(s.id_service) AS CantidadServicios\n" +
            "FROM servicios s\n" +
            "INNER JOIN category c ON s.id_category = c.id_category\n" +
            "GROUP BY c.name_category\n" +
            "ORDER BY CantidadServicios DESC", nativeQuery = true)
    public List<String[]> FindServicebyCategory();
}
