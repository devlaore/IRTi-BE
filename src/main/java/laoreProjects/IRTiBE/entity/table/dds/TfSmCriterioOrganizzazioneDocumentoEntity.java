package laoreProjects.IRTiBE.entity.table.dds;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import laoreProjects.IRTiBE.entity.table.dds.primaryKeys.TfSmCriterioOrganizzazioneDocumentoPK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(TfSmCriterioOrganizzazioneDocumentoPK.class)
@Table(name = "tf_sm_criterio_organizzazione_documento", schema = "dds")
public class TfSmCriterioOrganizzazioneDocumentoEntity {

    @Id
    Integer id_criterio_organizzazione_documento_sm;
    @Id
    Integer id_criterio_organizzazione_documento;
}
