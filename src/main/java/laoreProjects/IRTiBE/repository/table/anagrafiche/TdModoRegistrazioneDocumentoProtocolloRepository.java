package laoreProjects.IRTiBE.repository.table.anagrafiche;

import laoreProjects.IRTiBE.entity.table.anagrafiche.TdModoRegistrazioneDocumentoProtocolloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TdModoRegistrazioneDocumentoProtocolloRepository extends JpaRepository<TdModoRegistrazioneDocumentoProtocolloEntity, Integer> {

    @Query(value = "SELECT * from anagrafiche.td_modo_registrazione_documento_protocollo ORDER BY id_modo_registrazione_documento_protocollo", nativeQuery = true)
    Optional<List<TdModoRegistrazioneDocumentoProtocolloEntity>> getLista_TD_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO();
    @Query(value = "SELECT * from anagrafiche.td_modo_registrazione_documento_protocollo WHERE flag_attivo = 'Y' ORDER BY id_modo_registrazione_documento_protocollo", nativeQuery = true)
    Optional<List<TdModoRegistrazioneDocumentoProtocolloEntity>> getLista_TD_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO_Attivi();
}
