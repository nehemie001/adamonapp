package ci.digitalacademy.adamonapp.services.impl;

import ci.digitalacademy.adamonapp.models.Setting;
import ci.digitalacademy.adamonapp.repository.SettingRepository;
import ci.digitalacademy.adamonapp.services.SettingService;
import ci.digitalacademy.adamonapp.services.dto.SettingDTO;
import ci.digitalacademy.adamonapp.services.mapper.SettingMapper;
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
    public SettingDTO update(SettingDTO setting) {
        return null;
    }

    @Override
    public Optional<SettingDTO> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public List<SettingDTO> findAll() {
        return settingRepository.findAll().stream().map(settingMapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {

    }
}
