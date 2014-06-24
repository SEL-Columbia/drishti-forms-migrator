package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "record_ecps")
public class RecordEcps extends EntityForm {

    @Column(name = "eligible_couple_id")
    @JsonProperty("id")
    private String eligibleCoupleId;

    @Column(name = "number_of_ec_ps_given")
    @JsonProperty("numberOfECPsGiven")
    private String numberOfECPsGiven;

    @Column(name = "ecp_date")
    @JsonProperty("ecpDate")
    private String ecpDate;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private String submissionDate;

}
