package com.example.counter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Button newcounter = (Button) findViewById(R.id.bnew);
		newcounter.setOnClickListener(new counternew());
		
		final Button resultb = (Button) findViewById(R.id.result);
		resultb.setOnClickListener(new bresult());
			
	}
	
	class bresult implements OnClickListener
	{
		// here is the button to click to check the result list in my ResultView activity.
		@Override
		public void onClick(View v)
		{
			String s= "";
			try{
				FileInputStream fis = openFileInput("file.txt");
				BufferedReader er = new BufferedReader(new InputStreamReader(fis));
				s= er.readLine();
				if(s==null){
					String massage = "There is no counter in the history, please at least one counter";
					Toast.makeText(MainActivity.this, massage, Toast.LENGTH_LONG).show();
				}else{
					Intent newc = new Intent();
					newc.setClass(MainActivity.this, ResultView.class);
					MainActivity.this.startActivity(newc);
				}
			}catch (FileNotFoundException e) {
				// TODO: handle exception
				String massage = "No record in the Result list";
				Toast.makeText(MainActivity.this, massage, Toast.LENGTH_LONG).show();
				e.printStackTrace();
			}catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			
		}
	}

	
	class counternew implements OnClickListener
	{
		// here is the button to click to add a counter in my NewCounter activity.
		@Override
		public void onClick(View v)
		{
			Intent newc = new Intent();
			newc.setClass(MainActivity.this, NewCounter.class);
			MainActivity.this.startActivity(newc);

			// TODO Auto-generated method stub
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
