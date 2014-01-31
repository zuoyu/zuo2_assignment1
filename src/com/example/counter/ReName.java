package com.example.counter;


import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.example.counter.ViewList.vrename;

public class ReName extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_re_name);
		
		final Button backr = (Button) findViewById(R.id.result);
		backr.setOnClickListener(new rback());
		
		final Button rebutton = (Button)findViewById(R.id.rename);
		rebutton.setOnClickListener(new buttonre());
		
		
	}
	
	
	class buttonre implements OnClickListener
	{

		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			String s = "";
			ArrayList<DataSaving> myItem = new ArrayList<DataSaving>();
			
			EditText oldname = (EditText)findViewById(R.id.editoldname);
			String nameold =  oldname.getText().toString();
			
			EditText newname = (EditText)findViewById(R.id.editnewname);
			String namenew =  newname.getText().toString();
			
			Gson gson = new Gson();
			try{
				FileInputStream fis = openFileInput("file.txt");
				BufferedReader er = new BufferedReader(new InputStreamReader(fis));
				s= er.readLine();
				Log.v("PRNT JSON",s);
				
				while (s != null ){
					DataSaving data = gson.fromJson(s,DataSaving.class);
					String name = data.getText();
					if (name.equals(nameold)){
						data.setText(namenew);
					}
					myItem.add(data);
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
				
				int length = myItem.size();
				for(int i = 0; i< length;i++){
					fas.write(gson.toJson(myItem.get(i)).getBytes());
					fas.write("\n".getBytes());
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
			backbotton.setClass(ReName.this,ViewList.class);
			ReName.this.startActivity(backbotton);
			
		}
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.re_name, menu);
		return true;
	}


	/**
	 * @uml.property  name="vrename"
	 * @uml.associationEnd  inverse="reName:com.example.counter.ViewList.vrename"
	 */
	private vrename vrename;


	/**
	 * Getter of the property <tt>vrename</tt>
	 * @return  Returns the vrename.
	 * @uml.property  name="vrename"
	 */
	public vrename getVrename()
	{

		return vrename;
	}


	/**
	 * Setter of the property <tt>vrename</tt>
	 * @param vrename  The vrename to set.
	 * @uml.property  name="vrename"
	 */
	public void setVrename(vrename vrename)
	{

		this.vrename = vrename;
	}

}
