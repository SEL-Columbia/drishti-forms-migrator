package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "anc_registration")
public class AncRegistration extends EntityForm {

    @Column(name = "eligible_couple_id")
    @JsonProperty("id")
    private String eligibleCoupleId;

    @Column(name = "mother_id")
    @JsonProperty("motherId")
    private String motherId;

    @Column(name = "registration_date")
    @JsonProperty("registrationDate")
    private String registrationDate;

    @Column(name = "registration_place")
    @JsonProperty("registrationPlace")
    private String registrationPlace;

    @Column(name = "wife_name")
    @JsonProperty("wifeName")
    private String wifeName;

    @Column(name = "number_of_pregnancies")
    @JsonProperty("numberOfPregnancies")
    private String numberOfPregnancies;

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

    @Column(name = "linked_facility_for_delivery")
    @JsonProperty("linkedFacilityForDelivery")
    private String linkedFacilityForDelivery;

    @Column(name = "facility_name")
    @JsonProperty("facilityName")
    private String facilityName;

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

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private String submissionDate;

    @Column(name = "type")
    @JsonProperty("type")
    private String type;

    @Column(name = "is_closed")
    @JsonProperty("isClosed")
    private String isClosed;

    @Column(name = "current_method")
    @JsonProperty("currentMethod")
    private String currentMethod;

    @Column(name = "family_planning_method_change_date")
    @JsonProperty("familyPlanningMethodChangeDate")
    private String familyPlanningMethodChangeDate;

}
