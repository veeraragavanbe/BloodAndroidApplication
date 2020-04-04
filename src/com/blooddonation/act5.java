package com.blooddonation;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class act5 extends Activity implements LocationListener{
	String mobileno;
	
	Button b1;
	EditText ed1;
	TextView t1;
	String message="";
	final String tempno="5556";
	String location1="my location is:";
	private LocationManager locationManager;
	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main5);
	try
	{
	// /********** get Gps location service LocationManager object ************/
	 locationManager = (LocationManager)
	 getSystemService(Context.LOCATION_SERVICE);

	 locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
	 3000,10,this); 
	 
	 //Toast.makeText(getBaseContext(), location1, Toast.LENGTH_LONG).show();
	// t1.setText(location1);
	}catch (Exception e) {
		// TODO: handle exception
		Toast.makeText(getBaseContext(), "Location Error="+e.getMessage(), Toast.LENGTH_LONG).show();
	}
	try
	{
	mobileno=getIntent().getExtras().getString("mobile");
	
	//Toast.makeText(getBaseContext(), ""+mobileno, Toast.LENGTH_LONG).show();
	b1=(Button) findViewById(R.id.button1);
	ed1=(EditText) findViewById(R.id.editText1);
	t1=(TextView) findViewById(R.id.textView1);
	
	try
	{
	b1.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			String temp2=t1.getText().toString();
			String temp1=ed1.getText().toString();
			message=temp1.toUpperCase()+"("+temp2+")";
	//		Toast.makeText(getBaseContext(), message, Toast.LENGTH_LONG).show();
			try
			{
			SmsManager sms=SmsManager.getDefault();
			sms.sendTextMessage(tempno, null, message, null, null);
			//sms.sendTextMessage(mobileno, null, message, null, null);
			
			}catch (Exception e) {
				// TODO: handle exception
				Toast.makeText(getBaseContext(), "Error 1="+e.getMessage(), Toast.LENGTH_LONG).show();
			}
		}
	});
	}catch (Exception e) {
		// TODO: handle exception
		Toast.makeText(getBaseContext(), "Error 2="+e.getMessage(), Toast.LENGTH_LONG).show();
	}
	}catch (Exception e) {
		// TODO: handle exception
		Toast.makeText(getBaseContext(), "Error 3="+e.getMessage(), Toast.LENGTH_LONG).show();
	}
	}
	
	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		location1 =location1+ "Latitude: "+location.getLatitude()+ " Longitude:"+location.getLongitude();
	//	 Toast.makeText(getBaseContext(), location1, Toast.LENGTH_LONG).show();
		t1.setText(location1);
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}
}
	
