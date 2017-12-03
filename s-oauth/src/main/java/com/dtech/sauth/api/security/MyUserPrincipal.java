package com.dtech.sauth.api.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dtech.sauth.api.entity.Roles;
import com.dtech.sauth.api.entity.User;

public class MyUserPrincipal implements UserDetails {

    private static final long serialVersionUID = 1L;

    private final User user;

    //

    public MyUserPrincipal(User user) {
        this.user = user;
    }

    //

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        Set<Roles> roles = user.getRoles();
		for (Roles roles2 : roles) {
			GrantedAuthority ga = new SimpleGrantedAuthority(roles2.getRole());
			authorities.add(ga);
		}
        return authorities;
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

    //

    public User getUser() {
        return user;
    }

}
