package laoreProjects.IRTiBE.controller;

import laoreProjects.IRTiBE.entity.table.anagrafiche.*;
import laoreProjects.IRTiBE.entity.view.anagrafiche.VMacroAttivitaEntity;
import laoreProjects.IRTiBE.entity.view.anagrafiche.VSpecializzazioneAttivitaEntity;
import laoreProjects.IRTiBE.service.AnagraficheService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/anagrafiche")
@RequiredArgsConstructor
public class AnagraficheController {

    private final AnagraficheService anagraficheService;


    /*
        Controller tabella: td_attivita
     */
    @GetMapping("/lista_TD_ATTIVITA") // Postman request: "Lista Attività From Tabella"
    public ResponseEntity<List<TdAttivitaEntity>> getLista_TD_ATTIVITA() {

        List<TdAttivitaEntity> lista_TdAttivitaEntity = anagraficheService.getLista_TD_ATTIVITA();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdAttivitaEntity);
    }
    @GetMapping("/lista_TD_ATTIVITA_Attive") // Postman request: "Lista Attività Attive From Tabella"
    public ResponseEntity<List<TdAttivitaEntity>> getLista_TD_ATTIVITA_Attive() {

        List<TdAttivitaEntity> lista_TdAttivitaEntity = anagraficheService.getLista_TD_ATTIVITA_Attive();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdAttivitaEntity);
    }


    /*
        Controller tabella: td_ambito_attivita
     */
    @GetMapping("/lista_TD_AMBITO_ATTIVITA") // Postman request: "Lista Ambito Attività From Tabella"
    public ResponseEntity<List<TdAmbitoAttivitaEntity>> getLista_TD_AMBITO_ATTIVITA() {

        List<TdAmbitoAttivitaEntity> lista_TdAmbitoAttivitaEntity = anagraficheService.getLista_TD_AMBITO_ATTIVITA();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdAmbitoAttivitaEntity);
    }
    @GetMapping("/lista_TD_AMBITO_ATTIVITA_Attive") // Postman request: "Lista Ambito Attività Attive From Tabella"
    public ResponseEntity<List<TdAmbitoAttivitaEntity>> getLista_TD_AMBITO_ATTIVITA_Attive() {

        List<TdAmbitoAttivitaEntity> lista_TdAmbitoAttivitaEntity = anagraficheService.getLista_TD_AMBITO_ATTIVITA_Attive();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdAmbitoAttivitaEntity);
    }


    /*
        Controller tabella: td_macro_attivita
     */
    @GetMapping("/lista_TD_MACRO_ATTIVITA") // Postman request: "Lista Macro-Attività From Tabella"
    public ResponseEntity<List<TdMacroAttivitaEntity>> getLista_TD_MACRO_ATTIVITA() {

        List<TdMacroAttivitaEntity> lista_TdMacroAttivitaEntity = anagraficheService.getLista_TD_MACRO_ATTIVITA();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdMacroAttivitaEntity);
    }
    @GetMapping("/lista_TD_MACRO_ATTIVITA_Attive") // Postman request: "Lista Macro-Attività Attive From Tabella"
    public ResponseEntity<List<TdMacroAttivitaEntity>> getLista_TD_MACRO_ATTIVITA_Attive() {

        List<TdMacroAttivitaEntity> lista_TdMacroAttivitaEntity = anagraficheService.getLista_TD_MACRO_ATTIVITA_Attive();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdMacroAttivitaEntity);
    }
    @GetMapping("/lista_TD_MACRO_ATTIVITA_Attive_by_ID_AMBITO_ATTIVITA") // Postman request: "Lista Macro-Attività Attive by ID_AMBITO_ATTIVITA From Tabella"
    public ResponseEntity<List<TdMacroAttivitaEntity>> getLista_TD_MACRO_ATTIVITA_Attive_by_ID_AMBITO_ATTIVITA(@RequestParam("idAmbitoAttivita") Integer idAmbitoAttivita) {

        List<TdMacroAttivitaEntity> lista_TdMacroAttivitaEntity = anagraficheService.getLista_TD_MACRO_ATTIVITA_Attive_by_ID_AMBITO_ATTIVITA(idAmbitoAttivita);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdMacroAttivitaEntity);
    }


    /*
        Controller tabella: td_specializzazione_attivita
     */
    @GetMapping("/lista_TD_SPECIALIZZAZIONE_ATTIVITA") // Postman request: "Lista Specializzazione Attività From Tabella"
    public ResponseEntity<List<TdSpecializzazioneAttivitaEntity>> getLista_TD_SPECIALIZZAZIONE_ATTIVITA() {

        List<TdSpecializzazioneAttivitaEntity> lista_TdSpecializzazioneAttivitaEntity = anagraficheService.getLista_TD_SPECIALIZZAZIONE_ATTIVITA();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdSpecializzazioneAttivitaEntity);
    }
    @GetMapping("/lista_TD_SPECIALIZZAZIONE_ATTIVITA_Attive") // Postman request: "Lista Specializzazione Attività Attive From Tabella"
    public ResponseEntity<List<TdSpecializzazioneAttivitaEntity>> getLista_TD_SPECIALIZZAZIONE_ATTIVITA_Attive() {

        List<TdSpecializzazioneAttivitaEntity> lista_TdSpecializzazioneAttivitaEntity = anagraficheService.getLista_TD_SPECIALIZZAZIONE_ATTIVITA_Attive();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdSpecializzazioneAttivitaEntity);
    }
    @GetMapping("/lista_TD_SPECIALIZZAZIONE_ATTIVITA_Attive_by_ID_MACRO_ATTIVITA") // Postman request: "Lista Specializzazione Attività Attive by ID_MACRO_ATTIVITA From Tabella"
    public ResponseEntity<List<TdSpecializzazioneAttivitaEntity>> getLista_TD_SPECIALIZZAZIONE_ATTIVITA_Attive_by_ID_MACRO_ATTIVITA(@RequestParam("idMacroAttivita") Integer idMacroAttivita) {

        List<TdSpecializzazioneAttivitaEntity> lista_TdSpecializzazioneAttivitaEntity = anagraficheService.getLista_TD_SPECIALIZZAZIONE_ATTIVITA_Attive_by_ID_MACRO_ATTIVITA(idMacroAttivita);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdSpecializzazioneAttivitaEntity);
    }


    /*
        Controller tabella: td_tipo_documento
    */
    @GetMapping("/lista_TD_TIPO_DOCUMENTO") // Postman request: "Lista Tipo Documento From Tabella"
    public ResponseEntity<List<TdTipoDocumentoEntity>> getLista_TD_TIPO_DOCUMENTO() {

        List<TdTipoDocumentoEntity> lista_TdTipoDocumentoEntity = anagraficheService.getLista_TD_TIPO_DOCUMENTO();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdTipoDocumentoEntity);
    }
    @GetMapping("/lista_TD_TIPO_DOCUMENTO_Attivi") // Postman request: "Lista Tipo Documento Attivi From Tabella"
    public ResponseEntity<List<TdTipoDocumentoEntity>> getLista_TD_TIPO_DOCUMENTO_Attivi() {

        List<TdTipoDocumentoEntity> lista_TdTipoDocumentoEntity = anagraficheService.getLista_TD_TIPO_DOCUMENTO_Attivi();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdTipoDocumentoEntity);
    }


    /*
        Controller tabella: td_applicativo
    */
    @GetMapping("/lista_TD_APPLICATIVO") // Postman request: "Lista Applicativo From Tabella"
    public ResponseEntity<List<TdApplicativoEntity>> getLista_TD_APPLICATIVO() {

        List<TdApplicativoEntity> lista_TdApplicativoEntity = anagraficheService.getLista_TD_APPLICATIVO();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdApplicativoEntity);
    }
    @GetMapping("/lista_TD_APPLICATIVO_Attivi") // Postman request: "Lista Applicativo Attive From Tabella"
    public ResponseEntity<List<TdApplicativoEntity>> getLista_TD_APPLICATIVO_Attivi() {

        List<TdApplicativoEntity> lista_TdApplicativoEntity = anagraficheService.getLista_TD_APPLICATIVO_Attivi();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdApplicativoEntity);
    }


    /*
        Controller tabella: td_modo_registrazione_documento_protocollo
    */
    @GetMapping("/lista_TD_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO") // Postman request: "Lista Modo Registrazione Documento Protocollo From Tabella"
    public ResponseEntity<List<TdModoRegistrazioneDocumentoProtocolloEntity>> getLista_TD_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO() {

        List<TdModoRegistrazioneDocumentoProtocolloEntity> lista_TdModoRegistrazioneDocumentoProtocolloEntity = anagraficheService.getLista_TD_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdModoRegistrazioneDocumentoProtocolloEntity);
    }
    @GetMapping("/lista_TD_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO_Attivi") // Postman request: "Lista Modo Registrazione Documento Protocollo Attivi From Tabella"
    public ResponseEntity<List<TdModoRegistrazioneDocumentoProtocolloEntity>> getLista_TD_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO_Attivi() {

        List<TdModoRegistrazioneDocumentoProtocolloEntity> lista_TdModoRegistrazioneDocumentoProtocolloEntity = anagraficheService.getLista_TD_MODO_REGISTRAZIONE_DOCUMENTO_PROTOCOLLO_Attivi();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdModoRegistrazioneDocumentoProtocolloEntity);
    }


    /*
        Controller tabella: td_servizio
    */
    @GetMapping("/lista_TD_SERVIZIO") // Postman request: "Lista Servizio From Tabella"
    public ResponseEntity<List<TdServizioEntity>> getLista_TD_SERVIZIO() {

        List<TdServizioEntity> lista_TdServizioEntity = anagraficheService.getLista_TD_SERVIZIO();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdServizioEntity);
    }


    /*
        Controller tabella: td_modo_gestione_documento
    */
    @GetMapping("/lista_TD_MODO_GESTIONE_DOCUMENTO") // Postman request: "Lista Modo Gestione Documento From Tabella"
    public ResponseEntity<List<TdModoGestioneDocumentoEntity>> getLista_TD_MODO_GESTIONE_DOCUMENTO() {

        List<TdModoGestioneDocumentoEntity> lista_TdModoGestioneDocumentoEntity = anagraficheService.getLista_TD_MODO_GESTIONE_DOCUMENTO();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdModoGestioneDocumentoEntity);
    }
    @GetMapping("/lista_TD_MODO_GESTIONE_DOCUMENTO_Attivi") // Postman request: "Lista Modo Gestione Documento Attivi From Tabella"
    public ResponseEntity<List<TdModoGestioneDocumentoEntity>> getLista_TD_MODO_GESTIONE_DOCUMENTO_Attivi() {

        List<TdModoGestioneDocumentoEntity> lista_TdModoGestioneDocumentoEntity = anagraficheService.getLista_TD_MODO_GESTIONE_DOCUMENTO_Attivi();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdModoGestioneDocumentoEntity);
    }


    /*
        Controller tabella: td_modo_organizzazione_documento
    */
    @GetMapping("/lista_TD_MODO_ORGANIZZAZIONE_DOCUMENTO") // Postman request: "Lista Modo Organizzazione Documento From Tabella"
    public ResponseEntity<List<TdModoOrganizzazioneDocumentoEntity>> getLista_TD_MODO_ORGANIZZAZIONE_DOCUMENTO() {

        List<TdModoOrganizzazioneDocumentoEntity> lista_TdModoOrganizzazioneDocumentoEntity = anagraficheService.getLista_TD_MODO_ORGANIZZAZIONE_DOCUMENTO();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdModoOrganizzazioneDocumentoEntity);
    }
    @GetMapping("/lista_TD_MODO_ORGANIZZAZIONE_DOCUMENTO_Attivi") // Postman request: "Lista Modo Organizzazione Documento Attivi From Tabella"
    public ResponseEntity<List<TdModoOrganizzazioneDocumentoEntity>> getLista_TD_MODO_ORGANIZZAZIONE_DOCUMENTO_Attivi() {

        List<TdModoOrganizzazioneDocumentoEntity> lista_TdModoOrganizzazioneDocumentoEntity = anagraficheService.getLista_TD_MODO_ORGANIZZAZIONE_DOCUMENTO_Attivi();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdModoOrganizzazioneDocumentoEntity);
    }


    /*
        Controller tabella: td_criterio_organizzazione_documento
    */
    @GetMapping("/lista_TD_CRITERIO_ORGANIZZAZIONE_DOCUMENTO") // Postman request: "Lista Criterio Organizzazione Documento From Tabella"
    public ResponseEntity<List<TdCriterioOrganizzazioneDocumentoEntity>> getLista_TD_CRITERIO_ORGANIZZAZIONE_DOCUMENTO() {

        List<TdCriterioOrganizzazioneDocumentoEntity> lista_TdCriterioOrganizzazioneDocumentoEntity = anagraficheService.getLista_TD_CRITERIO_ORGANIZZAZIONE_DOCUMENTO();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdCriterioOrganizzazioneDocumentoEntity);
    }
    @GetMapping("/lista_TD_CRITERIO_ORGANIZZAZIONE_DOCUMENTO_Attivi") // Postman request: "Lista Criterio Organizzazione Documento Attivi From Tabella"
    public ResponseEntity<List<TdCriterioOrganizzazioneDocumentoEntity>> getLista_TD_CRITERIO_ORGANIZZAZIONE_DOCUMENTO_Attivi() {

        List<TdCriterioOrganizzazioneDocumentoEntity> lista_TdCriterioOrganizzazioneDocumentoEntity = anagraficheService.getLista_TD_CRITERIO_ORGANIZZAZIONE_DOCUMENTO_Attivi();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdCriterioOrganizzazioneDocumentoEntity);
    }


    /*
        Controller tabella: td_luogo_pubblicazione_documento
    */
    @GetMapping("/lista_TD_LUOGO_PUBBLICAZIONE_DOCUMENTO") // Postman request: "Lista Luogo Pubblicazione Documento From Tabella"
    public ResponseEntity<List<TdLuogoPubblicazioneDocumentoEntity>> getLista_TD_LUOGO_PUBBLICAZIONE_DOCUMENTO() {

        List<TdLuogoPubblicazioneDocumentoEntity> lista_TdLuogoPubblicazioneDocumentoEntity = anagraficheService.getLista_TD_LUOGO_PUBBLICAZIONE_DOCUMENTO();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdLuogoPubblicazioneDocumentoEntity);
    }
    @GetMapping("/lista_TD_LUOGO_PUBBLICAZIONE_DOCUMENTO_Attivi") // Postman request: "Lista Luogo Pubblicazione Documento Attivi From Tabella"
    public ResponseEntity<List<TdLuogoPubblicazioneDocumentoEntity>> getLista_TD_LUOGO_PUBBLICAZIONE_DOCUMENTO_Attivi() {

        List<TdLuogoPubblicazioneDocumentoEntity> lista_TdLuogoPubblicazioneDocumentoEntity = anagraficheService.getLista_TD_LUOGO_PUBBLICAZIONE_DOCUMENTO_Attivi();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdLuogoPubblicazioneDocumentoEntity);
    }


    /*
        Controller tabella: td_titolo
    */
    @GetMapping("/lista_TD_TITOLO") // Postman request: "Lista Titoli From Tabella"
    public ResponseEntity<List<TdTitoloEntity>> getLista_TD_TITOLO() {

        List<TdTitoloEntity> lista_TdTitoloEntity = anagraficheService.getLista_TD_TITOLO();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdTitoloEntity);
    }


    /*
        Controller tabella: td_classe
    */
    @GetMapping("/lista_TD_CLASSE") // Postman request: "Lista Classi From Tabella"
    public ResponseEntity<List<TdClasseEntity>> getLista_TD_CLASSE() {

        List<TdClasseEntity> lista_TdClasseEntity = anagraficheService.getLista_TD_CLASSE();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdClasseEntity);
    }
    @GetMapping("/lista_TD_CLASSE_by_ID_TITOLO") // Postman request: "Lista Classi by ID_TITOLO From Tabella"
    public ResponseEntity<List<TdClasseEntity>> getLista_TD_CLASSE_by_ID_TITOLO(@RequestParam("idTitolo") Integer idTitolo) {

        List<TdClasseEntity> lista_TdClasseEntity = anagraficheService.getLista_TD_CLASSE_by_ID_TITOLO(idTitolo);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_TdClasseEntity);
    }



    /*
        Controller vista: v_macro_attivita
     */
    @GetMapping("/lista_TD_MACRO_ATTIVITA_V") // Postman request: "Lista Macro-Attività From Vista"
    public ResponseEntity<List<VMacroAttivitaEntity>> getLista_TD_MACRO_ATTIVITA_V() {

        List<VMacroAttivitaEntity> lista_VMacroAttivitaEntity = anagraficheService.getLista_TD_MACRO_ATTIVITA_V();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_VMacroAttivitaEntity);
    }
    @GetMapping("/lista_TD_MACRO_ATTIVITA_Attive_V") // Postman request: "Lista Macro-Attività Attive From Vista"
    public ResponseEntity<List<VMacroAttivitaEntity>> getLista_TD_MACRO_ATTIVITA_Attive_V() {

        List<VMacroAttivitaEntity> lista_VMacroAttivitaEntity = anagraficheService.getLista_TD_MACRO_ATTIVITA_Attive_V();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_VMacroAttivitaEntity);
    }
    @GetMapping("/lista_TD_MACRO_ATTIVITA_Attive_by_ID_AMBITO_ATTIVITA_V") // Postman request: "Lista Macro-Attività Attive by ID_AMBITO_ATTIVITA From Vista"
    public ResponseEntity<List<VMacroAttivitaEntity>> lista_TD_MACRO_ATTIVITA_Attive_by_ID_AMBITO_ATTIVITA_V(@RequestParam("idAmbitoAttivita") Integer idAmbitoAttivita) {

        List<VMacroAttivitaEntity> lista_VMacroAttivitaEntity = anagraficheService.getLista_TD_MACRO_ATTIVITA_Attive_by_ID_AMBITO_ATTIVITA_V(idAmbitoAttivita);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_VMacroAttivitaEntity);
    }


    /*
        Controller vista: v_specializzazione_attivita
     */
    @GetMapping("/listaTD_SPECIALIZZAZIONE_ATTIVITA_V") // Postman request: "Lista Specializzazione-Attività From Vista"
    public ResponseEntity<List<VSpecializzazioneAttivitaEntity>> getLista_TD_SPECIALIZZAZIONE_ATTIVITA_V() {

        List<VSpecializzazioneAttivitaEntity> lista_VSpecializzazioneAttivitaEntity = anagraficheService.getLista_TD_SPECIALIZZAZIONE_ATTIVITA_V();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_VSpecializzazioneAttivitaEntity);
    }
    @GetMapping("/lista_TD_SPECIALIZZAZIONE_ATTIVITA_Attive_V") // Postman request: "Lista Specializzazione-Attività Attive From Vista"
    public ResponseEntity<List<VSpecializzazioneAttivitaEntity>> getLista_TD_SPECIALIZZAZIONE_ATTIVITA_Attive_V() {

        List<VSpecializzazioneAttivitaEntity> lista_VSpecializzazioneAttivitaEntity = anagraficheService.getLista_TD_SPECIALIZZAZIONE_ATTIVITA_Attive_V();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_VSpecializzazioneAttivitaEntity);
    }
    @GetMapping("/lista_TD_SPECIALIZZAZIONE_ATTIVITA_Attive_by_ID_MACRO_ATTIVITA_V") // Postman request: "Lista Specializzazione-Attività Attive by ID_MACRO_ATTIVITA From Vista"
    public ResponseEntity<List<VSpecializzazioneAttivitaEntity>> getLista_TD_SPECIALIZZAZIONE_ATTIVITA_Attive_by_ID_MACRO_ATTIVITA_V(@RequestParam("idMacroAttivita") Integer idMacroAttivita) {

        List<VSpecializzazioneAttivitaEntity> lista_VSpecializzazioneAttivitaEntity = anagraficheService.getLista_TD_SPECIALIZZAZIONE_ATTIVITA_Attive_by_ID_MACRO_ATTIVITA_V(idMacroAttivita);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_VSpecializzazioneAttivitaEntity);
    }


}
