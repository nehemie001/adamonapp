package ci.digitalacademy.adamonapp.services.mapper;

import ci.digitalacademy.adamonapp.models.User;
import ci.digitalacademy.adamonapp.services.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {
}
