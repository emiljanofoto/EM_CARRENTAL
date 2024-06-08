package Project.EM_CarRental.DTO.SecurityDto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterUserDto extends  LoginDto{
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
}
