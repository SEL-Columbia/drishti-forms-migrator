package app.model.subForms;

import app.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "pnc_registration_oa_child")
public class PncChildRegistration extends BaseEntity {

    @Column(name = "gender")
    @JsonProperty("gender")
    private String gender;

    @Column(name = "child_id")
    @JsonProperty("id")
    private String childId;

    @Column(name = "weight")
    @JsonProperty("weight")
    private Float weight;

    @Column(name = "blood_group")
    @JsonProperty("bloodGroup")
    private String bloodGroup;

    @Column(name = "immunizations_given")
    @JsonProperty("immunizationsGiven")
    private String immunizationsGiven;

    @Column(name = "is_child_high_risk1")
    @JsonProperty("isChildHighRisk1")
    private String isChildHighRisk1;

    @Column(name = "child_high_risk_reasons")
    @JsonProperty("childHighRiskReasons")
    private String childHighRiskReasons;

    @Column(name = "is_child_high_risk")
    @JsonProperty("isChildHighRisk")
    private String isChildHighRisk;

    @Column(name = "pnc_registration_oa_id")
    @JsonProperty("parentId")
    private long pncRegistrationOaId;

    @Column(name = "sub_form_name")
    @JsonProperty("name")
    private String subFormName;
}
