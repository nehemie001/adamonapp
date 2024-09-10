package ci.digitalacademy.adamonapp.controller;

import ci.digitalacademy.adamonapp.models.Role;
import ci.digitalacademy.adamonapp.models.User;
import ci.digitalacademy.adamonapp.repository.RoleRepository;
import ci.digitalacademy.adamonapp.services.RoleService;
import ci.digitalacademy.adamonapp.services.UserService;
import ci.digitalacademy.adamonapp.services.dto.RoleDTO;
import ci.digitalacademy.adamonapp.services.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;
    private final RoleRepository roleRepository;

    @GetMapping
    public String showUserPage(Model model) {
//        List<UserDTO> users = userService.findAll();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String pseudo;

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            pseudo = ((UserDetails) authentication.getPrincipal()).getUsername();
        } else {
            pseudo = null;
        }

        List<UserDTO> users = userService.findAll().stream()
                .filter(user -> !user.getPseudo().equals(pseudo))
                .collect(Collectors.toList());

        model.addAttribute("users", users);
        return "users/list";
    }

    @PostMapping
    public String saveUser(UserDTO userDTO){
        userService.save(userDTO);
        return "redirect:/users";
    }

    @GetMapping("/add")
    public String showAddUserPage(Model model) {
        model.addAttribute("user", new User());
        return "users/forms";
    }

    @PostMapping("/toggle-status")
    public String toggleUserStatus(@RequestParam("id") Long id, @RequestParam("isActive") boolean isActive) {
        log.info("Toggling user status for user with ID: {}", id);

        // Récupère l'utilisateur actuel
        UserDTO user = userService.findById(id);

        // Vérifie son état actuel et bascule le statut
        boolean newStatus;
        if (user.isActive()) {
            log.info("User is currently active, deactivating user.");
            newStatus = false; // Désactiver si actuellement actif
        } else {
            log.info("User is currently inactive, activating user.");
            newStatus = true; // Activer si actuellement inactif
        }

        // Met à jour le statut de l'utilisateur
        userService.toggleUserStatus(id, newStatus);

        userService.toggleUserStatus(id, isActive);
        return "redirect:/users"; // redirige vers la liste des utilisateurs
    }
}
