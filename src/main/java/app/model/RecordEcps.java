package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "record_ecps")
public class RecordEcps extends EntityForm {
    @Id
    @Column(name = "record_ecps_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long recordEcpsId;

    @Column(name = "id")
    @JsonProperty("id")
    private String id;

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
