package ci.digitalacademy.adamonapp.services;

import ci.digitalacademy.adamonapp.services.dto.AbsenceDTO;
import ci.digitalacademy.adamonapp.services.dto.SettingDTO;

import java.util.List;
import java.util.Optional;

public interface SettingService {

    SettingDTO save(SettingDTO settingDTO);

    SettingDTO update(SettingDTO settingDTO);

    SettingDTO update(SettingDTO settingDTO, Long id);

    Optional<SettingDTO> findOne(Long id);

    Optional<SettingDTO> findById(Long id);

    List<SettingDTO> findAll();

    void delete(Long id);

    Optional<SettingDTO> findBySlug(String slug);

    SettingDTO partialUpdate(SettingDTO settingDTO, Long id);
}
