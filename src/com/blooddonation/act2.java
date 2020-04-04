package com.blooddonation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class act2 extends Activity {
    /** Called when the activity is first created. */
	Spinner sp1;
	EditText ed1;
	
	String s1,s2;
	String bloodgroup[]={"A+","B+","O+","AB+","A-","B-","O-","AB-"};
	ImageButton ib1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        
        sp1=(Spinner)findViewById(R.id.spinner1);
        ed1=(EditText)findViewById(R.id.editText1);
        ib1=(ImageButton)findViewById(R.id.imageButton1);
        ArrayAdapter<String> aap=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,bloodgroup);
        sp1.setAdapter(aap);
        
        sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				int index=arg0.getSelectedItemPosition();
				String temp=bloodgroup[index].toString();
				if(temp.equalsIgnoreCase("A+"))
				{
					s1="Ap";
				}
				if(temp.equalsIgnoreCase("B+"))
				{
					s1="Bp";
				}
				if(temp.equalsIgnoreCase("O+"))
				{
					s1="Op";
				}
				if(temp.equalsIgnoreCase("AB+"))
				{
					s1="ABp";
				}
				if(temp.equalsIgnoreCase("A-"))
				{
					s1="An";
				}
				if(temp.equalsIgnoreCase("B-"))
				{
					s1="Bn";
				}
				if(temp.equalsIgnoreCase("O-"))
				{
					s1="On";
				}
				if(temp.equalsIgnoreCase("AB-"))
				{
					s1="ABn";
				}
				//s1=bloodgroup[arg2].toString();
			
			
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
      

        ib1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s2=ed1.getText().toString();	
			//Toast.makeText(getBaseContext(), "b1="+s1+"-"+s2, Toast.LENGTH_LONG).show();
				
				Intent in2=new Intent(act2.this,act3.class);
		
				in2.putExtra("blood",s1 );
				in2.putExtra("city",s2 );

				startActivity(in2);
				
				
			}
		}); 
 
        
    }
}
 