package com.blooddonation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class act1 extends Activity {
    /** Called when the activity is first created. */
	private static String urlString;
	EditText ed1,ed2,ed4,ed5,ed6,ed7;
	Button b1,b2;
	String s1,s2,s3,s4,s5,s6,s7,s8;
	TextView t1;
	Spinner sp1;
	String bloodgroup[]={"A+","B+","O+","AB+","A-","B-","O-","AB-"};
	//String bloodgroup[]={"A+","B+","O+","AB+","A-","B-","O-","AB-"};
	ImageButton img,img2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
        ed1=(EditText)findViewById(R.id.editText1);
        ed2=(EditText)findViewById(R.id.editText2);
        ed4=(EditText)findViewById(R.id.editText4);
        ed5=(EditText)findViewById(R.id.editText5);
        ed6=(EditText)findViewById(R.id.editText6);
        ed7=(EditText)findViewById(R.id.editText7);
 
        t1=(TextView)findViewById(R.id.textView1);
        img=(ImageButton)findViewById(R.id.imageButton1);
        img2=(ImageButton)findViewById(R.id.imageButton2);
        sp1=(Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String> aap=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,bloodgroup);
        sp1.setAdapter(aap);
        
        sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				int index=arg0.getSelectedItemPosition();
				String temp=bloodgroup[index].toString();
				if(temp.equalsIgnoreCase("A+"))
				{
					s3="Ap";
				}
				if(temp.equalsIgnoreCase("B+"))
				{
					s3="Bp";
				}
				if(temp.equalsIgnoreCase("O+"))
				{
					s3="Op";
				}
				if(temp.equalsIgnoreCase("AB+"))
				{
					s3="ABp";
				}
				if(temp.equalsIgnoreCase("A-"))
				{
					s3="An";
				}
				if(temp.equalsIgnoreCase("B-"))
				{
					s3="Bn";
				}
				if(temp.equalsIgnoreCase("O-"))
				{
					s3="On";
				}
				if(temp.equalsIgnoreCase("AB-"))
				{
					s3="ABn";
				}
				
				
				
				
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
        img2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				Intent in1=new Intent(act1.this,act.class);
				startActivity(in1);
				
			}
		});
        
        img.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=ed1.getText().toString();
				s2=ed2.getText().toString();
			    s4=ed4.getText().toString();
				s5=ed5.getText().toString();
				s6=ed6.getText().toString();
				s7=ed7.getText().toString();
				
				s8=s1+s2+s4+s5+s6;
				
				
				if(s8=="")
				{
					Toast.makeText(getBaseContext(), "please enter your details", Toast.LENGTH_LONG).show();
				}
				
				

				else
				{
					StoreRecord();
					
					AlertDialog.Builder alt=new AlertDialog.Builder(act1.this);
					alt.setTitle("Confirm");
					alt.setMessage("ARE YOU SURE DO YOU WONT TO REGISTER");
					alt.setIcon(R.drawable.icon);
					
					alt.setPositiveButton("YES", new DialogInterface.OnClickListener() {
						
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO Auto-generated method stub
					
							Toast.makeText(getBaseContext(), "REGISTER SUCCESSFULL", Toast.LENGTH_LONG).show();
							
							Intent in=new Intent(act1.this,act.class);
							startActivity(in);
							
						}
					});
					
					alt.setNegativeButton("NO", new DialogInterface.OnClickListener() {
						
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO Auto-generated method stub
							
							Toast.makeText(getBaseContext(), "REGISTER NOT SUCCESSFULL", Toast.LENGTH_LONG).show();
							
						}
					});
					
					alt.show();
					
				}
			
								
			}
		});
       
 
    }
    
    public void StoreRecord()
    {
    	 // Toast.makeText(getBaseContext(), "inside the method", Toast.LENGTH_LONG).show();
		// data get from text box
    	s1=ed1.getText().toString();
		s2=ed2.getText().toString();
	    s4=ed4.getText().toString();
		s5=ed5.getText().toString();
		s6=ed6.getText().toString();
		s7=ed7.getText().toString();
	    
	     //data trim()
		String name=s1.trim();
		String age=s2.trim();
		String blood=s3.trim();
		String phone=s4.trim();
		String email=s5.trim();
		String address=s6;//.trim();
		String city=s7.trim();
		
	//	Toast.makeText(getBaseContext(), name, Toast.LENGTH_LONG).show();
	//	Toast.makeText(getBaseContext(), age, Toast.LENGTH_LONG).show();
	//	Toast.makeText(getBaseContext(), blood, Toast.LENGTH_LONG).show();
	//	Toast.makeText(getBaseContext(), phone, Toast.LENGTH_LONG).show();
	//	Toast.makeText(getBaseContext(), email, Toast.LENGTH_LONG).show();
	//	Toast.makeText(getBaseContext(), address, Toast.LENGTH_LONG).show();
	//  Toast.makeText(getBaseContext(), city, Toast.LENGTH_LONG).show();
	    
	 
	     
					 
		urlString = "http://192.168.1.2/blood/dbinsert.php?name="+name+"&age="+age+"&blood="+blood+"&phone="+phone+"&email="+email+"&address="+address+"&city="+city+"";
		//Toast.makeText(getBaseContext(), urlString, Toast.LENGTH_LONG).show();
		// HTTPDataHandler class called
		HTTPDataHandler hh = new HTTPDataHandler(getBaseContext());
	    String  stream = hh.GetHTTPData(urlString);
	    
	    if(stream=="")
	    {
	    	//Toast.makeText(getBaseContext(), "no data in stream",Toast.LENGTH_LONG ).show();
	    }
	   
	    
	    
	    //Toast.makeText(getBaseContext(), stream, Toast.LENGTH_LONG).show();
	    
		
	   
	    
	    
	    
    }
  
}