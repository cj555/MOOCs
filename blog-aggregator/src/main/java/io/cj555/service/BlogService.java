package io.cj555.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import io.cj555.entity.Blog;
import io.cj555.entity.Item;
import io.cj555.entity.User;
import io.cj555.exception.RssException;
import io.cj555.repository.BlogRepository;
import io.cj555.repository.ItemRepository;
import io.cj555.repository.UserRepository;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RssService rssService;

	@Autowired
	private ItemRepository itemRepository;

	public void saveItems(Blog blog) {
		try {
			List<Item> items = rssService.getItems(blog.getUrl());
			for (Item item : items) {
				Item savedItem = itemRepository.findByBlogAndLink(blog, item.getLink());
				if(savedItem == null) {
					item.setBlog(blog);
					itemRepository.save(item);
				}
			}
		} catch (RssException e) {
			e.printStackTrace();
		}
	}

	public void saveBlog(Blog blog, String name) {
		// TODO Auto-generated method stub
		User user = userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
		saveItems(blog);

	}

	public Blog findOne(int id) {

		return blogRepository.findOne(id);

	}

	@PreAuthorize("#blog.user==authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog") Blog blog) {
		blogRepository.delete(blog);

	}

}
