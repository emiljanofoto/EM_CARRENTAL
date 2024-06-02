package Project.EM_CarRental.Service;

import Project.EM_CarRental.DTO.UserDTO;
import Project.EM_CarRental.Entities.Role;
import Project.EM_CarRental.Entities.User;
import Project.EM_CarRental.Mapper.UserDTOMapper;
import Project.EM_CarRental.Repository.RoleRepository;
import Project.EM_CarRental.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("UserName not found!"));

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);

    }

    public UserDTO saveUser(UserDTO userDTO) {
        if (userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
            throw new UsernameNotFoundException("Username already exists!");
        }
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(UserDTOMapper.mapToUser(userDTO));
        return userDTO;
    }

    public User editUser(Long id, UserDTO userDTO) {
        User userEdited = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found!"));
        userEdited.setUsername(userDTO.getUsername());
        userEdited.setName(userDTO.getName());
        userEdited.setEmail(userDTO.getEmail());
        userEdited.setPhone(userDTO.getPhone());
        userEdited.setLastname(userDTO.getLastName());
        userEdited.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return userRepository.save(userEdited);
    }

    public void deleteUser(Long id) {
        if (!userRepository.findById(id).isPresent()) {
            throw new UsernameNotFoundException("User not found!");
        }
        userRepository.deleteById(id);
    }

    public Role saveRole(Role role) {
        if (!roleRepository.findByName(role.getName()).isPresent()) {
            throw new UsernameNotFoundException("Role not found!");
        }
        return roleRepository.save(role);

    }

    public User addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
        Role role = roleRepository.findByName(roleName).orElseThrow(() -> new UsernameNotFoundException("Role not found!"));
        if (user.getRoles().contains(role)) {
            throw new UsernameNotFoundException("Role already exists for the user!");

        }
        user.getRoles().add(role);
        role.getUsers().add(user);
        return userRepository.save(user);


    }

    public void removeRoleFromUser(String username, String roleName) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
        Role role = roleRepository.findByName(roleName).orElseThrow(() -> new UsernameNotFoundException("Role not found!"));

        user.getRoles().remove(role);
        role.getUsers().remove(user);
    }

    public List<UserDTO> getAllUsers() {
        return UserDTOMapper.mapUserToUserDTO(userRepository.findAll());

    }


}
