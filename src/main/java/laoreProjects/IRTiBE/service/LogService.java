package laoreProjects.IRTiBE.service;

import jakarta.transaction.Transactional;
import laoreProjects.IRTiBE.authentication.entity.AccountEntity;
import laoreProjects.IRTiBE.entity.table.anagrafiche.TdApplicativoEntity;
import laoreProjects.IRTiBE.entity.table.dds.TfSmApplicativoEntity;
import laoreProjects.IRTiBE.entity.table.publics.LogSessioneEntity;
import laoreProjects.IRTiBE.repository.table.publics.LogSessioneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class LogService {

    private final LogSessioneRepository logSessioneRepository;

    public Integer log_SessionLogin(String idMatricola) {

        LogSessioneEntity logSessioneEntity;

        logSessioneEntity = new LogSessioneEntity();

        logSessioneEntity.setMatricola(idMatricola);
        logSessioneEntity.setTimestamp_login(LocalDateTime.now());

        LogSessioneEntity newLogSessioneEntity = logSessioneRepository.save(logSessioneEntity);

        return newLogSessioneEntity.getId_sessione();
    }
    public void log_SessionLogout(Integer idSessione) {

        LogSessioneEntity logSessioneEntity;

        Optional<LogSessioneEntity> op_LogSessioneEntity = logSessioneRepository.get_LOG_SESSIONE_by_ID_SESSIONE(idSessione);

        if(op_LogSessioneEntity.isPresent()) {
            logSessioneEntity = op_LogSessioneEntity.get();
            logSessioneEntity.setTimestamp_logout(LocalDateTime.now());
            logSessioneRepository.save(logSessioneEntity);
        }

    }

}
