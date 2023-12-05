package laoreProjects.IRTiBE.entity.table.dds.primaryKeys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TfSmModoRegistrazioneDocumentoProtocolloPK implements Serializable {

    private Integer id_modo_registrazione_documento_protocollo_sm;
    private Integer id_modo_registrazione_documento_protocollo;
}
