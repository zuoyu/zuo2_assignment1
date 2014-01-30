package com.example.counter;

import java.util.Date;


/**
 * @author  zuo2
 */
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
	/**
	 * @return
	 * @uml.property  name="timestamp"
	 */
	public Date getTimestamp()
	{
	
		return timestamp;
	}
	/**
	 * @param timestamp
	 * @uml.property  name="timestamp"
	 */
	public void setTimestamp(Date timestamp){
		this.timestamp = timestamp;
	}
	
	
	/**
	 * @param text
	 * @uml.property  name="text"
	 */
	public void setText(String text){
		this.text = text;
	}
	/**
	 * @return
	 * @uml.property  name="text"
	 */
	public String getText()
	{
	
		return text;
	}
	
	/**
	 * @return
	 * @uml.property  name="number"
	 */
	public int getNumber()
	{
	
		return number;
	}
	/**
	 * @param number
	 * @uml.property  name="number"
	 */
	public void setNumber(int number){
		this.number = number;
	}
	public void addNumber(){
		number++;
	}
	

}
