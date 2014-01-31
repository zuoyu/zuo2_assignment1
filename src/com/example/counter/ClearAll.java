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

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.example.counter.ViewList.backr;
import com.example.counter.ViewList.allclear;

public class ClearAll extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clear_all);
		
		final Button backm = (Button) findViewById(R.id.backr);
		backm.setOnClickListener(new mback());
		
		final Button clearfile = (Button) findViewById(R.id.result);
		clearfile.setOnClickListener(new fileclear());
		
	}
	class fileclear implements OnClickListener
	{

		@Override
		 public void onClick(View v) 

        { 
			// here is the button to click to clean all the data in my file.

			String s = "";
			ArrayList<DataSaving> mydata = new ArrayList<DataSaving>();
			Gson gson = new Gson();
			// get data from the file.txt.
			try{
				FileInputStream fis = openFileInput("file.txt");
				BufferedReader er = new BufferedReader(new InputStreamReader(fis));
				s= er.readLine();
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
					Toast.makeText(ClearAll.this, massage, Toast.LENGTH_LONG).show();
					
					Intent backbotton = new Intent();
					backbotton.setClass(ClearAll.this,NewCounter.class);
					ClearAll.this.startActivity(backbotton);
					
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
	class mback implements OnClickListener
	{
		// here is the button to click to go back to ViewList activity

		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			Intent backbotton = new Intent();
			backbotton.setClass(ClearAll.this,ViewList.class);
			ClearAll.this.startActivity(backbotton);
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.clear_all, menu);
		return true;
	}

	/**
	 * @uml.property  name="backr"
	 * @uml.associationEnd  inverse="clearAll:com.example.counter.ViewList.backr"
	 */
	private backr backr;

	/**
	 * Getter of the property <tt>backr</tt>
	 * @return  Returns the backr.
	 * @uml.property  name="backr"
	 */
	public backr getBackr()
	
	{
	
		return backr;
	}

	/**
	 * Setter of the property <tt>backr</tt>
	 * @param backr  The backr to set.
	 * @uml.property  name="backr"
	 */
	public void setBackr(backr backr)
	
	{
	
		this.backr = backr;
	}

	/**
	 * @uml.property  name="allclear"
	 * @uml.associationEnd  inverse="clearAll:com.example.counter.ViewList.allclear"
	 */
	private allclear allclear;

	/**
	 * Getter of the property <tt>allclear</tt>
	 * @return  Returns the allclear.
	 * @uml.property  name="allclear"
	 */
	public allclear getAllclear()
	{

		return allclear;
	}

	/**
	 * Setter of the property <tt>allclear</tt>
	 * @param allclear  The allclear to set.
	 * @uml.property  name="allclear"
	 */
	public void setAllclear(allclear allclear)
	{

		this.allclear = allclear;
	}

}
