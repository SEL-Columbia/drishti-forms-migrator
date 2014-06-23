package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tt")
public class Tt extends EntityForm {
    @Id
    @Column(name = "tt_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ttId;

    @Column(name = "id")
    @JsonProperty("id")
    private String id;

    @Column(name = "tt_dose")
    @JsonProperty("ttDose")
    private String ttDose;

    @Column(name = "tt_injection_place")
    @JsonProperty("ttInjectionPlace")
    private String ttInjectionPlace;

    @Column(name = "tt_date")
    @JsonProperty("ttDate")
    private String ttDate;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private String submissionDate;

}
