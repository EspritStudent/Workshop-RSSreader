/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rssreaderapplication;

/**
 *
 * The entity
 */
public class Event {
    private String title;
    private String description;
    private String link;

    public Event() {
    }

    public Event(String title, String description, String link) {
        this.title = title;
        this.description = description;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Event{" + "title=" + title + ", description=" + description + ", link=" + link + '}';
    }
    
    
    
}
