package Project.EM_CarRental.Mapper;

import Project.EM_CarRental.DTO.UserDTO;
import Project.EM_CarRental.Entities.User;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDTOMapper {

    public static List<UserDTO> mapUserToUserDTO(List<User> users) {
        return users.stream()
                .map(user -> new UserDTO(user.getId(), user.getName(),
                        user.getLastname(), user.getUsername(), user.getPassword(),
                        user.getEmail(), user.getPhone())).collect(Collectors.toList());
    }

    public static User mapToUser(UserDTO userDTO) {

        return User.builder()
                .name(userDTO.getName())
                .lastname(userDTO.getLastName())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .phone(userDTO.getPhone())
                .roles(new ArrayList<>())
                .build();
    }
}
