package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "people")
public class Person extends EntityForm{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_name", nullable = false)
    @JsonProperty("full_name")
    private String fullName;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;
}
