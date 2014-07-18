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
@Table(name = "anc_investigations")
@EqualsAndHashCode(callSuper = true)
public class AncInvestigations extends FormEntity {
    @Column(name = "mother_id")
    @JsonProperty("id")
    private String motherId;

    @Column(name = "test_date")
    @JsonProperty("testDate")
    private Date testDate;

    @Column(name = "test_results_to_enter")
    @JsonProperty("testResultsToEnter")
    private String testResultsToEnter;

    @Column(name = "woman_blood_group")
    @JsonProperty("womanBloodGroup")
    private String womanBloodGroup;

    @Column(name = "rh_incompatible_couple")
    @JsonProperty("rhIncompatibleCouple")
    private String rhIncompatibleCouple;

    @Column(name = "tests_result_positive")
    @JsonProperty("testsResultPositive")
    private String testsResultPositive;

    @Column(name = "bile_salts")
    @JsonProperty("bileSalts")
    private String bileSalts;

    @Column(name = "bile_pigments")
    @JsonProperty("bilePigments")
    private String bilePigments;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private Date submissionDate;

}
