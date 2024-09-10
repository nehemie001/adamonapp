package ci.digitalacademy.adamonapp.services.mapper;

import ci.digitalacademy.adamonapp.models.Absence;
import ci.digitalacademy.adamonapp.services.dto.AbsenceDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AbsenceMapper extends EntityMapper<AbsenceDTO, Absence> {
}
