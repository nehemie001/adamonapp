package ci.digitalacademy.adamonapp.services.mapping;

import ci.digitalacademy.adamonapp.models.User;
import ci.digitalacademy.adamonapp.services.dto.UserDTO;

public final class UserMapping {

    private UserMapping(){

    }

    public static void partialUpdate(User user, UserDTO userDTO) {
        if(userDTO.getPseudo() != null) {
            user.setPseudo(userDTO.getPseudo());
        }
    }
}
