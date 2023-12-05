package laoreProjects.IRTiBE.entity.table.dds;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import laoreProjects.IRTiBE.entity.table.dds.primaryKeys.TfSmModoRegistrazioneDocumentoProtocolloPK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(TfSmModoRegistrazioneDocumentoProtocolloPK.class)
@Table(name = "tf_sm_modo_registrazione_documento_protocollo", schema = "dds")
public class TfSmModoRegistrazioneDocumentoProtocolloEntity {

    @Id
    private Integer id_modo_registrazione_documento_protocollo_sm;
    @Id
    private Integer id_modo_registrazione_documento_protocollo;
}
