package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "child_immunizations")
public class ChildImmunizations extends EntityForm {
    @Id
    @Column(name = "child_immunizations_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long childImmunizationsId;

    @Column(name = "id")
    @JsonProperty("id")
    private String id;

    @Column(name = "previous_immunizations")
    @JsonProperty("previousImmunizations")
    private String previousImmunizations;

    @Column(name = "immunizations_received")
    @JsonProperty("immunizationsReceived")
    private String immunizationsReceived;

    @Column(name = "immunizations_given")
    @JsonProperty("immunizationsGiven")
    private String immunizationsGiven;

    @Column(name = "immunization_date")
    @JsonProperty("immunizationDate")
    private String immunizationDate;

    @Column(name = "immunization_place")
    @JsonProperty("immunizationPlace")
    private String immunizationPlace;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private String submissionDate;

    @Column(name = "date_of_birth")
    @JsonProperty("dateOfBirth")
    private String dateOfBirth;

}
