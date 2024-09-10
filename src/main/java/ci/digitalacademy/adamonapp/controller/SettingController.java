package ci.digitalacademy.adamonapp.controller;

import ci.digitalacademy.adamonapp.models.Setting;
import ci.digitalacademy.adamonapp.services.SchoolService;
import ci.digitalacademy.adamonapp.services.SettingService;
import ci.digitalacademy.adamonapp.services.dto.SchoolDTO;
import ci.digitalacademy.adamonapp.services.dto.SettingDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/settings")
public class SettingController {

    private final SettingService settingService;
    private final SchoolService schoolService;

    @GetMapping
    public String showSettingPage(Model model) {
        model.addAttribute("setting" , new Setting());
        return "settings/forms";
    }

    @PostMapping
    public String saveSetting(SettingDTO settingDTO) {
        settingService.save(settingDTO);
        return "redirect:/schools";
    }

    @GetMapping("/params")
    public String showParams(Model model) {
        List<SettingDTO> settings = settingService.findAll();
//        Optional<SchoolDTO> schools = schoolService.findOne(id);
        model.addAttribute("settings", settings);
//        model.addAttribute("schools", schools);
        return "settings/params";
    }
}
