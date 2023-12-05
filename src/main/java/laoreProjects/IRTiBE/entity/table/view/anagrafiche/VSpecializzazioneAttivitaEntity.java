package laoreProjects.IRTiBE.entity.view.anagrafiche;

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
@Table(name = "v_specializzazione_attivita", schema = "anagrafiche")
public class VSpecializzazioneAttivitaEntity {

    @Id
    private Integer id_specializzazione_attivita;
    private Integer id_macro_attivita;
    private String nome_specializzazione_attivita;
    private String nome_macro_attivita;
    private String flag_attivo;

}
