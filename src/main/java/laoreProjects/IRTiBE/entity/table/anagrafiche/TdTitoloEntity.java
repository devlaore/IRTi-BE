package laoreProjects.IRTiBE.entity.table.anagrafiche;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "td_titolo", schema = "anagrafiche")
public class TdTitoloEntity {

    @Id
    private Integer id_titolo;
    private String codice_titolo;
    private String nome_titolo;
}
