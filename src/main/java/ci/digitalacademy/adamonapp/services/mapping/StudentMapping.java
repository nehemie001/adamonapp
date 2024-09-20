package ci.digitalacademy.adamonapp.services.mapping;

import ci.digitalacademy.adamonapp.models.Student;
import ci.digitalacademy.adamonapp.services.dto.StudentDTO;

public class StudentMapping {

    private StudentMapping(){}

    public static void partialUpdate(Student student, StudentDTO studentDTO) {
        if(studentDTO.getMatricule() != null) {
            student.setMatricule(student.getMatricule());
        }

        if (studentDTO.getPhoneNumberFather() != null) {
            student.setPhoneNumberFather(student.getPhoneNumberFather());
        }
    }
}
