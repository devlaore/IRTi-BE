package laoreProjects.IRTiBE.entity.table.dds;

import jakarta.persistence.*;
import laoreProjects.IRTiBE.entity.table.dds.primaryKeys.TfSmTipoDocumentoPK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(TfSmTipoDocumentoPK.class)
@Table(name = "tf_sm_tipo_documento", schema = "dds")
public class TfSmTipoDocumentoEntity {

    @Id
    private Integer id_tipo_documento_sm;
    @Id
    private Integer id_tipo_documento;
}
