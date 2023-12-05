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
@Table(name = "td_applicativo", schema = "anagrafiche")
@SequenceGenerator(name = "td_applicativo_seq_generator", schema = "anagrafiche",
        sequenceName = "td_applicativo_seq", initialValue = 1008, allocationSize = 1)
public class TdApplicativoEntity {

    @Id
    @GeneratedValue(generator = "td_applicativo_seq_generator", strategy = GenerationType.SEQUENCE)
    private Integer id_applicativo;
    private String nome_applicativo;
    private String flag_attivo;
}
