package Project.EM_CarRental.DTO.SecurityDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {

    private String username;
    private String email;
    private String password;
}
