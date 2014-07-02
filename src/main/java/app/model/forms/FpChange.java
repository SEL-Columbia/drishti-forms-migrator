package app.model.forms;

import app.model.FromEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "fp_change")
public class FpChange extends FromEntity {

    @Column(name = "eligible_couple_id")
    @JsonProperty("id")
    private String eligibleCoupleId;

    @Column(name = "current_method")
    @JsonProperty("currentMethod")
    private String currentMethod;

    @Column(name = "new_method")
    @JsonProperty("newMethod")
    private String newMethod;

    @Column(name = "iud_removal_date")
    @JsonProperty("iudRemovalDate")
    private String iudRemovalDate;

    @Column(name = "iud_removal_place")
    @JsonProperty("iudRemovalPlace")
    private String iudRemovalPlace;

    @Column(name = "family_planning_method_change_date")
    @JsonProperty("familyPlanningMethodChangeDate")
    private String familyPlanningMethodChangeDate;

    @Column(name = "iud_place")
    @JsonProperty("iudPlace")
    private String iudPlace;

    @Column(name = "iud_person")
    @JsonProperty("iudPerson")
    private String iudPerson;

    @Column(name = "three_months_from_sterilization_date")
    @JsonProperty("threeMonthsFromSterilizationDate")
    private String threeMonthsFromSterilizationDate;

    @Column(name = "male_sterilization_message")
    @JsonProperty("maleSterilizationMessage")
    private String maleSterilizationMessage;

    @Column(name = "number_of_condoms_supplied")
    @JsonProperty("numberOfCondomsSupplied")
    private String numberOfCondomsSupplied;

    @Column(name = "number_of_ocp_delivered")
    @JsonProperty("numberOfOCPDelivered")
    private String numberOfOCPDelivered;

    @Column(name = "number_of_centchroman_pills_delivered")
    @JsonProperty("numberOfCentchromanPillsDelivered")
    private String numberOfCentchromanPillsDelivered;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private String submissionDate;

    @Column(name = "lmp_date")
    @JsonProperty("lmpDate")
    private String lmpDate;

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
