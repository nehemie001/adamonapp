package ci.digitalacademy.adamonapp.services.mapper;

import ci.digitalacademy.adamonapp.models.School;
import ci.digitalacademy.adamonapp.services.dto.SchoolDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchoolMapper extends EntityMapper<SchoolDTO, School> {
}
