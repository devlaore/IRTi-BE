package laoreProjects.IRTiBE.repository.table.anagrafiche;

import laoreProjects.IRTiBE.entity.table.anagrafiche.TdAmbitoAttivitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TdAmbitoAttivitaRepository extends JpaRepository<TdAmbitoAttivitaEntity, Integer> {

    @Query(value = "SELECT * from anagrafiche.td_ambito_attivita ORDER BY id_ambito_attivita", nativeQuery = true)
    Optional<List<TdAmbitoAttivitaEntity>> getLista_TD_AMBITO_ATTIVITA();
    @Query(value = "SELECT * from anagrafiche.td_ambito_attivita WHERE flag_attivo = 'Y' ORDER BY id_ambito_attivita", nativeQuery = true)
    Optional<List<TdAmbitoAttivitaEntity>> getLista_TD_AMBITO_ATTIVITA_Attive();
}
