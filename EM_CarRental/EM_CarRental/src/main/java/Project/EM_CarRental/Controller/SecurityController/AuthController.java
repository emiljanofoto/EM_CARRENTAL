package Project.EM_CarRental.Controller.SecurityController;
import Project.EM_CarRental.DTO.SecurityDto.LoginDto;
import Project.EM_CarRental.DTO.SecurityDto.RegisterUserDto;
import Project.EM_CarRental.Service.SecurityService.AuthService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(authService.accountLogin(loginDto));
    }


    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "basicAuth")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterUserDto registerClientDto) {
        return ResponseEntity.ok(authService.registerUserAccount(registerClientDto));
    }
}
