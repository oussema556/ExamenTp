package com.example.TP.services;


import com.example.TP.dao.EmployeRepo;
import com.example.TP.entities.Employe;
import com.example.TP.entities.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
@Slf4j
public class EmployeService implements UserDetailsService {

    private final EmployeRepo employeRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public EmployeService(EmployeRepo employeRepo) {
        this.employeRepo = employeRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Objects.requireNonNull(username);
        Employe user = employeRepo.findUserWithName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;

    }

    public Employe saveUser(String username, String password, String confirmedPassword) {
        Employe appUser = new Employe();
        if (employeRepo.findUserWithName(username).isPresent() == true)
            throw new RuntimeException("User already exists");
        if (!password.equals(confirmedPassword))
            throw new RuntimeException("Please confirm your password");
        appUser.setUsername(username);
        //appUser.setEnabled(true);
        Set<Role> roles = new HashSet<Role>();
        roles.add(new Role(1, "USER"));
        appUser.setRoles(roles);

        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        employeRepo.save(appUser);
        return appUser;
    }

}
