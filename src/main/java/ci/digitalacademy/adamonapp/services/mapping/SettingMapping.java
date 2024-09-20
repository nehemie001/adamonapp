package ci.digitalacademy.adamonapp.services.mapping;

import ci.digitalacademy.adamonapp.models.Setting;
import ci.digitalacademy.adamonapp.services.dto.SettingDTO;

public final class SettingMapping {

    private SettingMapping(){}

    public static void partialUpdate(Setting setting, SettingDTO settingDTO) {
        if(settingDTO.getSmtpUsername() != null) {
            setting.setSmtpUsername(settingDTO.getSmtpUsername());
        }
        if (settingDTO.getSmtpPort() != null) {
            setting.setSmtpPort(settingDTO.getSmtpPort());
        }
    }
}
