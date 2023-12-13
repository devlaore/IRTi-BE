package laoreProjects.IRTiBE.model.request;

import laoreProjects.IRTiBE.entity.table.anagrafiche.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionarioModelRequest {

    /*
        Campi del form: G E N E R A L I
     */
    private TdAttivitaEntity tdAttivitaEntity;
    private TdAmbitoAttivitaEntity tdAmbitoAttivitaEntity;
    private String ambitoAttivitaAltro;
    private TdMacroAttivitaEntity tdMacroAttivitaEntity;
    private String macroAttivitaAltro;
    private String annotazioniGenerali;
    private List<TdTipoDocumentoEntity> listaTdTipoDocumentoEntity;
    private String tipoDocumentoAltro;
    private String flag_applicativo;
    private List<TdApplicativoEntity> listaTdApplicativoEntity;
    private String applicativoAltro;
    private String flagModoRegistrazioneDocumentoProtocollo;
    private List<TdModoRegistrazioneDocumentoProtocolloEntity> listaTdModoRegistrazioneDocumentoProtocolloEntity;
    private String modoRegistrazioneDocumentoProtocolloAltro;
    private TdTitoloEntity tdTitoloEntity;
    private TdClasseEntity tdClasseEntity;


    /*
        Campi del form: O R G A N I Z Z A Z I O N E   D O C U M E N T O
     */
    private TdModoGestioneDocumentoEntity tdModoGestioneDocumentoEntity;
    private List<TdModoOrganizzazioneDocumentoEntity> listaTdModoOrganizzazioneDocumentoEntity;
    private List<TdCriterioOrganizzazioneDocumentoEntity> listaTdCriterioOrganizzazioneDocumentoEntity;
    private String annotazioniOrganizzazioneDoc;

    /*
        Campi del form: P U B B L I C A Z I O N E   D O C U M E N T O
     */
    private String flagLuogoPubblicazioneDocumento;
    private List<TdLuogoPubblicazioneDocumentoEntity> listaTdLuogoPubblicazioneDocumentoEntity;
    private String luogoPubblicazioneDocumentoAltro;
    private String annotazioniPubblicazioneDoc;

    /*
        Campi del form: D A T I   C O M P I L A N T E   Q U E S T I O N A R I O
     */
    private String nominativoCompilante;
    private String emailCompilante;
    private String telefonoCompilante;
    private TdServizioEntity tdServizioEntity;
    private String annotazioniCompilanteQuestionario;
    private String dataCompilazioneQuestionario;

}
