package ci.digitalacademy.adamonapp.services.mapping;

import ci.digitalacademy.adamonapp.models.Role;
import ci.digitalacademy.adamonapp.services.dto.RoleDTO;

public final class RoleMapping {

    private RoleMapping(){}

    public static void partialUpdate(Role role, RoleDTO roleDTO) {
        if (roleDTO.getRole() != null) {
            role.setRole(roleDTO.getRole());
        }
    }
}
