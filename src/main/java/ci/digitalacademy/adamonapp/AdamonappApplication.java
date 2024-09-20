package ci.digitalacademy.adamonapp;

import ci.digitalacademy.adamonapp.services.RoleService;
import ci.digitalacademy.adamonapp.services.UserService;
import ci.digitalacademy.adamonapp.services.dto.RoleDTO;
import ci.digitalacademy.adamonapp.services.dto.UserDTO;
import ci.digitalacademy.adamonapp.services.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class AdamonappApplication implements CommandLineRunner {

	private final BCryptPasswordEncoder passwordEncoder;
	private final RoleService roleService;
	private final UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(AdamonappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		RoleDTO admin = new RoleDTO();
		admin.setRole("ADMIN");
		RoleDTO user = new RoleDTO();
		user.setRole("USER");

		List<RoleDTO> roleUsersDTO = Arrays.asList(admin, user);
		roleUsersDTO = roleService.initRoles(roleUsersDTO);


		String password = passwordEncoder.encode("admin");
		UserDTO user1 = new UserDTO();
		user1.setPseudo("admin");
		user1.setRole(roleUsersDTO);
		user1.setPassword(password);
		user1.setActive(true);
		user1.setCreationDate(Instant.now());

		userService.save(user1);

		String password1 = passwordEncoder.encode("user");
		UserDTO user2 = new UserDTO();
		user2.setPseudo("user");
//		user2.setRole(roleUsersDTO);
		user2.setPassword(password1);
		user2.setActive(false);
		user2.setCreationDate(Instant.now());

		userService.save(user2);


//		UserDTO userDTO = new UserDTO();
//		userDTO.setPseudo("admin");
//		userDTO.setPassword(passwordEncoder.encode("admin"));
//
//		userDTO.setCreation_date(Date.from(Instant.now()));
//		userMapper.save(userDTO);


	}
}
