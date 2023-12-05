package laoreProjects.IRTiBE.repository.table.dds;

import laoreProjects.IRTiBE.entity.table.dds.TfSmLuogoPubblicazioneDocumentiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TfSmLuogoPubblicazioneDocumentiRepository extends JpaRepository<TfSmLuogoPubblicazioneDocumentiEntity, Integer> {

    @Query(value = "SELECT dds.f_get_next_id_luogo_pubblicazione_documento_sm()", nativeQuery = true)
    Integer getNext_ID_LUOGO_PUBBLICAZIONE_DOCUMENTO_SM();
}
