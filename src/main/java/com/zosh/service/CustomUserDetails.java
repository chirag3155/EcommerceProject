package com.zosh.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zosh.modal.User;
import com.zosh.repository.UserRepository;
import com.zosh.user.domain.UserRole;

@Service
public class CustomUserDetails implements UserDetailsService {
	
	private UserRepository userRepository;
	
	public CustomUserDetails(UserRepository userRepository) {
		this.userRepository=userRepository;
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(username);
		 
		if(user == null) {
			throw new UsernameNotFoundException("user not found with email "+username);
		}
		
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		 
		        // Make sure your Role class implements GrantedAuthority
		UserRole userRole = user.getRole();
        authorities.add(new SimpleGrantedAuthority(userRole.name()));
		    
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
