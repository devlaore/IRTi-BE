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
public class TfSmCriterioOrganizzazioneDocumentoPK implements Serializable {

    Integer id_criterio_organizzazione_documento_sm;
    Integer id_criterio_organizzazione_documento;

}
