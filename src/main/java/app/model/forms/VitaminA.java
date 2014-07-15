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
@Table(name = "vitamin_a")
@EqualsAndHashCode(callSuper = true)
public class VitaminA extends FormEntity {
    @Column(name = "child_id")
    @JsonProperty("id")
    private String childId;

    @Column(name = "date_of_birth")
    @JsonProperty("dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "vitamin_a_dose")
    @JsonProperty("vitaminADose")
    private Integer vitaminADose;

    @Column(name = "vitamin_a_date")
    @JsonProperty("vitaminADate")
    private Date vitaminADate;

    @Column(name = "vitamin_a_place")
    @JsonProperty("vitaminAPlace")
    private String vitaminAPlace;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private Date submissionDate;

}
