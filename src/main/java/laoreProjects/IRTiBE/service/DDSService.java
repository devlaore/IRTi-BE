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
        Integer next_ID_TIPO_DOCUMENTO_SM = salva_TF_SM_TIPO_DOCUMENTO(questionarioModelRequest.getListaTdTipoDocumentoEntity(), questionarioModelRequest.getTipoDocumentoAltro());
        tfQuestionarioEntity.setId_tipo_documento_sm(next_ID_TIPO_DOCUMENTO_SM);

        // FLAG_DOCUMENTO_GESTITO_DA_APPLICATIVO --> Obbligatorio
        tfQuestionarioEntity.setFlag_applicativo(questionarioModelRequest.getFlag_applicativo());

        // ID_APPLICATIVO --> Obbligatorio se FLAG_DOCUMENTO_GESTITO_DA_APPLICATIVO scelto = "SI"
        Integer next_ID_APPLICATIVO_SM = salva_TF_SM_APPLICATIVO(questionarioModelRequest.getListaTdApplicativoEntity(), questionarioModelRequest.getApplicativoAltro());
        tfQuestionarioEntity.setId_applicativo_sm(next_ID_APPLICATIVO_SM);

        // FLAG_REGISTRAZIONE_DOCUMENTO_A_PROTOCOLLO --> Obbligatorio
        tfQuestionarioEntity.setFlag_modo_registrazione_documento_protocollo(questionarioModelRequest.getFlagModoRegistrazioneDocumentoProtocollo());

        // ID_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO --> Obbligatorio se FLAG_REGISTRAZIONE_DOCUMENTO_A_PROTOCOLLO scelto = "In parte" ==> da verificare
        Integer next_ID_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO_SM = salva_TF_SM_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO(questionarioModelRequest.getListaTdModoRegistrazioneDocumentoProtocolloEntity(), questionarioModelRequest.getModoRegistrazioneDocumentoProtocolloAltro());
        tfQuestionarioEntity.setId_modo_registrazione_documento_protocollo_sm(next_ID_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO_SM);

        // ID_TITOLO --> Obbligatorio
        tfQuestionarioEntity.setId_titolo(questionarioModelRequest.getTdTitoloEntity().getId_titolo());

        // ID_CLASSE --> Obbligatorio
        tfQuestionarioEntity.setId_classe(questionarioModelRequest.getTdClasseEntity().getId_classe());



/*
        Gestione campi del form: O R G A N I Z Z A Z I O N E   D O C U M E N T O
*/
        // ID_MODO_GESTIONE_DOCUMENTO --> Obbligatorio
        tfQuestionarioEntity.setId_modo_gestione_documento(questionarioModelRequest.getTdModoGestioneDocumentoEntity().getId_modo_gestione_documento());

        // ID_MODO_ORGANIZZAZIONE_DOCUMENTO --> Obbligatorio
        Integer next_ID_MODO_ORGANIZZAZIONE_DOCUMENTO_SM = salva_TF_SM_MODO_ORGANIZZAZIONE_DOCUMENTO(questionarioModelRequest.getListaTdModoOrganizzazioneDocumentoEntity());
        tfQuestionarioEntity.setId_modo_organizzazione_documento_sm(next_ID_MODO_ORGANIZZAZIONE_DOCUMENTO_SM);

        // ID_CRITERIO_ORGANIZZAZIONE_DOCUMENTO --> Obbligatorio
        Integer next_ID_CRITERIO_ORGANIZZAZIONE_DOCUMENTO_SM = salva_TF_SM_CRITERIO_ORGANIZZAZIONE_DOCUMENTO(questionarioModelRequest.getListaTdCriterioOrganizzazioneDocumentoEntity());
        tfQuestionarioEntity.setId_criterio_organizzazione_documento_sm(next_ID_CRITERIO_ORGANIZZAZIONE_DOCUMENTO_SM);

        // ANNOTAZIONI_ORGANIZZAZIONE_DOCUMENTO --> Non Obbligatorio
        tfQuestionarioEntity.setAnnotazioni_organizzazione_doc(questionarioModelRequest.getAnnotazioniOrganizzazioneDoc());


