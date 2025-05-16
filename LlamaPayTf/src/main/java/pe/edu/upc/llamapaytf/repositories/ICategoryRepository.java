package pe.edu.upc.llamapaytf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.llamapaytf.entities.Category;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "SELECT c.name_category AS Nombre_Categoria," +
            "           SUM(t.monto_transaccion) AS Total_Gasto" +
            "    FROM transaccion t" +
            "    INNER JOIN servicios s ON t.id_service = s.id_service" +
            "    INNER JOIN category c ON s.id_category = c.id_category" +
            "    INNER JOIN tipotransaccion tt ON t.tipo_gasto_id = tt.tipo_gasto_id" +
            "    WHERE tt.descripcion = 'Gasto'" +
            "      AND EXTRACT(MONTH FROM t.fecha_transaccion) = :mes" +
            "      AND EXTRACT(YEAR FROM t.fecha_transaccion) = :anio" +
            "    GROUP BY c.name_category" +
            "    ORDER BY Total_Gasto DESC", nativeQuery = true)
    public List<String[]> FindMontoByCategoryMesAndAnio(@Param("mes") int mes, @Param("anio") int anio);

    @Query(value ="SELECT c.name_category AS Nombre_Categoria," +
            "           SUM(t.monto_transaccion) AS Total_Gasto" +
            "    FROM transaccion t" +
            "    INNER JOIN servicios s ON t.id_service = s.id_service" +
            "    INNER JOIN category c ON s.id_category = c.id_category" +
            "    INNER JOIN tipotransaccion tt ON t.tipo_gasto_id = tt.tipo_gasto_id" +
            "    WHERE tt.descripcion = 'Gasto'" +
            "      AND EXTRACT(YEAR FROM t.fecha_transaccion) = :anio" +
            "    GROUP BY c.name_category" +
            "    ORDER BY Total_Gasto DESC",nativeQuery = true)
    public List<String[]>FindMontoByCategoryAnio(@Param("anio") int anio);
}
