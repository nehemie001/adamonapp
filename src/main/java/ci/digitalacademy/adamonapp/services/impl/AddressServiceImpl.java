package ci.digitalacademy.adamonapp.services.impl;

import ci.digitalacademy.adamonapp.models.Absence;
import ci.digitalacademy.adamonapp.models.Address;
import ci.digitalacademy.adamonapp.repository.AbsenceRepository;
import ci.digitalacademy.adamonapp.repository.AddressRepository;
import ci.digitalacademy.adamonapp.services.AddressService;
import ci.digitalacademy.adamonapp.services.dto.AddressDTO;
import ci.digitalacademy.adamonapp.services.mapper.AbsenceMapper;
import ci.digitalacademy.adamonapp.services.mapper.AddressMapper;
import ci.digitalacademy.adamonapp.services.mapping.AddressMapping;
import ci.digitalacademy.adamonapp.services.mapping.UserMapping;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressServiceImpl implements AddressService {

    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;

    @Override
    public AddressDTO save(AddressDTO addressDTO) {
        log.debug("Request to save address : {}", addressDTO);
        Address address = addressMapper.toEntity(addressDTO);
        address = addressRepository.save(address);
        return addressMapper.toDto(address);
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) {
        return null;
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO, Long id) {
        return null;
    }

    @Override
    public Optional<AddressDTO> findOne(Long id) {
        return addressRepository.findById(id).map(addressMapper::toDto);
    }

    @Override
    public List<AddressDTO> findAll() {
        return addressRepository.findAll().stream().map(addressMapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete a address");
        addressRepository.deleteById(id);
    }

    @Override
    public AddressDTO partialUpdate(AddressDTO addressDTO, Long id) {
        log.debug("Request to update address : {}", addressDTO, id);
        return addressRepository.findById(id).map(address -> {
            AddressMapping.partialUpdate(address, addressDTO);
            return address;
        }).map(addressRepository::save).map(addressMapper::toDto).orElse(null);
    }

    @Override
    public Optional<AddressDTO> findBySlug(String slug) {
        return addressRepository.findBySlug(slug).map(addressMapper::toDto);
    }

    @Override
    public Optional<AddressDTO> findById(Long id) {
        return addressRepository.findById(id).map(addressMapper::toDto);
    }
}
