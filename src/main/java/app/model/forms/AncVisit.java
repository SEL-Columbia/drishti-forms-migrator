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
@Table(name = "anc_visit")
@EqualsAndHashCode(callSuper = true)
public class AncVisit extends FormEntity {
    @Column(name = "mother_id")
    @JsonProperty("id")
    private String motherId;

    @Column(name = "ec_id")
    @JsonProperty("ecId")
    private String ecId;

    @Column(name = "wife_name")
    @JsonProperty("wifeName")
    private String wifeName;

    @Column(name = "anc_visit_number")
    @JsonProperty("ancVisitNumber")
    private Integer ancVisitNumber;

    @Column(name = "anc_visit_date")
    @JsonProperty("ancVisitDate")
    private Date ancVisitDate;

    @Column(name = "anc_visit_person")
    @JsonProperty("ancVisitPerson")
    private String ancVisitPerson;

    @Column(name = "anc_visit_place")
    @JsonProperty("ancVisitPlace")
    private String ancVisitPlace;

    @Column(name = "risk_observed_during_anc")
    @JsonProperty("riskObservedDuringANC")
    private String riskObservedDuringANC;

    @Column(name = "other_risk_observed_during_anc")
    @JsonProperty("otherRiskObservedDuringANC")
    private String otherRiskObservedDuringANC;

    @Column(name = "jaundice")
    @JsonProperty("jaundice")
    private String jaundice;

    @Column(name = "vitals_taken")
    @JsonProperty("vitalsTaken")
    private String vitalsTaken;

    @Column(name = "bp_systolic")
    @JsonProperty("bpSystolic")
    private Integer bpSystolic;

    @Column(name = "bp_diastolic")
    @JsonProperty("bpDiastolic")
    private Integer bpDiastolic;

    @Column(name = "pulse_rate")
    @JsonProperty("pulseRate")
    private Integer pulseRate;

    @Column(name = "temperature")
    @JsonProperty("temperature")
    private Float temperature;

    @Column(name = "weight")
    @JsonProperty("weight")
    private Float weight;

    @Column(name = "reference_date")
    @JsonProperty("referenceDate")
    private Date referenceDate;

    @Column(name = "abdominals_observed")
    @JsonProperty("abdominalsObserved")
    private String abdominalsObserved;

    @Column(name = "abdominals_abnormal")
    @JsonProperty("abdominalsAbnormal")
    private String abdominalsAbnormal;

    @Column(name = "is_multiple_pregnancy")
    @JsonProperty("isMultiplePregnancy")
    private String isMultiplePregnancy;

    @Column(name = "is_malpresentation_of_fetus")
    @JsonProperty("isMalpresentationOfFetus")
    private String isMalpresentationOfFetus;

    @Column(name = "prasooti_payment1")
    @JsonProperty("prasootiPayment1")
    private String prasootiPayment1;

    @Column(name = "prasooti1_date")
    @JsonProperty("prasooti1Date")
    private Date prasooti1Date;

    @Column(name = "pih")
    @JsonProperty("pih")
    private String pih;

    @Column(name = "multiple_pregnancy_reason")
    @JsonProperty("multiplePregnancyReason")
    private String multiplePregnancyReason;

    @Column(name = "malpresentation_of_fetus_reason")
    @JsonProperty("malpresentationOfFetusReason")
    private String malpresentationOfFetusReason;

    @Column(name = "is_high_risk_till_delivery")
    @JsonProperty("isHighRiskTillDelivery")
    private String isHighRiskTillDelivery;

    @Column(name = "high_risk_till_delivery_reason")
    @JsonProperty("highRiskTillDeliveryReason")
    private String highRiskTillDeliveryReason;

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
    @JsonProperty("isHighRisk")
    private String isHighRisk;

    @Column(name = "is_birth_planning_done")
    @JsonProperty("isBirthPlanningDone")
    private String isBirthPlanningDone;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private Date submissionDate;

}
