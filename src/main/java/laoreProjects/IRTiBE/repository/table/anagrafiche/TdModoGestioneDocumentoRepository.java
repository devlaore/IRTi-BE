package laoreProjects.IRTiBE.repository.table.anagrafiche;

import laoreProjects.IRTiBE.entity.table.anagrafiche.TdModoGestioneDocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TdModoGestioneDocumentoRepository extends JpaRepository<TdModoGestioneDocumentoEntity, Integer> {

    @Query(value = "SELECT * from anagrafiche.td_modo_gestione_documento ORDER BY id_modo_gestione_documento", nativeQuery = true)
    Optional<List<TdModoGestioneDocumentoEntity>> getLista_TD_MODO_GESTIONE_DOCUMENTO();
    @Query(value = "SELECT * from anagrafiche.td_modo_gestione_documento WHERE flag_attivo = 'Y' ORDER BY id_modo_gestione_documento", nativeQuery = true)
    Optional<List<TdModoGestioneDocumentoEntity>> getLista_TD_MODO_GESTIONE_DOCUMENTO_Attivi();
}
