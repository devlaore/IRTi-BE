package laoreProjects.IRTiBE.entity.table.dds;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import laoreProjects.IRTiBE.entity.table.dds.primaryKeys.TfSmApplicativoPK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(TfSmApplicativoPK.class)
@Table(name = "tf_sm_applicativo", schema = "dds")
public class TfSmApplicativoEntity {

    @Id
    private Integer id_applicativo_sm;
    @Id
    private Integer id_applicativo;
}
