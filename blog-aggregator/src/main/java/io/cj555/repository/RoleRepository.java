package io.cj555.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import io.cj555.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByName(String name);

}