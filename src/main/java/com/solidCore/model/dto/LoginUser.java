package com.solidCore.model.dto;

import com.solidCore.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @projectName: CBlog
 * @package: com.cts.model.dto
 * @className: LoginUser
 * @author: chentongsheng
 * @description: TODO
 * @date: 2023/2/20 20:51
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"username","password","authorities","accountNonExpired","accountNonLocked","credentialsNonExpired","enabled"})
public class LoginUser implements UserDetails {

    private User user;

    public LoginUser(User user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
