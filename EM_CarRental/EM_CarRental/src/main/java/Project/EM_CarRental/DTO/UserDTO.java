package Project.EM_CarRental.DTO;


import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private String name;
    private String lastName;
    private String email;
    private String phone;


}
