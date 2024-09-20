package ci.digitalacademy.adamonapp.services.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class AbsenceDTO {

    private Long id;

    private Instant dateAbsence;

    private String absenceNumber;

    private StudentDTO student;

    private String slug;
}
