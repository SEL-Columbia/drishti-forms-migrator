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
@Table(name = "tt")
@EqualsAndHashCode(callSuper = true)
public class Tt extends FormEntity {
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
    private Date ttDate;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private Date submissionDate;

}
