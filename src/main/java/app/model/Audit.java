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
@Table(name = "migration_audit")
@EqualsAndHashCode(callSuper = true)
public class Audit extends BaseEntity {
    @Column(name = "last_polled_timestamp")
    private Long lastPolledTimestamp;

    @Column(name = "total_no_of_form_entries")
    private Long totalFormEntries;

    @Column(name = "successfully_processed_form_entries")
    private Long successfullyProcessedFormEntries;

    @Transient
    private DateTime createdDate;

    public Audit(long lastPolledTimestamp, long totalFormEntries, long successfullyProcessedFormEntries) {
        this.lastPolledTimestamp = lastPolledTimestamp;
        this.totalFormEntries = totalFormEntries;
        this.successfullyProcessedFormEntries = successfullyProcessedFormEntries;
    }

    public static Audit DEFAULT = new Audit(0L, 0L, 0L);
}
