package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ifa")
public class Ifa extends EntityForm {
    @Id
    @Column(name = "ifa_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ifaId;

    @Column(name = "id")
    @JsonProperty("id")
    private String id;

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
