package com.springpractice;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
public class Circle implements Shape , ApplicationEventPublisherAware {
	private Point center;
	private ApplicationEventPublisher publisher;
	@Autowired
	private MessageSource messagesource;
	
	public void setMessagesource(MessageSource messagesource) {
		this.messagesource = messagesource;
	}


	public void draw(){
		//System.out.println("Drawing Circle");
		System.out.println(this.messagesource.getMessage("drawing.circle", null ,"default message for drawing circle",null ));
		System.out.println(this.messagesource.getMessage("drawing.point", new Object[] {center.getX(),center.getY()},"default message for drawing center point",null ));
		//System.out.println("The center of the circle is:("+ center.getX() +"," + center.getY() +")");
	    //System.out.println(this.messagesource.getMessage("greeting", null ,"default greeting",null ));
		DrawEvent drawEvent = new DrawEvent(this);
		publisher.publishEvent(drawEvent);
	}


	public Point getCenter() {
		return center;
	}
    @Resource(name="point3")
	public void setCenter(Point center) {
		this.center = center;
	}
	
    @PostConstruct
    public void initializeCircle(){
    	System.out.println("Init of circle");
    }
    
    @PreDestroy
    public void destroyCircle(){
    	System.out.println("Destroy of circle");
    }


	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
		
	}
    
    
	
}
