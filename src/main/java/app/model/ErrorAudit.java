package app.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Data
@NoArgsConstructor
@Table(name = "error_audit")
@EqualsAndHashCode(callSuper = true)
public class ErrorAudit extends BaseEntity {
    @Column(name = "instance_id")
    private String instanceId;

    @Column(name = "failure_reason")
    private String failureReason;

    @Column(name = "detailed_reason")
    private String detailedReason;

    @Transient
    private DateTime createdDate;

    public ErrorAudit(String instanceId, String failureReason, String detailedReason) {
        this.instanceId = instanceId;
        this.failureReason = failureReason;
        this.detailedReason = detailedReason;
    }
}
