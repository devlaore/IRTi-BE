package laoreProjects.IRTiBE.entity.table.anagrafiche;

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
@Table(name = "td_modo_registrazione_documento_protocollo", schema = "anagrafiche")
@SequenceGenerator(name = "td_modo_registrazione_documento_protocollo_seq_generator", schema = "anagrafiche",
        sequenceName = "td_modo_registrazione_documento_protocollo_seq", initialValue = 1004, allocationSize = 1)
public class TdModoRegistrazioneDocumentoProtocolloEntity {

    @Id
    @GeneratedValue(generator = "td_modo_registrazione_documento_protocollo_seq_generator", strategy = GenerationType.SEQUENCE)
    private Integer id_modo_registrazione_documento_protocollo;
    private String nome_modo_registrazione_documento_protocollo;
    private String flag_attivo;
}
