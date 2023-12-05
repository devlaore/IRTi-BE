package laoreProjects.IRTiBE.service;

import jakarta.transaction.Transactional;
import laoreProjects.IRTiBE.entity.table.anagrafiche.*;
import laoreProjects.IRTiBE.entity.view.anagrafiche.VMacroAttivitaEntity;
import laoreProjects.IRTiBE.entity.view.anagrafiche.VSpecializzazioneAttivitaEntity;
import laoreProjects.IRTiBE.repository.table.anagrafiche.*;
import laoreProjects.IRTiBE.repository.view.anagrafiche.VMacroAttivitaRepository;
import laoreProjects.IRTiBE.repository.view.anagrafiche.VSpecializzazioneAttivitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AnagraficheService {

    private final TdAttivitaRepository tdAttivitaRepository;
    private final TdAmbitoAttivitaRepository tdAmbitoAttivitaRepository;
    private final TdMacroAttivitaRepository tdMacroAttivitaRepository;
    private final TdSpecializzazioneAttivitaRepository tdSpecializzazioneAttivitaRepository;
    private final TdTipoDocumentoRepository tdTipoDocumentoRepository;
    private final TdApplicativoRepository tdApplicativoRepository;
    private final TdModoRegistrazioneDocumentoProtocolloRepository tdModoRegistrazioneDocumentoProtocolloRepository;
    private final TdModoGestioneDocumentoRepository tdModoGestioneDocumentoRepository;
    private final TdModoOrganizzazioneDocumentoRepository tdModoOrganizzazioneDocumentoRepository;
    private final TdCriterioOrganizzazioneDocumentoRepository tdCriterioOrganizzazioneDocumentoRepository;
    private final TdLuogoPubblicazioneDocumentoRepository tdLuogoPubblicazioneDocumentoRepository;
    private final TdTitoloRepository tdTitoloRepository;
    private final TdClasseRepository tdClasseRepository;
    private final TdServizioRepository tdServizioRepository;



    private final VMacroAttivitaRepository vMacroAttivitaRepository;
    private final VSpecializzazioneAttivitaRepository vSpecializzazioneAttivitaRepository;



    /*
        Service tabella: td_attivita
     */
    public List<TdAttivitaEntity> getLista_TD_ATTIVITA() {
        /*
            Ritorna la lista dell'anagrafica TD_ATTIVITA attive(flag_attiva = 'Y');
         */
        Optional<List<TdAttivitaEntity>> op_ListaTdAttivitaEntity;
        List<TdAttivitaEntity> listaTdAttivitaEntity;

        op_ListaTdAttivitaEntity = tdAttivitaRepository.getLista_TD_ATTIVITA();

        if (op_ListaTdAttivitaEntity.isEmpty())
            listaTdAttivitaEntity = new ArrayList();
        else
            listaTdAttivitaEntity = op_ListaTdAttivitaEntity.get();

        return listaTdAttivitaEntity;
    }
    public List<TdAttivitaEntity> getLista_TD_ATTIVITA_Attive() {
        /*
            Ritorna la lista dell'anagrafica TD_ATTIVITA attive(flag_attiva = 'Y');
         */
        Optional<List<TdAttivitaEntity>> op_ListaTdAttivitaEntity;
        List<TdAttivitaEntity> listaTdAttivitaEntity;

        op_ListaTdAttivitaEntity = tdAttivitaRepository.getLista_TD_ATTIVITA_Attive();

        if (op_ListaTdAttivitaEntity.isEmpty())
            listaTdAttivitaEntity = new ArrayList();
        else
            listaTdAttivitaEntity = op_ListaTdAttivitaEntity.get();

        return listaTdAttivitaEntity;
    }

    /*
        Service tabella: td_ambito_attivita
     */
    public List<TdAmbitoAttivitaEntity> getLista_TD_AMBITO_ATTIVITA() {
        /*
            Ritorna la lista dell'anagrafica TD_FUNZIONE attive(flag_attiva = 'Y');
         */
        Optional<List<TdAmbitoAttivitaEntity>> op_ListaTdFunzioneEntity;
        List<TdAmbitoAttivitaEntity> listaTdAmbitoAttivitaEntity;

        op_ListaTdFunzioneEntity = tdAmbitoAttivitaRepository.getLista_TD_AMBITO_ATTIVITA();

        if (op_ListaTdFunzioneEntity.isEmpty())
            listaTdAmbitoAttivitaEntity = new ArrayList();
        else
            listaTdAmbitoAttivitaEntity = op_ListaTdFunzioneEntity.get();

        return listaTdAmbitoAttivitaEntity;

    }
    public List<TdAmbitoAttivitaEntity> getLista_TD_AMBITO_ATTIVITA_Attive() {
        /*
            Ritorna la lista dell'anagrafica TD_FUNZIONE attive(flag_attiva = 'Y');
         */
        Optional<List<TdAmbitoAttivitaEntity>> op_ListaTdFunzioneEntity;
        List<TdAmbitoAttivitaEntity> listaTdAmbitoAttivitaEntity;

        op_ListaTdFunzioneEntity = tdAmbitoAttivitaRepository.getLista_TD_AMBITO_ATTIVITA_Attive();

        if (op_ListaTdFunzioneEntity.isEmpty())
            listaTdAmbitoAttivitaEntity = new ArrayList();
        else
            listaTdAmbitoAttivitaEntity = op_ListaTdFunzioneEntity.get();

        return listaTdAmbitoAttivitaEntity;

    }
    public TdAmbitoAttivitaEntity addAmbitoAttivita(String newAmbitoAttivita) {
        TdAmbitoAttivitaEntity tdAmbitoAttivitaEntity = new TdAmbitoAttivitaEntity();

        tdAmbitoAttivitaEntity.setNome_ambito_attivita(newAmbitoAttivita);
        tdAmbitoAttivitaEntity.setFlag_attivo("Y");

        tdAmbitoAttivitaRepository.save(tdAmbitoAttivitaEntity);

        return tdAmbitoAttivitaEntity;
    }

    /*
        Service tabella: td_macro_attivita
     */
    public List<TdMacroAttivitaEntity> getLista_TD_MACRO_ATTIVITA() {
        /*
            Ritorna la lista dell'anagrafica TD_MACRO_ATTIVITA
         */
        Optional<List<TdMacroAttivitaEntity>> op_ListaTdMacroAttivitaEntity;
        List<TdMacroAttivitaEntity> listaTdMacroAttivitaEntity;

        op_ListaTdMacroAttivitaEntity = tdMacroAttivitaRepository.getLista_TD_MACRO_ATTIVITA();

        if (op_ListaTdMacroAttivitaEntity.isEmpty())
            listaTdMacroAttivitaEntity = new ArrayList();
        else
            listaTdMacroAttivitaEntity = op_ListaTdMacroAttivitaEntity.get();

        return listaTdMacroAttivitaEntity;
    }
    public List<TdMacroAttivitaEntity> getLista_TD_MACRO_ATTIVITA_Attive() {
        /*
            Ritorna la lista dell'anagrafica TD_MACRO_ATTIVITA attive associate
         */
        Optional<List<TdMacroAttivitaEntity>> op_ListaTdMacroAttivitaEntity;
        List<TdMacroAttivitaEntity> listaTdMacroAttivitaEntity;

        op_ListaTdMacroAttivitaEntity = tdMacroAttivitaRepository.getLista_TD_MACRO_ATTIVITA_Attive();

        if (op_ListaTdMacroAttivitaEntity.isEmpty())
            listaTdMacroAttivitaEntity = new ArrayList();
        else
            listaTdMacroAttivitaEntity = op_ListaTdMacroAttivitaEntity.get();

        return listaTdMacroAttivitaEntity;
    }
    public List<TdMacroAttivitaEntity> getLista_TD_MACRO_ATTIVITA_Attive_by_ID_AMBITO_ATTIVITA(Integer idAmbitoAttivita) {
        /*
            Ritorna la lista dell'anagrafica TD_MACRO_ATTIVITA attive associate ad un dato Ambito Attivita
         */
        Optional<List<TdMacroAttivitaEntity>> op_ListaTdMacroAttivitaEntity;
        List<TdMacroAttivitaEntity> listaTdMacroAttivitaEntity;

        op_ListaTdMacroAttivitaEntity = tdMacroAttivitaRepository.getLista_TD_MACRO_ATTIVITA_Attive_by_ID_AMBITO_ATTIVITA(idAmbitoAttivita);

        if (op_ListaTdMacroAttivitaEntity.isEmpty())
            listaTdMacroAttivitaEntity = new ArrayList();
        else
            listaTdMacroAttivitaEntity = op_ListaTdMacroAttivitaEntity.get();

        return listaTdMacroAttivitaEntity;
    }
    public TdMacroAttivitaEntity addMacroAttivita(String newMacroAttivita, Integer idAmbitoAttivita) {
        TdMacroAttivitaEntity tdMacroAttivitaEntity = new TdMacroAttivitaEntity();

        tdMacroAttivitaEntity.setNome_macro_attivita(newMacroAttivita);
        tdMacroAttivitaEntity.setId_ambito_attivita(idAmbitoAttivita);
        tdMacroAttivitaEntity.setFlag_attivo("Y");

        tdMacroAttivitaRepository.save(tdMacroAttivitaEntity);

        return tdMacroAttivitaEntity;
    }

    /*
        Service tabella: td_specializzazione_attivita
     */
    public List<TdSpecializzazioneAttivitaEntity> getLista_TD_SPECIALIZZAZIONE_ATTIVITA() {
        /*
            Ritorna la lista dell'anagrafica TD_SPECIALIZZAZIONE_ATTIVITA;
         */
        Optional<List<TdSpecializzazioneAttivitaEntity>> op_ListaTdSpecializzazioneAttivita;
        List<TdSpecializzazioneAttivitaEntity> listaTdSpecializzazioneAttivitaEntity;

        op_ListaTdSpecializzazioneAttivita = tdSpecializzazioneAttivitaRepository.getLista_TD_SPECIALIZZAZIONE_ATTIVITA();

        if (op_ListaTdSpecializzazioneAttivita.isEmpty())
            listaTdSpecializzazioneAttivitaEntity = new ArrayList();
        else
            listaTdSpecializzazioneAttivitaEntity = op_ListaTdSpecializzazioneAttivita.get();

        return listaTdSpecializzazioneAttivitaEntity;

    }
    public List<TdSpecializzazioneAttivitaEntity> getLista_TD_SPECIALIZZAZIONE_ATTIVITA_Attive() {
        /*
            Ritorna la lista dell'anagrafica TD_SPECIALIZZAZIONE_ATTIVITA attive(flag_attiva = 'Y');
         */
        Optional<List<TdSpecializzazioneAttivitaEntity>> op_ListaTdSpecializzazioneAttivita;
        List<TdSpecializzazioneAttivitaEntity> listaTdSpecializzazioneAttivitaEntity;

        op_ListaTdSpecializzazioneAttivita = tdSpecializzazioneAttivitaRepository.getLista_TD_SPECIALIZZAZIONE_ATTIVITA_Attive();

        if (op_ListaTdSpecializzazioneAttivita.isEmpty())
            listaTdSpecializzazioneAttivitaEntity = new ArrayList();
        else
            listaTdSpecializzazioneAttivitaEntity = op_ListaTdSpecializzazioneAttivita.get();

        return listaTdSpecializzazioneAttivitaEntity;

    }
    public List<TdSpecializzazioneAttivitaEntity> getLista_TD_SPECIALIZZAZIONE_ATTIVITA_Attive_by_ID_MACRO_ATTIVITA(Integer idMacroAttivita) {
        /*
            Ritorna la lista dell'anagrafica TD_MACRO_ATTIVITA attive associate ad una data Macro Attivita
         */
        Optional<List<TdSpecializzazioneAttivitaEntity>> op_TdSpecializzazioneAttivitaEntity;
        List<TdSpecializzazioneAttivitaEntity> listaTdSpecializzazioneAttivitaEntity;

        op_TdSpecializzazioneAttivitaEntity = tdSpecializzazioneAttivitaRepository.getLista_TD_SPECIALIZZAZIONE_ATTIVITA_Attive_by_ID_MACRO_ATTIVITA(idMacroAttivita);

        if (op_TdSpecializzazioneAttivitaEntity.isEmpty())
            listaTdSpecializzazioneAttivitaEntity = new ArrayList();
        else
            listaTdSpecializzazioneAttivitaEntity = op_TdSpecializzazioneAttivitaEntity.get();

        return listaTdSpecializzazioneAttivitaEntity;
    }
    public TdSpecializzazioneAttivitaEntity addSpecializzazioneAttivita(String newSpecializzazioneAttivita, Integer idMacroAttivita) {
        TdSpecializzazioneAttivitaEntity tdSpecializzazioneAttivitaEntity = new TdSpecializzazioneAttivitaEntity();

        tdSpecializzazioneAttivitaEntity.setNome_specializzazione_attivita(newSpecializzazioneAttivita);
        tdSpecializzazioneAttivitaEntity.setId_macro_attivita(idMacroAttivita);
        tdSpecializzazioneAttivitaEntity.setFlag_attivo("Y");

        tdSpecializzazioneAttivitaRepository.save(tdSpecializzazioneAttivitaEntity);

        return tdSpecializzazioneAttivitaEntity;
    }

    /*
        Service tabella: td_tipo_documento
     */
    public List<TdTipoDocumentoEntity> getLista_TD_TIPO_DOCUMENTO() {
        /*
            Ritorna la lista dell'anagrafica TD_ATTIVITA attivi(flag_attiva = 'Y');
         */
        Optional<List<TdTipoDocumentoEntity>> op_ListaTdTipoDocumentoEntity;
        List<TdTipoDocumentoEntity> listaTdTipoDocumentoEntity;

        op_ListaTdTipoDocumentoEntity = tdTipoDocumentoRepository.getLista_TD_TIPO_DOCUMENTO();

        if (op_ListaTdTipoDocumentoEntity.isEmpty())
            listaTdTipoDocumentoEntity = new ArrayList();
        else
            listaTdTipoDocumentoEntity = op_ListaTdTipoDocumentoEntity.get();

        return listaTdTipoDocumentoEntity;
    }
    public List<TdTipoDocumentoEntity> getLista_TD_TIPO_DOCUMENTO_Attivi() {
        /*
            Ritorna la lista dell'anagrafica TD_ATTIVITA attivi(flag_attiva = 'Y');
         */
        Optional<List<TdTipoDocumentoEntity>> op_ListaTdTipoDocumentoEntity;
        List<TdTipoDocumentoEntity> listaTdTipoDocumentoEntity;

        op_ListaTdTipoDocumentoEntity = tdTipoDocumentoRepository.getLista_TD_TIPO_DOCUMENTO_Attivi();

        if (op_ListaTdTipoDocumentoEntity.isEmpty())
            listaTdTipoDocumentoEntity = new ArrayList();
        else
            listaTdTipoDocumentoEntity = op_ListaTdTipoDocumentoEntity.get();

        return listaTdTipoDocumentoEntity;
    }
    public TdTipoDocumentoEntity addTipoDocumento(String newTipoDocumento) {
        TdTipoDocumentoEntity tdTipoDocumentoEntity = new TdTipoDocumentoEntity();

        tdTipoDocumentoEntity.setNome_tipo_documento(newTipoDocumento);
        tdTipoDocumentoEntity.setFlag_attivo("Y");

        tdTipoDocumentoRepository.save(tdTipoDocumentoEntity);

        return tdTipoDocumentoEntity;
    }

    /*
            Service tabella: td_applicativi
     */
    public List<TdApplicativoEntity> getLista_TD_APPLICATIVO() {
        /*
            Ritorna la lista dell'anagrafica TD_APPLICATIVI attivi(flag_attiva = 'Y');
         */
        Optional<List<TdApplicativoEntity>> op_ListaTdApplicativiEntity;
        List<TdApplicativoEntity> listaTdApplicativoEntity;

        op_ListaTdApplicativiEntity = tdApplicativoRepository.getLista_TD_APPLICATIVO();

        if (op_ListaTdApplicativiEntity.isEmpty())
            listaTdApplicativoEntity = new ArrayList();
        else
            listaTdApplicativoEntity = op_ListaTdApplicativiEntity.get();

        return listaTdApplicativoEntity;
    }
    public List<TdApplicativoEntity> getLista_TD_APPLICATIVO_Attivi() {
        /*
            Ritorna la lista dell'anagrafica TD_APPLICATIVI attivi(flag_attiva = 'Y');
         */
        Optional<List<TdApplicativoEntity>> op_ListaTdApplicativiEntity;
        List<TdApplicativoEntity> listaTdApplicativoEntity;

        op_ListaTdApplicativiEntity = tdApplicativoRepository.getLista_TD_APPLICATIVO_Attivi();

        if (op_ListaTdApplicativiEntity.isEmpty())
            listaTdApplicativoEntity = new ArrayList();
        else
            listaTdApplicativoEntity = op_ListaTdApplicativiEntity.get();

        return listaTdApplicativoEntity;
    }
    public TdApplicativoEntity addApplicativo(String newApplicativo) {
        TdApplicativoEntity tdApplicativoEntity = new TdApplicativoEntity();

        tdApplicativoEntity.setNome_applicativo(newApplicativo);
        tdApplicativoEntity.setFlag_attivo("Y");

        tdApplicativoRepository.save(tdApplicativoEntity);

        return tdApplicativoEntity;
    }

    /*
        Service tabella: td_modo_registrazione_documento_protocollo
     */
    public List<TdModoRegistrazioneDocumentoProtocolloEntity> getLista_TD_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO() {
        /*
            Ritorna la lista dell'anagrafica TD_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO;
         */
        Optional<List<TdModoRegistrazioneDocumentoProtocolloEntity>> op_ListaTdModoRegistrazioneDocumentoProtocolloEntity;
        List<TdModoRegistrazioneDocumentoProtocolloEntity> listaTdModoRegistrazioneDocumentoProtocolloEntity;

        op_ListaTdModoRegistrazioneDocumentoProtocolloEntity = tdModoRegistrazioneDocumentoProtocolloRepository.getLista_TD_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO();

        if (op_ListaTdModoRegistrazioneDocumentoProtocolloEntity.isEmpty())
            listaTdModoRegistrazioneDocumentoProtocolloEntity = new ArrayList();
        else
            listaTdModoRegistrazioneDocumentoProtocolloEntity = op_ListaTdModoRegistrazioneDocumentoProtocolloEntity.get();

        return listaTdModoRegistrazioneDocumentoProtocolloEntity;
    }
    public List<TdModoRegistrazioneDocumentoProtocolloEntity> getLista_TD_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO_Attivi() {
        /*
            Ritorna la lista dell'anagrafica TD_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO_Attivi attivi(flag_attiva = 'Y');
         */
        Optional<List<TdModoRegistrazioneDocumentoProtocolloEntity>> op_ListaTdModoRegistrazioneDocumentoProtocolloEntity;
        List<TdModoRegistrazioneDocumentoProtocolloEntity> listaTdModoRegistrazioneDocumentoProtocolloEntity;

        op_ListaTdModoRegistrazioneDocumentoProtocolloEntity = tdModoRegistrazioneDocumentoProtocolloRepository.getLista_TD_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO_Attivi();

        if (op_ListaTdModoRegistrazioneDocumentoProtocolloEntity.isEmpty())
            listaTdModoRegistrazioneDocumentoProtocolloEntity = new ArrayList();
        else
            listaTdModoRegistrazioneDocumentoProtocolloEntity = op_ListaTdModoRegistrazioneDocumentoProtocolloEntity.get();

        return listaTdModoRegistrazioneDocumentoProtocolloEntity;
    }
    public TdModoRegistrazioneDocumentoProtocolloEntity addModoRegistrazioneDocumentoProtocollo(String newModoRegistrazioneDocumentoProtocollo) {
        TdModoRegistrazioneDocumentoProtocolloEntity tdModoRegistrazioneDocumentoProtocolloEntity = new TdModoRegistrazioneDocumentoProtocolloEntity();

        tdModoRegistrazioneDocumentoProtocolloEntity.setNome_modo_registrazione_documento_protocollo(newModoRegistrazioneDocumentoProtocollo);
        tdModoRegistrazioneDocumentoProtocolloEntity.setFlag_attivo("Y");

        tdModoRegistrazioneDocumentoProtocolloRepository.save(tdModoRegistrazioneDocumentoProtocolloEntity);

        return tdModoRegistrazioneDocumentoProtocolloEntity;
    }

    /*
            Service tabella: td_titolo
     */
    public List<TdTitoloEntity> getLista_TD_TITOLO() {
        /*
            Ritorna la lista dell'anagrafica TD_TITOLO;
         */
        Optional<List<TdTitoloEntity>> op_TdTitoloEntity;
        List<TdTitoloEntity> listaTdTitoloEntity;

        op_TdTitoloEntity = tdTitoloRepository.getLista_TD_TITOLO();

        if (op_TdTitoloEntity.isEmpty())
            listaTdTitoloEntity = new ArrayList();
        else
            listaTdTitoloEntity = op_TdTitoloEntity.get();

        return listaTdTitoloEntity;
    }

    /*
            Service tabella: td_classe
     */
    public List<TdClasseEntity> getLista_TD_CLASSE() {
        /*
            Ritorna la lista dell'anagrafica TD_CLASSE;
         */
        Optional<List<TdClasseEntity>> op_TdClasseEntity;
        List<TdClasseEntity> listaTdClasseEntity;

        op_TdClasseEntity = tdClasseRepository.getLista_TD_CLASSE();

        if (op_TdClasseEntity.isEmpty())
            listaTdClasseEntity = new ArrayList();
        else
            listaTdClasseEntity = op_TdClasseEntity.get();

        return listaTdClasseEntity;
    }
    public List<TdClasseEntity> getLista_TD_CLASSE_by_ID_TITOLO(Integer idTitolo) {
        /*
            Ritorna la lista dell'anagrafica TD_CLASSE per un dato id_titolo;
         */
        Optional<List<TdClasseEntity>> op_TdClasseEntity;
        List<TdClasseEntity> listaTdClasseEntity;

        op_TdClasseEntity = tdClasseRepository.getLista_TD_CLASSE_by_ID_TITOLO(idTitolo);

        if (op_TdClasseEntity.isEmpty())
            listaTdClasseEntity = new ArrayList();
        else
            listaTdClasseEntity = op_TdClasseEntity.get();

        return listaTdClasseEntity;
    }

    /*
        Service tabella: td_modo_gestione_documento
     */
    public List<TdModoGestioneDocumentoEntity> getLista_TD_MODO_GESTIONE_DOCUMENTO() {
        /*
            Ritorna la lista dell'anagrafica TD_MODO_GESTIONE_DOCUMENTO attivi(flag_attiva = 'Y');
         */
        Optional<List<TdModoGestioneDocumentoEntity>> op_ListaTdModoGestioneDocumentoEntity;
        List<TdModoGestioneDocumentoEntity> listaTdModoGestioneDocumentoEntity;

        op_ListaTdModoGestioneDocumentoEntity = tdModoGestioneDocumentoRepository.getLista_TD_MODO_GESTIONE_DOCUMENTO();

        if (op_ListaTdModoGestioneDocumentoEntity.isEmpty())
            listaTdModoGestioneDocumentoEntity = new ArrayList();
        else
            listaTdModoGestioneDocumentoEntity = op_ListaTdModoGestioneDocumentoEntity.get();

        return listaTdModoGestioneDocumentoEntity;
    }
    public List<TdModoGestioneDocumentoEntity> getLista_TD_MODO_GESTIONE_DOCUMENTO_Attivi() {
        /*
            Ritorna la lista dell'anagrafica TD_MODO_GESTIONE_DOCUMENTO attivi(flag_attiva = 'Y');
         */
        Optional<List<TdModoGestioneDocumentoEntity>> op_ListaTdModoGestioneDocumentoEntity;
        List<TdModoGestioneDocumentoEntity> listaTdModoGestioneDocumentoEntity;

        op_ListaTdModoGestioneDocumentoEntity = tdModoGestioneDocumentoRepository.getLista_TD_MODO_GESTIONE_DOCUMENTO_Attivi();

        if (op_ListaTdModoGestioneDocumentoEntity.isEmpty())
            listaTdModoGestioneDocumentoEntity = new ArrayList();
        else
            listaTdModoGestioneDocumentoEntity = op_ListaTdModoGestioneDocumentoEntity.get();

        return listaTdModoGestioneDocumentoEntity;
    }

    /*
        Service tabella: td_modo_organizzazione_documento
     */
    public List<TdModoOrganizzazioneDocumentoEntity> getLista_TD_MODO_ORGANIZZAZIONE_DOCUMENTO() {
        /*
            Ritorna la lista dell'anagrafica TD_MODO_ORGANIZZAZIONE_DOCUMENTO attivi(flag_attiva = 'Y');
         */
        Optional<List<TdModoOrganizzazioneDocumentoEntity>> op_TdModoOrganizzazioneDocumentoEntity;
        List<TdModoOrganizzazioneDocumentoEntity> listaTdTdModoOrganizzazioneDocumentoEntity;

        op_TdModoOrganizzazioneDocumentoEntity = tdModoOrganizzazioneDocumentoRepository.getLista_TD_MODO_ORGANIZZAZIONE_DOCUMENTO();

        if (op_TdModoOrganizzazioneDocumentoEntity.isEmpty())
            listaTdTdModoOrganizzazioneDocumentoEntity = new ArrayList();
        else
            listaTdTdModoOrganizzazioneDocumentoEntity = op_TdModoOrganizzazioneDocumentoEntity.get();

        return listaTdTdModoOrganizzazioneDocumentoEntity;
    }
    public List<TdModoOrganizzazioneDocumentoEntity> getLista_TD_MODO_ORGANIZZAZIONE_DOCUMENTO_Attivi() {
        /*
            Ritorna la lista dell'anagrafica TD_MODO_ORGANIZZAZIONE_DOCUMENTO attivi(flag_attiva = 'Y');
         */
        Optional<List<TdModoOrganizzazioneDocumentoEntity>> op_TdModoOrganizzazioneDocumentoEntity;
        List<TdModoOrganizzazioneDocumentoEntity> listaTdTdModoOrganizzazioneDocumentoEntity;

        op_TdModoOrganizzazioneDocumentoEntity = tdModoOrganizzazioneDocumentoRepository.getLista_TD_MODO_ORGANIZZAZIONE_DOCUMENTO_Attivi();

        if (op_TdModoOrganizzazioneDocumentoEntity.isEmpty())
            listaTdTdModoOrganizzazioneDocumentoEntity = new ArrayList();
        else
            listaTdTdModoOrganizzazioneDocumentoEntity = op_TdModoOrganizzazioneDocumentoEntity.get();

        return listaTdTdModoOrganizzazioneDocumentoEntity;
    }

    /*
        Service tabella: td_criterio_organizzazione_documento
     */
    public List<TdCriterioOrganizzazioneDocumentoEntity> getLista_TD_CRITERIO_ORGANIZZAZIONE_DOCUMENTO() {
        /*
            Ritorna la lista dell'anagrafica TD_CRITERIO_ORGANIZZAZIONE_DOCUMENTO attivi(flag_attiva = 'Y');
         */
        Optional<List<TdCriterioOrganizzazioneDocumentoEntity>> op_TdCriterioOrganizzazioneDocumentoEntity;
        List<TdCriterioOrganizzazioneDocumentoEntity> listaTdCriterioOrganizzazioneDocumentoEntity;

        op_TdCriterioOrganizzazioneDocumentoEntity = tdCriterioOrganizzazioneDocumentoRepository.getLista_TD_CRITERIO_ORGANIZZAZIONE_DOCUMENTO();

        if (op_TdCriterioOrganizzazioneDocumentoEntity.isEmpty())
            listaTdCriterioOrganizzazioneDocumentoEntity = new ArrayList();
        else
            listaTdCriterioOrganizzazioneDocumentoEntity = op_TdCriterioOrganizzazioneDocumentoEntity.get();

        return listaTdCriterioOrganizzazioneDocumentoEntity;
    }
    public List<TdCriterioOrganizzazioneDocumentoEntity> getLista_TD_CRITERIO_ORGANIZZAZIONE_DOCUMENTO_Attivi() {
        /*
            Ritorna la lista dell'anagrafica TD_CRITERIO_ORGANIZZAZIONE_DOCUMENTO attivi(flag_attiva = 'Y');
         */
        Optional<List<TdCriterioOrganizzazioneDocumentoEntity>> op_TdCriterioOrganizzazioneDocumentoEntity;
        List<TdCriterioOrganizzazioneDocumentoEntity> listaTdCriterioOrganizzazioneDocumentoEntity;

        op_TdCriterioOrganizzazioneDocumentoEntity = tdCriterioOrganizzazioneDocumentoRepository.getLista_TD_CRITERIO_ORGANIZZAZIONE_DOCUMENTO_Attivi();

        if (op_TdCriterioOrganizzazioneDocumentoEntity.isEmpty())
            listaTdCriterioOrganizzazioneDocumentoEntity = new ArrayList();
        else
            listaTdCriterioOrganizzazioneDocumentoEntity = op_TdCriterioOrganizzazioneDocumentoEntity.get();

        return listaTdCriterioOrganizzazioneDocumentoEntity;
    }

    /*
        Service tabella: td_luogo_pubblicazione_documenti
     */
    public List<TdLuogoPubblicazioneDocumentoEntity> getLista_TD_LUOGO_PUBBLICAZIONE_DOCUMENTO() {
        /*
            Ritorna la lista dell'anagrafica TD_LUOGO_PUBBLICAZIONE_DOCUMENTO attivi(flag_attiva = 'Y');
         */
        Optional<List<TdLuogoPubblicazioneDocumentoEntity>> op_TdLuogoPubblicazioneDocumentiEntity;
        List<TdLuogoPubblicazioneDocumentoEntity> listaTdLuogoPubblicazioneDocumentoEntity;

        op_TdLuogoPubblicazioneDocumentiEntity = tdLuogoPubblicazioneDocumentoRepository.getLista_TD_LUOGO_PUBBLICAZIONE_DOCUMENTO();

        if (op_TdLuogoPubblicazioneDocumentiEntity.isEmpty())
            listaTdLuogoPubblicazioneDocumentoEntity = new ArrayList();
        else
            listaTdLuogoPubblicazioneDocumentoEntity = op_TdLuogoPubblicazioneDocumentiEntity.get();

        return listaTdLuogoPubblicazioneDocumentoEntity;
    }
    public List<TdLuogoPubblicazioneDocumentoEntity> getLista_TD_LUOGO_PUBBLICAZIONE_DOCUMENTO_Attivi() {
        /*
            Ritorna la lista dell'anagrafica TD_LUOGO_PUBBLICAZIONE_DOCUMENTO attivi(flag_attiva = 'Y');
         */
        Optional<List<TdLuogoPubblicazioneDocumentoEntity>> op_TdLuogoPubblicazioneDocumentiEntity;
        List<TdLuogoPubblicazioneDocumentoEntity> listaTdLuogoPubblicazioneDocumentoEntity;

        op_TdLuogoPubblicazioneDocumentiEntity = tdLuogoPubblicazioneDocumentoRepository.getLista_TD_LUOGO_PUBBLICAZIONE_DOCUMENTO_Attivi();

        if (op_TdLuogoPubblicazioneDocumentiEntity.isEmpty())
            listaTdLuogoPubblicazioneDocumentoEntity = new ArrayList();
        else
            listaTdLuogoPubblicazioneDocumentoEntity = op_TdLuogoPubblicazioneDocumentiEntity.get();

        return listaTdLuogoPubblicazioneDocumentoEntity;
    }
    public TdLuogoPubblicazioneDocumentoEntity addLuogoPubblicazioneDocumenti(String newLuogoPubblicazioneDocumenti) {
        TdLuogoPubblicazioneDocumentoEntity tdLuogoPubblicazioneDocumentoEntity = new TdLuogoPubblicazioneDocumentoEntity();

        tdLuogoPubblicazioneDocumentoEntity.setNome_luogo_pubblicazione_documento(newLuogoPubblicazioneDocumenti);
        tdLuogoPubblicazioneDocumentoEntity.setFlag_attivo("Y");

        tdLuogoPubblicazioneDocumentoRepository.save(tdLuogoPubblicazioneDocumentoEntity);

        return tdLuogoPubblicazioneDocumentoEntity;
    }

    /*
            Service tabella: td_servizi
     */
    public List<TdServizioEntity> getLista_TD_SERVIZIO() {
        /*
            Ritorna la lista dell'anagrafica TD_SERVIZI;
         */
        List<TdServizioEntity> listaTdServizioEntity;

        listaTdServizioEntity = tdServizioRepository.findAll();

        return listaTdServizioEntity;
    }


    /*
        Service vista: v_macro_attivita
     */
    public List<VMacroAttivitaEntity> getLista_TD_MACRO_ATTIVITA_V() {
        /*
            Ritorna la lista dell'anagrafica TD_MACRO_ATTIVITA attraverso la vista V_MACRO_ATTIVITA
         */
        Optional<List<VMacroAttivitaEntity>> op_ListaVMacroAttivitaEntity;
        List<VMacroAttivitaEntity> listaVMacroAttivitaEntity;

        op_ListaVMacroAttivitaEntity = vMacroAttivitaRepository.getLista_TD_MACRO_ATTIVITA_V();

        if (op_ListaVMacroAttivitaEntity.isEmpty())
            listaVMacroAttivitaEntity = new ArrayList();
        else
            listaVMacroAttivitaEntity = op_ListaVMacroAttivitaEntity.get();

        return listaVMacroAttivitaEntity;
    }
    public List<VMacroAttivitaEntity> getLista_TD_MACRO_ATTIVITA_Attive_V() {
        /*
            Ritorna la lista dell'anagrafica TD_MACRO_ATTIVITA attive attraverso la vista V_MACRO_ATTIVITA
         */
        Optional<List<VMacroAttivitaEntity>> op_ListaVMacroAttivitaEntity;
        List<VMacroAttivitaEntity> listaVMacroAttivitaEntity;

        op_ListaVMacroAttivitaEntity = vMacroAttivitaRepository.getLista_TD_MACRO_ATTIVITA_Attive_V();

        if (op_ListaVMacroAttivitaEntity.isEmpty())
            listaVMacroAttivitaEntity = new ArrayList();
        else
            listaVMacroAttivitaEntity = op_ListaVMacroAttivitaEntity.get();

        return listaVMacroAttivitaEntity;
    }
    public List<VMacroAttivitaEntity> getLista_TD_MACRO_ATTIVITA_Attive_by_ID_AMBITO_ATTIVITA_V(Integer idAmbitoAttivita) {
        /*
            Ritorna la lista dell'anagrafica TD_MACRO_ATTIVITA attive associate ad un dato Ambito Attivita attraverso la vista V_MACRO_ATTIVITA
         */
        Optional<List<VMacroAttivitaEntity>> op_ListaVMacroAttivitaEntity;
        List<VMacroAttivitaEntity> listaVMacroAttivitaEntity;

        op_ListaVMacroAttivitaEntity = vMacroAttivitaRepository.getLista_TD_MACRO_ATTIVITA_Attive_by_ID_AMBITO_ATTIVITA_V(idAmbitoAttivita);

        if (op_ListaVMacroAttivitaEntity.isEmpty())
            listaVMacroAttivitaEntity = new ArrayList();
        else
            listaVMacroAttivitaEntity = op_ListaVMacroAttivitaEntity.get();

        return listaVMacroAttivitaEntity;
    }


    /*
        Service vista: v_specializzazione_attivita
     */
    public List<VSpecializzazioneAttivitaEntity> getLista_TD_SPECIALIZZAZIONE_ATTIVITA_V() {
        /*
            Ritorna la lista dell'anagrafica TD_SPECIALIZZAZIONE_ATTIVITA attraverso la vista V_SPECIALIZZAZIONE_ATTIVITA
         */
        Optional<List<VSpecializzazioneAttivitaEntity>> op_ListaVSpecializzazioneAttivitaEntity;
        List<VSpecializzazioneAttivitaEntity> listaVSpecializzazioneAttivitaEntity;

        op_ListaVSpecializzazioneAttivitaEntity = vSpecializzazioneAttivitaRepository.getLista_TD_SPECIALIZZAZIONE_ATTIVITA_V();

        if (op_ListaVSpecializzazioneAttivitaEntity.isEmpty())
            listaVSpecializzazioneAttivitaEntity = new ArrayList();
        else
            listaVSpecializzazioneAttivitaEntity = op_ListaVSpecializzazioneAttivitaEntity.get();

        return listaVSpecializzazioneAttivitaEntity;
    }
    public List<VSpecializzazioneAttivitaEntity> getLista_TD_SPECIALIZZAZIONE_ATTIVITA_Attive_V() {
        /*
            Ritorna la lista dell'anagrafica TD_SPECIALIZZAZIONE_ATTIVITA attive attraverso la vista V_SPECIALIZZAZIONE_ATTIVITA
         */
        Optional<List<VSpecializzazioneAttivitaEntity>> op_ListaVSpecializzazioneAttivitaEntity;
        List<VSpecializzazioneAttivitaEntity> listaVSpecializzazioneAttivitaEntity;

        op_ListaVSpecializzazioneAttivitaEntity = vSpecializzazioneAttivitaRepository.getLista_TD_SPECIALIZZAZIONE_ATTIVITA_Attive_V();

        if (op_ListaVSpecializzazioneAttivitaEntity.isEmpty())
            listaVSpecializzazioneAttivitaEntity = new ArrayList();
        else
            listaVSpecializzazioneAttivitaEntity = op_ListaVSpecializzazioneAttivitaEntity.get();

        return listaVSpecializzazioneAttivitaEntity;
    }
    public List<VSpecializzazioneAttivitaEntity> getLista_TD_SPECIALIZZAZIONE_ATTIVITA_Attive_by_ID_MACRO_ATTIVITA_V(Integer idMacroAttivita) {
        /*
            Ritorna la lista dell'anagrafica TD_SPECIALIZZAZIONE_ATTIVITA attive associate ad un dato Macro Attivita attraverso la vista V_SPECIALIZZAZIONE_ATTIVITA
         */
        Optional<List<VSpecializzazioneAttivitaEntity>> op_ListaVSpecializzazioneAttivitaEntity;
        List<VSpecializzazioneAttivitaEntity> listaVSpecializzazioneAttivitaEntity;

        op_ListaVSpecializzazioneAttivitaEntity = vSpecializzazioneAttivitaRepository.getLista_TD_SPECIALIZZAZIONE_ATTIVITA_Attive_by_ID_MACRO_ATTIVITA_V(idMacroAttivita);

        if (op_ListaVSpecializzazioneAttivitaEntity.isEmpty())
            listaVSpecializzazioneAttivitaEntity = new ArrayList();
        else
            listaVSpecializzazioneAttivitaEntity = op_ListaVSpecializzazioneAttivitaEntity.get();

        return listaVSpecializzazioneAttivitaEntity;
    }

}
