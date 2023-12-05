package laoreProjects.IRTiBE.entity.table.dds;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tf_questionario", schema = "dds")
@SequenceGenerator(name = "tf_questionario_seq_generator", schema = "dds",
        sequenceName = "tf_questionario_seq", initialValue = 100001, allocationSize = 1)
public class TfQuestionarioEntity {

    @Id
    @GeneratedValue(generator = "tf_questionario_seq_generator", strategy = GenerationType.SEQUENCE)
    private Integer id_questionario;
    private Integer id_attivita;
    private Integer id_ambito_attivita;
    private Integer id_macro_attivita;
    private Integer id_specializzazione_attivita;
    private Integer id_tipo_documento_sm;
    private Integer id_applicativo_sm;
    private Integer id_modo_registrazione_documento_protocollo_sm;
    private Integer id_titolo;
    private Integer id_classe;
    private Integer id_modo_gestione_documento;
    private Integer id_modo_organizzazione_documento_sm;
    private Integer id_criterio_organizzazione_documento_sm;
    private Integer id_luogo_pubblicazione_documento_sm;
    private Integer id_servizio;
    private String annotazioni_generali;
    private String annotazioni_organizzazione_doc;
    private String annotazioni_pubblicazione_doc;
    private String annotazioni_compilante_questionario;
    private String flag_applicativo;
    private String flag_modo_registrazione_documento_protocollo;
    private String flag_luogo_pubblicazione_documento;
    private String nominativo_compilante;
    private String email_compilante;
    private String telefono_compilante;
    private LocalDate data_compilazione_questionario;

}
