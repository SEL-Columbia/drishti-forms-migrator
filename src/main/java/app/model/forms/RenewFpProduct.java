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
@Table(name = "renew_fp_product")
@EqualsAndHashCode(callSuper = true)
public class RenewFpProduct extends FormEntity {
    @Column(name = "eligible_couple_id")
    @JsonProperty("id")
    private String eligibleCoupleId;

    @Column(name = "current_method")
    @JsonProperty("currentMethod")
    private String currentMethod;

    @Column(name = "fp_renew_method_visit_date")
    @JsonProperty("fpRenewMethodVisitDate")
    private Date fpRenewMethodVisitDate;

    @Column(name = "was_fp_method_renewed")
    @JsonProperty("wasFPMethodRenewed")
    private String wasFPMethodRenewed;

    @Column(name = "dmpa_injection_date")
    @JsonProperty("dmpaInjectionDate")
    private Date dmpaInjectionDate;

    @Column(name = "number_of_condoms_supplied")
    @JsonProperty("numberOfCondomsSupplied")
    private Integer numberOfCondomsSupplied;

    @Column(name = "number_of_ocp_delivered")
    @JsonProperty("numberOfOCPDelivered")
    private Integer numberOfOCPDelivered;

    @Column(name = "number_of_centchroman_pills_supplied")
    @JsonProperty("numberOfCentchromanPillsSupplied")
    private Integer numberOfCentchromanPillsSupplied;

    @Column(name = "ocp_refill_date")
    @JsonProperty("ocpRefillDate")
    private Date ocpRefillDate;

    @Column(name = "reason_for_not_renewal_of_fp_product")
    @JsonProperty("reasonForNotRenewalOfFPProduct")
    private String reasonForNotRenewalOfFPProduct;

    @Column(name = "reason_for_couple_to_refuse_renewal_of_fp_product")
    @JsonProperty("reasonForCoupleToRefuseRenewalOfFPProduct")
    private String reasonForCoupleToRefuseRenewalOfFPProduct;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private Date submissionDate;

}
