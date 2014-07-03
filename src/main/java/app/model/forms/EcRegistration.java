package app.model.forms;

import app.model.FromEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "ec_registration")
@EqualsAndHashCode(callSuper = true)
public class EcRegistration extends FromEntity {
    @Column(name = "eligible_couple_id")
    @JsonProperty("id")
    private String eligibleCoupleId;

    @Column(name = "phc")
    @JsonProperty("phc")
    private String phc;

    @Column(name = "sub_center")
    @JsonProperty("subCenter")
    private String subCenter;

    @Column(name = "village")
    @JsonProperty("village")
    private String village;

    @Column(name = "household_number")
    @JsonProperty("householdNumber")
    private String householdNumber;

    @Column(name = "household_address")
    @JsonProperty("householdAddress")
    private String householdAddress;

    @Column(name = "head_of_household")
    @JsonProperty("headOfHousehold")
    private String headOfHousehold;

    @Column(name = "ec_number")
    @JsonProperty("ecNumber")
    private String ecNumber;

    @Column(name = "wife_name")
    @JsonProperty("wifeName")
    private String wifeName;

    @Column(name = "aadhar_number")
    @JsonProperty("aadharNumber")
    private String aadharNumber;

    @Column(name = "wife_age")
    @JsonProperty("wifeAge")
    private Integer wifeAge;

    @Column(name = "husband_age")
    @JsonProperty("husbandAge")
    private Integer husbandAge;

    @Column(name = "woman_dob")
    @JsonProperty("womanDOB")
    private Date womanDOB;

    @Column(name = "husband_dob")
    @JsonProperty("husbandDOB")
    private Date husbandDOB;

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

    @Column(name = "religion")
    @JsonProperty("religion")
    private String religion;

    @Column(name = "caste")
    @JsonProperty("caste")
    private String caste;

    @Column(name = "educational_level")
    @JsonProperty("educationalLevel")
    private String educationalLevel;

    @Column(name = "number_of_pregnancies")
    @JsonProperty("numberOfPregnancies")
    private Integer numberOfPregnancies;

    @Column(name = "number_of_live_births")
    @JsonProperty("numberOfLiveBirths")
    private Integer numberOfLiveBirths;

    @Column(name = "number_of_abortions")
    @JsonProperty("numberOfAbortions")
    private Integer numberOfAbortions;

    @Column(name = "number_of_spontaneous_abortions")
    @JsonProperty("numberOfSpontaneousAbortions")
    private Integer numberOfSpontaneousAbortions;

    @Column(name = "number_of_induced_abortions")
    @JsonProperty("numberOfInducedAbortions")
    private Integer numberOfInducedAbortions;

    @Column(name = "number_of_still_births")
    @JsonProperty("numberOfStillBirths")
    private Integer numberOfStillBirths;

    @Column(name = "number_of_living_children")
    @JsonProperty("numberOfLivingChildren")
    private Integer numberOfLivingChildren;

    @Column(name = "number_of_living_male_children")
    @JsonProperty("numberOfLivingMaleChildren")
    private Integer numberOfLivingMaleChildren;

    @Column(name = "number_of_living_female_child")
    @JsonProperty("numberOfLivingFemaleChild")
    private Integer numberOfLivingFemaleChild;

    @Column(name = "is_youngest_child_under_two")
    @JsonProperty("isYoungestChildUnderTwo")
    private String isYoungestChildUnderTwo;

    @Column(name = "youngest_child_age")
    @JsonProperty("youngestChildAge")
    private Integer youngestChildAge;

    @Column(name = "youngest_child_dob")
    @JsonProperty("youngestChildDOB")
    private Date youngestChildDOB;

    @Column(name = "current_method")
    @JsonProperty("currentMethod")
    private String currentMethod;

    @Column(name = "iud_place")
    @JsonProperty("iudPlace")
    private String iudPlace;

    @Column(name = "iud_person")
    @JsonProperty("iudPerson")
    private String iudPerson;

    @Column(name = "family_planning_method_change_date")
    @JsonProperty("familyPlanningMethodChangeDate")
    private Date familyPlanningMethodChangeDate;

    @Column(name = "three_months_from_sterilization_date")
    @JsonProperty("threeMonthsFromSterilizationDate")
    private Date threeMonthsFromSterilizationDate;

    @Column(name = "number_of_condoms_supplied")
    @JsonProperty("numberOfCondomsSupplied")
    private Integer numberOfCondomsSupplied;

    @Column(name = "number_of_ocp_delivered")
    @JsonProperty("numberOfOCPDelivered")
    private Integer numberOfOCPDelivered;

    @Column(name = "number_of_centchroman_pills_delivered")
    @JsonProperty("numberOfCentchromanPillsDelivered")
    private Integer numberOfCentchromanPillsDelivered;

    @Column(name = "is_high_priority")
    @JsonProperty("isHighPriority")
    private String isHighPriority;

    @Column(name = "high_priority_reason")
    @JsonProperty("highPriorityReason")
    private String highPriorityReason;

    @Column(name = "is_out_of_area")
    @JsonProperty("isOutOfArea")
    private String isOutOfArea;

    @Column(name = "is_closed")
    @JsonProperty("isClosed")
    private String isClosed;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private Date submissionDate;

    @Column(name = "registration_date")
    @JsonProperty("registrationDate")
    private Date registrationDate;

    @Column(name = "parity")
    @JsonProperty("parity")
    private Integer parity;

    @Column(name = "dmpa_injection_date")
    @JsonProperty("dmpaInjectionDate")
    private Date dmpaInjectionDate;

    @Column(name = "ocp_refill_date")
    @JsonProperty("ocpRefillDate")
    private Date ocpRefillDate;

    @Column(name = "husband_education_level")
    @JsonProperty("husbandEducationLevel")
    private String husbandEducationLevel;

    @Column(name = "lmp_date")
    @JsonProperty("lmpDate")
    private Date lmpDate;

    @Column(name = "upt_result")
    @JsonProperty("uptResult")
    private String uptResult;

    @Column(name = "sterilization_doctor_name")
    @JsonProperty("sterilizationDoctorName")
    private String sterilizationDoctorName;

    @Column(name = "male_sterilization_type")
    @JsonProperty("maleSterilizationType")
    private String maleSterilizationType;

    @Column(name = "female_sterilization_type")
    @JsonProperty("femaleSterilizationType")
    private String femaleSterilizationType;

}
