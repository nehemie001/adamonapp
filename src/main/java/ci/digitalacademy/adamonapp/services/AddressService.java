package ci.digitalacademy.adamonapp.services;

import ci.digitalacademy.adamonapp.services.dto.AddressDTO;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    AddressDTO save(AddressDTO adresse);

    AddressDTO update(AddressDTO adresse);

    Optional<AddressDTO> findOne(Long id);

    List<AddressDTO> findAll();

    void delete(Long id);
}
