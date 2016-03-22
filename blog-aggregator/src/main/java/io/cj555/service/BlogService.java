package io.cj555.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
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



	public Blog findOne(int id) {
		
		return blogRepository.findOne(id);
		
	}

	@PreAuthorize("#blog.user==authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog") Blog blog) {
		blogRepository.delete(blog);
		
	}

}
