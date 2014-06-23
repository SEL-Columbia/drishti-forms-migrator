package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "vitamin_a")
public class VitaminA extends EntityForm {
    @Id
    @Column(name = "vitamin_a_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long vitaminAId;

    @Column(name = "id")
    @JsonProperty("id")
    private String id;

    @Column(name = "date_of_birth")
    @JsonProperty("dateOfBirth")
    private String dateOfBirth;

    @Column(name = "vitamin_a_dose")
    @JsonProperty("vitaminADose")
    private String vitaminADose;

    @Column(name = "vitamin_a_date")
    @JsonProperty("vitaminADate")
    private String vitaminADate;

    @Column(name = "vitamin_a_place")
    @JsonProperty("vitaminAPlace")
    private String vitaminAPlace;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private String submissionDate;

}