/*
        Gestione campi del form: P U B B L I C A Z I O N E   D O C U M E N T O
*/

        // FLAG_DOCUMENTO_SOGGETTO_A_PUBBLICAZIONE --> Obbligatorio
        tfQuestionarioEntity.setFlag_luogo_pubblicazione_documento(questionarioModelRequest.getFlagLuogoPubblicazioneDocumento());

        // ID_LUOGO_PUBBLICAZIONE_DOCUMENTO --> Obbligatorio se FLAG_DOCUMENTO_SOGGETTO_A_PUBBLICAZIONE scelto = "Si"
        Integer next_ID_LUOGO_PUBBLICAZIONE_DOCUMENTO = salva_TF_SM_LUOGO_PUBBLICAZIONE_DOCUMENTO(questionarioModelRequest.getListaTdLuogoPubblicazioneDocumentoEntity(), questionarioModelRequest.getLuogoPubblicazioneDocumentoAltro());
        tfQuestionarioEntity.setId_luogo_pubblicazione_documento_sm(next_ID_LUOGO_PUBBLICAZIONE_DOCUMENTO);

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
        tfQuestionarioEntity.setId_servizio(questionarioModelRequest.getTdServizioEntity().getId_servizio());

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
    private Integer salva_TF_SM_TIPO_DOCUMENTO(List<TdTipoDocumentoEntity> listaTdTipoDocumentoEntity, String listaTipoDocumentoAltro)  {

        // Se tra i "Tipo Documento" selezionati è presente anche la voce "Altro" ...
        if (listaTipoDocumentoAltro != null) {

            listaTdTipoDocumentoEntity.removeIf( tdTipoDocumentoEntity -> (tdTipoDocumentoEntity.getId_tipo_documento() == 9999) );

            // Estraggo la lista dei nuovi "Tipo Documento" ...
            String[] listaTipoDocumentoAltroArray = listaTipoDocumentoAltro.split(";");
            for (int i = 0; i < listaTipoDocumentoAltroArray.length; i++)
            {
                // Rimuovo eventuali caratteri blank presenti all'inizio e/o alla fine del nuovo "Tipo Documento"
                String tipoDocumentoAltro = listaTipoDocumentoAltroArray[i].strip();

                // Verifico che il la singola nuova voce del "Tipo Documento" non sia una stringa vuota
                if (!tipoDocumentoAltro.equals("")) {
                    // Creo la relativa anagrafica ...
                    TdTipoDocumentoEntity tdTipoDocumentoEntityAltro = anagraficheService.addTipoDocumento(tipoDocumentoAltro);

                    // Aggiungo il nuovo "Tipo Documento" a quelli eventualmente già selezionati(potrebbe essere che l'utente selezioni solo "Tipi Documento" nuovi)
                    listaTdTipoDocumentoEntity.add(tdTipoDocumentoEntityAltro);
                }

            }

        }

        // Recupero il successivo ID_TIPO_DOCUMENTO_SM della tabella relativa alle selezioni multiple del "Tipo Documento"
        Integer next_ID_TIPO_DOCUMENTO_SM = tfSmTipoDocumentoRepository.getNext_ID_TIPO_DOCUMENTO_SM();

        for(TdTipoDocumentoEntity tdTipoDocumentoEntity : listaTdTipoDocumentoEntity) {

            TfSmTipoDocumentoEntity tfSmTipoDocumentoEntity = new TfSmTipoDocumentoEntity();

            tfSmTipoDocumentoEntity.setId_tipo_documento_sm(next_ID_TIPO_DOCUMENTO_SM);
            tfSmTipoDocumentoEntity.setId_tipo_documento(tdTipoDocumentoEntity.getId_tipo_documento());

            tfSmTipoDocumentoRepository.save(tfSmTipoDocumentoEntity);
        }

        return next_ID_TIPO_DOCUMENTO_SM;
    }
    private Integer salva_TF_SM_APPLICATIVO(List<TdApplicativoEntity> listaTdApplicativoEntity, String listaApplicativoAltro)  {

        // Se tra gli "Applicativi" selezionati è presente anche la voce "Altro" ...
        if (listaApplicativoAltro != null) {

            listaTdApplicativoEntity.removeIf( tdApplicativoEntity -> (tdApplicativoEntity.getId_applicativo() == 99999) );

            // Estraggo la lista dei nuovi "Applicativi" ...
            String[] listaApplicativoAltroArray = listaApplicativoAltro.split(";");
            for (int i = 0; i < listaApplicativoAltroArray.length; i++)
            {
                // Rimuovo eventuali caratteri blank presenti all'inizio e/o alla fine del nuovo "Applicativo"
                String applicativoAltro = listaApplicativoAltroArray[i].strip();

                // Verifico che il la singola nuova voce dell'"Applicativo" non sia una stringa vuota
                if (!applicativoAltro.equals("")) {
                    // Creo la relativa anagrafica ...
                    TdApplicativoEntity tdApplicativoEntityAltro = anagraficheService.addApplicativo(applicativoAltro);

                    // Aggiungo il nuovo "Applicativo" a quelli eventualmente già selezionati(potrebbe essere che l'utente selezioni solo "Applicativi" nuovi)
                    listaTdApplicativoEntity.add(tdApplicativoEntityAltro);
                }

            }

        }

        // Verifico se la lista degli "Applicativo" è vuota(caso in cui il flag_applicativo <> 'No'"
        if (listaTdApplicativoEntity == null) {
            return null;
        }

        // Recupero il successivo ID_APPLICATIVO_SM della tabella relativa alle selezioni multiple del "Applicativo"
        Integer next_ID_APPLICATIVO_SM = tfSmApplicativoRepository.getNext_ID_APPLICATIVO_SM();

        for(TdApplicativoEntity tdApplicativoEntity : listaTdApplicativoEntity) {

            TfSmApplicativoEntity tfSmApplicativoEntity = new TfSmApplicativoEntity();

            tfSmApplicativoEntity.setId_applicativo_sm(next_ID_APPLICATIVO_SM);
            tfSmApplicativoEntity.setId_applicativo(tdApplicativoEntity.getId_applicativo());

            tfSmApplicativoRepository.save(tfSmApplicativoEntity);
        }

        return next_ID_APPLICATIVO_SM;
    }
    private Integer salva_TF_SM_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO(List<TdModoRegistrazioneDocumentoProtocolloEntity> listaTdModoRegistrazioneDocumentoProtocolloEntity, String listaTdModoRegistrazioneDocumentoProtocolloAltro)  {

        // Se tra i "Modi Registrazione Documento Protocollo" selezionati è presente anche la voce "Altro" ...
        if (listaTdModoRegistrazioneDocumentoProtocolloAltro != null) {

            listaTdModoRegistrazioneDocumentoProtocolloEntity.removeIf( tdModoRegistrazioneDocumentoProtocolloEntity -> (tdModoRegistrazioneDocumentoProtocolloEntity.getId_modo_registrazione_documento_protocollo() == 9999) );

            // Estraggo la lista dei nuovi "Modi Registrazione Documento Protocollo" ...
            String[] listaModoRegistrazioneDocumentoProtocolloAltroArray = listaTdModoRegistrazioneDocumentoProtocolloAltro.split(";");
            for (int i = 0; i < listaModoRegistrazioneDocumentoProtocolloAltroArray.length; i++)
            {
                // Rimuovo eventuali caratteri blank presenti all'inizio e/o alla fine del nuovo "Modo Registrazione Documento Protocollo"
                String modoRegistrazioneDocumentoProtocolloAltro = listaModoRegistrazioneDocumentoProtocolloAltroArray[i].strip();

                // Verifico che il la singola nuova voce del "Modi Registrazione Documento Protocollo" non sia una stringa vuota
                if (!modoRegistrazioneDocumentoProtocolloAltro.equals("")) {
                    // Creo la relativa anagrafica ...
                    TdModoRegistrazioneDocumentoProtocolloEntity tdModoRegistrazioneDocumentoProtocolloEntityAltro = anagraficheService.addModoRegistrazioneDocumentoProtocollo(modoRegistrazioneDocumentoProtocolloAltro);

                    // Aggiungo il nuovo "Modo Registrazione Documento Protocollo" a quelli eventualmente già selezionati(potrebbe essere che l'utente selezioni solo "Modi Registrazione Documento Protocollo" nuovi)
                    listaTdModoRegistrazioneDocumentoProtocolloEntity.add(tdModoRegistrazioneDocumentoProtocolloEntityAltro);
                }

            }

        }

        // Verifico se la lista dei "Modi Registrazione Documento Protocollo" è vuota(caso in cui il flag_modo_registrazione_documento_protocollo <> 'in parte ...'"
        if (listaTdModoRegistrazioneDocumentoProtocolloEntity == null) {
            return null;
        }

        // Recupero il successivo ID_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO_SM della tabella relativa alle selezioni multiple del "Modo Registrazione Documento Protocollo"
        Integer next_ID_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO_SM = tfSmModoRegistrazioneDocumentoProtocolloRepository.getNext_ID_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO_SM();

        for(TdModoRegistrazioneDocumentoProtocolloEntity tdModoRegistrazioneDocumentoProtocolloEntity : listaTdModoRegistrazioneDocumentoProtocolloEntity) {

            TfSmModoRegistrazioneDocumentoProtocolloEntity tfSmModoRegistrazioneDocumentoProtocolloEntity = new TfSmModoRegistrazioneDocumentoProtocolloEntity();

            tfSmModoRegistrazioneDocumentoProtocolloEntity.setId_modo_registrazione_documento_protocollo_sm(next_ID_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO_SM);
            tfSmModoRegistrazioneDocumentoProtocolloEntity.setId_modo_registrazione_documento_protocollo(tdModoRegistrazioneDocumentoProtocolloEntity.getId_modo_registrazione_documento_protocollo());

            tfSmModoRegistrazioneDocumentoProtocolloRepository.save(tfSmModoRegistrazioneDocumentoProtocolloEntity);
        }

        return next_ID_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO_SM;

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
    private Integer salva_TF_SM_LUOGO_PUBBLICAZIONE_DOCUMENTO(List<TdLuogoPubblicazioneDocumentoEntity> listaTdLuogoPubblicazioneDocumentoEntity, String listaTdLuogoPubblicazioneDocumentoAltro)  {

        // Se tra i "Luoghi Pubblicazione Documento" selezionati è presente anche la voce "Altro" ...
        if (listaTdLuogoPubblicazioneDocumentoAltro != null) {

            listaTdLuogoPubblicazioneDocumentoEntity.removeIf( tdLuogoPubblicazioneDocumentoEntity -> (tdLuogoPubblicazioneDocumentoEntity.getId_luogo_pubblicazione_documento() == 9999) );

            // Estraggo la lista dei nuovi "Luoghi Pubblicazione Documento" ...
            String[] listaLuogoPubblicazioneDocumentoAltroArray = listaTdLuogoPubblicazioneDocumentoAltro.split(";");
            for (int i = 0; i < listaLuogoPubblicazioneDocumentoAltroArray.length; i++)
            {
                // Rimuovo eventuali caratteri blank presenti all'inizio e/o alla fine del nuovo "Luogo Pubblicazione Documento"
                String luogoPubblicazioneDocumentoProtocolloAltro = listaLuogoPubblicazioneDocumentoAltroArray[i].strip();

                // Verifico che il la singola nuova voce del "Luoghi Pubblicazione Documento" non sia una stringa vuota
                if (!luogoPubblicazioneDocumentoProtocolloAltro.equals("")) {
                    // Creo la relativa anagrafica ...
                    TdLuogoPubblicazioneDocumentoEntity tdLuogoPubblicazioneDocumentoEntityAltro = anagraficheService.addLuogoPubblicazioneDocumenti(luogoPubblicazioneDocumentoProtocolloAltro);

                    // Aggiungo il nuovo "Luoghi Pubblicazione Documento" a quelli eventualmente già selezionati(potrebbe essere che l'utente selezioni solo "Modi Registrazione Documento Protocollo" nuovi)
                    listaTdLuogoPubblicazioneDocumentoEntity.add(tdLuogoPubblicazioneDocumentoEntityAltro);
                }

            }

        }

        // Verifico se la lista dei "Luoghi Pubblicazione Documento" è vuota(caso in cui il flag_luogo_pubblicazione_documento <> 'No'"
        if (listaTdLuogoPubblicazioneDocumentoEntity == null) {
            return null;
        }

        // Recupero il successivo next_ID_LUOGO_PUBBLICAZIONE_DOCUMENTO della tabella relativa alle selezioni multiple del "Luogo Pubblicazione Documento"
        Integer next_ID_LUOGO_PUBBLICAZIONE_DOCUMENTO = tfSmLuogoPubblicazioneDocumentiRepository.getNext_ID_LUOGO_PUBBLICAZIONE_DOCUMENTO_SM();

        for(TdLuogoPubblicazioneDocumentoEntity tdLuogoPubblicazioneDocumentoEntity : listaTdLuogoPubblicazioneDocumentoEntity) {

            TfSmLuogoPubblicazioneDocumentiEntity tfSmLuogoPubblicazioneDocumentiEntity = new TfSmLuogoPubblicazioneDocumentiEntity();

            tfSmLuogoPubblicazioneDocumentiEntity.setId_luogo_pubblicazione_documento_sm(next_ID_LUOGO_PUBBLICAZIONE_DOCUMENTO);
            tfSmLuogoPubblicazioneDocumentiEntity.setId_luogo_pubblicazione_documento(tdLuogoPubblicazioneDocumentoEntity.getId_luogo_pubblicazione_documento());

            tfSmLuogoPubblicazioneDocumentiRepository.save(tfSmLuogoPubblicazioneDocumentiEntity);
        }

        return next_ID_LUOGO_PUBBLICAZIONE_DOCUMENTO;

    }

}
