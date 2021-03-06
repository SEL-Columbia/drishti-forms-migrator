package app.model.subForms;

import app.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "pnc_child_visit")
@EqualsAndHashCode(callSuper = true)
public class ChildPncVisit extends BaseEntity {

    @Column(name = "child_id")
    @JsonProperty("id")
    private String childId;

    @Column(name = "sub_form_name")
    @JsonProperty("name")
    private String subFormName;

    @Column(name = "gender")
    @JsonProperty("gender")
    private String gender;

    @Column(name = "weight")
    @JsonProperty("weight")
    private Float weight;

    @Column(name = "immunizations_given")
    @JsonProperty("immunizationsGiven")
    private String immunizationsGiven;

    @Column(name = "urine_stool_problems")
    @JsonProperty("urineStoolProblems")
    private String urineStoolProblems;

    @Column(name = "days_of_diarrhea")
    @JsonProperty("daysOfDiarrhea")
    private String daysOfDiarrhea;

    @Column(name = "blood_in_stool")
    @JsonProperty("bloodInStool")
    private String bloodInStool;

    @Column(name = "activity_problems")
    @JsonProperty("activityProblems")
    private String activityProblems;

    @Column(name = "breathing_problems")
    @JsonProperty("breathingProblems")
    private String breathingProblems;

    @Column(name = "respiration_rate")
    @JsonProperty("respirationRate")
    private Float respirationRate;

    @Column(name = "skin_problems")
    @JsonProperty("skinProblems")
    private String skinProblems;

    @Column(name = "has_fever_symptoms")
    @JsonProperty("hasFeverSymptoms")
    private String hasFeverSymptoms;

    @Column(name = "temperature")
    @JsonProperty("temperature")
    private Float temperature;

    @Column(name = "child_exclusive_bf")
    @JsonProperty("childExclusiveBF")
    private String childExclusiveBF;

    @Column(name = "immediate_referral")
    @JsonProperty("immediateReferral")
    private String immediateReferral;

    @Column(name = "immediate_referral_reason")
    @JsonProperty("immediateReferralReason")
    private String immediateReferralReason;

    @Column(name = "is_child_high_risk")
    @JsonProperty("isChildHighRisk")
    private String isChildHighRisk;

    @Column(name = "pnc_visit_id")
    @JsonProperty("parentId")
    private long pncVisitId;
}
