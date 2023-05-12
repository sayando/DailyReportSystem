package com.techacademy.service;

import java.util.Optional;

//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.techacademy.entity.Authentication;
import com.techacademy.repository.AuthenticationRepository;
/*
@Service
public class EmployeeDetailService implements EmployeeDetailsService {
    private final AuthenticationRepository authenticationRepository;

    public EmployeeDetailService(AuthenticationRepository repository) {
        this.authenticationRepository = repository;
    }

    @Override
    public EmployeeDetails loadUserByEmployeename(String employeename) throws EmployeenameNotFoundException {
        Optional<Authentication> authentication = authenticationRepository.findById(username);

        if (!authentication.isPresent()) {
            throw new EmployeenameNotFoundException("Exception:Employeename Not Found");
        }
        return new UserDetail(authentication.get().getUser());
    }
}*/