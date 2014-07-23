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
@Table(name = "postpartum_family_planning")
@EqualsAndHashCode(callSuper = true)
public class PostpartumFamilyPlanning extends FormEntity {
    @Column(name = "mother_id")
    @JsonProperty("id")
    private String motherId;

    @Column(name = "ec_id")
    @JsonProperty("ecId")
    private String ecId;

    @Column(name = "is_fp_post_delivery")
    @JsonProperty("isFPPostDelivery")
    private String isFPPostDelivery;

    @Column(name = "pp_fp_method1")
    @JsonProperty("ppFPMethod1")
    private String ppFPMethod1;

    @Column(name = "pp_fp_method1_start_date")
    @JsonProperty("ppFPMethod1StartDate")
    private Date ppFPMethod1StartDate;

    @Column(name = "iud_place1")
    @JsonProperty("iudPlace1")
    private String iudPlace1;

    @Column(name = "iud_place1_name")
    @JsonProperty("iudPlace1Name")
    private String iudPlace1Name;

    @Column(name = "iud_person1")
    @JsonProperty("iudPerson1")
    private String iudPerson1;

    @Column(name = "iud_person1_other")
    @JsonProperty("iudPerson1Other")
    private String iudPerson1Other;

    @Column(name = "iud_person1_name")
    @JsonProperty("iudPerson1Name")
    private String iudPerson1Name;

    @Column(name = "sterilization_doctor_name1")
    @JsonProperty("sterilizationDoctorName1")
    private String sterilizationDoctorName1;

    @Column(name = "female_sterilization_type1")
    @JsonProperty("femaleSterilizationType1")
    private String femaleSterilizationType1;

    @Column(name = "reference_date")
    @JsonProperty("referenceDate")
    private Date referenceDate;

    @Column(name = "is_exclusive_breast_feeding")
    @JsonProperty("isExclusiveBreastFeeding")
    private String isExclusiveBreastFeeding;

    @Column(name = "is_partial_breast_feeding")
    @JsonProperty("isPartialBreastFeeding")
    private String isPartialBreastFeeding;

    @Column(name = "has_monthly_bleeding_returned")
    @JsonProperty("hasMonthlyBleedingReturned")
    private String hasMonthlyBleedingReturned;

    @Column(name = "is_lam_continued")
    @JsonProperty("isLAMContinued")
    private String isLAMContinued;

    @Column(name = "preference_future_children")
    @JsonProperty("preferenceFutureChildren")
    private String preferenceFutureChildren;

    @Column(name = "pp_fp_method2")
    @JsonProperty("ppFPMethod2")
    private String ppFPMethod2;

    @Column(name = "pp_fp_method2_start_date")
    @JsonProperty("ppFPMethod2StartDate")
    private Date ppFPMethod2StartDate;

    @Column(name = "iud_place2")
    @JsonProperty("iudPlace2")
    private String iudPlace2;

    @Column(name = "iud_place2_name")
    @JsonProperty("iudPlace2Name")
    private String iudPlace2Name;

    @Column(name = "iud_person2")
    @JsonProperty("iudPerson2")
    private String iudPerson2;

    @Column(name = "iud_person2_other")
    @JsonProperty("iudPerson2Other")
    private String iudPerson2Other;

    @Column(name = "iud_person2_name")
    @JsonProperty("iudPerson2Name")
    private String iudPerson2Name;

    @Column(name = "sterilization_doctor_name2")
    @JsonProperty("sterilizationDoctorName2")
    private String sterilizationDoctorName2;

    @Column(name = "female_sterilization_type2")
    @JsonProperty("femaleSterilizationType2")
    private String femaleSterilizationType2;

    @Column(name = "male_sterilization_type")
    @JsonProperty("maleSterilizationType")
    private String maleSterilizationType;

    @Column(name = "number_of_ocp_delivered")
    @JsonProperty("numberOfOCPDelivered")
    private Float numberOfOCPDelivered;

    @Column(name = "number_of_condoms_supplied")
    @JsonProperty("numberOfCondomsSupplied")
    private Float numberOfCondomsSupplied;

    @Column(name = "number_of_centchroman_pills_supplied")
    @JsonProperty("numberOfCentchromanPillsSupplied")
    private Float numberOfCentchromanPillsSupplied;

    @Column(name = "hep_b")
    @JsonProperty("hepB")
    private String hepB;

    @Column(name = "current_method")
    @JsonProperty("currentMethod")
    private String currentMethod;

    @Column(name = "family_planning_method_change_date")
    @JsonProperty("familyPlanningMethodChangeDate")
    private Date familyPlanningMethodChangeDate;

    @Column(name = "iud_place")
    @JsonProperty("iudPlace")
    private String iudPlace;

    @Column(name = "iud_place_name")
    @JsonProperty("iudPlaceName")
    private String iudPlaceName;

    @Column(name = "iud_person")
    @JsonProperty("iudPerson")
    private String iudPerson;

    @Column(name = "iud_person_other")
    @JsonProperty("iudPersonOther")
    private String iudPersonOther;

    @Column(name = "iud_person_name")
    @JsonProperty("iudPersonName")
    private String iudPersonName;

    @Column(name = "sterilization_doctor_name")
    @JsonProperty("sterilizationDoctorName")
    private String sterilizationDoctorName;

    @Column(name = "female_sterilization_type")
    @JsonProperty("femaleSterilizationType")
    private String femaleSterilizationType;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private Date submissionDate;

}
