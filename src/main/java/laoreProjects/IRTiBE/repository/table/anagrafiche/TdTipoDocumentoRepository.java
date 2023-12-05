package laoreProjects.IRTiBE.repository.table.anagrafiche;

import laoreProjects.IRTiBE.entity.table.anagrafiche.TdTipoDocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TdTipoDocumentoRepository extends JpaRepository<TdTipoDocumentoEntity, Integer> {

    @Query(value = "SELECT * from anagrafiche.td_tipo_documento ORDER BY id_tipo_documento", nativeQuery = true)
    Optional<List<TdTipoDocumentoEntity>> getLista_TD_TIPO_DOCUMENTO();
    @Query(value = "SELECT * from anagrafiche.td_tipo_documento WHERE flag_attivo = 'Y' ORDER BY id_tipo_documento", nativeQuery = true)
    Optional<List<TdTipoDocumentoEntity>> getLista_TD_TIPO_DOCUMENTO_Attivi();
}
