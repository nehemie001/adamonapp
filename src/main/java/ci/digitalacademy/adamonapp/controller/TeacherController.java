package ci.digitalacademy.adamonapp.controller;

import ci.digitalacademy.adamonapp.models.Setting;
import ci.digitalacademy.adamonapp.models.Teacher;
import ci.digitalacademy.adamonapp.services.TeacherService;
import ci.digitalacademy.adamonapp.services.dto.SettingDTO;
import ci.digitalacademy.adamonapp.services.dto.TeacherDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public String showTeacherPage(Model model) {
        List<TeacherDTO> teachers = teacherService.findAll();
        model.addAttribute("teachers" , teachers);
        return "teachers/list";
    }

    @PostMapping
    public String saveTeacher(TeacherDTO teacherDO) {
        teacherService.save(teacherDO);
        return "redirect:/teachers";
    }

    @GetMapping("/add")
    public String showAddTeacherPage(Model model) {
        log.debug("Request to show add teacher forms");
        model.addAttribute("teacher", new TeacherDTO());
        return "teachers/forms";
    }

    @GetMapping("/search")
    public String searchTeachers(@RequestParam String query  , @RequestParam String gender, Model model)
    {
        List<TeacherDTO> teachers = teacherService.findByfirstNameOrlastNameAndGender(query, gender);
        model.addAttribute("teachers", teachers);
        model.addAttribute("query", query);
        model.addAttribute("gender", gender);

        return "teachers/list";
    }
}
