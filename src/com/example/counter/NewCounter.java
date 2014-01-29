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

public class NewCounter extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_counter);
		
		String massage = "After you enter the name please click the check button to check the duplicate. Otherwise you will mess you data";
		Toast.makeText(NewCounter.this, massage, Toast.LENGTH_LONG).show();
		
		final Button backm = (Button) findViewById(R.id.bbb);
		backm.setOnClickListener(new mback());
		
		final Button listv = (Button) findViewById(R.id.delb);
		listv.setOnClickListener(new vlist());
				
		final Button addbutton = (Button)findViewById(R.id.addb);
		addbutton.setOnClickListener(new buttonadd());
		
		final Button checkbutton = (Button)findViewById(R.id.search);
		checkbutton.setOnClickListener(new buttoncheck());
		
	}
	
	class buttoncheck implements OnClickListener
	{
		String s = "";
		@Override
		public void onClick(View v)
		{
			Gson gson = new Gson();
			try{
				FileInputStream fis = openFileInput("file.txt");
				BufferedReader er = new BufferedReader(new InputStreamReader(fis));
				EditText username = (EditText)findViewById(R.id.nameed);
				String namei =  username.getText().toString();
				s= er.readLine();
				Log.v("PRNT JSON",s);
				
				while (s != null ){
					DataSaving data = gson.fromJson(s,DataSaving.class);
					String namej = data.getText();
					if (namej.equals(namei)){
						String massage = "There is a same counter's name in the record. if you want to keep adding please click add.";
						Toast.makeText(NewCounter.this, massage, Toast.LENGTH_LONG).show();
						break;	
					}else{
						String massage = "There is no any counter called "+namei+" in the record";
						Toast.makeText(NewCounter.this, massage, Toast.LENGTH_LONG).show();
					}
					s= er.readLine();
				}
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
		protected Date timestamp;

		@Override
		public void onClick(View v)
		{
			try{
				timestamp = new Date(System.currentTimeMillis());
				String emp = "";
				Date timeD =  timestamp;
				String time =  timestamp.toString();
				EditText username = (EditText)findViewById(R.id.nameed);
				String name =  username.getText().toString();
				if (name.equals(emp)){
					String massage = "please write a counter's name";
					Toast.makeText(NewCounter.this, massage, Toast.LENGTH_LONG).show();
				}else{
					TextView displays = (TextView)findViewById(R.id.display);
					DataSaving obj = new DataSaving(name,timeD);
				
				
					String record = name + "|" + time+"\n";
					displays.setText(record);
				
					FileOutputStream fos = openFileOutput("file.txt",Context.MODE_APPEND);
				
					Gson gson = new Gson();
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

}
