package ci.digitalacademy.adamonapp.services;

import ci.digitalacademy.adamonapp.services.dto.SettingDTO;

import java.util.List;
import java.util.Optional;

public interface SettingService {

    SettingDTO save(SettingDTO settingDTO);

    SettingDTO update(SettingDTO settingDTO);

    Optional<SettingDTO> findOne(Long id);

    List<SettingDTO> findAll();

    void delete(Long id);
}
