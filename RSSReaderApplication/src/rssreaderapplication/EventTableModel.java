/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rssreaderapplication;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * The table model
 */
public class EventTableModel extends AbstractTableModel{

    String url;
    RSSFeedReader rssFeed=new RSSFeedReader();
       
    List<Event> events;
    String[] titles={"Event","Description","Link"}; 
    
    public EventTableModel(String url) {     
        this.url = url;
        events=rssFeed.getItems(url);
    }

    @Override
    public int getRowCount() {
       return events.size();
    }

    @Override
    public int getColumnCount() {
        return titles.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Event event=events.get(rowIndex);
        if(columnIndex==0){
            return event.getTitle();
        }else if(columnIndex==1){
            return event.getDescription();
        }else{
            return event.getLink();
        }
    }

    @Override
    public String getColumnName(int column) {
        return titles[column];
    }
    
    
    
}
