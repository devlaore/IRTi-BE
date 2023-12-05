package laoreProjects.IRTiBE.repository.table.dds;

import laoreProjects.IRTiBE.entity.table.dds.TfSmCriterioOrganizzazioneDocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TfSmCriterioOrganizzazioneDocumentoRepository extends JpaRepository<TfSmCriterioOrganizzazioneDocumentoEntity, Integer> {

    @Query(value = "SELECT dds.f_get_next_id_criterio_organizzazione_documento_sm()", nativeQuery = true)
    Integer getNext_ID_CRITERIO_ORGANIZZAZIONE_DOCUMENTO_SM();
}
