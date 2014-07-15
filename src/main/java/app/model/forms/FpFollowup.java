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
@Table(name = "fp_followup")
@EqualsAndHashCode(callSuper = true)
public class FpFollowup extends FormEntity {
    @Column(name = "eligible_couple_id")
    @JsonProperty("id")
    private String eligibleCoupleId;

    @Column(name = "needs_followup")
    @JsonProperty("needsFollowup")
    private String needsFollowup;

    @Column(name = "current_method")
    @JsonProperty("currentMethod")
    private String currentMethod;

    @Column(name = "current_method_note")
    @JsonProperty("currentMethodNote")
    private String currentMethodNote;

    @Column(name = "fp_followup_date")
    @JsonProperty("fpFollowupDate")
    private Date fpFollowupDate;

    @Column(name = "is_sterilization_failure")
    @JsonProperty("isSterilizationFailure")
    private String isSterilizationFailure;

    @Column(name = "iud_sid_effect")
    @JsonProperty("iudSidEffect")
    private String iudSidEffect;

    @Column(name = "other_side_effect")
    @JsonProperty("otherSideEffect")
    private String otherSideEffect;

    @Column(name = "sterilization_side_effect")
    @JsonProperty("sterilizationSideEffect")
    private String sterilizationSideEffect;

    @Column(name = "side_effect")
    @JsonProperty("sideEffect")
    private String sideEffect;

    @Column(name = "is_fp_method_complication_resolved")
    @JsonProperty("isFPMethodComplicationResolved")
    private String isFPMethodComplicationResolved;

    @Column(name = "refer_couple_fp_method_complication")
    @JsonProperty("referCoupleFPMethodComplication")
    private String referCoupleFPMethodComplication;

    @Column(name = "refer_couple_fp_method_complication_place")
    @JsonProperty("referCoupleFPMethodComplicationPlace")
    private String referCoupleFPMethodComplicationPlace;

    @Column(name = "refer_couple_fp_method_complication_place_other")
    @JsonProperty("referCoupleFPMethodComplicationPlaceOther")
    private String referCoupleFPMethodComplicationPlaceOther;

    @Column(name = "needs_referral_followup")
    @JsonProperty("needsReferralFollowup")
    private String needsReferralFollowup;

    @Column(name = "fp_method_complication_treatment_plan")
    @JsonProperty("fpMethodComplicationTreatmentPlan")
    private String fpMethodComplicationTreatmentPlan;

    @Column(name = "fp_method_complication_treatment_plan_other")
    @JsonProperty("fpMethodComplicationTreatmentPlanOther")
    private String fpMethodComplicationTreatmentPlanOther;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private Date submissionDate;

}
