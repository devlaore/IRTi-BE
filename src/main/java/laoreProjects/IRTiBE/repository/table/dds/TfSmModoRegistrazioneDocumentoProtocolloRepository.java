package laoreProjects.IRTiBE.repository.table.dds;

import laoreProjects.IRTiBE.entity.table.dds.TfSmModoRegistrazioneDocumentoProtocolloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TfSmModoRegistrazioneDocumentoProtocolloRepository extends JpaRepository<TfSmModoRegistrazioneDocumentoProtocolloEntity, Integer> {

    @Query(value = "SELECT dds.f_get_next_id_modo_registrazione_documento_protocollo_sm()", nativeQuery = true)
    Integer getNext_ID_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO_SM();
}
