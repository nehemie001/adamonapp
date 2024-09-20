package ci.digitalacademy.adamonapp.controller;

import ci.digitalacademy.adamonapp.models.School;
import ci.digitalacademy.adamonapp.models.Setting;
import ci.digitalacademy.adamonapp.services.FileStorageService;
import ci.digitalacademy.adamonapp.services.SchoolService;
import ci.digitalacademy.adamonapp.services.SettingService;
import ci.digitalacademy.adamonapp.services.dto.RegistrationSchoolDTO;
import ci.digitalacademy.adamonapp.services.dto.SchoolDTO;
import ci.digitalacademy.adamonapp.services.dto.SettingDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/schools")
public class SchoolController {

    private final SchoolService schoolService;
    private final SettingService settingService;
    private final FileStorageService fileStorageService;

    @GetMapping
    public String showSchoolPage(Model model) {
//        List<SchoolDTO> schoolDTO = schoolService.findAll();
//        if (schoolDTO.isEmpty()) {
//            return "schools/forms";
//        } else {
//            model.addAttribute("school", new RegistrationSchoolDTO());
//            return "redirect/login";
//        }
        model.addAttribute("school" , new RegistrationSchoolDTO());
        return "schools/forms";
    }

    @PostMapping
    public String saveSchool(@ModelAttribute RegistrationSchoolDTO registrationSchoolDTO) throws IOException {
        log.debug("Request to save teacher : {}", registrationSchoolDTO);
        fileStorageService.upload(registrationSchoolDTO.getFile());
        SettingDTO settingDTO = settingService.findAll().get(0);
        SchoolDTO schoolDTO = new SchoolDTO();
        schoolDTO.setId(settingDTO.getId());
        schoolDTO.setName(registrationSchoolDTO.getName());
        schoolDTO.setUrlLogo(registrationSchoolDTO.getFile().getOriginalFilename());
        schoolService.save(schoolDTO);
        return "redirect:/login";
    }
}
