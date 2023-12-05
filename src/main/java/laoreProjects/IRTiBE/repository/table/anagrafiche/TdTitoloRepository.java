package laoreProjects.IRTiBE.repository.table.anagrafiche;

import laoreProjects.IRTiBE.entity.table.anagrafiche.TdTitoloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TdTitoloRepository extends JpaRepository<TdTitoloEntity, Integer> {

    @Query(value = "SELECT * from anagrafiche.td_titolo ORDER BY id_titolo", nativeQuery = true)
    Optional<List<TdTitoloEntity>> getLista_TD_TITOLO();
}
