package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "anc_close")
public class AncClose extends EntityForm {

    @Column(name = "mother_id")
    @JsonProperty("id")
    private String motherId;

    @Column(name = "close_reason")
    @JsonProperty("closeReason")
    private String closeReason;

    @Column(name = "number_of_abortions")
    @JsonProperty("numberOfAbortions")
    private String numberOfAbortions;

    @Column(name = "is_maternal_death")
    @JsonProperty("isMaternalDeath")
    private String isMaternalDeath;

    @Column(name = "number_of_spontaneous_abortions")
    @JsonProperty("numberOfSpontaneousAbortions")
    private String numberOfSpontaneousAbortions;

    @Column(name = "date_of_spontaneous_abortion")
    @JsonProperty("dateOfSpontaneousAbortion")
    private String dateOfSpontaneousAbortion;

    @Column(name = "reference_date")
    @JsonProperty("referenceDate")
    private String referenceDate;

    @Column(name = "number_of_weeks_pregnant_when_spontaneous_abortion_happened")
    @JsonProperty("numberOfWeeksPregnantWhenSpontaneousAbortionHappened")
    private String numberOfWeeksPregnantWhenSpontaneousAbortionHappened;

    @Column(name = "cause_of_spontaneous_abortion")
    @JsonProperty("causeOfSpontaneousAbortion")
    private String causeOfSpontaneousAbortion;

    @Column(name = "other_cause_of_spontaneous_abortion")
    @JsonProperty("otherCauseOfSpontaneousAbortion")
    private String otherCauseOfSpontaneousAbortion;

    @Column(name = "place_of_spontaneous_abortion")
    @JsonProperty("placeOfSpontaneousAbortion")
    private String placeOfSpontaneousAbortion;

    @Column(name = "is_rh_negative")
    @JsonProperty("isRHNegative")
    private String isRHNegative;

    @Column(name = "number_of_induced_abortions")
    @JsonProperty("numberOfInducedAbortions")
    private String numberOfInducedAbortions;

    @Column(name = "time_of_induced_abortion")
    @JsonProperty("timeOfInducedAbortion")
    private String timeOfInducedAbortion;

    @Column(name = "date_of_induced_abortion")
    @JsonProperty("dateOfInducedAbortion")
    private String dateOfInducedAbortion;

    @Column(name = "maternal_death_date")
    @JsonProperty("maternalDeathDate")
    private String maternalDeathDate;

    @Column(name = "maternal_death_trimester")
    @JsonProperty("maternalDeathTrimester")
    private String maternalDeathTrimester;

    @Column(name = "maternal_death_cause")
    @JsonProperty("maternalDeathCause")
    private String maternalDeathCause;

    @Column(name = "other_maternal_death_cause")
    @JsonProperty("otherMaternalDeathCause")
    private String otherMaternalDeathCause;

    @Column(name = "rh_injection_given")
    @JsonProperty("rhInjectionGiven")
    private String rhInjectionGiven;

    @Column(name = "is_anc_close_confirmed")
    @JsonProperty("isANCCloseConfirmed")
    private String isANCCloseConfirmed;

    @Column(name = "has_anc_left_place")
    @JsonProperty("hasANCLeftPlace")
    private String hasANCLeftPlace;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private String submissionDate;

}
