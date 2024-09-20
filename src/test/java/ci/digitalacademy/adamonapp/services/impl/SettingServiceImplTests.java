package ci.digitalacademy.adamonapp.services.impl;

import ci.digitalacademy.adamonapp.models.Setting;
import ci.digitalacademy.adamonapp.repository.SettingRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class SettingServiceImplTests {
    @Mock
    private SettingRepository settingRepository;

    @InjectMocks
    private SettingServiceImpl settingService;

    @Test
    public void whenGetSettingById_thenReturnSetting() {
//        when(settingRepository.findById(5L)).thenReturn(Optional.of(new Setting(5L, "test", "test", "test")));
    }
}
