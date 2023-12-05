package laoreProjects.IRTiBE.repository.table.anagrafiche;

import laoreProjects.IRTiBE.entity.table.anagrafiche.TdClasseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TdClasseRepository extends JpaRepository<TdClasseEntity, Integer> {

    @Query(value = "SELECT * from anagrafiche.td_classe ORDER BY id_classe", nativeQuery = true)
    Optional<List<TdClasseEntity>> getLista_TD_CLASSE();
    @Query(value = "SELECT * from anagrafiche.td_classe WHERE id_titolo = :idTitolo ORDER BY id_classe", nativeQuery = true)
    Optional<List<TdClasseEntity>> getLista_TD_CLASSE_by_ID_TITOLO(@Param("idTitolo") Integer idTitolo);
}
