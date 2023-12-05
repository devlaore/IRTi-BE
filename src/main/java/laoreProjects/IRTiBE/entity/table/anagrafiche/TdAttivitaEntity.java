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
@Table(name = "td_attivita", schema = "anagrafiche")
@SequenceGenerator(name = "td_attivita_seq_generator", schema = "anagrafiche",
        sequenceName = "td_attivita_seq", initialValue = 1003, allocationSize = 1)
public class TdAttivitaEntity {

    @Id
    @GeneratedValue(generator = "td_attivita_seq_generator", strategy = GenerationType.SEQUENCE)
    private Integer id_attivita;
    private String nome_attivita;
    private String desc_attivita;
    private String flag_attivo;
}
