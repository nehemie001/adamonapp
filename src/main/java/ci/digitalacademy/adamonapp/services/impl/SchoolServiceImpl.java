package ci.digitalacademy.adamonapp.services.impl;

import ci.digitalacademy.adamonapp.models.School;
import ci.digitalacademy.adamonapp.models.Setting;
import ci.digitalacademy.adamonapp.repository.SchoolRepository;
import ci.digitalacademy.adamonapp.services.SchoolService;
import ci.digitalacademy.adamonapp.services.SettingService;
import ci.digitalacademy.adamonapp.services.dto.SchoolDTO;
import ci.digitalacademy.adamonapp.services.dto.SettingDTO;
import ci.digitalacademy.adamonapp.services.mapper.SchoolMapper;
import ci.digitalacademy.adamonapp.services.mapping.SchoolMapping;
import ci.digitalacademy.adamonapp.services.mapping.UserMapping;
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
    private final SettingService settingService;

    @Override
    public SchoolDTO save(SchoolDTO schoolDTO) {
        log.debug("Request to save school: {}", schoolDTO);
        Optional<SettingDTO> setting = settingService.findOne(schoolDTO.getId());
//        settingDTO.setEmail(settingService.findById(settingDTO.getEmail().getId()).orElse(null));
        School school = schoolMapper.toEntity(schoolDTO);
        school = schoolRepository.save(school);
        return schoolMapper.toDto(school);
    }

    @Override
    public SchoolDTO update(SchoolDTO schoolDTO) {
        log.debug("Request to update a school : {}", schoolDTO);
        return findOne(schoolDTO.getId()).map(existingUser -> {
            existingUser.setName(schoolDTO.getName());
            return save(existingUser);
        }).orElseThrow(()-> new RuntimeException("School not found"));
    }

    @Override
    public SchoolDTO update(SchoolDTO schoolDTO, Long id) {
        schoolDTO.setId(id);
        return update(schoolDTO);
    }

    @Override
    public Optional<SchoolDTO> findOne(Long id) {
        return schoolRepository.findById(id).map(school -> schoolMapper.toDto(school));
    }

    @Override
    public List<SchoolDTO> findAll() {
        log.debug("Request to find all school");
        return schoolRepository.findAll().stream().map(schoolMapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete a school : {}", id);
        schoolRepository.deleteById(id);
    }

    @Override
    public Optional<SchoolDTO> findById(Long id) {
        log.debug("Request to find a school with id : {} ", id);
        return schoolRepository.findById(id).map(schoolMapper::toDto);
    }


    @Override
    public SchoolDTO partialUpdate(SchoolDTO schoolDTO, Long id) {
        log.debug("Request to update school: {} {}", schoolDTO, id);
        return schoolRepository.findById(id).map(school -> {
            SchoolMapping.partialUpdate(school, schoolDTO);
            return school;
        }).map(schoolRepository::save).map(schoolMapper::toDto).orElse(null);
    }

}
