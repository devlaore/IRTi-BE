package laoreProjects.IRTiBE.repository.table.anagrafiche;

import laoreProjects.IRTiBE.entity.table.anagrafiche.TdLuogoPubblicazioneDocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TdLuogoPubblicazioneDocumentoRepository extends JpaRepository<TdLuogoPubblicazioneDocumentoEntity, Integer> {

    @Query(value = "SELECT * from anagrafiche.td_luogo_pubblicazione_documento ORDER BY td_luogo_pubblicazione_documento", nativeQuery = true)
    Optional<List<TdLuogoPubblicazioneDocumentoEntity>> getLista_TD_LUOGO_PUBBLICAZIONE_DOCUMENTO();
    @Query(value = "SELECT * from anagrafiche.td_luogo_pubblicazione_documento WHERE flag_attivo = 'Y' ORDER BY td_luogo_pubblicazione_documento", nativeQuery = true)
    Optional<List<TdLuogoPubblicazioneDocumentoEntity>> getLista_TD_LUOGO_PUBBLICAZIONE_DOCUMENTO_Attivi();
}
