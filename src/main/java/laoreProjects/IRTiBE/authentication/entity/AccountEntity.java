package laoreProjects.IRTiBE.authentication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account", schema = "public")
public class AccountEntity {

    @Id
    private String matricola;
    private String password;
    private String nominativo;
    private String servizio;
    private String telefono;
    private String email;
    private String reset_password;

}
