package app.model.forms;

import app.model.FromEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "child_close")
public class ChildClose extends FromEntity {

    @Column(name = "child_id")
    @JsonProperty("id")
    private String childId;

    @Column(name = "close_reason")
    @JsonProperty("closeReason")
    private String closeReason;

    @Column(name = "number_of_living_children")
    @JsonProperty("numberOfLivingChildren")
    private String numberOfLivingChildren;

    @Column(name = "is_immunization_death")
    @JsonProperty("isImmunizationDeath")
    private String isImmunizationDeath;

    @Column(name = "death_cause")
    @JsonProperty("deathCause")
    private String deathCause;

    @Column(name = "other_death_cause")
    @JsonProperty("otherDeathCause")
    private String otherDeathCause;

    @Column(name = "death_date")
    @JsonProperty("deathDate")
    private String deathDate;

    @Column(name = "is_close_confirmed")
    @JsonProperty("isCloseConfirmed")
    private String isCloseConfirmed;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private String submissionDate;

    @Column(name = "child_mother_eligible_couple_id")
    @JsonProperty("child.mother.eligible_couple.id")
    private String childMotherEligibleCoupleId;

}
