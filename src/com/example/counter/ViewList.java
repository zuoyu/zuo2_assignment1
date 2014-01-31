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
		
		populateListView(); // show the result in to view list.
		
		registerClickCallback();// able to click  the view list.
		
		final Button renamev = (Button) findViewById(R.id.rename);
		renamev.setOnClickListener(new vrename());
		
		final Button removev = (Button) findViewById(R.id.remove);
		removev.setOnClickListener(new vremove());
		
		final Button clearall = (Button) findViewById(R.id.clear);
		clearall.setOnClickListener(new allclear());
		
		final Button rback = (Button) findViewById(R.id.back3);
		rback.setOnClickListener(new backr());
	}
	
	
	class allclear implements OnClickListener
	{

		@Override
		public void onClick(View v)
		{
			// jump to ClearAll activity

			// TODO Auto-generated method stub
			Intent backbotton = new Intent();
			backbotton.setClass(ViewList.this,ClearAll.class);
			ViewList.this.startActivity(backbotton);
		}

		/**
		 * @uml.property  name="clearAll"
		 * @uml.associationEnd  inverse="allclear:com.example.counter.ClearAll"
		 */
		private ClearAll clearAll;

		/**
		 * Getter of the property <tt>clearAll</tt>
		 * @return  Returns the clearAll.
		 * @uml.property  name="clearAll"
		 */
		public ClearAll getClearAll()
		
		
		{
		
			return clearAll;
		}

		/**
		 * Setter of the property <tt>clearAll</tt>
		 * @param clearAll  The clearAll to set.
		 * @uml.property  name="clearAll"
		 */
		public void setClearAll(ClearAll clearAll)
		
		
		{
		
			this.clearAll = clearAll;
		}
		
	}
	
	class backr implements OnClickListener
	{

		@Override
		public void onClick(View v)
		{

			// TODO Auto-generated method stub
			Intent backbotton = new Intent();
			backbotton.setClass(ViewList.this,NewCounter.class);
			ViewList.this.startActivity(backbotton);
		}

		/**
		 * @uml.property  name="clearAll"
		 * @uml.associationEnd  inverse="backr:com.example.counter.ClearAll"
		 */
		private ClearAll clearAll;

		/**
		 * Getter of the property <tt>clearAll</tt>
		 * @return  Returns the clearAll.
		 * @uml.property  name="clearAll"
		 */
		public ClearAll getClearAll()
		
		
		
		{
		
			return clearAll;
		}

		/**
		 * Setter of the property <tt>clearAll</tt>
		 * @param clearAll  The clearAll to set.
		 * @uml.property  name="clearAll"
		 */
		public void setClearAll(ClearAll clearAll)
		
		
		
		{
		
			this.clearAll = clearAll;
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

		/**
		 * @uml.property  name="removeCounter"
		 * @uml.associationEnd  inverse="vremove:com.example.counter.RemoveCounter"
		 */
		private RemoveCounter removeCounter;

		/**
		 * Getter of the property <tt>removeCounter</tt>
		 * @return  Returns the removeCounter.
		 * @uml.property  name="removeCounter"
		 */
		public RemoveCounter getRemoveCounter()
		{

			return removeCounter;
		}

		/**
		 * Setter of the property <tt>removeCounter</tt>
		 * @param removeCounter  The removeCounter to set.
		 * @uml.property  name="removeCounter"
		 */
		public void setRemoveCounter(RemoveCounter removeCounter)
		{

			this.removeCounter = removeCounter;
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

		/**
		 * @uml.property  name="reName"
		 * @uml.associationEnd  inverse="vrename:com.example.counter.ReName"
		 */
		private ReName reName;

		/**
		 * Getter of the property <tt>reName</tt>
		 * @return  Returns the reName.
		 * @uml.property  name="reName"
		 */
		public ReName getReName()
		
		{
		
			return reName;
		}

		/**
		 * Setter of the property <tt>reName</tt>
		 * @param reName  The reName to set.
		 * @uml.property  name="reName"
		 */
		public void setReName(ReName reName)
		
		{
		
			this.reName = reName;
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

	/**
	 * @uml.property  name="newCounter"
	 * @uml.associationEnd  inverse="viewList:com.example.counter.NewCounter"
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

}
