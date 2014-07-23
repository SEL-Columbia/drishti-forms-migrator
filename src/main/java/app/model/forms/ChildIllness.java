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
@Table(name = "child_illness")
@EqualsAndHashCode(callSuper = true)
public class ChildIllness extends FormEntity {
    @Column(name = "child_id")
    @JsonProperty("id")
    private String childId;

    @Column(name = "sick_visit_date")
    @JsonProperty("sickVisitDate")
    private Date sickVisitDate;

    @Column(name = "date_of_birth")
    @JsonProperty("dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "child_signs")
    @JsonProperty("childSigns")
    private String childSigns;

    @Column(name = "child_signs_other")
    @JsonProperty("childSignsOther")
    private String childSignsOther;

    @Column(name = "immediate_referral")
    @JsonProperty("immediateReferral")
    private String immediateReferral;

    @Column(name = "immediate_referral_reason")
    @JsonProperty("immediateReferralReason")
    private String immediateReferralReason;

    @Column(name = "report_child_disease")
    @JsonProperty("reportChildDisease")
    private String reportChildDisease;

    @Column(name = "report_child_disease_other")
    @JsonProperty("reportChildDiseaseOther")
    private String reportChildDiseaseOther;

    @Column(name = "report_child_disease_date")
    @JsonProperty("reportChildDiseaseDate")
    private Date reportChildDiseaseDate;

    @Column(name = "report_child_disease_place")
    @JsonProperty("reportChildDiseasePlace")
    private String reportChildDiseasePlace;

    @Column(name = "number_of_ors_given")
    @JsonProperty("numberOfORSGiven")
    private Float numberOfORSGiven;

    @Column(name = "child_referral")
    @JsonProperty("childReferral")
    private String childReferral;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private Date submissionDate;

}
