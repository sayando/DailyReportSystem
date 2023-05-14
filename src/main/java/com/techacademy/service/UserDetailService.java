/*package com.techacademy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.techacademy.entity.Authentication;
import com.techacademy.entity.Employee;
import com.techacademy.repository.AuthenticationRepository;
import com.techacademy.repository.EmployeeRepository;

@Service
public class UserDetailService implements UserDetailsService {
    private final AuthenticationRepository authenticationRepository;
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    

    @Autowired
    public UserDetailService(AuthenticationRepository authenticationRepository, 
                                  EmployeeRepository employeeRepository, 
                                  PasswordEncoder passwordEncoder) {
        this.authenticationRepository = authenticationRepository;
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Optional<Authentication> authentication = authenticationRepository.findById(Integer.parseInt(id));

        if (!authentication.isPresent()) {
            throw new UsernameNotFoundException("User not found with id: " + id);
        }

        Employee employee = authentication.get().getEmployee();
        
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(authentication.get().getRole().toString()));

        return new org.springframework.security.core.userdetails.User(
                employee.getId(),
                passwordEncoder.encode(employee.getPassword()),
                authorities
        );
    }
}*/
