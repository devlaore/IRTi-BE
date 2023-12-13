package laoreProjects.IRTiBE.authentication.repository;

import laoreProjects.IRTiBE.entity.table.anagrafiche.TdModoGestioneDocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import laoreProjects.IRTiBE.authentication.entity.AccountEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, String> {

    @Query(value = "SELECT * from public.account WHERE matricola = :matricola", nativeQuery = true)
    Optional<AccountEntity> get_ACCOUNT_By_MATRICOLA(@Param("matricola") String matricola);

    @Query(value = "DELETE from public.account WHERE matricola = :matricola", nativeQuery = true)
    Optional<AccountEntity> delete_ACCOUNT_By_MATRICOLA(@Param("matricola") String matricola);


}
