package io.cj555.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.cj555.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByName(String name);


}