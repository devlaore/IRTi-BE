package laoreProjects.IRTiBE.repository.table.anagrafiche;

import laoreProjects.IRTiBE.entity.table.anagrafiche.TdSpecializzazioneAttivitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TdSpecializzazioneAttivitaRepository extends JpaRepository<TdSpecializzazioneAttivitaEntity, Integer> {

    @Query(value = "SELECT * from anagrafiche.td_specializzazione_attivita ORDER BY id_specializzazione_attivita", nativeQuery = true)
    Optional<List<TdSpecializzazioneAttivitaEntity>> getLista_TD_SPECIALIZZAZIONE_ATTIVITA();
    @Query(value = "SELECT * from anagrafiche.td_specializzazione_attivita WHERE flag_attivo = 'Y' ORDER BY id_specializzazione_attivita", nativeQuery = true)
    Optional<List<TdSpecializzazioneAttivitaEntity>> getLista_TD_SPECIALIZZAZIONE_ATTIVITA_Attive();
    @Query(value = "SELECT * from anagrafiche.td_specializzazione_attivita WHERE id_macro_attivita IN (:idMacroAttivita, 9999) AND flag_attivo = 'Y' ORDER BY id_specializzazione_attivita", nativeQuery = true)
    Optional<List<TdSpecializzazioneAttivitaEntity>> getLista_TD_SPECIALIZZAZIONE_ATTIVITA_Attive_by_ID_MACRO_ATTIVITA(@Param("idMacroAttivita") Integer idMacroAttivita);
}
