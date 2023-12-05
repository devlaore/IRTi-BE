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
@Table(name = "td_luogo_pubblicazione_documento", schema = "anagrafiche")
@SequenceGenerator(name = "td_luogo_pubblicazione_documento_seq_generator", schema = "anagrafiche",
        sequenceName = "td_luogo_pubblicazione_documento_seq", initialValue = 1004, allocationSize = 1)
public class TdLuogoPubblicazioneDocumentoEntity {

    @Id
    @GeneratedValue(generator = "td_luogo_pubblicazione_documento_seq_generator", strategy = GenerationType.SEQUENCE)
    private Integer id_luogo_pubblicazione_documento;
    private String nome_luogo_pubblicazione_documento;
    private String flag_attivo;

}
