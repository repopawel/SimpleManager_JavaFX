/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleManager;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author PLRAD2SIU
 */
public class EventsList {
    private String data;
    private String event;
    private String enddate;
    private String expires;
    private String ok;
    private Integer id;

    public EventsList(String data, String event, String enddate, String expires, String ok, Integer id) {
        this.data = data;
        this.event = event;
        this.enddate = enddate;
        this.expires = expires;
        this.ok = ok;
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
   
    
  
    

    
    
    
    
    
    
}
