package laoreProjects.IRTiBE.repository.table.anagrafiche;

import laoreProjects.IRTiBE.entity.table.anagrafiche.TdApplicativoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TdApplicativoRepository extends JpaRepository<TdApplicativoEntity, Integer> {

    @Query(value = "SELECT * from anagrafiche.td_applicativo ORDER BY id_applicativo", nativeQuery = true)
    Optional<List<TdApplicativoEntity>> getLista_TD_APPLICATIVO();
    @Query(value = "SELECT * from anagrafiche.td_applicativo WHERE flag_attivo = 'Y' ORDER BY id_applicativo", nativeQuery = true)
    Optional<List<TdApplicativoEntity>> getLista_TD_APPLICATIVO_Attivi();
}
