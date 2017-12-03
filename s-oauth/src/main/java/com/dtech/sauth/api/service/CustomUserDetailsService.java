package com.dtech.sauth.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dtech.sauth.api.entity.User;
import com.dtech.sauth.api.security.MyUserPrincipal;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    private UserService userService;

    public CustomUserDetailsService() {
        super();
    }

    @Override
    public UserDetails loadUserByUsername(final String username) {
        final User user = userService.get(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);
    }

}
