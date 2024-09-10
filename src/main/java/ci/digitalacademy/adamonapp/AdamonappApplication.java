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

		RoleDTO role1 = new RoleDTO();
		role1.setName("admin");
		RoleDTO role2 = new RoleDTO();
		role2.setName("staff");
		RoleDTO role3 = new RoleDTO();
		role3.setName("other");

		List<RoleDTO> roleUsersDTO = Arrays.asList(role1, role2, role3);
		roleUsersDTO = roleService.initRoles(roleUsersDTO);


		String password = passwordEncoder.encode("admin");
		UserDTO other = new UserDTO();
		other.setPseudo("admin");
		other.setPassword(password);
		other.setActive(true);
		other.setCreation_date(Date.from(Instant.now()));

		userService.save(other);

		String password2 = passwordEncoder.encode("admin2");
		UserDTO staff = new UserDTO();
		staff.setPseudo("admin2");
		staff.setPassword(password2);
		staff.setActive(true);
		staff.setCreation_date(Date.from(Instant.now()));

		userService.save(staff);

		String password1 = passwordEncoder.encode("user");
		UserDTO admin = new UserDTO();
		admin.setPseudo("user");
		admin.setPassword(password1);
		admin.setActive(false);
		admin.setCreation_date(Date.from(Instant.now()));

		userService.save(admin);


//		UserDTO userDTO = new UserDTO();
//		userDTO.setPseudo("admin");
//		userDTO.setPassword(passwordEncoder.encode("admin"));
//
//		userDTO.setCreation_date(Date.from(Instant.now()));
//		userMapper.save(userDTO);


	}
}
