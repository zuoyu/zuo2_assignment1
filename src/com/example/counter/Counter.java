package com.example.counter;

import java.util.Date;


public class Counter
{
	protected String text;
	protected int number;
	protected Date timestamp;
	public Counter(String text, int number)
	{
		super();
		this.text = text;
		this.number = number;
	}
	public Counter(String text, int number, Date timestamp)
	{
		super();
		this.timestamp = timestamp;
		this.text = text;
		this.number = number;
	}
	public Date getTimestamp()
	{
	
		return timestamp;
	}
	public void setTimestamp(Date timestamp){
		this.timestamp = timestamp;
	}
	
	
	public void setText(String text){
		this.text = text;
	}
	public String getText()
	{
	
		return text;
	}
	
	public int getNumber()
	{
	
		return number;
	}
	public void setNumber(int number){
		this.number = number;
	}
	public void addNumber(){
		number++;
	}
	

}
