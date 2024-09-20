package ci.digitalacademy.adamonapp.controller;

import ci.digitalacademy.adamonapp.models.School;
import ci.digitalacademy.adamonapp.services.SchoolService;
import ci.digitalacademy.adamonapp.services.dto.SchoolDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthController {

    private final SchoolService schoolService;

    @GetMapping
    public String showLogin(Model model) {
        List<SchoolDTO> schools = schoolService.findAll();
        Optional<SchoolDTO> schoolDTO = schools.stream().findFirst();

        model.addAttribute("school", schoolDTO.orElse(null));
        return "auth/login";
    }
}
