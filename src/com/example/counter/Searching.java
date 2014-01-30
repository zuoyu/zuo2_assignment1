package com.example.counter;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

public class Searching extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_searching);
		
		final Button backr = (Button) findViewById(R.id.back11);
		backr.setOnClickListener(new rback());
		
		final Button perhour = (Button) findViewById(R.id.hour);
		perhour.setOnClickListener(new hourper());
		
		final Button perweek = (Button) findViewById(R.id.week1);
		perweek.setOnClickListener(new weekper());
		
		final Button permonth = (Button) findViewById(R.id.month1);
		permonth.setOnClickListener(new monthper());
		
		final Button perday = (Button) findViewById(R.id.day);
		perday.setOnClickListener(new dayper());
	}
	
	class dayper implements OnClickListener
	{
		
		@Override
		public void onClick(View v)
		{
			
			// TODO Auto-generated method stub
			
			String emp = "";
			EditText username = (EditText)findViewById(R.id.edname);
			String name =  username.getText().toString();
			if (name.equals(emp)){
				String massage = "please write a counter's name";
				Toast.makeText(Searching.this, massage, Toast.LENGTH_LONG).show();
			}else{
				Intent backbotton = new Intent();
				backbotton.setClass(Searching.this,PerDay.class);
				Searching.this.startActivity(backbotton);
				
				Intent passCname = new Intent(Searching.this, PerDay.class);
                passCname.putExtra("text", name);
                startActivity(passCname);
			}
		}
		
	}
	class monthper implements OnClickListener
	{
		
		@Override
		public void onClick(View v)
		{

			// TODO Auto-generated method stub
			
			
			String emp = "";
			EditText username = (EditText)findViewById(R.id.edname);
			String name =  username.getText().toString();
			if (name.equals(emp)){
				String massage = "please write a counter's name";
				Toast.makeText(Searching.this, massage, Toast.LENGTH_LONG).show();
			}else{
				Intent backbotton = new Intent();
				backbotton.setClass(Searching.this,PerMonth.class);
				Searching.this.startActivity(backbotton);
				
				Intent passCname = new Intent(Searching.this, PerMonth.class);
                passCname.putExtra("text", name);
                startActivity(passCname);
			}
		}
		
	}
	
	class weekper implements OnClickListener
	{
		
		@Override
		public void onClick(View v)
		{

			// TODO Auto-generated method stub
			
			String emp = "";
			EditText username = (EditText)findViewById(R.id.edname);
			String name =  username.getText().toString();
			if (name.equals(emp)){
				String massage = "please write a counter's name";
				Toast.makeText(Searching.this, massage, Toast.LENGTH_LONG).show();
			}else{
				Intent backbotton = new Intent();
				backbotton.setClass(Searching.this,PerWeek.class);
				Searching.this.startActivity(backbotton);
				
				Intent passCname = new Intent(Searching.this, PerWeek.class);
                passCname.putExtra("text", name);
                startActivity(passCname);
			}
		}
		
	}
	
	class hourper implements OnClickListener
	{
		
		@Override
		public void onClick(View v)
		{

			// TODO Auto-generated method stub
			
			
			String emp = "";
			EditText username = (EditText)findViewById(R.id.edname);
			String name =  username.getText().toString();
			if (name.equals(emp)){
				String massage = "please write a counter's name";
				Toast.makeText(Searching.this, massage, Toast.LENGTH_LONG).show();
			}else{
				Intent backbotton = new Intent();
				backbotton.setClass(Searching.this,PerHour.class);
				Searching.this.startActivity(backbotton);
				
				Intent passCname = new Intent(Searching.this, PerHour.class);
                passCname.putExtra("text", name);
                startActivity(passCname);
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
			backbotton.setClass(Searching.this,ResultView.class);
			Searching.this.startActivity(backbotton);
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.searching, menu);
		return true;
	}

}
