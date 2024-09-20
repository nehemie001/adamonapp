package ci.digitalacademy.adamonapp.services.mapping;

import ci.digitalacademy.adamonapp.models.Student;
import ci.digitalacademy.adamonapp.models.Teacher;
import ci.digitalacademy.adamonapp.services.dto.StudentDTO;
import ci.digitalacademy.adamonapp.services.dto.TeacherDTO;

public class TeacherMapping {

    private TeacherMapping(){}

    public static void partialUpdate(Teacher teacher, TeacherDTO teacherDTO) {
        if(teacherDTO.getLastName() != null) {
            teacher.setLastName(teacher.getLastName());
        }

        if (teacherDTO.getFirstName() != null) {
            teacher.setFirstName(teacher.getFirstName());
        }
    }
}
