package ci.digitalacademy.adamonapp.services.impl;

import ci.digitalacademy.adamonapp.models.Absence;
import ci.digitalacademy.adamonapp.repository.AbsenceRepository;
import ci.digitalacademy.adamonapp.services.AbsenceService;
import ci.digitalacademy.adamonapp.services.dto.AbsenceDTO;
import ci.digitalacademy.adamonapp.services.mapper.AbsenceMapper;
import ci.digitalacademy.adamonapp.services.mapping.AbsenceMapping;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AbsenceServiceImpl implements AbsenceService {

    private final AbsenceMapper absenceMapper;
    private final AbsenceRepository absenceRepository;

    @Override
    public AbsenceDTO save(AbsenceDTO absenceDTO) {
        log.debug("");
        Absence absence = absenceMapper.toEntity(absenceDTO);
        absence = absenceRepository.save(absence);
        return absenceMapper.toDto(absence);
    }

    @Override
    public AbsenceDTO update(AbsenceDTO absenceDTO) {
        return findOne(absenceDTO.getId()).map(existingAbsence -> {
            existingAbsence.setAbsenceNumber(absenceDTO.getAbsenceNumber());
            existingAbsence.setDateAbsence(absenceDTO.getDateAbsence());
            existingAbsence.setStudent(absenceDTO.getStudent());
            return save(existingAbsence);
        }).orElseThrow(()-> new RuntimeException("Teacher not found"));
    }

    @Override
    public AbsenceDTO update(AbsenceDTO absenceDTO, Long id) {
        absenceDTO.setId(id);
        return update(absenceDTO);
    }

    @Override
    public Optional<AbsenceDTO> findOne(Long id) {
        return absenceRepository.findById(id).map(absence -> {
            return absenceMapper.toDto(absence);
        });
    }

    @Override
    public List<AbsenceDTO> findAll() {
        return absenceRepository.findAll().stream().map(absence -> {
            return absenceMapper.toDto(absence);
        }).toList();
    }

    @Override
    public void delete(Long id) {
        absenceRepository.deleteById(id);
    }

//    @Override
//    public AbsenceDTO saveAbsence(AbsenceDTO absenceDTO) {
//        final String slug = SlugifyUtils.generate((absenceDTO.getAbsenceNumber().toString()));
//        absenceDTO.setSlug(slug);
//        return save(absenceDTO);
//    }

    @Override
    public AbsenceDTO partialUpdate(AbsenceDTO absenceDTO, Long id) {
        return absenceRepository.findById(id).map(absence -> {
            AbsenceMapping.partialUpdate(absence, absenceDTO);
            return absence;
        }).map(absenceRepository::save).map(absenceMapper::toDto).orElse(null);
    }
}
