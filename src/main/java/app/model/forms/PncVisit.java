package app.model.forms;

import app.model.FromEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "pnc_visit")
public class PncVisit extends FromEntity {

    @Column(name = "mother_id")
    @JsonProperty("id")
    private String motherId;

    @Column(name = "ec_id")
    @JsonProperty("ecId")
    private String ecId;

    @Column(name = "wife_name")
    @JsonProperty("wifeName")
    private String wifeName;

    @Column(name = "delivery_outcome")
    @JsonProperty("deliveryOutcome")
    private String deliveryOutcome;

    @Column(name = "did_woman_survive")
    @JsonProperty("didWomanSurvive")
    private String didWomanSurvive;

    @Column(name = "did_mother_survive")
    @JsonProperty("didMotherSurvive")
    private String didMotherSurvive;

    @Column(name = "delivery_place")
    @JsonProperty("deliveryPlace")
    private String deliveryPlace;

    @Column(name = "discharge_date")
    @JsonProperty("dischargeDate")
    private String dischargeDate;

    @Column(name = "delivery_type")
    @JsonProperty("deliveryType")
    private String deliveryType;

    @Column(name = "reference_date")
    @JsonProperty("referenceDate")
    private String referenceDate;

    @Column(name = "pnc_visit_date")
    @JsonProperty("pncVisitDate")
    private String pncVisitDate;

    @Column(name = "pnc_visit_day")
    @JsonProperty("pncVisitDay")
    private String pncVisitDay;

    @Column(name = "pnc_visit_place")
    @JsonProperty("pncVisitPlace")
    private String pncVisitPlace;

    @Column(name = "pnc_visit_person")
    @JsonProperty("pncVisitPerson")
    private String pncVisitPerson;

    @Column(name = "difficulties1")
    @JsonProperty("difficulties1")
    private String difficulties1;

    @Column(name = "abdominal_problems")
    @JsonProperty("abdominalProblems")
    private String abdominalProblems;

    @Column(name = "vaginal_problems")
    @JsonProperty("vaginalProblems")
    private String vaginalProblems;

    @Column(name = "difficulties2")
    @JsonProperty("difficulties2")
    private String difficulties2;

    @Column(name = "breast_problems")
    @JsonProperty("breastProblems")
    private String breastProblems;

    @Column(name = "cesarean_incision_area")
    @JsonProperty("cesareanIncisionArea")
    private String cesareanIncisionArea;

    @Column(name = "has_fever_symptoms")
    @JsonProperty("hasFeverSymptoms")
    private String hasFeverSymptoms;

    @Column(name = "temperature")
    @JsonProperty("temperature")
    private String temperature;

    @Column(name = "has_fever")
    @JsonProperty("hasFever")
    private String hasFever;

    @Column(name = "pulse_rate")
    @JsonProperty("pulseRate")
    private String pulseRate;

    @Column(name = "bp_systolic")
    @JsonProperty("bpSystolic")
    private String bpSystolic;

    @Column(name = "bp_diastolic")
    @JsonProperty("bpDiastolic")
    private String bpDiastolic;

    @Column(name = "hb_level")
    @JsonProperty("hbLevel")
    private String hbLevel;

    @Column(name = "number_of_ifa_tablets_given")
    @JsonProperty("numberOfIFATabletsGiven")
    private String numberOfIFATabletsGiven;

    @Column(name = "immediate_referral")
    @JsonProperty("immediateReferral")
    private String immediateReferral;

    @Column(name = "immediate_referral_reason")
    @JsonProperty("immediateReferralReason")
    private String immediateReferralReason;

    @Column(name = "anaemic_status")
    @JsonProperty("anaemicStatus")
    private String anaemicStatus;

    @Column(name = "pih")
    @JsonProperty("pih")
    private String pih;

    @Column(name = "pre_eclampsia")
    @JsonProperty("preEclampsia")
    private String preEclampsia;

    @Column(name = "is_high_risk_till_pnc_close")
    @JsonProperty("isHighRiskTillPNCClose")
    private String isHighRiskTillPNCClose;

    @Column(name = "high_risk_till_pnc_close_reason")
    @JsonProperty("highRiskTillPNCCloseReason")
    private String highRiskTillPNCCloseReason;

    @Column(name = "high_risk_reason")
    @JsonProperty("highRiskReason")
    private String highRiskReason;

    @Column(name = "is_high_risk")
    @JsonProperty("is_high_risk")
    private String isHighRisk;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private String submissionDate;

}
