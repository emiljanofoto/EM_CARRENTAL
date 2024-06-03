package Project.EM_CarRental.Controller;


import Project.EM_CarRental.DTO.CreditCardDTO;
import Project.EM_CarRental.DTO.UserDTO;
import Project.EM_CarRental.Entities.Role;
import Project.EM_CarRental.Entities.User;
import Project.EM_CarRental.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @PutMapping("/users/{id}")
    public User editUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.editUser(id, userDTO);

    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/roles")
    public Role saveRole(@RequestBody Role role) {
        return userService.saveRole(role);
    }

    @DeleteMapping("/users/{username}/role/{roleName}")
    public void deleteRole(@PathVariable String username, @PathVariable String roleName) {
        userService.removeRoleFromUser(username, roleName);

    }

    @PutMapping("/users/{username}/roles")
    public User addRoleToUser(@PathVariable String username, @RequestBody String roleName) {
        return userService.addRoleToUser(username, roleName);

    }

    @PutMapping("/users/{username}/creditCards")
    public User addCreditCardToUser(@PathVariable String username, @RequestBody CreditCardDTO creditCardDto) {
        return userService.addCreditCardToUser(username, creditCardDto);
    }

    @DeleteMapping("/users/{username}/creditCards")
    public void deleteUserCreditCard(@PathVariable String username) {
        userService.deleteCreditCardFromUser(username);
    }



}
