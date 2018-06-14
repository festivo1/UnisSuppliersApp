package com.utsicom.webapp.service;

import com.utsicom.webapp.dto.UserDTO;
import com.utsicom.webapp.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService , GenericService<User>{

    User findByEmail(String email);

   
}

