package Project.EM_CarRental.Controller.SecurityController;

import Project.EM_CarRental.Entities.User;
import Project.EM_CarRental.Repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserLogInSecurity {

    private final UserRepository userRepository;

    public UserLogInSecurity(UserRepository userRepository) {this.userRepository = userRepository;}

    public User getUser() {
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        String username = principal.getName();
        return userRepository.findByUsername(username).orElseThrow();

    }


}