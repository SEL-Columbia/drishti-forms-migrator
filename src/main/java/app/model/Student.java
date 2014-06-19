package app.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "student")
public class Student extends EntityForm{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "course", nullable = false)
    private String course;
}
