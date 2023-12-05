package laoreProjects.IRTiBE.repository.table.anagrafiche;

import laoreProjects.IRTiBE.entity.table.anagrafiche.TdCriterioOrganizzazioneDocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TdCriterioOrganizzazioneDocumentoRepository extends JpaRepository<TdCriterioOrganizzazioneDocumentoEntity, Integer> {

    @Query(value = "SELECT * from anagrafiche.td_criterio_organizzazione_documento ORDER BY id_criterio_organizzazione_documento", nativeQuery = true)
    Optional<List<TdCriterioOrganizzazioneDocumentoEntity>> getLista_TD_CRITERIO_ORGANIZZAZIONE_DOCUMENTO();
    @Query(value = "SELECT * from anagrafiche.td_criterio_organizzazione_documento WHERE flag_attivo = 'Y' ORDER BY id_criterio_organizzazione_documento", nativeQuery = true)
    Optional<List<TdCriterioOrganizzazioneDocumentoEntity>> getLista_TD_CRITERIO_ORGANIZZAZIONE_DOCUMENTO_Attivi();
}
