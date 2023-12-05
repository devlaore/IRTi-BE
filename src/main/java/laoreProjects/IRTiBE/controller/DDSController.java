package laoreProjects.IRTiBE.controller;

import laoreProjects.IRTiBE.entity.table.dds.TfQuestionarioEntity;
import laoreProjects.IRTiBE.entity.view.dds.VQuestionarioEntity;
import laoreProjects.IRTiBE.model.request.QuestionarioModelRequest;
import laoreProjects.IRTiBE.service.DDSService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dds")
@RequiredArgsConstructor
public class DDSController {

    private final DDSService ddsService;

    /*
        Controller tabella: tf_questionario
     */
    @PostMapping("/salva_TF_QUESTIONARIO") // Postman request: "Salva Questionario"
    public ResponseEntity<TfQuestionarioEntity> salva_TF_QUESTIONARIO(@RequestBody QuestionarioModelRequest questionarioModelRequest) {

        TfQuestionarioEntity tfQuestionarioEntity = ddsService.salva_TF_QUESTIONARIO(questionarioModelRequest);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tfQuestionarioEntity);
    }

    /*
        Controller vista: v_questionario
     */
    @GetMapping("/lista_V_QUESTIONARIO") // Postman request: "Lista Questionari From Vista"
    public ResponseEntity<List<VQuestionarioEntity>> getLista_V_QUESTIONARIO() {

        List<VQuestionarioEntity> lista_VQuestionarioEntity = ddsService.getLista_V_QUESTIONARIO();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lista_VQuestionarioEntity);
    }
}
