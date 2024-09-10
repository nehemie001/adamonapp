package ci.digitalacademy.adamonapp.services.mapper;

import ci.digitalacademy.adamonapp.models.Setting;
import ci.digitalacademy.adamonapp.services.dto.SettingDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SettingMapper extends EntityMapper<SettingDTO, Setting> {
}
