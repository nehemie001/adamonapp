package ci.digitalacademy.adamonapp.services.mapper;

import ci.digitalacademy.adamonapp.models.Role;
import ci.digitalacademy.adamonapp.services.dto.RoleDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper extends EntityMapper<RoleDTO, Role> {
}
