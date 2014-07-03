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
@Table(name = "fp_complications")
@EqualsAndHashCode(callSuper = true)
public class FpComplications extends FromEntity {
    @Column(name = "eligible_couple_id")
    @JsonProperty("id")
    private String eligibleCoupleId;

    @Column(name = "current_method")
    @JsonProperty("currentMethod")
    private String currentMethod;

    @Column(name = "current_method_note")
    @JsonProperty("currentMethodNote")
    private String currentMethodNote;

    @Column(name = "complication_date")
    @JsonProperty("complicationDate")
    private Date complicationDate;

    @Column(name = "is_sterilization_failure")
    @JsonProperty("isSterilizationFailure")
    private String isSterilizationFailure;

    @Column(name = "condom_side_effect")
    @JsonProperty("condomSideEffect")
    private String condomSideEffect;

    @Column(name = "iud_sid_effect")
    @JsonProperty("iudSidEffect")
    private String iudSidEffect;

    @Column(name = "ocp_side_effect")
    @JsonProperty("ocpSideEffect")
    private String ocpSideEffect;

    @Column(name = "sterilization_side_effect")
    @JsonProperty("sterilizationSideEffect")
    private String sterilizationSideEffect;

    @Column(name = "injectable_side_effect")
    @JsonProperty("injectableSideEffect")
    private String injectableSideEffect;

    @Column(name = "other_side_effect")
    @JsonProperty("otherSideEffect")
    private String otherSideEffect;

    @Column(name = "refer_couple_fp_method_complication")
    @JsonProperty("referCoupleFPMethodComplication")
    private String referCoupleFPMethodComplication;

    @Column(name = "refer_couple_fp_method_complication_place")
    @JsonProperty("referCoupleFPMethodComplicationPlace")
    private String referCoupleFPMethodComplicationPlace;

    @Column(name = "refer_couple_fp_method_complication_place_other")
    @JsonProperty("referCoupleFPMethodComplicationPlaceOther")
    private String referCoupleFPMethodComplicationPlaceOther;

    @Column(name = "fp_method_complication_treatment_plan")
    @JsonProperty("fpMethodComplicationTreatmentPlan")
    private String fpMethodComplicationTreatmentPlan;

    @Column(name = "fp_method_complication_treatment_plan_other")
    @JsonProperty("fpMethodComplicationTreatmentPlanOther")
    private String fpMethodComplicationTreatmentPlanOther;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private Date submissionDate;

    @Column(name = "needs_referral_followup")
    @JsonProperty("needsReferralFollowup")
    private String needsReferralFollowup;

    @Column(name = "needs_followup")
    @JsonProperty("needsFollowup")
    private String needsFollowup;

}
