package ci.digitalacademy.adamonapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "student")
public class Student extends Person {

    @Column(name = "matricule", unique = true)
    private String matricule;

    @Column(name = "phone_number_father")
    private String phoneNumberFather;

    @Column(name = "slug", unique = true)
    private String slug;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Set<StudentCard> studentCards;

    @OneToMany(mappedBy = "student")
    private Set<Absence> absence;
}
