package com.zosh.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.modal.User;
import com.zosh.user.domain.UserRole;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmail(String email);

//	public User findByRole(UserRole roleAdmin);

	public User findByRole(UserRole roleAdmin);

}
