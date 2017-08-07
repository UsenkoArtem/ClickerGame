package com.clicker.security;

import com.clicker.model.User;
import com.clicker.model.UserRole;
import com.clicker.repository.UserRepository;
import com.clicker.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
     User user = userRepository.getUserByLogin(login);
     if(null == user){
         throw new UsernameNotFoundException("No present login: " + login);
     }else {
         List<String> userRoles = userRoleRepository.findUserRolesByUserLogin(login);

         return new UserDetailsImpl(user, userRoles);
     }
    }
}
