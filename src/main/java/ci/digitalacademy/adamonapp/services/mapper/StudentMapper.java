package ci.digitalacademy.adamonapp.services.mapper;

import ci.digitalacademy.adamonapp.models.Student;
import ci.digitalacademy.adamonapp.services.dto.StudentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper extends EntityMapper<StudentDTO, Student> {
}
