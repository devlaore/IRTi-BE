package laoreProjects.IRTiBE.entity.view.dds;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "v_questionario", schema = "dds")
public class VQuestionarioEntity {

    @Id
    private Integer id_questionario;
    private String nome_attivita;
    private String nome_ambito_attivita;
    private String nome_macro_attivita;
    private String nome_specializzazione_attivita;
    private String lista_nome_tipo_documento;
    private String flag_applicativo;
    private String lista_nome_applicativo;
    private String flag_modo_registrazione_documento_protocollo;
    private String lista_nome_modo_registrazione_documento_protocollo;
    private String titolo;
    private String classe;
    private String annotazioni_generali;
    private String nome_modo_gestione_documento;
    private String lista_nome_modo_organizzazione_documento;
    private String lista_nome_criterio_organizzazione_documento;
    private String annotazioni_organizzazione_doc;
    private String flag_luogo_pubblicazione_documento;
    private String lista_nome_luogo_pubblicazione_documento;
    private String annotazioni_pubblicazione_doc;
    private String nome_servizio;
    private String nominativo_compilante;
    private String email_compilante;
    private String telefono_compilante;
    private String annotazioni_compilante_questionario;
    private LocalDate data_compilazione_questionario;
}
