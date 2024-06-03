package Project.EM_CarRental.Service;


import Project.EM_CarRental.DTO.UserDTO;
import Project.EM_CarRental.Entities.User;
import Project.EM_CarRental.Mapper.UserDTOMapper;
import Project.EM_CarRental.Repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserRegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public void registerUser(UserDTO userDTO) {
        if (userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
            throw new EntityExistsException("User with username " + userDTO.getUsername() + " already exists");


        }
        User user = UserDTOMapper.mapToUser(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        userService.addRoleToUser(user.getUsername(), "ROLE_USER");
    }

}



