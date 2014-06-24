package app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@MappedSuperclass
@Data
public class BaseEntityForm {
    @Id
    @Column(name = "id")
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
