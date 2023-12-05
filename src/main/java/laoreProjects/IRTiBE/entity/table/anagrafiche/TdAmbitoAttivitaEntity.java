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
@Table(name = "td_ambito_attivita", schema = "anagrafiche")
@SequenceGenerator(name = "td_ambito_attivita_seq_generator", schema = "anagrafiche",
        sequenceName = "td_ambito_attivita_seq", initialValue = 1008, allocationSize = 1)
public class TdAmbitoAttivitaEntity {

    @Id
    @GeneratedValue(generator = "td_ambito_attivita_seq_generator", strategy = GenerationType.SEQUENCE)
    private Integer id_ambito_attivita;
    private String nome_ambito_attivita;
    private String flag_attivo;
}
