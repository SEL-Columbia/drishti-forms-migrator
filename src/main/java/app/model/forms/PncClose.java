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
@Table(name = "pnc_close")
@EqualsAndHashCode(callSuper = true)
public class PncClose extends FormEntity {
    @Column(name = "mother_id")
    @JsonProperty("id")
    private String motherId;

    @Column(name = "close_reason")
    @JsonProperty("closeReason")
    private String closeReason;

    @Column(name = "death_date")
    @JsonProperty("deathDate")
    private Date deathDate;

    @Column(name = "is_maternal_death")
    @JsonProperty("isMaternalDeath")
    private String isMaternalDeath;

    @Column(name = "maternal_death_cause")
    @JsonProperty("maternalDeathCause")
    private String maternalDeathCause;

    @Column(name = "other_maternal_death_cause")
    @JsonProperty("otherMaternalDeathCause")
    private String otherMaternalDeathCause;

    @Column(name = "is_pnc_close_confirmed")
    @JsonProperty("isPNCCloseConfirmed")
    private String isPNCCloseConfirmed;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private Date submissionDate;

}
