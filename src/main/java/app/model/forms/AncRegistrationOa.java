package app.model.forms;

import app.model.FromEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "anc_registration_oa")
public class AncRegistrationOa extends FromEntity {

    @Column(name = "eligible_couple_id")
    @JsonProperty("id")
    private String eligibleCoupleId;

    @Column(name = "original_village")
    @JsonProperty("originalVillage")
    private String originalVillage;

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

    @Column(name = "aadhar_number")
    @JsonProperty("aadharNumber")
    private String aadharNumber;

    @Column(name = "wife_age")
    @JsonProperty("wifeAge")
    private String wifeAge;

    @Column(name = "husband_name")
    @JsonProperty("husbandName")
    private String husbandName;

    @Column(name = "phone_number")
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @Column(name = "phone_owner")
    @JsonProperty("phoneOwner")
    private String phoneOwner;

    @Column(name = "alternate_phone_number")
    @JsonProperty("alternatePhoneNumber")
    private String alternatePhoneNumber;

    @Column(name = "alternate_phone_owner")
    @JsonProperty("alternatePhoneOwner")
    private String alternatePhoneOwner;

    @Column(name = "economic_status")
    @JsonProperty("economicStatus")
    private String economicStatus;

    @Column(name = "bpl_card_number")
    @JsonProperty("bplCardNumber")
    private String bplCardNumber;

    @Column(name = "caste")
    @JsonProperty("caste")
    private String caste;

    @Column(name = "mother_id")
    @JsonProperty("motherId")
    private String motherId;

    @Column(name = "registration_date")
    @JsonProperty("registrationDate")
    private String registrationDate;

    @Column(name = "thayi_card_number")
    @JsonProperty("thayiCardNumber")
    private String thayiCardNumber;

    @Column(name = "anc_number")
    @JsonProperty("ancNumber")
    private String ancNumber;

    @Column(name = "is_jsy_beneficiary")
    @JsonProperty("isJSYBeneficiary")
    private String isJSYBeneficiary;

    @Column(name = "asha_name")
    @JsonProperty("ashaName")
    private String ashaName;

    @Column(name = "asha_phone_number")
    @JsonProperty("ashaPhoneNumber")
    private String ashaPhoneNumber;

    @Column(name = "reference_date")
    @JsonProperty("referenceDate")
    private String referenceDate;

    @Column(name = "edd")
    @JsonProperty("edd")
    private String edd;

    @Column(name = "is_first_pregnancy")
    @JsonProperty("isFirstPregnancy")
    private String isFirstPregnancy;

    @Column(name = "had_three_or_more_births")
    @JsonProperty("hadThreeOrMoreBirths")
    private String hadThreeOrMoreBirths;

    @Column(name = "had_three_or_more_abortions")
    @JsonProperty("hadThreeOrMoreAbortions")
    private String hadThreeOrMoreAbortions;

    @Column(name = "is_youngest_child_under_two")
    @JsonProperty("isYoungestChildUnderTwo")
    private String isYoungestChildUnderTwo;

    @Column(name = "complications")
    @JsonProperty("complications")
    private String complications;

    @Column(name = "other_complications")
    @JsonProperty("otherComplications")
    private String otherComplications;

    @Column(name = "medical_histories")
    @JsonProperty("medicalHistories")
    private String medicalHistories;

    @Column(name = "other_medical_histories")
    @JsonProperty("otherMedicalHistories")
    private String otherMedicalHistories;

    @Column(name = "blood_group")
    @JsonProperty("bloodGroup")
    private String bloodGroup;

    @Column(name = "is_rh_negative")
    @JsonProperty("isRHNegative")
    private String isRHNegative;

    @Column(name = "husband_blood_group")
    @JsonProperty("husbandBloodGroup")
    private String husbandBloodGroup;

    @Column(name = "is_rh_incompatible_couple")
    @JsonProperty("isRHIncompatibleCouple")
    private String isRHIncompatibleCouple;

    @Column(name = "height")
    @JsonProperty("height")
    private String height;

    @Column(name = "weight")
    @JsonProperty("weight")
    private String weight;

    @Column(name = "is_tobacco_used")
    @JsonProperty("isTobaccoUsed")
    private String isTobaccoUsed;

    @Column(name = "tobacco_user")
    @JsonProperty("tobaccoUser")
    private String tobaccoUser;

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
    private String submissionDate;

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
