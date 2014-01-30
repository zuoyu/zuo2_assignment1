package com.example.counter;

import java.util.Date;


public class DataSaving
{
	//this is the class using to put information which what I want in to Json. 
	protected String text;
	protected Date timestamp;
	public DataSaving(String text, Date timestamp)
	{
		super();
		this.text = text;
		this.timestamp = timestamp;
	}

	public void setText(String text){
		this.text = text;
	}
	

	public String getText()
	{
	
		return text;
	}
	

	public Date getTimestamp()
	{
	
		return timestamp;
	}
	

}
