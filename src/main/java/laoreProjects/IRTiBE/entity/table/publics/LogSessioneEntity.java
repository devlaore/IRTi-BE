package laoreProjects.IRTiBE.entity.table.publics;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "log_sessione", schema = "public")
@SequenceGenerator(name = "log_sessione_seq_generator", schema = "public",
        sequenceName = "log_sessione_seq", initialValue = 100000001, allocationSize = 1)
public class LogSessioneEntity {
    @Id
    @GeneratedValue(generator = "log_sessione_seq_generator", strategy = GenerationType.SEQUENCE)
    private Integer id_sessione;
    private String matricola;
    private LocalDateTime timestamp_login;
    private LocalDateTime timestamp_logout;
    private String causa_logout;

}
