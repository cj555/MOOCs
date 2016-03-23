package io.cj555.service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Service;

import io.cj555.entity.Item;
import io.cj555.exception.RssException;
import io.cj555.rss.ObjectFactory;
import io.cj555.rss.TRss;
import io.cj555.rss.TRssChannel;
import io.cj555.rss.TRssItem;

@Service
public class RssService {
	
	public List<Item> getItems(File file) throws RssException{
		
		return getItems(new StreamSource(file));
		
	}
	
	
	public List<Item> getItems(String url) throws RssException{
		
		return getItems(new StreamSource(url));
		
	}
	
	
	private List<Item> getItems(Source source) throws RssException {
		
		List<Item> list = new ArrayList<Item>();
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			JAXBElement<TRss> jAXBElement = unmarshaller.unmarshal(source, TRss.class);
			TRss rss = jAXBElement.getValue();
			List<TRssChannel> channels = rss.getChannel();
			
			
			
			for (TRssChannel channel : channels) {
				List<TRssItem> items = channel.getItem();
				for (TRssItem rssItem : items) {
					Item item = new Item();
					item.setTitle(rssItem.getTitle());
					item.setDescription(rssItem.getDescription());
					item.setLink(rssItem.getLink());
					Date pubDate = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH)
							.parse(rssItem.getPubDate());
					item.setPublishedDate(pubDate);
					list.add(item);
				}

			}

		} catch (JAXBException e) {
			throw new RssException(e);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		

	}

}
