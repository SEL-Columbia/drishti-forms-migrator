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
@Table(name = "fp_referral_followup")
@EqualsAndHashCode(callSuper = true)
public class FpReferralFollowup extends FormEntity {
    @Column(name = "eligible_couple_id")
    @JsonProperty("id")
    private String eligibleCoupleId;

    @Column(name = "referral_followup_date")
    @JsonProperty("referralFollowupDate")
    private Date referralFollowupDate;

    @Column(name = "couple_went_for_referral")
    @JsonProperty("coupleWentForReferral")
    private String coupleWentForReferral;

    @Column(name = "referral_result")
    @JsonProperty("referralResult")
    private String referralResult;

    @Column(name = "reason_for_couple_not_going_for_referral")
    @JsonProperty("reasonForCoupleNotGoingForReferral")
    private String reasonForCoupleNotGoingForReferral;

    @Column(name = "new_treatment_plan")
    @JsonProperty("newTreatmentPlan")
    private String newTreatmentPlan;

    @Column(name = "referral_place")
    @JsonProperty("referralPlace")
    private String referralPlace;

    @Column(name = "needs_referral_followup")
    @JsonProperty("needsReferralFollowup")
    private String needsReferralFollowup;

    @Column(name = "needs_followup")
    @JsonProperty("needsFollowup")
    private String needsFollowup;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private Date submissionDate;
}
