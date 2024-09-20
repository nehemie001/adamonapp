package ci.digitalacademy.adamonapp.services.mapping;

import ci.digitalacademy.adamonapp.models.School;
import ci.digitalacademy.adamonapp.services.dto.SchoolDTO;

public final class SchoolMapping {

    private SchoolMapping(){}

    public static void partialUpdate(School school, SchoolDTO schoolDTO) {
        if (schoolDTO.getName() != null) {
            school.setName(school.getName());
        }
    }
}
