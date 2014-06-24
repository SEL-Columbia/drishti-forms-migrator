package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "ec_close")
public class EcClose extends EntityForm {

    @Column(name = "eligible_couple_id")
    @JsonProperty("id")
    private String eligibleCoupleId;

    @Column(name = "close_reason")
    @JsonProperty("closeReason")
    private String closeReason;

    @Column(name = "other_close_reason")
    @JsonProperty("otherCloseReason")
    private String otherCloseReason;

    @Column(name = "is_sterilization_death")
    @JsonProperty("isSterilizationDeath")
    private String isSterilizationDeath;

    @Column(name = "sterilization_death_date")
    @JsonProperty("sterilizationDeathDate")
    private String sterilizationDeathDate;

    @Column(name = "is_maternal_death")
    @JsonProperty("isMaternalDeath")
    private String isMaternalDeath;

    @Column(name = "maternal_death_date")
    @JsonProperty("maternalDeathDate")
    private String maternalDeathDate;

    @Column(name = "maternal_death_cause")
    @JsonProperty("maternalDeathCause")
    private String maternalDeathCause;

    @Column(name = "other_maternal_death_cause")
    @JsonProperty("otherMaternalDeathCause")
    private String otherMaternalDeathCause;

    @Column(name = "is_ec_close_confirmed")
    @JsonProperty("isECCloseConfirmed")
    private String isECCloseConfirmed;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private String submissionDate;

}
