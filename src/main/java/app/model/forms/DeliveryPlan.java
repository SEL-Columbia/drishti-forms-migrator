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
@Table(name = "delivery_plan")
@EqualsAndHashCode(callSuper = true)
public class DeliveryPlan extends FormEntity {
    @Column(name = "mother_id")
    @JsonProperty("id")
    private String motherId;

    @Column(name = "ec_id")
    @JsonProperty("ecId")
    private String ecId;

    @Column(name = "phone_number")
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @Column(name = "is_high_risk")
    @JsonProperty("isHighRisk")
    private String isHighRisk;

    @Column(name = "high_risk_reason")
    @JsonProperty("highRiskReason")
    private String highRiskReason;

    @Column(name = "anaemic_status")
    @JsonProperty("anaemicStatus")
    private String anaemicStatus;

    @Column(name = "woman_blood_group")
    @JsonProperty("womanBloodGroup")
    private String womanBloodGroup;

    @Column(name = "woman_name")
    @JsonProperty("womanName")
    private String womanName;

    @Column(name = "asha_phone_number")
    @JsonProperty("ashaPhoneNumber")
    private String ashaPhoneNumber;

    @Column(name = "family_member")
    @JsonProperty("familyMember")
    private String familyMember;

    @Column(name = "family_member2")
    @JsonProperty("familyMember2")
    private String familyMember2;

    @Column(name = "same_phone_number")
    @JsonProperty("samePhoneNumber")
    private String samePhoneNumber;

    @Column(name = "new_phone_number")
    @JsonProperty("newPhoneNumber")
    private String newPhoneNumber;

    @Column(name = "phone_number1")
    @JsonProperty("phoneNumber1")
    private String phoneNumber1;

    @Column(name = "phone_number2")
    @JsonProperty("phoneNumber2")
    private String phoneNumber2;

    @Column(name = "same_asha_phone_number")
    @JsonProperty("sameAshaPhoneNumber")
    private String sameAshaPhoneNumber;

    @Column(name = "new_asha_phone_number")
    @JsonProperty("newAshaPhoneNumber")
    private String newAshaPhoneNumber;

    @Column(name = "asha_phone_number1")
    @JsonProperty("ashaPhoneNumber1")
    private String ashaPhoneNumber1;

    @Column(name = "asha_phone_number2")
    @JsonProperty("ashaPhoneNumber2")
    private String ashaPhoneNumber2;

    @Column(name = "blood_group_message")
    @JsonProperty("bloodGroupMessage")
    private String bloodGroupMessage;

    @Column(name = "is_blood_donor_available")
    @JsonProperty("isBloodDonorAvailable")
    private String isBloodDonorAvailable;

    @Column(name = "reviewed_hrp_status1")
    @JsonProperty("reviewedHRPStatus1")
    private String reviewedHRPStatus1;

    @Column(name = "reviewed_hrp_status2")
    @JsonProperty("reviewedHRPStatus2")
    private String reviewedHRPStatus2;

    @Column(name = "reviewed_hrp_status")
    @JsonProperty("reviewedHRPStatus")
    private String reviewedHRPStatus;

    @Column(name = "mo_visit")
    @JsonProperty("moVisit")
    private String moVisit;

    @Column(name = "mo_visit_message")
    @JsonProperty("moVisitMessage")
    private String moVisitMessage;

    @Column(name = "delivery_facility1")
    @JsonProperty("deliveryFacility1")
    private String deliveryFacility1;

    @Column(name = "home_reasons")
    @JsonProperty("homeReasons")
    private String homeReasons;

    @Column(name = "delivery_facility_name1")
    @JsonProperty("deliveryFacilityName1")
    private String deliveryFacilityName1;

    @Column(name = "hrp_delivery_facility_message")
    @JsonProperty("hrpDeliveryFacilityMessage")
    private String hrpDeliveryFacilityMessage;

    @Column(name = "severe_anaemia_delivery_facility_message")
    @JsonProperty("severeAnaemiaDeliveryFacilityMessage")
    private String severeAnaemiaDeliveryFacilityMessage;

    @Column(name = "normal_delivery_facility_message")
    @JsonProperty("normalDeliveryFacilityMessage")
    private String normalDeliveryFacilityMessage;

    @Column(name = "change_delivery_facility")
    @JsonProperty("changeDeliveryFacility")
    private String changeDeliveryFacility;

    @Column(name = "delivery_facility2")
    @JsonProperty("deliveryFacility2")
    private String deliveryFacility2;

    @Column(name = "delivery_facility_name2")
    @JsonProperty("deliveryFacilityName2")
    private String deliveryFacilityName2;

    @Column(name = "delivery_facility")
    @JsonProperty("deliveryFacility")
    private String deliveryFacility;

    @Column(name = "delivery_facility_name")
    @JsonProperty("deliveryFacilityName")
    private String deliveryFacilityName;

    @Column(name = "five_delivery_cleans")
    @JsonProperty("fiveDeliveryCleans")
    private String fiveDeliveryCleans;

    @Column(name = "nearest247_facility")
    @JsonProperty("nearest247Facility")
    private String nearest247Facility;

    @Column(name = "nearest247_facility_message")
    @JsonProperty("nearest247FacilityMessage")
    private String nearest247FacilityMessage;

    @Column(name = "transportation_plan1")
    @JsonProperty("transportationPlan1")
    private String transportationPlan1;

    @Column(name = "transportation_plan1_message")
    @JsonProperty("transportationPlan1Message")
    private String transportationPlan1Message;

    @Column(name = "transportation_plan")
    @JsonProperty("transportationPlan")
    private String transportationPlan;

    @Column(name = "other_transportation_plan")
    @JsonProperty("otherTransportationPlan")
    private String otherTransportationPlan;

    @Column(name = "money_for_transport")
    @JsonProperty("moneyForTransport")
    private String moneyForTransport;

    @Column(name = "money_for_transport_message")
    @JsonProperty("moneyForTransportMessage")
    private String moneyForTransportMessage;

    @Column(name = "birth_companion")
    @JsonProperty("birthCompanion")
    private String birthCompanion;

    @Column(name = "post_partum_family_planning_message")
    @JsonProperty("postPartumFamilyPlanningMessage")
    private String postPartumFamilyPlanningMessage;

    @Column(name = "ready_to_select_post_partum_family_planning")
    @JsonProperty("readyToSelectPostPartumFamilyPlanning")
    private String readyToSelectPostPartumFamilyPlanning;

    @Column(name = "post_partum_family_planning_method")
    @JsonProperty("postPartumFamilyPlanningMethod")
    private String postPartumFamilyPlanningMethod;

    @Column(name = "birth_planning")
    @JsonProperty("birthPlanning")
    private String birthPlanning;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private Date submissionDate;

}
