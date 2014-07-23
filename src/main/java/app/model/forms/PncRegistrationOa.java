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
@Table(name = "pnc_registration_oa")
@EqualsAndHashCode(callSuper = true)
public class PncRegistrationOa extends FormEntity {
    @Column(name = "eligible_couple_id")
    @JsonProperty("id")
    private String eligibleCoupleId;

    @Column(name = "mother_id")
    @JsonProperty("motherId")
    private String motherId;

    @Column(name = "registration_date")
    @JsonProperty("registrationDate")
    private Date registrationDate;

    @Column(name = "phc")
    @JsonProperty("phc")
    private String phc;

    @Column(name = "sub_center")
    @JsonProperty("subCenter")
    private String subCenter;

    @Column(name = "village")
    @JsonProperty("village")
    private String village;

    @Column(name = "household_address")
    @JsonProperty("householdAddress")
    private String householdAddress;

    @Column(name = "wife_name")
    @JsonProperty("wifeName")
    private String wifeName;

    @Column(name = "wife_age")
    @JsonProperty("wifeAge")
    private Float wifeAge;

    @Column(name = "thayi_card_number")
    @JsonProperty("thayiCardNumber")
    private String thayiCardNumber;

    @Column(name = "aadhaar_number")
    @JsonProperty("aadhaarNumber")
    private String aadhaarNumber;

    @Column(name = "husband_name")
    @JsonProperty("husbandName")
    private String husbandName;

    @Column(name = "phone_number")
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @Column(name = "phone_owner")
    @JsonProperty("phoneOwner")
    private String phoneOwner;

    @Column(name = "economic_status")
    @JsonProperty("economicStatus")
    private String economicStatus;

    @Column(name = "bpl_card_number")
    @JsonProperty("bplCardNumber")
    private String bplCardNumber;

    @Column(name = "caste")
    @JsonProperty("caste")
    private String caste;

    @Column(name = "reference_date")
    @JsonProperty("referenceDate")
    private Date referenceDate;

    @Column(name = "delivery_place")
    @JsonProperty("deliveryPlace")
    private String deliveryPlace;

    @Column(name = "delivery_facility_name")
    @JsonProperty("deliveryFacilityName")
    private String deliveryFacilityName;

    @Column(name = "is_skilled_delivery")
    @JsonProperty("isSkilledDelivery")
    private String isSkilledDelivery;

    @Column(name = "delivery_type")
    @JsonProperty("deliveryType")
    private String deliveryType;

    @Column(name = "delivery_outcome")
    @JsonProperty("deliveryOutcome")
    private String deliveryOutcome;

    @Column(name = "cause_of_still_birth")
    @JsonProperty("causeOfStillBirth")
    private String causeOfStillBirth;

    @Column(name = "other_cause_of_still_birth")
    @JsonProperty("otherCauseOfStillBirth")
    private String otherCauseOfStillBirth;

    @Column(name = "did_breastfeeding_start")
    @JsonProperty("didBreastfeedingStart")
    private String didBreastfeedingStart;

    @Column(name = "had_delivery_complications")
    @JsonProperty("hadDeliveryComplications")
    private String hadDeliveryComplications;

    @Column(name = "delivery_complications")
    @JsonProperty("deliveryComplications")
    private String deliveryComplications;

    @Column(name = "other_delivery_complications")
    @JsonProperty("otherDeliveryComplications")
    private String otherDeliveryComplications;

    @Column(name = "is_high_risk")
    @JsonProperty("isHighRisk")
    private String isHighRisk;

    @Column(name = "high_risk_reason")
    @JsonProperty("highRiskReason")
    private String highRiskReason;

    @Column(name = "period_of_stay")
    @JsonProperty("periodOfStay")
    private String periodOfStay;

    @Column(name = "did_woman_survive")
    @JsonProperty("didWomanSurvive")
    private String didWomanSurvive;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private Date submissionDate;

    @Column(name = "type")
    @JsonProperty("type")
    private String type;

    @Column(name = "is_closed")
    @JsonProperty("isClosed")
    private String isClosed;

    @Column(name = "is_out_of_area")
    @JsonProperty("isOutOfArea")
    private String isOutOfArea;

}
