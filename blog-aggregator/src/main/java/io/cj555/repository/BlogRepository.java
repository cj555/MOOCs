package io.cj555.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.cj555.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer>{



}