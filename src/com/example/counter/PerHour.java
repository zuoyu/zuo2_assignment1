package com.example.counter;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.example.counter.Searching.hourper;

public class PerHour extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_per_hour);
		
		final Button rback = (Button) findViewById(R.id.back3);
		rback.setOnClickListener(new backr());
		
		populateListView();
		registerClickCallback();
	}

	
	class backr implements OnClickListener
	{

		@Override
		public void onClick(View v)
		{

			// TODO Auto-generated method stub
			Intent backbotton = new Intent();
			backbotton.setClass(PerHour.this,Searching.class);
			PerHour.this.startActivity(backbotton);
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
				Toast.makeText(PerHour.this, massage, Toast.LENGTH_LONG).show();
				
			}
		});
		
	}

	private void populateListView()
	{
		
		// TODO Auto-generated method stub
		Intent getName= getIntent();
        String newName=(String)getName.getSerializableExtra("text");
        
        
        String massage = "You are searching " + newName + "'s record";
		Toast.makeText(PerHour.this, massage, Toast.LENGTH_LONG).show();
		
		
		String ss = "";
		String end = "";
		ArrayList<String> myIteam = new ArrayList<String>();
		ArrayList<Counter> orderlist = new ArrayList<Counter>();
		ArrayList<String> record =  new ArrayList<String>();
		ArrayList<Integer> numberrecord = new ArrayList<Integer>();
		
		Gson gson = new Gson();
		// get data from the file.txt.
		try{
			FileInputStream fis = openFileInput("file.txt");
			BufferedReader er = new BufferedReader(new InputStreamReader(fis));
			ss= er.readLine();
			Log.v("PRNT JSON",ss);
			while (ss != null ){
				String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
				String[] hourNames = {"AM","PM"};
				DataSaving datas = gson.fromJson(ss,DataSaving.class);
				Date time = datas.getTimestamp();
				
				//import Calendar, and then we can using it to get date.
				Calendar cal = Calendar.getInstance();
				cal.setTime(time);
				int year = cal.get(Calendar.YEAR);
				
				int month = cal.get(Calendar.MONTH);
				
				int day = cal.get(Calendar.DAY_OF_MONTH);
				
				int day_r = cal.get(Calendar.HOUR);
				
				int day_h = cal.get(Calendar.HOUR_OF_DAY);
				
				if(day_h > 12){
					end = hourNames[1];
				}else{
					end = hourNames[0];
				}
				
				
				if(newName.equals(datas.getText())){
					myIteam.add("The Hour of "+year+" "+monthNames[month]+" "+day+" "+day_r+" "+end+": ");
				}
				
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
		
		
		int record_number =0;
		int size = myIteam.size();
		String record_name = "";
		Counter obj = new Counter(record_name,record_number);
		
		for (int i = 0; i<size; i++)
		{
			record_name = myIteam.get(i);
			if(record_name != null){
				obj.setText(record_name);
				for (int j =0; j<size;j++){
					String namei = myIteam.get(j);
					if(obj.getText().equals(namei)){
						obj.addNumber();
						myIteam.set(j, null);
					}
				}
				String fin_name = obj.getText();
				int fin_number = obj.getNumber();
				Counter abj =new Counter(fin_name,fin_number);
				orderlist.add(abj);
				record.add(fin_name +" | "+fin_number);
				obj.setNumber(0);
				
			}
		}
		
	
		for (int i =0;i<orderlist.size();i++){
			Counter good = orderlist.get(i);
			int number_pop = good.getNumber();
			numberrecord.add(number_pop);
		}
		
		int n = numberrecord.size();
		boolean swapped = true;
		while(swapped){
			swapped = false;
			for(int i = 0; i< (n-1);i++){
				if(numberrecord.get(i) > numberrecord.get(i+1)){
					int temp = numberrecord.get(i);
					numberrecord.set(i, numberrecord.get(i+1));
					numberrecord.set(i+1, temp);
					
					String temp1 = record.get(i);
					record.set(i, record.get(i+1));
					record.set(i+1, temp1);
					
					swapped = true;
				}
			}
			
		}
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this,
				R.layout.data_item,
				record);
		
		ListView list = (ListView) findViewById(R.id.listView1);
		list.setAdapter(adapter);
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.per_hour, menu);
		return true;
	}
	/**
	 * @uml.property  name="hourper"
	 * @uml.associationEnd  inverse="perHour:com.example.counter.Searching.hourper"
	 */
	private hourper hourper;
	/**
	 * Getter of the property <tt>hourper</tt>
	 * @return  Returns the hourper.
	 * @uml.property  name="hourper"
	 */
	public hourper getHourper()
	{

		return hourper;
	}

	/**
	 * Setter of the property <tt>hourper</tt>
	 * @param hourper  The hourper to set.
	 * @uml.property  name="hourper"
	 */
	public void setHourper(hourper hourper)
	{

		this.hourper = hourper;
	}

}
