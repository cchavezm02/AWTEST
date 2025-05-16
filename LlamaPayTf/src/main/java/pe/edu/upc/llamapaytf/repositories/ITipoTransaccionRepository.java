package pe.edu.upc.llamapaytf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.llamapaytf.entities.TipoTransaccion;

@Repository
public interface ITipoTransaccionRepository extends JpaRepository<TipoTransaccion,Integer> {
}
