package ci.digitalacademy.adamonapp.controller;

import ci.digitalacademy.adamonapp.models.Role;
import ci.digitalacademy.adamonapp.services.RoleService;
import ci.digitalacademy.adamonapp.services.dto.RoleDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public String showUserPage(Model model) {
        List<RoleDTO> roles = roleService.findAll();
        model.addAttribute("roles", roles);
        return "roles/list";
    }

    @PostMapping
    public String saveTeacher(RoleDTO roleDTO){
        log.debug("Request to save user role :{}", roleDTO);
        roleService.save(roleDTO);
        return "redirect:/roles";
    }

    @GetMapping("/add")
    public String showAddUserPage(Model model) {
        log.debug("Request to show add user role forms");
        model.addAttribute("role", new Role());
        return "roles/forms";
    }
}
