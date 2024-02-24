package com.zosh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.zosh.modal.User;
import com.zosh.repository.UserRepository;
import com.zosh.user.domain.UserRole;

@SpringBootApplication
public class ECommerceApplication {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

//	public void run(String...args) {
//		User adminAcc = userRepository.findByRole(UserRole.ROLE_ADMIN);
//		
//		if(null == adminAcc) {
//			User user = new User();
//			user.setEmail("admin@gmail.com");
//			user.setFirstName("admin");
//			user.setLastName("admin");
//			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
//			userRepository.save(user);
//		}
//	}
}
