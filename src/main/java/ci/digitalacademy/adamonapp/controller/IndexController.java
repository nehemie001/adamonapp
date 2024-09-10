package ci.digitalacademy.adamonapp.controller;

import ci.digitalacademy.adamonapp.services.SchoolService;
import ci.digitalacademy.adamonapp.services.SettingService;
import ci.digitalacademy.adamonapp.services.dto.SchoolDTO;
import ci.digitalacademy.adamonapp.services.dto.SettingDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class IndexController {

    private final SettingService settingService;
    private final SchoolService schoolService;

    @GetMapping
    public String index() {
        List<SettingDTO> settings = settingService.findAll();
        List<SchoolDTO> schools = schoolService.findAll();

        if (settings.isEmpty()) {
            return "redirect:/settings";
        }

        if (schools.isEmpty()) {
            return "redirect:/schools";
        }
        return "redirect:/login";
    }
}
