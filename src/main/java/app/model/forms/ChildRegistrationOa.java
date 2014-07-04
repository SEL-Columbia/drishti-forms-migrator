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
@Table(name = "child_registration_oa")
@EqualsAndHashCode(callSuper = true)
public class ChildRegistrationOa extends FromEntity {
    @Column(name = "child_id")
    @JsonProperty("id")
    private String childId;

    @Column(name = "registration_date")
    @JsonProperty("registrationDate")
    private Date registrationDate;

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

    @Column(name = "mother_name")
    @JsonProperty("motherName")
    private String motherName;

    @Column(name = "father_name")
    @JsonProperty("fatherName")
    private String fatherName;

    @Column(name = "thayi_card_number")
    @JsonProperty("thayiCardNumber")
    private String thayiCardNumber;

    @Column(name = "economic_status")
    @JsonProperty("economicStatus")
    private String economicStatus;

    @Column(name = "caste")
    @JsonProperty("caste")
    private String caste;

    @Column(name = "phone_number")
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "date_of_birth")
    @JsonProperty("dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "gender")
    @JsonProperty("gender")
    private String gender;

    @Column(name = "blood_group")
    @JsonProperty("bloodGroup")
    private String bloodGroup;

    @Column(name = "birth_weight")
    @JsonProperty("birthWeight")
    private Float birthWeight;

    @Column(name = "weight")
    @JsonProperty("weight")
    private Float weight;

    @Column(name = "height")
    @JsonProperty("height")
    private Integer height;

    @Column(name = "immunizations_given")
    @JsonProperty("immunizationsGiven")
    private String immunizationsGiven;

    @Column(name = "bcg_date")
    @JsonProperty("bcgDate")
    private Date bcgDate;

    @Column(name = "opv0_date")
    @JsonProperty("opv0Date")
    private Date opv0Date;

    @Column(name = "hepb0_date")
    @JsonProperty("hepb0Date")
    private Date hepb0Date;

    @Column(name = "opv1_date")
    @JsonProperty("opv1Date")
    private Date opv1Date;

    @Column(name = "dpt1_date")
    @JsonProperty("dpt1Date")
    private Date dpt1Date;

    @Column(name = "hepb1_date")
    @JsonProperty("hepb1Date")
    private Date hepb1Date;

    @Column(name = "pentavalent1_date")
    @JsonProperty("pentavalent1Date")
    private Date pentavalent1Date;

    @Column(name = "opv2_date")
    @JsonProperty("opv2Date")
    private Date opv2Date;

    @Column(name = "dpt2_date")
    @JsonProperty("dpt2Date")
    private Date dpt2Date;

    @Column(name = "hepb2_date")
    @JsonProperty("hepb2Date")
    private Date hepb2Date;

    @Column(name = "pentavalent2_date")
    @JsonProperty("pentavalent2Date")
    private Date pentavalent2Date;

    @Column(name = "opv3_date")
    @JsonProperty("opv3Date")
    private Date opv3Date;

    @Column(name = "dpt3_date")
    @JsonProperty("dpt3Date")
    private Date dpt3Date;

    @Column(name = "hepb3_date")
    @JsonProperty("hepb3Date")
    private Date hepb3Date;

    @Column(name = "pentavalent3_date")
    @JsonProperty("pentavalent3Date")
    private Date pentavalent3Date;

    @Column(name = "measles_date")
    @JsonProperty("measlesDate")
    private Date measlesDate;

    @Column(name = "mmr_date")
    @JsonProperty("mmrDate")
    private Date mmrDate;

    @Column(name = "dpt_booster1_date")
    @JsonProperty("dptBooster1Date")
    private String dptBooster1Date;

    @Column(name = "opv_booster_date")
    @JsonProperty("opvBoosterDate")
    private Date opvBoosterDate;

    @Column(name = "je_date")
    @JsonProperty("jeDate")
    private Date jeDate;

    @Column(name = "je2_date")
    @JsonProperty("je2Date")
    private Date je2Date;

    @Column(name = "measles_booster_date")
    @JsonProperty("measlesBoosterDate")
    private Date measlesBoosterDate;

    @Column(name = "dpt_booster2_date")
    @JsonProperty("dptBooster2Date")
    private Date dptBooster2Date;

    @Column(name = "child_vitamin_a_history")
    @JsonProperty("childVitaminAHistory")
    private String childVitaminAHistory;

    @Column(name = "vitamin1_date")
    @JsonProperty("vitamin1Date")
    private Date vitamin1Date;

    @Column(name = "vitamin2_date")
    @JsonProperty("vitamin2Date")
    private Date vitamin2Date;

    @Column(name = "vitamin3_date")
    @JsonProperty("vitamin3Date")
    private Date vitamin3Date;

    @Column(name = "vitamin4_date")
    @JsonProperty("vitamin4Date")
    private Date vitamin4Date;

    @Column(name = "vitamin5_date")
    @JsonProperty("vitamin5Date")
    private Date vitamin5Date;

    @Column(name = "vitamin6_date")
    @JsonProperty("vitamin6Date")
    private Date vitamin6Date;

    @Column(name = "vitamin7_date")
    @JsonProperty("vitamin7Date")
    private Date vitamin7Date;

    @Column(name = "vitamin8_date")
    @JsonProperty("vitamin8Date")
    private Date vitamin8Date;

    @Column(name = "vitamin9_date")
    @JsonProperty("vitamin9Date")
    private Date vitamin9Date;

    @Column(name = "is_child_high_risk")
    @JsonProperty("isChildHighRisk")
    private String isChildHighRisk;

    @Column(name = "child_high_risk_reason")
    @JsonProperty("childHighRiskReason")
    private String childHighRiskReason;

    @Column(name = "stay_in_area")
    @JsonProperty("stayInArea")
    private String stayInArea;

    @Column(name = "ec_id")
    @JsonProperty("ecId")
    private String ecId;

    @Column(name = "mother_id")
    @JsonProperty("motherId")
    private String motherId;

    @Column(name = "is_mother_closed")
    @JsonProperty("isMotherClosed")
    private String isMotherClosed;

    @Column(name = "is_closed")
    @JsonProperty("isClosed")
    private String isClosed;

    @Column(name = "is_out_of_area")
    @JsonProperty("isOutOfArea")
    private String isOutOfArea;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private Date submissionDate;

}
