package com.example.counter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.counter.MainActivity.counternew;

public class NewCounter extends 
MainActivity
{
	public int click1 = 0; 

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_counter);
		
		final Button backm = (Button) findViewById(R.id.bbb);
		backm.setOnClickListener(new mback());
		
		final Button listv = (Button) findViewById(R.id.delb);
		listv.setOnClickListener(new vlist());
				

		Button checkbutton = (Button)findViewById(R.id.search);
		checkbutton.setOnClickListener(new buttoncheck());
		
		Button addbutton = (Button)findViewById(R.id.addb);

		
		Button resetbutton = (Button)findViewById(R.id.reset);

		addbutton.setOnClickListener(new buttonadd());
		resetbutton.setOnClickListener(new buttonreset());

	}
	
	class buttoncheck implements OnClickListener
	{
		String s = "";
		boolean che;
		@Override
		public void onClick(View v)
		{
			// it will check the is there have same name in the data file then can tell user the result.
			Gson gson = new Gson();
			try{
				FileInputStream fis = openFileInput("file.txt");
				BufferedReader er = new BufferedReader(new InputStreamReader(fis));
				EditText username = (EditText)findViewById(R.id.nameed);
				String namei =  username.getText().toString();
				s= er.readLine();
				
				
				while (s != null ){
					DataSaving data = gson.fromJson(s,DataSaving.class);
					String namej = data.getText();
					if (namej.equals(namei)){
						che = true;
						break;	
					}else{
						che = false;
					}
					s= er.readLine();
				}
				if(che == true){
					String massage = "There is a same counter's name in the record. if you want to keep adding please click add.";
					Toast.makeText(NewCounter.this, massage, Toast.LENGTH_LONG).show();
				}else{
					String massage = "There is no any counter called "+namei+" in the record";
					Toast.makeText(NewCounter.this, massage, Toast.LENGTH_LONG).show();
				}
				click1 = 1;
			}catch (FileNotFoundException e) {
				// TODO: handle exception
				String massage = "No record!!";
				Toast.makeText(NewCounter.this, massage, Toast.LENGTH_LONG).show();
				e.printStackTrace();
			}catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
	
	class buttonadd implements OnClickListener
	{
		//add the date when you click and your user name into the data file 
		protected Date timestamp;
		int countrecord = 0;

		@Override
		public void onClick(View v)
		{
			if(click1 == 1){
				TextView displays = (TextView)findViewById(R.id.textView1);
				String record = "you clicked"+countrecord+"\n";
				displays.setText(record);
				try{
					timestamp = new Date(System.currentTimeMillis());
					String emp = "";
					Date timeD =  timestamp;
					EditText username = (EditText)findViewById(R.id.nameed);
					String name =  username.getText().toString();
					if (name.equals(emp)){
						String massage = "please write a counter's name";
						Toast.makeText(NewCounter.this, massage, Toast.LENGTH_LONG).show();
					}else{
						countrecord++;
						displays = (TextView)findViewById(R.id.textView1);
						DataSaving obj = new DataSaving(name,timeD);
					
					
						record = "you clicked"+countrecord+"\n";
						displays.setText(record);
					
						FileOutputStream fos = openFileOutput("file.txt",Context.MODE_APPEND);
					
						Gson gson = new Gson();
						//using Gson to save and put it in to file.txt. then next time I can just open file.txt to get my data
						String json =  gson.toJson(obj);
					
						fos.write(json.getBytes());
						fos.write("\n".getBytes());
						Log.v("JSON======",json);
						fos.close();
					}
				}catch (FileNotFoundException e){
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else{
				String massage = "please check you name first";
				Toast.makeText(NewCounter.this, massage, Toast.LENGTH_LONG).show();
			}
			
		}
			
		
	}
	
	class buttonreset implements OnClickListener
	{
		int renumber = 0;

		@Override
		public void onClick(View v)
		{
			
			// TODO Auto-generated method stub
			if(click1 == 1){
				TextView displays = (TextView)findViewById(R.id.textView1);
				String record = "you clicked"+renumber+"\n";
				displays.setText(record);
				String s = "";
				String a = "haha";
				ArrayList<DataSaving> mydata = new ArrayList<DataSaving>();
				
				EditText oldname = (EditText)findViewById(R.id.nameed);
				String nameold =  oldname.getText().toString();
				
				Gson gson = new Gson();
				// get data from the file.txt.
				try{
					FileInputStream fis = openFileInput("file.txt");
					BufferedReader er = new BufferedReader(new InputStreamReader(fis));
					s= er.readLine();
					Log.v("PRNT JSON",s);
					
					while (s != null ){
						DataSaving data = gson.fromJson(s,DataSaving.class);
						String name = data.getText();
						if (name.equals(nameold)){
							a = "haha";
						}else{
							mydata.add(data);
						}
						s= er.readLine();
					}
				}catch (FileNotFoundException e) {
					// TODO: handle exception
					e.printStackTrace();
				}catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				try{
					FileOutputStream fas = openFileOutput("file.txt",Context.MODE_PRIVATE);
					
					int length = mydata.size();
					for(int i = 0; i< length;i++){
						fas.write(gson.toJson(mydata.get(i)).getBytes());
						fas.write("\n".getBytes());
					}
					if(length == 0)
					{
						String ggg = "";
						fas.write(ggg.getBytes());
						
						String massage = "Your counter are cleaned";
						Toast.makeText(NewCounter.this, massage, Toast.LENGTH_LONG).show();
						
					}else{
						String massage = "Your counter are cleaned";
						Toast.makeText(NewCounter.this, massage, Toast.LENGTH_LONG).show();
					}
					fas.close();
				}catch (FileNotFoundException e) {
					// TODO: handle exception
					e.printStackTrace();
				}catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else{
				String massage = "please check you name first";
				Toast.makeText(NewCounter.this, massage, Toast.LENGTH_LONG).show();
			}
			
			
		}
		
	}
	class mback implements OnClickListener
	{

		@Override
		public void onClick(View v)
		{
			Intent backbotton = new Intent();
			backbotton.setClass(NewCounter.this,MainActivity.class);
			NewCounter.this.startActivity(backbotton);
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class vlist implements OnClickListener
	{
		ArrayList<String> record = new ArrayList<String>();
		String s ="";
		int a =0;
		@Override
		public void onClick(View v)
		{
			try{
				FileInputStream fis = openFileInput("file.txt");
				BufferedReader er = new BufferedReader(new InputStreamReader(fis));
				s= er.readLine();
				if(s==null){
					String massage = "There is no counter in the history, please at least one counter";
					Toast.makeText(NewCounter.this, massage, Toast.LENGTH_LONG).show();
				}else{
						Intent backbotton = new Intent();
						backbotton.setClass(NewCounter.this,ViewList.class);
						NewCounter.this.startActivity(backbotton);
				}
			}catch (FileNotFoundException e) {
				// TODO: handle exception
				String massage = "No record in the ViewList";
				Toast.makeText(NewCounter.this, massage, Toast.LENGTH_LONG).show();
				e.printStackTrace();
			}catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			
		}
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_counter, menu);
		return true;
	}



	/**
	 * @uml.property  name="searching"
	 * @uml.associationEnd  inverse="newCounter:com.example.counter.Searching"
	 */
	private Searching searching;

	/**
	 * Getter of the property <tt>searching</tt>
	 * @return  Returns the searching.
	 * @uml.property  name="searching"
	 */
	public Searching getSearching()
	
	
	
	
	
	{
	
		return searching;
	}



	/**
	 * Setter of the property <tt>searching</tt>
	 * @param searching  The searching to set.
	 * @uml.property  name="searching"
	 */
	public void setSearching(Searching searching)
	
	
	
	
	
	{
	
		this.searching = searching;
	}



	/**
	 * @uml.property  name="mainActivity"
	 * @uml.associationEnd  inverse="newCounter:com.example.counter.MainActivity"
	 */
	private MainActivity mainActivity;

	/**
	 * Getter of the property <tt>mainActivity</tt>
	 * @return  Returns the mainActivity.
	 * @uml.property  name="mainActivity"
	 */
	public MainActivity getMainActivity()
	
	
	
	{
	
		return mainActivity;
	}



	/**
	 * Setter of the property <tt>mainActivity</tt>
	 * @param mainActivity  The mainActivity to set.
	 * @uml.property  name="mainActivity"
	 */
	public void setMainActivity(MainActivity mainActivity)
	
	
	
	{
	
		this.mainActivity = mainActivity;
	}



	/**
	 * @uml.property  name="viewList"
	 * @uml.associationEnd  inverse="newCounter:com.example.counter.ViewList"
	 */
	private ViewList viewList;

	/**
	 * Getter of the property <tt>viewList</tt>
	 * @return  Returns the viewList.
	 * @uml.property  name="viewList"
	 */
	public ViewList getViewList()
	
	
	{
	
		return viewList;
	}



	/**
	 * Setter of the property <tt>viewList</tt>
	 * @param viewList  The viewList to set.
	 * @uml.property  name="viewList"
	 */
	public void setViewList(ViewList viewList)
	
	
	{
	
		this.viewList = viewList;
	}



	/**
	 * @uml.property  name="mainActivity1"
	 * @uml.associationEnd  inverse="newCounter1:com.example.counter.MainActivity"
	 */
	private MainActivity mainActivity1;

	/**
	 * Getter of the property <tt>mainActivity1</tt>
	 * @return  Returns the mainActivity1.
	 * @uml.property  name="mainActivity1"
	 */
	public MainActivity getMainActivity1()
	
	{
	
		return mainActivity1;
	}



	/**
	 * Setter of the property <tt>mainActivity1</tt>
	 * @param mainActivity1  The mainActivity1 to set.
	 * @uml.property  name="mainActivity1"
	 */
	public void setMainActivity1(MainActivity mainActivity1)
	
	{
	
		this.mainActivity1 = mainActivity1;
	}



	/**
	 * @uml.property  name="counternew"
	 * @uml.associationEnd  inverse="newCounter:com.example.counter.MainActivity.counternew"
	 */
	private counternew counternew;

	/**
	 * Getter of the property <tt>counternew</tt>
	 * @return  Returns the counternew.
	 * @uml.property  name="counternew"
	 */
	public counternew getCounternew()
	{

		return counternew;
	}



	/**
	 * Setter of the property <tt>counternew</tt>
	 * @param counternew  The counternew to set.
	 * @uml.property  name="counternew"
	 */
	public void setCounternew(counternew counternew)
	{

		this.counternew = counternew;
	}

}
