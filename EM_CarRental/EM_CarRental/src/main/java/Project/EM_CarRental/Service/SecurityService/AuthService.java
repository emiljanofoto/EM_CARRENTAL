package Project.EM_CarRental.Service.SecurityService;
import Project.EM_CarRental.DTO.SecurityDto.LoginDto;
import Project.EM_CarRental.DTO.SecurityDto.RegisterUserDto;
import Project.EM_CarRental.Entities.Role;
import Project.EM_CarRental.Entities.User;
import Project.EM_CarRental.Repository.RoleRepository;
import Project.EM_CarRental.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
  //  private final ClientRepository clientRepository;
    private PasswordEncoder passwordEncoder;





    public String accountLogin(LoginDto loginDto) {
        String usernameOrEmail;
        if (loginDto.getUsername() != null) {
            usernameOrEmail = loginDto.getUsername();
        } else {
            usernameOrEmail = loginDto.getEmail();
        }

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usernameOrEmail, loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "Logged in successfully!";
    }


    @Transactional
    public String registerUserAccount(RegisterUserDto registerDto) {
        if (Boolean.TRUE.equals(userRepository.existsByUsernameOrEmail(registerDto.getEmail(), registerDto.getUsername()))) {
            return "User already exists!";
        }

        User newUser = new User();
        newUser.setUsername(registerDto.getUsername());
        newUser.setEmail(registerDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByRole("ROLE_USER").orElseThrow(() -> new RuntimeException("Error: Role is not found.")));
        newUser.setRoles(roles);

        newUser.setName(registerDto.getFirstName());
        newUser.setLastname(registerDto.getLastName());
        newUser.setPhone(registerDto.getPhoneNumber());
        userRepository.save(newUser);

        return "Registered successfully!";
    }

}
