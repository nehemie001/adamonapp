package ci.digitalacademy.adamonapp.services;

import ci.digitalacademy.adamonapp.services.dto.AbsenceDTO;

import java.util.List;
import java.util.Optional;

public interface AbsenceService {
    AbsenceDTO save(AbsenceDTO absenceDTO);

    AbsenceDTO update(AbsenceDTO absenceDTO);

    AbsenceDTO update(AbsenceDTO absenceDTO, Long id);

    Optional<AbsenceDTO> findOne(Long id);

    List<AbsenceDTO> findAll();

    void delete(Long id);

    AbsenceDTO partialUpdate(AbsenceDTO absenceDTO, Long id);
}
