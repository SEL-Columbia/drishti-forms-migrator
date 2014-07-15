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
@Table(name = "ifa")
@EqualsAndHashCode(callSuper = true)
public class Ifa extends FormEntity {
    @Column(name = "mother_id")
    @JsonProperty("id")
    private String motherId;

    @Column(name = "ifa_tablets_place")
    @JsonProperty("ifaTabletsPlace")
    private String ifaTabletsPlace;

    @Column(name = "number_of_ifa_tablets_given")
    @JsonProperty("numberOfIFATabletsGiven")
    private Integer numberOfIFATabletsGiven;

    @Column(name = "ifa_tablets_date")
    @JsonProperty("ifaTabletsDate")
    private Date ifaTabletsDate;

    @Column(name = "submission_date")
    @JsonProperty("submissionDate")
    private Date submissionDate;

}
