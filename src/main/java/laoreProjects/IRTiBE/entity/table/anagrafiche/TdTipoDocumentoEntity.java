package laoreProjects.IRTiBE.entity.table.anagrafiche;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "td_tipo_documento", schema = "anagrafiche")
@SequenceGenerator(name = "td_tipo_documento_seq_generator", schema = "anagrafiche",
        sequenceName = "td_tipo_documento_seq", initialValue = 1018, allocationSize = 1)
public class TdTipoDocumentoEntity {

    @Id
    @GeneratedValue(generator = "td_tipo_documento_seq_generator", strategy = GenerationType.SEQUENCE)
    private Integer id_tipo_documento;
    private String nome_tipo_documento;
    private String flag_attivo;
}
