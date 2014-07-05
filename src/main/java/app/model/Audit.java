package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "migration_audit")
@EqualsAndHashCode(callSuper = true)
public class Audit extends BaseEntity {
    @Column(name = "last_polled_timestamp")
    private Long lastPolledTimestamp;

    @Column(name = "no_of_form_entries")
    private Long noOfFormEntries;

    public static Audit DEFAULT = new Audit(0L, 0L);
}
