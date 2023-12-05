package laoreProjects.IRTiBE.repository.table.anagrafiche;

import laoreProjects.IRTiBE.entity.table.anagrafiche.TdServizioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TdServizioRepository extends JpaRepository<TdServizioEntity, Integer> {

    @Query(value = "SELECT * from anagrafiche.td_servizio ORDER BY id_servizio", nativeQuery = true)
    Optional<List<TdServizioEntity>> getLista_TD_SERVIZIO();
}
