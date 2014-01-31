package com.example.counter;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
import android.widget.Toast;

public class RemoveCounter extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_remove_counter);
		final Button backr = (Button) findViewById(R.id.backr);
		backr.setOnClickListener(new rback());
		
		final Button rebutton = (Button) findViewById(R.id.result);
		rebutton.setOnClickListener(new buttonre());
	}
	
	class buttonre implements OnClickListener
	{
		//this is using the find a username and remove it.
		@Override
		public void onClick(View v)
		{
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
					
					String massage = "All counters are removed.";
					Toast.makeText(RemoveCounter.this, massage, Toast.LENGTH_LONG).show();
					
					Intent backbotton = new Intent();
					backbotton.setClass(RemoveCounter.this,NewCounter.class);
					RemoveCounter.this.startActivity(backbotton);
					
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
		}
	}
		
	
	class rback implements OnClickListener
	{

		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			Intent backbotton = new Intent();
			backbotton.setClass(RemoveCounter.this,ViewList.class);
			RemoveCounter.this.startActivity(backbotton);
			
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.remove_counter, menu);
		return true;
	}

}
