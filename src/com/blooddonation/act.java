package com.blooddonation;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class act extends Activity {
    /** Called when the activity is first created. */
	TextView t1;
	ImageButton ib1,ib2;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        t1=(TextView)findViewById(R.id.textView1);
        ib1=(ImageButton)findViewById(R.id.imageButton1);
        ib2=(ImageButton)findViewById(R.id.imageButton2);
       
        
        
        ib1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			
				
				
				Intent in1=new Intent(act.this,act1.class);
				startActivity(in1);
				 
			}
		});
     ib2.setOnClickListener(new OnClickListener() {
		
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			Intent in2=new Intent(act.this,act2.class);
			startActivity(in2);
			
		}
	});
              
    }
}