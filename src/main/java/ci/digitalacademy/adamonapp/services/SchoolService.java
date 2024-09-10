package ci.digitalacademy.adamonapp.services;

import ci.digitalacademy.adamonapp.services.dto.SchoolDTO;

import java.util.List;
import java.util.Optional;

public interface SchoolService {

    SchoolDTO save(SchoolDTO schoolDTO);

    SchoolDTO update(SchoolDTO schoolDTO);

    Optional<SchoolDTO> findOne(Long id);

    List<SchoolDTO> findAll();

    void delete(Long id);
}
