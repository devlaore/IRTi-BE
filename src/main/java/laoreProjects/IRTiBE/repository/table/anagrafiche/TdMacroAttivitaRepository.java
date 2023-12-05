package laoreProjects.IRTiBE.repository.table.anagrafiche;

import laoreProjects.IRTiBE.entity.table.anagrafiche.TdMacroAttivitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TdMacroAttivitaRepository extends JpaRepository<TdMacroAttivitaEntity, Integer> {

    @Query(value = "SELECT * from anagrafiche.td_macro_attivita ORDER BY id_macro_attivita", nativeQuery = true)
    Optional<List<TdMacroAttivitaEntity>> getLista_TD_MACRO_ATTIVITA();
    @Query(value = "SELECT * from anagrafiche.td_macro_attivita WHERE flag_attivo = 'Y' ORDER BY id_macro_attivita", nativeQuery = true)
    Optional<List<TdMacroAttivitaEntity>> getLista_TD_MACRO_ATTIVITA_Attive();
    @Query(value = "SELECT * from anagrafiche.td_macro_attivita WHERE id_ambito_attivita IN (:idAmbitoAttivita, 9999) AND flag_attivo = 'Y' ORDER BY id_macro_attivita", nativeQuery = true)
    Optional<List<TdMacroAttivitaEntity>> getLista_TD_MACRO_ATTIVITA_Attive_by_ID_AMBITO_ATTIVITA(@Param("idAmbitoAttivita") Integer idAmbitoAttivita);
}
