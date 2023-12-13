package laoreProjects.IRTiBE.service;

import jakarta.transaction.Transactional;
import laoreProjects.IRTiBE.entity.table.anagrafiche.*;
import laoreProjects.IRTiBE.entity.table.dds.*;
import laoreProjects.IRTiBE.entity.view.dds.VQuestionarioEntity;
import laoreProjects.IRTiBE.model.request.QuestionarioModelRequest;
import laoreProjects.IRTiBE.repository.table.dds.*;
import laoreProjects.IRTiBE.repository.view.dds.VQuestionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DDSService {

    private final String ALTRO = "Altro";

    private final AnagraficheService anagraficheService;

    private final VQuestionarioRepository vQuestionarioRepository;
    private final TfQuestionarioRepository tfQuestionarioRepository;
    private final TfSmTipoDocumentoRepository tfSmTipoDocumentoRepository;
    private final TfSmApplicativoRepository tfSmApplicativoRepository;
    private final TfSmLuogoPubblicazioneDocumentiRepository tfSmLuogoPubblicazioneDocumentiRepository;
    private final TfSmModoRegistrazioneDocumentoProtocolloRepository tfSmModoRegistrazioneDocumentoProtocolloRepository;
    private final TfSmCriterioOrganizzazioneDocumentoRepository tfSmCriterioOrganizzazioneDocumentoRepository;
    private final TfSmModoOrganizzazioneDocumentoRepository tfSmModoOrganizzazioneDocumentoRepository;

    /*
        Service vista: tf_questionario
     */
    public TfQuestionarioEntity salva_TF_QUESTIONARIO(QuestionarioModelRequest questionarioModelRequest) {
        /*
            Salva un record della tabella TF_QUESTIONARIO
         */

/*
        Gestione campi del form: G E N E R A L I
*/
        // ID_QUESTIONARIO
        TfQuestionarioEntity tfQuestionarioEntity = new TfQuestionarioEntity();

        // ID_ATTIVITA --> Obbligatorio
        tfQuestionarioEntity.setId_attivita(questionarioModelRequest.getTdAttivitaEntity().getId_attivita());

        // ID_AMBITO_ATTIVITA --> Obbligatorio(tra quelli presenti o "Altro")
        if (questionarioModelRequest.getAmbitoAttivitaAltro() == null) {
            tfQuestionarioEntity.setId_ambito_attivita(questionarioModelRequest.getTdAmbitoAttivitaEntity().getId_ambito_attivita());
        } else {
            TdAmbitoAttivitaEntity tdAmbitoAttivitaEntity = anagraficheService.addAmbitoAttivita(questionarioModelRequest.getAmbitoAttivitaAltro());
            tfQuestionarioEntity.setId_ambito_attivita(tdAmbitoAttivitaEntity.getId_ambito_attivita());
        }

        // ID_MACRO_ATTIVITA --> Obbligatorio(tra quelli presenti o "Altro")
        if (questionarioModelRequest.getMacroAttivitaAltro() == null) {
            tfQuestionarioEntity.setId_macro_attivita(questionarioModelRequest.getTdMacroAttivitaEntity().getId_macro_attivita());
        } else {
            TdMacroAttivitaEntity tdMacroAttivitaEntity = anagraficheService.addMacroAttivita(questionarioModelRequest.getMacroAttivitaAltro(), tfQuestionarioEntity.getId_ambito_attivita());
            tfQuestionarioEntity.setId_macro_attivita(tdMacroAttivitaEntity.getId_macro_attivita());
        }

        // ANNOTAZIONI_GENERALI --> NON Obbligatorio
        tfQuestionarioEntity.setAnnotazioni_generali(questionarioModelRequest.getAnnotazioniGenerali());

        // ID_TIPO_DOCUMENTO --> Obbligatorio
        if (questionarioModelRequest.getTipoDocumentoAltro() == null) {
            Integer next_ID_TIPO_DOCUMENTO_SM = salva_TF_SM_TIPO_DOCUMENTO(questionarioModelRequest.getListaTdTipoDocumentoEntity());
            tfQuestionarioEntity.setId_tipo_documento_sm(next_ID_TIPO_DOCUMENTO_SM);
        } else {
            // Rimuovo dalla lista dei Tipo Documento il Tipo Documento "Altro"
            questionarioModelRequest.getListaTdTipoDocumentoEntity().removeIf( tdTipoDocumento -> (tdTipoDocumento.getId_tipo_documento() == 9999));

            TdTipoDocumentoEntity tdTipoDocumentoEntity = anagraficheService.addTipoDocumento(questionarioModelRequest.getTipoDocumentoAltro());
            questionarioModelRequest.getListaTdTipoDocumentoEntity().add(tdTipoDocumentoEntity);
            Integer next_ID_TIPO_DOCUMENTO_SM = salva_TF_SM_TIPO_DOCUMENTO(questionarioModelRequest.getListaTdTipoDocumentoEntity());
            tfQuestionarioEntity.setId_tipo_documento_sm(next_ID_TIPO_DOCUMENTO_SM);
        }

        // FLAG_DOCUMENTO_GESTITO_DA_APPLICATIVO --> Obbligatorio
        tfQuestionarioEntity.setFlag_applicativo(questionarioModelRequest.getFlag_applicativo());

        // ID_APPLICATIVO --> Obbligatorio se FLAG_DOCUMENTO_GESTITO_DA_APPLICATIVO scelto = "SI"
        if (questionarioModelRequest.getFlag_applicativo() != null && questionarioModelRequest.getFlag_applicativo().equals("Si")) {
            if (questionarioModelRequest.getApplicativoAltro() == null) {
                Integer next_ID_APPLICATIVO_SM = salva_TF_SM_APPLICATIVO(questionarioModelRequest.getListaTdApplicativoEntity());
                tfQuestionarioEntity.setId_applicativo_sm(next_ID_APPLICATIVO_SM);
            } else {
                // Rimuovo dalla lista degli applicativi l'applicativo "Altro"
                questionarioModelRequest.getListaTdApplicativoEntity().removeIf( tdApplicativo -> (tdApplicativo.getId_applicativo() == 99999));

                TdApplicativoEntity tdApplicativoEntity = anagraficheService.addApplicativo(questionarioModelRequest.getApplicativoAltro());
                questionarioModelRequest.getListaTdApplicativoEntity().add(tdApplicativoEntity);
                Integer next_ID_APPLICATIVO_SM = salva_TF_SM_APPLICATIVO(questionarioModelRequest.getListaTdApplicativoEntity());
                tfQuestionarioEntity.setId_applicativo_sm(next_ID_APPLICATIVO_SM);
            }
        } else {
            tfQuestionarioEntity.setId_applicativo_sm(null);
        }

        // FLAG_REGISTRAZIONE_DOCUMENTO_A_PROTOCOLLO --> Obbligatorio
        tfQuestionarioEntity.setFlag_modo_registrazione_documento_protocollo(questionarioModelRequest.getFlagModoRegistrazioneDocumentoProtocollo());

        // ID_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO --> Obbligatorio se FLAG_REGISTRAZIONE_DOCUMENTO_A_PROTOCOLLO scelto = "In parte" ==> da verificare
        if (questionarioModelRequest.getFlagModoRegistrazioneDocumentoProtocollo() != null && questionarioModelRequest.getFlagModoRegistrazioneDocumentoProtocollo().equals("In parte")) {
            if (questionarioModelRequest.getModoRegistrazioneDocumentoProtocolloAltro() == null) {
                Integer next_ID_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO_SM = salva_TF_SM_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO(questionarioModelRequest.getListaTdModoRegistrazioneDocumentoProtocolloEntity());
                tfQuestionarioEntity.setId_modo_registrazione_documento_protocollo_sm(next_ID_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO_SM);

            } else {
                // Rimuovo dalla lista dei Modo Registrazione Documento il Modo Registrazione Documento "Altro"
                questionarioModelRequest.getListaTdModoRegistrazioneDocumentoProtocolloEntity().removeIf( tdModoRegistrazioneDocumentoProtocollo -> (tdModoRegistrazioneDocumentoProtocollo.getId_modo_registrazione_documento_protocollo() == 9999));

                TdModoRegistrazioneDocumentoProtocolloEntity tdModoRegistrazioneDocumentoProtocolloEntity = anagraficheService.addModoRegistrazioneDocumentoProtocollo(questionarioModelRequest.getModoRegistrazioneDocumentoProtocolloAltro());
                questionarioModelRequest.getListaTdModoRegistrazioneDocumentoProtocolloEntity().add(tdModoRegistrazioneDocumentoProtocolloEntity);
                Integer next_ID_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO_SM = salva_TF_SM_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO(questionarioModelRequest.getListaTdModoRegistrazioneDocumentoProtocolloEntity());
                tfQuestionarioEntity.setId_modo_registrazione_documento_protocollo_sm(next_ID_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO_SM);
            }
        } else {
            tfQuestionarioEntity.setId_modo_registrazione_documento_protocollo_sm(null);
        }

        // ID_TITOLO --> Obbligatorio
        if(questionarioModelRequest.getTdTitoloEntity() != null) {
            tfQuestionarioEntity.setId_titolo(questionarioModelRequest.getTdTitoloEntity().getId_titolo());
        } else {
            tfQuestionarioEntity.setId_titolo(null);
        }

        // ID_CLASSE --> Obbligatorio
        if(questionarioModelRequest.getTdClasseEntity() != null) {
            tfQuestionarioEntity.setId_classe(questionarioModelRequest.getTdClasseEntity().getId_classe());
        } else {
            tfQuestionarioEntity.setId_classe(null);
        }



/*
        Gestione campi del form: O R G A N I Z Z A Z I O N E   D O C U M E N T O
*/
        // ID_MODO_GESTIONE_DOCUMENTO --> Obbligatorio
        if(questionarioModelRequest.getTdModoGestioneDocumentoEntity() != null) {
            tfQuestionarioEntity.setId_modo_gestione_documento(questionarioModelRequest.getTdModoGestioneDocumentoEntity().getId_modo_gestione_documento());
        } else {
            tfQuestionarioEntity.setId_modo_gestione_documento(null);
        }

        // ID_MODO_ORGANIZZAZIONE_DOCUMENTO --> Obbligatorio
        if(questionarioModelRequest.getListaTdModoOrganizzazioneDocumentoEntity() != null) {
            Integer next_ID_MODO_ORGANIZZAZIONE_DOCUMENTO_SM = salva_TF_SM_MODO_ORGANIZZAZIONE_DOCUMENTO(questionarioModelRequest.getListaTdModoOrganizzazioneDocumentoEntity());
            tfQuestionarioEntity.setId_modo_organizzazione_documento_sm(next_ID_MODO_ORGANIZZAZIONE_DOCUMENTO_SM);

        } else {
            tfQuestionarioEntity.setId_modo_organizzazione_documento_sm(null);
        }



        // ID_CRITERIO_ORGANIZZAZIONE_DOCUMENTO --> Obbligatorio
        if(questionarioModelRequest.getListaTdCriterioOrganizzazioneDocumentoEntity() != null) {
            Integer next_ID_CRITERIO_ORGANIZZAZIONE_DOCUMENTO_SM = salva_TF_SM_CRITERIO_ORGANIZZAZIONE_DOCUMENTO(questionarioModelRequest.getListaTdCriterioOrganizzazioneDocumentoEntity());
            tfQuestionarioEntity.setId_criterio_organizzazione_documento_sm(next_ID_CRITERIO_ORGANIZZAZIONE_DOCUMENTO_SM);

        } else {
            tfQuestionarioEntity.setId_criterio_organizzazione_documento_sm(null);
        }



        // ANNOTAZIONI_ORGANIZZAZIONE_DOCUMENTO --> Non Obbligatorio
        tfQuestionarioEntity.setAnnotazioni_organizzazione_doc(questionarioModelRequest.getAnnotazioniOrganizzazioneDoc());


/*
        Gestione campi del form: P U B B L I C A Z I O N E   D O C U M E N T O
*/

        // FLAG_DOCUMENTO_SOGGETTO_A_PUBBLICAZIONE --> Obbligatorio
        tfQuestionarioEntity.setFlag_luogo_pubblicazione_documento(questionarioModelRequest.getFlagLuogoPubblicazioneDocumento());

        // ID_LUOGO_PUBBLICAZIONE_DOCUMENTO --> Obbligatorio se FLAG_DOCUMENTO_SOGGETTO_A_PUBBLICAZIONE scelto = "Si"
        if (questionarioModelRequest.getFlagLuogoPubblicazioneDocumento() != null && questionarioModelRequest.getFlagLuogoPubblicazioneDocumento().equals("Si")) {
            if (questionarioModelRequest.getLuogoPubblicazioneDocumentoAltro() == null) {
                Integer next_ID_LUOGO_PUBBLICAZIONE_DOCUMENTO = salva_TF_SM_LUOGO_PUBBLICAZIONE_DOCUMENTO(questionarioModelRequest.getListaTdLuogoPubblicazioneDocumentoEntity());
                tfQuestionarioEntity.setId_luogo_pubblicazione_documento_sm(next_ID_LUOGO_PUBBLICAZIONE_DOCUMENTO);
            } else {
                // Rimuovo dalla lista dei Luogo Pubblicazione Documento il Luogo Pubblicazione Documento "Altro"
                questionarioModelRequest.getListaTdLuogoPubblicazioneDocumentoEntity().removeIf( tdLuogoPubblicazioneDocumento -> (tdLuogoPubblicazioneDocumento.getId_luogo_pubblicazione_documento() == 9999));

                TdLuogoPubblicazioneDocumentoEntity tdLuogoPubblicazioneDocumentoEntity = anagraficheService.addLuogoPubblicazioneDocumenti(questionarioModelRequest.getLuogoPubblicazioneDocumentoAltro());
                questionarioModelRequest.getListaTdLuogoPubblicazioneDocumentoEntity().add(tdLuogoPubblicazioneDocumentoEntity);
                Integer next_ID_LUOGO_PUBBLICAZIONE_DOCUMENTO = salva_TF_SM_LUOGO_PUBBLICAZIONE_DOCUMENTO(questionarioModelRequest.getListaTdLuogoPubblicazioneDocumentoEntity());
                tfQuestionarioEntity.setId_luogo_pubblicazione_documento_sm(next_ID_LUOGO_PUBBLICAZIONE_DOCUMENTO);
            }
        } else {
            tfQuestionarioEntity.setId_luogo_pubblicazione_documento_sm(null);
        }

        // ANNOTAZIONI_PUBBLICAZIONE_DOC --> Non Obbligatorio
        tfQuestionarioEntity.setAnnotazioni_pubblicazione_doc(questionarioModelRequest.getAnnotazioniPubblicazioneDoc());


/*
        Gestione campi del form: D A T I   C O M P I L A N T E   Q U E S T I O N A R I O
*/
        // NOMINATIVO_COMPILANTE --> Obbligatorio
        tfQuestionarioEntity.setNominativo_compilante(questionarioModelRequest.getNominativoCompilante());

        // E_MAIL_COMPILANTE --> Obbligatorio
        tfQuestionarioEntity.setEmail_compilante(questionarioModelRequest.getEmailCompilante());

        // TELEFONO_COMPILANTE --> Obbligatorio
        tfQuestionarioEntity.setTelefono_compilante(questionarioModelRequest.getTelefonoCompilante());

        // ID_SERVIZIO --> Obbligatorio
        if(questionarioModelRequest.getTdServizioEntity() != null) {
            tfQuestionarioEntity.setId_servizio(questionarioModelRequest.getTdServizioEntity().getId_servizio());
        } else {
            tfQuestionarioEntity.setId_servizio(null);
        }

        // ANNOTAZIONI_COMPILANTE_QUESTIONARIO --> Obbligatorio
        tfQuestionarioEntity.setAnnotazioni_compilante_questionario(questionarioModelRequest.getAnnotazioniCompilanteQuestionario());

        // DATA_COMPILAZIONE_QUESTIONARIO --> Obbligatorio
        DateTimeFormatter dFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        tfQuestionarioEntity.setData_compilazione_questionario(LocalDate.parse(questionarioModelRequest.getDataCompilazioneQuestionario(), dFormatter));



        tfQuestionarioRepository.save(tfQuestionarioEntity);

        return tfQuestionarioEntity;
    }

    /*
        Service vista: v_questionario
     */
    public List<VQuestionarioEntity> getLista_V_QUESTIONARIO() {
        /*
            Ritorna la lista dei questionari compilati dalla vista V_QUESTIONARIO
         */
        Optional<List<VQuestionarioEntity>> op_VQuestionarioEntity;
        List<VQuestionarioEntity> listaVQuestionarioEntity;

        op_VQuestionarioEntity = vQuestionarioRepository.getLista_V_QUESTIONARIO();

        if (op_VQuestionarioEntity.isEmpty())
            listaVQuestionarioEntity = new ArrayList();
        else
            listaVQuestionarioEntity = op_VQuestionarioEntity.get();

        return listaVQuestionarioEntity;
    }


    /*
        Service tabelle memorizzazione "Selezioni Multiple"
     */
    private Integer salva_TF_SM_TIPO_DOCUMENTO(List<TdTipoDocumentoEntity> listaTdTipoDocumentoEntity)  {

        if(listaTdTipoDocumentoEntity == null) {
            return null;
        }

        Integer next_ID_TIPO_DOCUMENTO_SM = tfSmTipoDocumentoRepository.getNext_ID_TIPO_DOCUMENTO_SM();

        for(TdTipoDocumentoEntity tdTipoDocumentoEntity : listaTdTipoDocumentoEntity) {

            TfSmTipoDocumentoEntity tfSmTipoDocumentoEntity = new TfSmTipoDocumentoEntity();

            tfSmTipoDocumentoEntity.setId_tipo_documento_sm(next_ID_TIPO_DOCUMENTO_SM);
            tfSmTipoDocumentoEntity.setId_tipo_documento(tdTipoDocumentoEntity.getId_tipo_documento());

            tfSmTipoDocumentoRepository.save(tfSmTipoDocumentoEntity);
        }

        return next_ID_TIPO_DOCUMENTO_SM;
    }
    private Integer salva_TF_SM_APPLICATIVO(List<TdApplicativoEntity> listaTdApplicativoEntity)  {

        if(listaTdApplicativoEntity == null) {
            return null;
        }

        Integer next_ID_APPLICATIVO_SM = tfSmApplicativoRepository.getNext_ID_APPLICATIVO_SM();

        for(TdApplicativoEntity tdApplicativoEntity : listaTdApplicativoEntity) {

            TfSmApplicativoEntity tfSmTipoDocumentoEntity = new TfSmApplicativoEntity();

            tfSmTipoDocumentoEntity.setId_applicativo_sm(next_ID_APPLICATIVO_SM);
            tfSmTipoDocumentoEntity.setId_applicativo(tdApplicativoEntity.getId_applicativo());

            tfSmApplicativoRepository.save(tfSmTipoDocumentoEntity);
        }

        return next_ID_APPLICATIVO_SM;
    }
    private Integer salva_TF_SM_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO(List<TdModoRegistrazioneDocumentoProtocolloEntity> listaTdModoRegistrazioneDocumentoProtocolloEntity)  {

        Integer next_ID_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO_SM = tfSmModoRegistrazioneDocumentoProtocolloRepository.getNext_ID_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO_SM();

        for(TdModoRegistrazioneDocumentoProtocolloEntity tdModoRegistrazioneDocumentoProtocolloEntity : listaTdModoRegistrazioneDocumentoProtocolloEntity) {

            TfSmModoRegistrazioneDocumentoProtocolloEntity tfSmModoRegistrazioneDocumentoProtocolloEntity = new TfSmModoRegistrazioneDocumentoProtocolloEntity();

            tfSmModoRegistrazioneDocumentoProtocolloEntity.setId_modo_registrazione_documento_protocollo_sm(next_ID_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO_SM);
            tfSmModoRegistrazioneDocumentoProtocolloEntity.setId_modo_registrazione_documento_protocollo(tdModoRegistrazioneDocumentoProtocolloEntity.getId_modo_registrazione_documento_protocollo());

            tfSmModoRegistrazioneDocumentoProtocolloRepository.save(tfSmModoRegistrazioneDocumentoProtocolloEntity);
        }

        return next_ID_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO_SM;
    }
    private Integer salva_TF_SM_LUOGO_PUBBLICAZIONE_DOCUMENTO(List<TdLuogoPubblicazioneDocumentoEntity> listaTdLuogoPubblicazioneDocumentoEntity)  {

        Integer next_ID_LUOGO_PUBBLICAZIONE_DOCUMENTO_SM = tfSmLuogoPubblicazioneDocumentiRepository.getNext_ID_LUOGO_PUBBLICAZIONE_DOCUMENTO_SM();

        for(TdLuogoPubblicazioneDocumentoEntity tdLuogoPubblicazioneDocumentoEntity : listaTdLuogoPubblicazioneDocumentoEntity) {

            TfSmLuogoPubblicazioneDocumentiEntity tfSmLuogoPubblicazioneDocumentiEntity = new TfSmLuogoPubblicazioneDocumentiEntity();

            tfSmLuogoPubblicazioneDocumentiEntity.setId_luogo_pubblicazione_documento_sm(next_ID_LUOGO_PUBBLICAZIONE_DOCUMENTO_SM);
            tfSmLuogoPubblicazioneDocumentiEntity.setId_luogo_pubblicazione_documento(tdLuogoPubblicazioneDocumentoEntity.getId_luogo_pubblicazione_documento());

            tfSmLuogoPubblicazioneDocumentiRepository.save(tfSmLuogoPubblicazioneDocumentiEntity);
        }

        return next_ID_LUOGO_PUBBLICAZIONE_DOCUMENTO_SM;
    }
    private Integer salva_TF_SM_CRITERIO_ORGANIZZAZIONE_DOCUMENTO(List<TdCriterioOrganizzazioneDocumentoEntity> listaTdCriterioOrganizzazioneDocumentoEntity)  {

        Integer next_ID_CRITERIO_ORGANIZZAZIONE_DOCUMENTO_SM = tfSmCriterioOrganizzazioneDocumentoRepository.getNext_ID_CRITERIO_ORGANIZZAZIONE_DOCUMENTO_SM();

        for(TdCriterioOrganizzazioneDocumentoEntity tdCriterioOrganizzazioneDocumentoEntity : listaTdCriterioOrganizzazioneDocumentoEntity) {

            TfSmCriterioOrganizzazioneDocumentoEntity tfSmCriterioOrganizzazioneDocumentoEntity = new TfSmCriterioOrganizzazioneDocumentoEntity();

            tfSmCriterioOrganizzazioneDocumentoEntity.setId_criterio_organizzazione_documento_sm(next_ID_CRITERIO_ORGANIZZAZIONE_DOCUMENTO_SM);
            tfSmCriterioOrganizzazioneDocumentoEntity.setId_criterio_organizzazione_documento(tdCriterioOrganizzazioneDocumentoEntity.getId_criterio_organizzazione_documento());

            tfSmCriterioOrganizzazioneDocumentoRepository.save(tfSmCriterioOrganizzazioneDocumentoEntity);
        }

        return next_ID_CRITERIO_ORGANIZZAZIONE_DOCUMENTO_SM;
    }
    private Integer salva_TF_SM_MODO_ORGANIZZAZIONE_DOCUMENTO(List<TdModoOrganizzazioneDocumentoEntity> listaTdModoOrganizzazioneDocumentoEntity)  {

        Integer next_ID_MODO_ORGANIZZAZIONE_DOCUMENTO_SM = tfSmModoOrganizzazioneDocumentoRepository.getNext_ID_ID_MODO_ORGANIZZAZIONE_DOCUMENTO_SM();

        for(TdModoOrganizzazioneDocumentoEntity tdModoOrganizzazioneDocumentoEntity : listaTdModoOrganizzazioneDocumentoEntity) {

            TfSmModoOrganizzazioneDocumentoEntity tfSmModoOrganizzazioneDocumentoEntity = new TfSmModoOrganizzazioneDocumentoEntity();

            tfSmModoOrganizzazioneDocumentoEntity.setId_modo_organizzazione_documento_sm(next_ID_MODO_ORGANIZZAZIONE_DOCUMENTO_SM);
            tfSmModoOrganizzazioneDocumentoEntity.setId_modo_organizzazione_documento(tdModoOrganizzazioneDocumentoEntity.getId_modo_organizzazione_documento());

            tfSmModoOrganizzazioneDocumentoRepository.save(tfSmModoOrganizzazioneDocumentoEntity);
        }

        return next_ID_MODO_ORGANIZZAZIONE_DOCUMENTO_SM;
    }

}
