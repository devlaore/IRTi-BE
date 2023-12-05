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
@Table(name = "td_specializzazione_attivita", schema = "anagrafiche")
@SequenceGenerator(name = "td_specializzazione_attivita_seq_generator", schema = "anagrafiche",
        sequenceName = "td_specializzazione_attivita_seq", initialValue = 1124, allocationSize = 1)
public class TdSpecializzazioneAttivitaEntity {

    @Id
    @GeneratedValue(generator = "td_specializzazione_attivita_seq_generator", strategy = GenerationType.SEQUENCE)
    private Integer id_specializzazione_attivita;
    private Integer id_macro_attivita;
    private String nome_specializzazione_attivita;
    private String flag_attivo;
}
