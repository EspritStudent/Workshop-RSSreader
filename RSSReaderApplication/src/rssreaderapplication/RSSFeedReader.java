/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rssreaderapplication;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 * It Reads and prints any RSS feed type.
 */
public class RSSFeedReader {
 
    private String baseUrl="http://services.rice.edu/events/dailyevents.cfm";

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String url) {
        this.baseUrl = url;
    }
    
    public List<Event> getItems(String url) {
        System.out.println(url);
        List<Event> events=new ArrayList<Event>();
       
        try {
            URL feedUrl = new URL(url);
            
            /* SyndFeedInput: parser to process RSS feeds into SyndFeed instance*/
            SyndFeedInput input = new SyndFeedInput();
            
            /* Load the RSS feed
             * XmlReader: reading an XML document
             * SyndFeed: rss feed
             */
            SyndFeed feed = input.build(new XmlReader(feedUrl));
          
            System.out.println("Feed Author: "+ feed.getAuthor());
            System.out.println("Feed Title: "+ feed.getTitle());
            System.out.println("Feed Description: "+ feed.getDescription());
            System.out.println("Feed Version: "+ feed.getFeedType());
            // Iterate through feed items, display each item title
            Iterator entryIter = feed.getEntries().iterator();
            while (entryIter.hasNext())
            {
                SyndEntry entry = (SyndEntry) entryIter.next();
                Event event=new Event(entry.getTitle(),entry.getDescription().getValue(),entry.getLink());
                events.add(event);
            }         
           
        } catch (IOException ex) {
                Logger.getLogger(RSSFeedReader.class.getName()).log(Level.SEVERE, null, ex);    
        } catch (IllegalArgumentException ex) {
                Logger.getLogger(RSSFeedReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FeedException ex) {
                Logger.getLogger(RSSFeedReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return events;
    }
}