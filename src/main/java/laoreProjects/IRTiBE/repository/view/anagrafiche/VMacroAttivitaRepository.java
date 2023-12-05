package laoreProjects.IRTiBE.repository.view.anagrafiche;

import laoreProjects.IRTiBE.entity.view.anagrafiche.VMacroAttivitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface VMacroAttivitaRepository extends JpaRepository<VMacroAttivitaEntity, Integer> {

    @Query(value = "SELECT * from anagrafiche.v_macro_attivita ORDER BY id_macro_attivita", nativeQuery = true)
    Optional<List<VMacroAttivitaEntity>> getLista_TD_MACRO_ATTIVITA_V();
    @Query(value = "SELECT * from anagrafiche.v_macro_attivita WHERE flag_attivo = 'Y' ORDER BY id_macro_attivita", nativeQuery = true)
    Optional<List<VMacroAttivitaEntity>> getLista_TD_MACRO_ATTIVITA_Attive_V();
    @Query(value = "SELECT * from anagrafiche.v_macro_attivita WHERE id_ambito_attivita = :idAmbitoAttivita AND flag_attivo = 'Y' ORDER BY id_macro_attivita", nativeQuery = true)
    Optional<List<VMacroAttivitaEntity>> getLista_TD_MACRO_ATTIVITA_Attive_by_ID_AMBITO_ATTIVITA_V(@Param("idAmbitoAttivita") Integer idAmbitoAttivita);
}
