package laoreProjects.IRTiBE.repository.table.anagrafiche;

import laoreProjects.IRTiBE.entity.table.anagrafiche.TdAttivitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TdAttivitaRepository extends JpaRepository<TdAttivitaEntity, Integer> {

    @Query(value = "SELECT * from anagrafiche.td_attivita ORDER BY id_attivita", nativeQuery = true)
    Optional<List<TdAttivitaEntity>> getLista_TD_ATTIVITA();
    @Query(value = "SELECT * from anagrafiche.td_attivita WHERE flag_attivo = 'Y' ORDER BY id_attivita", nativeQuery = true)
    Optional<List<TdAttivitaEntity>> getLista_TD_ATTIVITA_Attive();
}
