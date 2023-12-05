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
public class TfSmTipoDocumentoPK implements Serializable {
    private Integer id_tipo_documento_sm;
    private Integer id_tipo_documento;
}
