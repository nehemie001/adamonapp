package ci.digitalacademy.adamonapp.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDTO extends PersonDTO{

    private Boolean available;

    private String specialty;

    private String slug;
}
