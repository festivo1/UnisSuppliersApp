package com.utsicom.webapp.service.impl;

import com.utsicom.webapp.dto.UserDTO;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.utsicom.webapp.model.Role;
import com.utsicom.webapp.model.User;
//import com.lfa.pritibhoj.repository.RoleRepository;
import com.utsicom.webapp.repository.UserRepository;
import com.utsicom.webapp.service.UserService;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class CustomUserServiceImpl extends GenericServiceImpl<User>implements UserService {

    @Autowired
    private UserRepository userRepository;
    private List<User> users;//used for caching
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
//        User user = new User();
//        user.setFirstName(registration.getFirstName());
//        user.setLastName(registration.getLastName());
//        user.setEmail(registration.getEmail());
//        user.setPassword(bCryptPasswordEncoder.encode(registration.getPassword()));
//        //user.setPhoto(registration.getPhoto());
//        //user.setRoles(new Role("USER_ROLE")));
//        return userRepository.save(user);
//    }
    
    
//    @Autowired
//    private DipoRepository dipoDAO;
    

    @Override
    public List<User> getAll() {
        if (users == null) {
            users = userRepository.findAll();
        }
        return users;
    }
     @Override
    public void saveOrUpdate(User user) {
        userRepository.save(user);
      
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<User> getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAllById(Iterable<Integer> id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

}