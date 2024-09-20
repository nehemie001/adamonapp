package ci.digitalacademy.adamonapp.services.mapping;

import ci.digitalacademy.adamonapp.models.Absence;
import ci.digitalacademy.adamonapp.services.dto.AbsenceDTO;

public final class AbsenceMapping {

    private AbsenceMapping() {
        // No instances allowed
    }

    public static void partialUpdate(Absence absence, AbsenceDTO absenceDTO) {
        if (absenceDTO.getDateAbsence() != null) {
            absence.setAbsenceDate(absenceDTO.getDateAbsence());
        }
        if (absenceDTO.getAbsenceNumber() != null) {
            absence.setAbsenceNumber(absenceDTO.getAbsenceNumber());
        }
    }
}
