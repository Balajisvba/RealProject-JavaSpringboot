package com.RealProject.RealProject.Services;

import com.RealProject.RealProject.Model.Admin;
import com.RealProject.RealProject.Repository.AdminRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final AdminRepo adminRepo;
    public CustomUserDetailsService(AdminRepo adminRepo){
        this.adminRepo=adminRepo;
    }
    @Override
    public UserDetails loadUserByUsername(String username){
        Admin admin=adminRepo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User Not Found"));

        return User.builder()
                .username(admin.getUsername())
                .password(admin.getPassword())
                .build();

    }
}
