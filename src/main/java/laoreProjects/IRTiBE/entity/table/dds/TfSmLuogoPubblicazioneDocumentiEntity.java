package laoreProjects.IRTiBE.entity.table.dds;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import laoreProjects.IRTiBE.entity.table.dds.primaryKeys.TfSmLuogoPubblicazioneDocumentiPK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(TfSmLuogoPubblicazioneDocumentiPK.class)
@Table(name = "tf_sm_luogo_pubblicazione_documento", schema = "dds")
public class TfSmLuogoPubblicazioneDocumentiEntity {

    @Id
    private Integer id_luogo_pubblicazione_documento_sm;
    @Id
    private Integer id_luogo_pubblicazione_documento;
}
