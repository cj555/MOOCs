package io.cj555.service;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import io.cj555.entity.Blog;
import io.cj555.entity.Item;
import io.cj555.entity.Role;
import io.cj555.entity.User;
import io.cj555.repository.BlogRepository;
import io.cj555.repository.ItemRepository;
import io.cj555.repository.RoleRepository;
import io.cj555.repository.UserRepository;

@Service
@Transactional
public class InitDbService {

	@Autowired 
	private RoleRepository roleRepository;
	
	@Autowired 
	private BlogRepository blogRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	
	@Autowired 
	private ItemRepository itemRepository;
	
	
	@PostConstruct
	public void init(){
		
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		
		
		User userAdmin = new User();
		userAdmin.setName("admin");
		List<Role> roles = new ArrayList<Role>();
		
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		
		
		
		Blog blogQuantocracy = new Blog();
		blogQuantocracy.setName("Quantocracy");
		blogQuantocracy.setUrl("http://feeds.feedburner.com/Quantocracy?format=xml");
		blogQuantocracy.setUser(userAdmin);
		blogRepository.save(blogQuantocracy);
		
		
		Item item1 = new Item();
		item1.setBlog(blogQuantocracy);
		item1.setTitle("first");
		item1.setLink("http://www.quantocracy.com");
		item1.setPublishedData(new Date());
		itemRepository.save(item1);
		
		
		Item item2 = new Item();
		item2.setBlog(blogQuantocracy);
		item2.setTitle("second");
		item2.setLink("http://www.quantocracy.com");
		item2.setPublishedData(new Date());
		itemRepository.save(item2);
		
	
		
	}
	
	
}
