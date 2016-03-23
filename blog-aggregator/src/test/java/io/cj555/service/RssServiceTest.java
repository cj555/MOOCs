package io.cj555.service;

import static org.junit.Assert.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import io.cj555.entity.Item;
import io.cj555.exception.RssException;

public class RssServiceTest {

	private RssService rssService;

	@Before
	public void setUp() throws Exception {
		rssService = new RssService();
	}

	@Test
	public void testGetItemsFile() throws RssException {
		
		{
		List<Item> items = rssService.getItems(new File("test_rss/javavids.xml"));
		assertEquals(10, items.size());
		Item firstItem = items.get(0);
		for (Item item:items){
			
			System.out.println("title:"+ item.getTitle());
			System.out.println("Date:"+ new SimpleDateFormat("dd MM yyyy HH:mm:ss").format(firstItem.getPublishedDate()));
			
		}
		
		assertEquals("How to solve Source not found error during debug in Eclipse", firstItem.getTitle());
//		Sun, 22 Jun 2014 20:35:49 +0000
		assertEquals("23 06 2014 04:35:49", new SimpleDateFormat("dd MM yyyy HH:mm:ss").format(firstItem.getPublishedDate()));
		}
		{
			List<Item> items = rssService.getItems("http://feeds.feedburner.com/javavids?format=xml");
			for (Item item:items){
				
				System.out.println("title:"+ item.getTitle());
//				System.out.println("Date:"+ new SimpleDateFormat("dd MM yyyy HH:mm:ss").format(firstItem.getPublishedDate()));
				
			}
		}
		
		
		
		
	}

}
