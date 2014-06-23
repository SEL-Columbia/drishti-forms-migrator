package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ec_edit")
public class EcEdit extends EntityForm {
    @Id
    @Column(name = "ec_edit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ecEditId;

    @Column(name = "id")
    @JsonProperty("id")
    private String id;

    @Column(name = "district")
    @JsonProperty("district")
    private String district;

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

    @Column(name = "wife_name")
    @JsonProperty("wifeName")
    private String wifeName;

    @Column(name = "aadhar_number")
    @JsonProperty("aadharNumber")
    private String aadharNumber;

    @Column(name = "wife_age")
    @JsonProperty("wifeAge")
    private String wifeAge;

    @Column(name = "husband_age")
    @JsonProperty("husbandAge")
    private String husbandAge;

    @Column(name = "woman_dob")
    @JsonProperty("womanDOB")
    private String womanDOB;

    @Column(name = "husband_dob")
    @JsonProperty("husbandDOB")
    private String husbandDOB;

    @Column(name = "husband_name")
    @JsonProperty("husbandName")
    private String husbandName;

    @Column(name = "phone_number")
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @Column(name = "religion")
    @JsonProperty("religion")
    private String religion;

    @Column(name = "educational_level")
    @JsonProperty("educationalLevel")
    private String educationalLevel;

    @Column(name = "husband_educational_level")
    @JsonProperty("husbandEducationalLevel")
    private String husbandEducationalLevel;

    @Column(name = "number_of_pregnancies")
    @JsonProperty("numberOfPregnancies")
    private String numberOfPregnancies;

    @Column(name = "number_of_live_births")
    @JsonProperty("numberOfLiveBirths")
    private String numberOfLiveBirths;

    @Column(name = "number_of_abortions")
    @JsonProperty("numberOfAbortions")
    private String numberOfAbortions;

    @Column(name = "number_of_spontaneous_abortions")
    @JsonProperty("numberOfSpontaneousAbortions")
    private String numberOfSpontaneousAbortions;

    @Column(name = "number_of_induced_abortions")
    @JsonProperty("numberOfInducedAbortions")
    private String numberOfInducedAbortions;

    @Column(name = "number_of_still_births")
    @JsonProperty("numberOfStillBirths")
    private String numberOfStillBirths;

    @Column(name = "number_of_living_children")
    @JsonProperty("numberOfLivingChildren")
    private String numberOfLivingChildren;

    @Column(name = "number_of_living_male_children")
    @JsonProperty("numberOfLivingMaleChildren")
    private String numberOfLivingMaleChildren;

    @Column(name = "number_of_living_female_child")
    @JsonProperty("numberOfLivingFemaleChild")
    private String numberOfLivingFemaleChild;

    @Column(name = "current_method")
    @JsonProperty("currentMethod")
    private String currentMethod;

    @Column(name = "abortion_risk")
    @JsonProperty("abortionRisk")
    private String abortionRisk;

    @Column(name = "parity_risk_priority")
    @JsonProperty("parityRiskPriority")
    private String parityRiskPriority;

    @Column(name = "age_risk_priority")
    @JsonProperty("ageRiskPriority")
    private String ageRiskPriority;

    @Column(name = "partity")
    @JsonProperty("partity")
    private String partity;

    @Column(name = "young_child_risk_priority")
    @JsonProperty("youngChildRiskPriority")
    private String youngChildRiskPriority;

    @Column(name = "is_high_priority")
    @JsonProperty("isHighPriority")
    private String isHighPriority;

    @Column(name = "high_priority_reason")
    @JsonProperty("highPriorityReason")
    private String highPriorityReason;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private String submissionDate;

}
