package laoreProjects.IRTiBE.repository.table.anagrafiche;

import laoreProjects.IRTiBE.entity.table.anagrafiche.TdModoOrganizzazioneDocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TdModoOrganizzazioneDocumentoRepository extends JpaRepository<TdModoOrganizzazioneDocumentoEntity, Integer> {

    @Query(value = "SELECT * from anagrafiche.td_modo_organizzazione_documento ORDER BY id_modo_organizzazione_documento", nativeQuery = true)
    Optional<List<TdModoOrganizzazioneDocumentoEntity>> getLista_TD_MODO_ORGANIZZAZIONE_DOCUMENTO();
    @Query(value = "SELECT * from anagrafiche.td_modo_organizzazione_documento WHERE flag_attivo = 'Y' ORDER BY id_modo_organizzazione_documento", nativeQuery = true)
    Optional<List<TdModoOrganizzazioneDocumentoEntity>> getLista_TD_MODO_ORGANIZZAZIONE_DOCUMENTO_Attivi();
}
