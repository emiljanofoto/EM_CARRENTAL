package Project.EM_CarRental.Service.SecurityService;


import Project.EM_CarRental.Entities.Role;
import Project.EM_CarRental.Entities.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class MyUserDetails implements UserDetails {

    private final User user;


    @Override
    public Collection< ?extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = (Set<Role>) user.getRoles();

        Set<SimpleGrantedAuthority> listOfAllAccess =  new HashSet<>();
        for(Role role : roles){
            listOfAllAccess.add(new SimpleGrantedAuthority(role.getRole()));
        }

        return listOfAllAccess;
    }


    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
