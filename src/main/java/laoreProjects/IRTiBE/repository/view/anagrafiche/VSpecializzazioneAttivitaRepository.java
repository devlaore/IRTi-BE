package laoreProjects.IRTiBE.repository.view.anagrafiche;

import laoreProjects.IRTiBE.entity.view.anagrafiche.VSpecializzazioneAttivitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface VSpecializzazioneAttivitaRepository extends JpaRepository<VSpecializzazioneAttivitaEntity, Integer> {

    @Query(value = "SELECT * from anagrafiche.v_specializzazione_attivita ORDER BY id_specializzazione_attivita", nativeQuery = true)
    Optional<List<VSpecializzazioneAttivitaEntity>> getLista_TD_SPECIALIZZAZIONE_ATTIVITA_V();
    @Query(value = "SELECT * from anagrafiche.v_specializzazione_attivita WHERE flag_attivo = 'Y' ORDER BY id_specializzazione_attivita", nativeQuery = true)
    Optional<List<VSpecializzazioneAttivitaEntity>> getLista_TD_SPECIALIZZAZIONE_ATTIVITA_Attive_V();
    @Query(value = "SELECT * from anagrafiche.v_specializzazione_attivita WHERE id_macro_attivita = :idMacroAttivita AND flag_attivo = 'Y' ORDER BY id_specializzazione_attivita", nativeQuery = true)
    Optional<List<VSpecializzazioneAttivitaEntity>> getLista_TD_SPECIALIZZAZIONE_ATTIVITA_Attive_by_ID_MACRO_ATTIVITA_V(@Param("idMacroAttivita") Integer idMacroAttivita);
}
