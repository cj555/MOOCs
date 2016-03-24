package io.cj555.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.cj555.entity.Blog;
import io.cj555.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer>{
	
	List<Blog> findByUser(User user);
	
}