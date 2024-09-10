package ci.digitalacademy.adamonapp.services.mapper;

import ci.digitalacademy.adamonapp.models.Address;
import ci.digitalacademy.adamonapp.services.dto.AddressDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper extends EntityMapper<AddressDTO, Address> {
}
