package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "hb_test")
public class HbTest extends EntityForm {
    @Id
    @Column(name = "hb_test_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hbTestId;

    @Column(name = "id")
    @JsonProperty("id")
    private String id;

    @Column(name = "hb_test_date")
    @JsonProperty("hbTestDate")
    private String hbTestDate;

    @Column(name = "hb_test_place")
    @JsonProperty("hbTestPlace")
    private String hbTestPlace;

    @Column(name = "hb_level")
    @JsonProperty("hbLevel")
    private String hbLevel;

    @Column(name = "anaemic_status")
    @JsonProperty("anaemicStatus")
    private String anaemicStatus;

    @Column(name = "high_risk_reason")
    @JsonProperty("highRiskReason")
    private String highRiskReason;

    @Column(name = "is_high_risk_till_delivery")
    @JsonProperty("isHighRiskTillDelivery")
    private String isHighRiskTillDelivery;

    @Column(name = "is_high_risk_till_delivery_reason")
    @JsonProperty("isHighRiskTillDeliveryReason")
    private String isHighRiskTillDeliveryReason;

    @Column(name = "is_high_risk_till_pnc_close")
    @JsonProperty("isHighRiskTillPNCClose")
    private String isHighRiskTillPNCClose;

    @Column(name = "is_high_risk_till_pnc_close_reason")
    @JsonProperty("isHighRiskTillPNCCloseReason")
    private String isHighRiskTillPNCCloseReason;

    @Column(name = "is_high_risk")
    @JsonProperty("isHighRisk")
    private String isHighRisk;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private String submissionDate;

}
