package ci.digitalacademy.adamonapp.services.impl;

import ci.digitalacademy.adamonapp.models.Setting;
import ci.digitalacademy.adamonapp.repository.SettingRepository;
import ci.digitalacademy.adamonapp.services.SettingService;
import ci.digitalacademy.adamonapp.services.dto.AbsenceDTO;
import ci.digitalacademy.adamonapp.services.dto.SettingDTO;
import ci.digitalacademy.adamonapp.services.mapper.SettingMapper;
import ci.digitalacademy.adamonapp.services.mapping.SettingMapping;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SettingServiceImpl implements SettingService {

    private final SettingRepository settingRepository;
    private final SettingMapper settingMapper;

    @Override
    public SettingDTO save(SettingDTO settingDTO) {
        log.debug("Request to save setting: {}", settingDTO);
        Setting setting = settingMapper.toEntity(settingDTO);
        log.debug("Setting after mapping{}", setting);
        setting = settingRepository.save(setting);
        return settingMapper.toDto(setting);
    }

    @Override
    public SettingDTO update(SettingDTO settingDTO) {
        return findOne(settingDTO.getId()).map(existingUser -> {
            existingUser.setSmtpUsername(settingDTO.getSmtpUsername());
            existingUser.setSmtpPort(settingDTO.getSmtpPort());
            return save(existingUser);
        }).orElseThrow(()-> new RuntimeException("User not found"));
    }

    @Override
    public SettingDTO update(SettingDTO settingDTO, Long id) {
        settingDTO.setId(id);
        return update(settingDTO);
    }

    @Override
    public Optional<SettingDTO> findOne(Long id) {
        return settingRepository.findById(id).map(settingMapper::toDto);
    }

    @Override
    public Optional<SettingDTO> findById(Long id) {
        return settingRepository.findById(id).map(settingMapper::toDto);
    }

    @Override
    public List<SettingDTO> findAll() {
        return settingRepository.findAll().stream().map(settingMapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete setting: {}", id);
        settingRepository.deleteById(id);
    }

    @Override
    public Optional<SettingDTO> findBySlug(String slug) {
        log.debug("Request to get setting by slug:{}", slug);
        return settingRepository.findBySlug(slug).map(settingMapper::toDto);
    }

    @Override
    public SettingDTO partialUpdate(SettingDTO settingDTO, Long id) {
        return settingRepository.findById(id).map(setting -> {
            SettingMapping.partialUpdate(setting, settingDTO);
            return setting;
        }).map(settingRepository::save).map(settingMapper::toDto).orElse(null);
    }
}
