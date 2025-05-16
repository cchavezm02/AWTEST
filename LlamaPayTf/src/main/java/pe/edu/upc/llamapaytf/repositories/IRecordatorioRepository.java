package pe.edu.upc.llamapaytf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.llamapaytf.entities.Recordatorio;

import java.util.List;

@Repository
public interface IRecordatorioRepository extends JpaRepository<Recordatorio,Integer> {
    @Query(value="SELECT * FROM Recordatorio r WHERE r.nombre_recordatorio LIKE %:rec%",nativeQuery = true)
    List<Recordatorio> buscarPorRecordatorio(@Param("rec") String rec);
}
