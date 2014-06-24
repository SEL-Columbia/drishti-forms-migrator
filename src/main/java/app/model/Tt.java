package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tt")
public class Tt extends EntityForm {

    @Column(name = "mother_id")
    @JsonProperty("id")
    private String motherId;

    @Column(name = "tt_dose")
    @JsonProperty("ttDose")
    private String ttDose;

    @Column(name = "tt_injection_place")
    @JsonProperty("ttInjectionPlace")
    private String ttInjectionPlace;

    @Column(name = "tt_date")
    @JsonProperty("ttDate")
    private String ttDate;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private String submissionDate;

}
