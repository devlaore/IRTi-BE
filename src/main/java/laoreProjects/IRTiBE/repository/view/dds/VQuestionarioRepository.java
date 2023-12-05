package laoreProjects.IRTiBE.repository.view.dds;

import laoreProjects.IRTiBE.entity.view.dds.VQuestionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VQuestionarioRepository extends JpaRepository<VQuestionarioEntity, Integer> {

    @Query(value = "SELECT * from dds.v_questionario ORDER BY id_questionario", nativeQuery = true)
    Optional<List<VQuestionarioEntity>> getLista_V_QUESTIONARIO();
}
