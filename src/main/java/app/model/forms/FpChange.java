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
@Table(name = "fp_change")
@EqualsAndHashCode(callSuper = true)
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
    private Date iudRemovalDate;

    @Column(name = "iud_removal_place")
    @JsonProperty("iudRemovalPlace")
    private String iudRemovalPlace;

    @Column(name = "family_planning_method_change_date")
    @JsonProperty("familyPlanningMethodChangeDate")
    private Date familyPlanningMethodChangeDate;

    @Column(name = "iud_place")
    @JsonProperty("iudPlace")
    private String iudPlace;

    @Column(name = "iud_person")
    @JsonProperty("iudPerson")
    private String iudPerson;

    @Column(name = "three_months_from_sterilization_date")
    @JsonProperty("threeMonthsFromSterilizationDate")
    private Date threeMonthsFromSterilizationDate;

    @Column(name = "male_sterilization_message")
    @JsonProperty("maleSterilizationMessage")
    private String maleSterilizationMessage;

    @Column(name = "number_of_condoms_supplied")
    @JsonProperty("numberOfCondomsSupplied")
    private Integer numberOfCondomsSupplied;

    @Column(name = "number_of_ocp_delivered")
    @JsonProperty("numberOfOCPDelivered")
    private Integer numberOfOCPDelivered;

    @Column(name = "number_of_centchroman_pills_delivered")
    @JsonProperty("numberOfCentchromanPillsDelivered")
    private Integer numberOfCentchromanPillsDelivered;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private Date submissionDate;

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
