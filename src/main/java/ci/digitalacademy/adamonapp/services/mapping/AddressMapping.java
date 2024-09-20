package ci.digitalacademy.adamonapp.services.mapping;

import ci.digitalacademy.adamonapp.models.Address;
import ci.digitalacademy.adamonapp.services.dto.AddressDTO;

public class AddressMapping {

    private AddressMapping(){}

    public static void partialUpdate(Address address, AddressDTO addressDTO) {
       if (addressDTO.getCountry() != null) {
           address.setCountry(address.getCountry());
       }
       if (addressDTO.getCity() != null) {
           address.setCity(address.getCity());
       }
    }
}
