package com.ust.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.security.service.MyUser;
@Repository
public interface MyUserRepo extends JpaRepository<MyUser, Long>{
	Optional<MyUser> findByUsername(String username);
}
