package Project.EM_CarRental.Controller;


import Project.EM_CarRental.DTO.UserDTO;
import Project.EM_CarRental.Service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserRegistrationController {

    private final UserRegistrationService userRegistrationService;

    @PostMapping("/registration")
    public void registerUser (@RequestBody UserDTO userDTO){
        userRegistrationService.registerUser(userDTO);
    }
}
