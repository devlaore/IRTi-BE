package laoreProjects.IRTiBE.repository.table.publics;

import laoreProjects.IRTiBE.entity.table.dds.TfQuestionarioBozzeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import laoreProjects.IRTiBE.entity.table.publics.LogSessioneEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LogSessioneRepository extends JpaRepository<LogSessioneEntity, Integer> {

    @Query(value = "SELECT * from public.log_sessione WHERE id_sessione = :idSessione", nativeQuery = true)
    Optional<LogSessioneEntity> get_LOG_SESSIONE_by_ID_SESSIONE(@Param("idSessione") Integer idSessione);


}
