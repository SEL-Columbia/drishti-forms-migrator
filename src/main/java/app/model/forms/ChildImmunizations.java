package app.model.forms;

import app.model.FromEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "child_immunizations")
@EqualsAndHashCode(callSuper = true)
public class ChildImmunizations extends FromEntity {
    @Column(name = "child_id")
    @JsonProperty("id")
    private String childId;

    @Column(name = "previous_immunizations")
    @JsonProperty("previousImmunizations")
    private String previousImmunizations;

    @Column(name = "immunizations_received")
    @JsonProperty("immunizationsReceived")
    private String immunizationsReceived;

    @Column(name = "immunizations_given")
    @JsonProperty("immunizationsGiven")
    private String immunizationsGiven;

    @Column(name = "immunization_date")
    @JsonProperty("immunizationDate")
    private Date immunizationDate;

    @Column(name = "immunization_place")
    @JsonProperty("immunizationPlace")
    private String immunizationPlace;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private Date submissionDate;

    @Column(name = "date_of_birth")
    @JsonProperty("dateOfBirth")
    private Date dateOfBirth;

}
