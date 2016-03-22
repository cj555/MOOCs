package io.cj555.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.cj555.entity.Blog;
import io.cj555.entity.User;
import io.cj555.repository.BlogRepository;
import io.cj555.repository.UserRepository;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private UserRepository userRepository;

	public void saveBlog(Blog blog, String name) {
		// TODO Auto-generated method stub
		User user = userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);

	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		blogRepository.delete(id);
		
	}

}
