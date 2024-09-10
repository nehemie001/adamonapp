package ci.digitalacademy.adamonapp.services.mapper;

import ci.digitalacademy.adamonapp.models.StudentCard;
import ci.digitalacademy.adamonapp.services.dto.StudentCardDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentCardMapper extends EntityMapper<StudentCardDTO, StudentCard> {
}
