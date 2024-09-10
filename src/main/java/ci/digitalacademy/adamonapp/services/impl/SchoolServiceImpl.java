package ci.digitalacademy.adamonapp.services.impl;

import ci.digitalacademy.adamonapp.models.School;
import ci.digitalacademy.adamonapp.models.Setting;
import ci.digitalacademy.adamonapp.repository.SchoolRepository;
import ci.digitalacademy.adamonapp.services.SchoolService;
import ci.digitalacademy.adamonapp.services.dto.SchoolDTO;
import ci.digitalacademy.adamonapp.services.mapper.SchoolMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    @Override
    public SchoolDTO save(SchoolDTO schoolDTO) {
        log.debug("Request to save school: {}", schoolDTO);
        School school = schoolMapper.toEntity(schoolDTO);
        school = schoolRepository.save(school);
        return schoolMapper.toDto(school);
    }

    @Override
    public SchoolDTO update(SchoolDTO setting) {
        return null;
    }

    @Override
    public Optional<SchoolDTO> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public List<SchoolDTO> findAll() {
        return schoolRepository.findAll().stream().map(schoolMapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {

    }
}
