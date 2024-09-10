package ci.digitalacademy.adamonapp.controller;

import ci.digitalacademy.adamonapp.models.Setting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/params")
public class ParamController {

    @GetMapping
    public String showSettingPage(Model model) {
        model.addAttribute("setting" , new Setting());
        return "param/index";
    }
}
