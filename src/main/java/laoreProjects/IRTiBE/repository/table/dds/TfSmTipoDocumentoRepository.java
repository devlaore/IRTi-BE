package laoreProjects.IRTiBE.repository.table.dds;

import laoreProjects.IRTiBE.entity.table.dds.TfSmTipoDocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TfSmTipoDocumentoRepository extends JpaRepository<TfSmTipoDocumentoEntity, Integer> {
    @Query(value = "SELECT dds.f_get_next_id_tipo_documento_sm()", nativeQuery = true)
    Integer getNext_ID_TIPO_DOCUMENTO_SM();
}
