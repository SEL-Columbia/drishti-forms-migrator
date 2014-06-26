package app.model.subForms;

import app.model.BaseEntityForm;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "delivery_out_come_child_registration")
public class ChildRegistration extends BaseEntityForm {

    @Column(name = "child_id")
    @JsonProperty("id")
    private String childId;

    @Column(name = "sub_form_name")
    @JsonProperty("name")
    private String subFormName;

    @Column(name = "gender")
    @JsonProperty("gender")
    private String gender;

    @Column(name = "weight")
    @JsonProperty("weight")
    private String weight;

    @Column(name = "blood_group")
    @JsonProperty("bloodGroup")
    private String bloodGroup;

    @Column(name = "immunizations_given")
    @JsonProperty("immunizationsGiven")
    private String immunizationsGiven;

    @Column(name = "hep_b")
    @JsonProperty("hepB")
    private String hepB;

    @Column(name = "is_hep_b_prophylaxis_provided")
    @JsonProperty("isHepBProphylaxisProvided")
    private String isHepBProphylaxisProvided;

    @Column(name = "is_child_high_risk1")
    @JsonProperty("isChildHighRisk1")
    private String isChildHighRisk1;

    @Column(name = "child_high_risk_reasons")
    @JsonProperty("childHighRiskReasons")
    private String childHighRiskReasons;

    @Column(name = "is_child_high_risk")
    @JsonProperty("isChildHighRisk")
    private String isChildHighRisk;

    @Column(name = "lbw")
    @JsonProperty("lbw")
    private String lbw;

    @Column(name = "vlbw")
    @JsonProperty("vlbw")
    private String vlbw;

    @Column(name = "premature")
    @JsonProperty("premature")
    private String premature;

    @Column(name = "delivery_outcome_id")
    @JsonProperty("parentId")
    private long deliveryOutcomeId;
}
