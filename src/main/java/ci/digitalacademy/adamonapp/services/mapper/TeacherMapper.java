package ci.digitalacademy.adamonapp.services.mapper;

import ci.digitalacademy.adamonapp.models.Teacher;
import ci.digitalacademy.adamonapp.services.dto.TeacherDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper extends EntityMapper<TeacherDTO, Teacher> {
}
