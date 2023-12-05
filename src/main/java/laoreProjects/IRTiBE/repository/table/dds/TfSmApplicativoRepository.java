package laoreProjects.IRTiBE.repository.table.dds;

import laoreProjects.IRTiBE.entity.table.dds.TfSmApplicativoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TfSmApplicativoRepository extends JpaRepository<TfSmApplicativoEntity, Integer> {
    @Query(value = "SELECT dds.f_get_next_id_applicativo_sm()", nativeQuery = true)
    Integer getNext_ID_APPLICATIVO_SM();
}
