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
import com.example.counter.ResultView.rsearch;

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

		/**
		 * @uml.property  name="perDay"
		 * @uml.associationEnd  inverse="dayper:com.example.counter.PerDay"
		 */
		private PerDay perDay;

		/**
		 * Getter of the property <tt>perDay</tt>
		 * @return  Returns the perDay.
		 * @uml.property  name="perDay"
		 */
		public PerDay getPerDay()
		
		
		
		{
		
			return perDay;
		}

		/**
		 * Setter of the property <tt>perDay</tt>
		 * @param perDay  The perDay to set.
		 * @uml.property  name="perDay"
		 */
		public void setPerDay(PerDay perDay)
		
		
		
		{
		
			this.perDay = perDay;
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

		/**
		 * @uml.property  name="perMonth"
		 * @uml.associationEnd  inverse="monthper:com.example.counter.PerMonth"
		 */
		private PerMonth perMonth;

		/**
		 * Getter of the property <tt>perMonth</tt>
		 * @return  Returns the perMonth.
		 * @uml.property  name="perMonth"
		 */
		public PerMonth getPerMonth()
		
		{
		
			return perMonth;
		}

		/**
		 * Setter of the property <tt>perMonth</tt>
		 * @param perMonth  The perMonth to set.
		 * @uml.property  name="perMonth"
		 */
		public void setPerMonth(PerMonth perMonth)
		
		{
		
			this.perMonth = perMonth;
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

		/**
		 * @uml.property  name="perWeek"
		 * @uml.associationEnd  inverse="weekper:com.example.counter.PerWeek"
		 */
		private PerWeek perWeek;

		/**
		 * Getter of the property <tt>perWeek</tt>
		 * @return  Returns the perWeek.
		 * @uml.property  name="perWeek"
		 */
		public PerWeek getPerWeek()
		{

			return perWeek;
		}

		/**
		 * Setter of the property <tt>perWeek</tt>
		 * @param perWeek  The perWeek to set.
		 * @uml.property  name="perWeek"
		 */
		public void setPerWeek(PerWeek perWeek)
		{

			this.perWeek = perWeek;
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

		/**
		 * @uml.property  name="perHour"
		 * @uml.associationEnd  inverse="hourper:com.example.counter.PerHour"
		 */
		private PerHour perHour;

		/**
		 * Getter of the property <tt>perHour</tt>
		 * @return  Returns the perHour.
		 * @uml.property  name="perHour"
		 */
		public PerHour getPerHour()
		
		
		{
		
			return perHour;
		}

		/**
		 * Setter of the property <tt>perHour</tt>
		 * @param perHour  The perHour to set.
		 * @uml.property  name="perHour"
		 */
		public void setPerHour(PerHour perHour)
		
		
		{
		
			this.perHour = perHour;
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

	/**
	 * @uml.property  name="newCounter"
	 * @uml.associationEnd  inverse="searching:com.example.counter.NewCounter"
	 */
	private NewCounter newCounter;

	/**
	 * Getter of the property <tt>newCounter</tt>
	 * @return  Returns the newCounter.
	 * @uml.property  name="newCounter"
	 */
	public NewCounter getNewCounter()
	
	
	
	
	
	{
	
		return newCounter;
	}

	/**
	 * Setter of the property <tt>newCounter</tt>
	 * @param newCounter  The newCounter to set.
	 * @uml.property  name="newCounter"
	 */
	public void setNewCounter(NewCounter newCounter)
	
	
	
	
	
	{
	
		this.newCounter = newCounter;
	}

	/**
	 * @uml.property  name="rsearch"
	 * @uml.associationEnd  inverse="searching:com.example.counter.ResultView.rsearch"
	 */
	private rsearch rsearch;

	/**
	 * Getter of the property <tt>rsearch</tt>
	 * @return  Returns the rsearch.
	 * @uml.property  name="rsearch"
	 */
	public rsearch getRsearch()
	
	
	
	
	{
	
		return rsearch;
	}

	/**
	 * Setter of the property <tt>rsearch</tt>
	 * @param rsearch  The rsearch to set.
	 * @uml.property  name="rsearch"
	 */
	public void setRsearch(rsearch rsearch)
	
	
	
	
	{
	
		this.rsearch = rsearch;
	}

}
