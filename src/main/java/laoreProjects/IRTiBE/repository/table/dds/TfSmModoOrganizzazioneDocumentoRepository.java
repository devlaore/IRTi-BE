package laoreProjects.IRTiBE.repository.table.dds;

import laoreProjects.IRTiBE.entity.table.dds.TfSmModoOrganizzazioneDocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TfSmModoOrganizzazioneDocumentoRepository extends JpaRepository<TfSmModoOrganizzazioneDocumentoEntity, Integer> {

    @Query(value = "SELECT dds.f_get_next_id_modo_organizzazione_documento_sm()", nativeQuery = true)
    Integer getNext_ID_ID_MODO_ORGANIZZAZIONE_DOCUMENTO_SM();
}
