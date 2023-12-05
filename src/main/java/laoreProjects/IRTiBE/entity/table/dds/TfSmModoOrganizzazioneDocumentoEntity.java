package laoreProjects.IRTiBE.entity.table.dds;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import laoreProjects.IRTiBE.entity.table.dds.primaryKeys.TfSmModoOrganizzazioneDocumentoPK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(TfSmModoOrganizzazioneDocumentoPK.class)
@Table(name = "tf_sm_modo_organizzazione_documento", schema = "dds")
public class TfSmModoOrganizzazioneDocumentoEntity {

    @Id
    private Integer id_modo_organizzazione_documento_sm;
    @Id
    private Integer id_modo_organizzazione_documento;
}
