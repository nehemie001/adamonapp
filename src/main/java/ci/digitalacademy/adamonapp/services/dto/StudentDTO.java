package ci.digitalacademy.adamonapp.services.dto;

import ci.digitalacademy.adamonapp.models.Absence;
import ci.digitalacademy.adamonapp.models.StudentCard;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class StudentDTO extends PersonDTO {

    private String matricule;

    private String phoneNumberFather;

    private Set<StudentCard> studentCards;

    private List<Absence> absence;
}
