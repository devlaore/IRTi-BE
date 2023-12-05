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
@Table(name = "td_modo_organizzazione_documento", schema = "anagrafiche")
@SequenceGenerator(name = "td_modo_organizzazione_documento_seq_generator", schema = "anagrafiche",
        sequenceName = "td_modo_organizzazione_documento_seq", initialValue = 1007, allocationSize = 1)
public class TdModoOrganizzazioneDocumentoEntity {

    @Id
    @GeneratedValue(generator = "td_modo_organizzazione_documento_seq_generator", strategy = GenerationType.SEQUENCE)
    private Integer id_modo_organizzazione_documento;
    private String nome_modo_organizzazione_documento;
    private String flag_attivo;
}
