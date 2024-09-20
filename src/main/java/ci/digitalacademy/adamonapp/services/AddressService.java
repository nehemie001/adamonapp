package ci.digitalacademy.adamonapp.services;

import ci.digitalacademy.adamonapp.services.dto.AddressDTO;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    AddressDTO save(AddressDTO addressDTO);

    AddressDTO update(AddressDTO addressDTO);

    AddressDTO update(AddressDTO addressDTO, Long id);

    Optional<AddressDTO> findOne(Long id);

    List<AddressDTO> findAll();

    void delete(Long id);

    AddressDTO partialUpdate(AddressDTO addressDTO, Long id);

    Optional<AddressDTO> findBySlug(String slug);

    Optional<AddressDTO> findById(Long id);
}
