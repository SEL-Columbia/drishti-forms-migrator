package app.model.forms;

import app.model.FormEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "record_ecps")
@EqualsAndHashCode(callSuper = true)
public class RecordEcps extends FormEntity {
    @Column(name = "eligible_couple_id")
    @JsonProperty("id")
    private String eligibleCoupleId;

    @Column(name = "number_of_ec_ps_given")
    @JsonProperty("numberOfECPsGiven")
    private Integer numberOfECPsGiven;

    @Column(name = "ecp_date")
    @JsonProperty("ecpDate")
    private Date ecpDate;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private Date submissionDate;

}
