package com.RealProject.RealProject.Controller;

import com.RealProject.RealProject.DTOs.LoginReq;
import com.RealProject.RealProject.DTOs.RegisterReqDto;
import com.RealProject.RealProject.Model.Admin;
import com.RealProject.RealProject.Repository.AdminRepo;
import com.RealProject.RealProject.Services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AdminRepo adminRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;
    @Autowired
    private JwtService jwtService;

    public AuthController(AdminRepo adminRepo,PasswordEncoder passwordEncoder,
                          AuthenticationManager authManager){
        this.adminRepo=adminRepo;
        this.passwordEncoder=passwordEncoder;
        this.authManager=authManager;
    }
    @PostMapping("/register")
    public String register(@RequestBody RegisterReqDto req) {
        Admin admin = new Admin();

        admin.setUsername(req.getUsername());
        admin.setPassword(passwordEncoder.encode(req.getPassword()));

        if(adminRepo.findByUsername(admin.getUsername()).isEmpty()) {
            adminRepo.save(admin);
            return "User Reregisted Succesfully";
        }else{
            return "User Already Exists";
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginReq req){
        //Authenticate the User
        Authentication auth=authManager.authenticate(new
                UsernamePasswordAuthenticationToken(req.getUsername(),req.getPassword()));

        //If Correct ->Generate Token
        return jwtService.generateToken(req.getUsername());

    }


}