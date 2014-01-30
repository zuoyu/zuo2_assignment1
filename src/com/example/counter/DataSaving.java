package com.example.counter;

import java.util.Date;

/**
 * @author  zuo2
 */
public class DataSaving
{
	protected String text;
	protected Date timestamp;
	public DataSaving(String text, Date timestamp)
	{
		super();
		this.text = text;
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
	 * @uml.property  name="timestamp"
	 */
	public Date getTimestamp()
	{
	
		return timestamp;
	}
	

}
