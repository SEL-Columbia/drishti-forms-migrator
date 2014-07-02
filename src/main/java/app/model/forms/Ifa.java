package app.model.forms;

import app.model.FromEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "ifa")
public class Ifa extends FromEntity {

    @Column(name = "mother_id")
    @JsonProperty("id")
    private String motherId;

    @Column(name = "ifa_tablets_place")
    @JsonProperty("ifaTabletsPlace")
    private String ifaTabletsPlace;

    @Column(name = "number_of_ifa_tablets_given")
    @JsonProperty("numberOfIFATabletsGiven")
    private String numberOfIFATabletsGiven;

    @Column(name = "ifa_tablets_date")
    @JsonProperty("ifaTabletsDate")
    private String ifaTabletsDate;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private String submissionDate;

}
