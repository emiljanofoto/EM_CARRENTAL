package Project.EM_CarRental.Service.SecurityService;

import Project.EM_CarRental.Entities.User;
import Project.EM_CarRental.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String emailOrUsername) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(emailOrUsername,emailOrUsername).orElseThrow(
                () -> new UsernameNotFoundException("User not found with email: " + emailOrUsername));

//        Set<GrantedAuthority> authorities = user.getRoles().stream().map(role -> new org.springframework.security.core.authority.SimpleGrantedAuthority(role.getRole())).collect(java.util.stream.Collectors.toSet());
//
//        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);

        return new MyUserDetails(user);
    }

}