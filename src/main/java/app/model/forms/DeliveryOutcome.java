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
@Table(name = "delivery_outcome")
@EqualsAndHashCode(callSuper = true)
public class DeliveryOutcome extends FormEntity {
    @Column(name = "mother_id")
    @JsonProperty("id")
    private String motherId;

    @Column(name = "ec_id")
    @JsonProperty("ecId")
    private String ecId;

    @Column(name = "reference_date")
    @JsonProperty("referenceDate")
    private Date referenceDate;

    @Column(name = "delivery_registration_date")
    @JsonProperty("deliveryRegistrationDate")
    private Date deliveryRegistrationDate;

    @Column(name = "delivery_place")
    @JsonProperty("deliveryPlace")
    private String deliveryPlace;

    @Column(name = "delivery_facility_name")
    @JsonProperty("deliveryFacilityName")
    private String deliveryFacilityName;

    @Column(name = "is_this_only_delivery_facility")
    @JsonProperty("isThisOnlyDeliveryFacility")
    private String isThisOnlyDeliveryFacility;

    @Column(name = "additional_delivery_facility")
    @JsonProperty("additionalDeliveryFacility")
    private String additionalDeliveryFacility;

    @Column(name = "reasons_for_additional_delivery_facility")
    @JsonProperty("reasonsForAdditionalDeliveryFacility")
    private String reasonsForAdditionalDeliveryFacility;

    @Column(name = "other_reasons_for_additional_delivery_facility")
    @JsonProperty("otherReasonsForAdditionalDeliveryFacility")
    private String otherReasonsForAdditionalDeliveryFacility;

    @Column(name = "is_skilled_delivery")
    @JsonProperty("isSkilledDelivery")
    private String isSkilledDelivery;

    @Column(name = "delivery_type")
    @JsonProperty("deliveryType")
    private String deliveryType;

    @Column(name = "delivery_outcome")
    @JsonProperty("deliveryOutcome")
    private String deliveryOutcome;

    @Column(name = "parity")
    @JsonProperty("parity")
    private Float parity;

    @Column(name = "number_of_live_births")
    @JsonProperty("numberOfLiveBirths")
    private Float numberOfLiveBirths;

    @Column(name = "number_of_still_births")
    @JsonProperty("numberOfStillBirths")
    private Float numberOfStillBirths;

    @Column(name = "cause_of_still_birth")
    @JsonProperty("causeOfStillBirth")
    private String causeOfStillBirth;

    @Column(name = "other_cause_of_still_birth")
    @JsonProperty("otherCauseOfStillBirth")
    private String otherCauseOfStillBirth;

    @Column(name = "did_woman_survive")
    @JsonProperty("didWomanSurvive")
    private String didWomanSurvive;

    @Column(name = "did_mother_survive")
    @JsonProperty("didMotherSurvive")
    private String didMotherSurvive;

    @Column(name = "did_breastfeeding_start")
    @JsonProperty("didBreastfeedingStart")
    private String didBreastfeedingStart;

    @Column(name = "maternal_death_cause")
    @JsonProperty("maternalDeathCause")
    private String maternalDeathCause;

    @Column(name = "other_maternal_death_cause")
    @JsonProperty("otherMaternalDeathCause")
    private String otherMaternalDeathCause;

    @Column(name = "is_rh_negative")
    @JsonProperty("isRHNegative")
    private String isRHNegative;

    @Column(name = "is_rh_injection_given")
    @JsonProperty("isRHInjectionGiven")
    private String isRHInjectionGiven;

    @Column(name = "had_delivery_complications")
    @JsonProperty("hadDeliveryComplications")
    private String hadDeliveryComplications;

    @Column(name = "delivery_complications")
    @JsonProperty("deliveryComplications")
    private String deliveryComplications;

    @Column(name = "other_delivery_complications")
    @JsonProperty("otherDeliveryComplications")
    private String otherDeliveryComplications;

    @Column(name = "is_high_risk_till_pnc_close")
    @JsonProperty("isHighRiskTillPNCClose")
    private String isHighRiskTillPNCClose;

    @Column(name = "high_risk_till_pnc_close_reason")
    @JsonProperty("highRiskTillPNCCloseReason")
    private String highRiskTillPNCCloseReason;

    @Column(name = "anemic_status")
    @JsonProperty("anemicStatus")
    private String anemicStatus;

    @Column(name = "pih")
    @JsonProperty("pih")
    private String pih;

    @Column(name = "pre_eclampsia")
    @JsonProperty("preEclampsia")
    private String preEclampsia;

    @Column(name = "jaundice")
    @JsonProperty("jaundice")
    private String jaundice;

    @Column(name = "is_high_risk")
    @JsonProperty("isHighRisk")
    private String isHighRisk;

    @Column(name = "is_birth_planning_done")
    @JsonProperty("isBirthPlanningDone")
    private String isBirthPlanningDone;

    @Column(name = "high_risk_reason")
    @JsonProperty("highRiskReason")
    private String highRiskReason;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private Date submissionDate;

    @Column(name = "type")
    @JsonProperty("type")
    private String type;

    @Column(name = "number_of_living_children")
    @JsonProperty("numberOfLivingChildren")
    private Float numberOfLivingChildren;

    @Column(name = "number_of_children_born")
    @JsonProperty("numberOfChildrenBorn")
    private Float numberOfChildrenBorn;

    @Column(name = "number_of_female_children_born")
    @JsonProperty("numberOfFemaleChildrenBorn")
    private Float numberOfFemaleChildrenBorn;

    @Column(name = "number_of_male_children_born")
    @JsonProperty("numberOfMaleChildrenBorn")
    private Float numberOfMaleChildrenBorn;

    @Column(name = "number_of_living_female_child")
    @JsonProperty("numberOfLivingFemaleChild")
    private Float numberOfLivingFemaleChild;

    @Column(name = "number_of_living_male_child")
    @JsonProperty("numberOfLivingMaleChild")
    private Float numberOfLivingMaleChild;

    @Column(name = "youngest_child_dob")
    @JsonProperty("youngestChildDOB")
    private Date youngestChildDOB;

    @Column(name = "youngest_child_age")
    @JsonProperty("youngestChildAge")
    private Float youngestChildAge;

}
