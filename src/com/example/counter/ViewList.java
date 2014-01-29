package com.example.counter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;


import com.google.gson.Gson;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewList extends Activity
{
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_list);
		
		populateListView();
		registerClickCallback();
		final Button renamev = (Button) findViewById(R.id.rename);
		renamev.setOnClickListener(new vrename());
		
		final Button removev = (Button) findViewById(R.id.remove);
		removev.setOnClickListener(new vremove());
		
		final Button clearall = (Button) findViewById(R.id.clear);
		clearall.setOnClickListener(new allclear());
	}
	
	
	class allclear implements OnClickListener
	{

		@Override
		public void onClick(View v)
		{

			// TODO Auto-generated method stub
			Intent backbotton = new Intent();
			backbotton.setClass(ViewList.this,ClearAll.class);
			ViewList.this.startActivity(backbotton);
		}
		
	}
	
	class vremove implements OnClickListener
	{

		@Override
		public void onClick(View v)
		{

			// TODO Auto-generated method stub
			Intent backbotton = new Intent();
			backbotton.setClass(ViewList.this,RemoveCounter.class);
			ViewList.this.startActivity(backbotton);
		}
		
	}

	
	class vrename implements OnClickListener
	{

		@Override
		public void onClick(View v)
		{

			// TODO Auto-generated method stub
			Intent backbotton = new Intent();
			backbotton.setClass(ViewList.this,ReName.class);
			ViewList.this.startActivity(backbotton);
		}
		
	}

	private void registerClickCallback()
	{
		ListView list = (ListView) findViewById(R.id.listView1);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> paret, View viewClicked, int position,
					long id)
			{

				// TODO Auto-generated method stub
				TextView textView = (TextView) viewClicked;
				String massage = "You Clicked #" + position + ", which is string:" + textView.getText().toString();
				Toast.makeText(ViewList.this, massage, Toast.LENGTH_LONG).show();
				
			}
		});
		
	}

	private void populateListView()
	{
		
		// TODO Auto-generated method stub
		
		String ss = "";
		ArrayList<String> myIteam = new ArrayList<String>();
		
		Gson gson = new Gson();
		try{
			FileInputStream fis = openFileInput("file.txt");
			BufferedReader er = new BufferedReader(new InputStreamReader(fis));
			ss= er.readLine();
			Log.v("PRNT JSON",ss);
			while (ss != null ){
				DataSaving datas = gson.fromJson(ss,DataSaving.class);
				String texti = datas.getText();
				Date datei = datas.getTimestamp();
				String dates = datei.toString();
				myIteam.add(texti+ " | "+dates);
				ss= er.readLine();
			}
		
		}
		catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this,
				R.layout.data_item,
				myIteam);
		
		ListView list = (ListView) findViewById(R.id.listView1);
		list.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_list, menu);
		return true;
	}

}
