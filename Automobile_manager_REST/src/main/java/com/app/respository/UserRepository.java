package com.app.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entiites.User;

public  interface  UserRepository extends JpaRepository<User, Long>  {
	User findByUserName(String userName);

}
