package laoreProjects.IRTiBE.entity.view.anagrafiche;

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
@Table(name = "v_macro_attivita", schema = "anagrafiche")
public class VMacroAttivitaEntity {
    @Id
    private Integer id_macro_attivita;
    private Integer id_ambito_attivita;
    private String nome_macro_attivita;
    private String nome_ambito_attivita;
    private String flag_attivo;
}
