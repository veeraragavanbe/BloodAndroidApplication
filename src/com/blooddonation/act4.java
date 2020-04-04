package com.blooddonation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class act4 extends Activity {
    /** Called when the activity is first created. */
	String tempname,tempmobile;
	String umobile;
	int index1=0;
	private static String urlString;
	String search[]=new String[100];
	String temparray1[]={"NAME:","AGE:","BLOOD-GROUP:","MOBILE-NO:","EMAIL-ID:","ADDRESS:","CITY:"};
	TextView t1,t2,t3,t4,t5,t6,t7;
	Typeface tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	Button b1,b2;
	String tempblood;
	
	
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main4);
        try
        {
        	b1=(Button) findViewById(R.id.button1);
        	b2=(Button) findViewById(R.id.button2);
        	t1=(TextView) findViewById(R.id.textView1);
        	t2=(TextView) findViewById(R.id.textView2);
        	t3=(TextView) findViewById(R.id.textView3);
        	t4=(TextView) findViewById(R.id.textView4);
        	t5=(TextView) findViewById(R.id.textView5);
        	t6=(TextView) findViewById(R.id.textView6);
        	t7=(TextView) findViewById(R.id.textView7);
        	
        	tf1=Typeface.createFromAsset(getAssets(),"fonts/ALGER.TTF");
        	t1.setTypeface(tf1);
        	tf2=Typeface.createFromAsset(getAssets(),"fonts/ALGER.TTF");
        	t2.setTypeface(tf2);
        	tf3=Typeface.createFromAsset(getAssets(),"fonts/ALGER.TTF");
        	t3.setTypeface(tf3);
        	tf4=Typeface.createFromAsset(getAssets(),"fonts/ALGER.TTF");
        	t4.setTypeface(tf4);
        	tf5=Typeface.createFromAsset(getAssets(),"fonts/ALGER.TTF");
        	t5.setTypeface(tf5);
        	tf6=Typeface.createFromAsset(getAssets(),"fonts/ALGER.TTF");
        	t6.setTypeface(tf6);
        	tf7=Typeface.createFromAsset(getAssets(),"fonts/ALGER.TTF");
        	t7.setTypeface(tf7);
        	
        	
        tempname=getIntent().getExtras().getString("name");
        tempmobile=getIntent().getExtras().getString("mobile");
        //Toast.makeText(getBaseContext(), tempname+","+tempmobile, Toast.LENGTH_LONG).show();
        try
        {
        GetRecords();
        String s1="";
        int len=0;
        
        final Long m1=Long.parseLong(umobile);
        //Toast.makeText(getBaseContext(),"the"+m1, Toast.LENGTH_LONG).show();
        try
        {
        	s1=temparray1[len]+search[len];
        	t1.setText(s1.toUpperCase().toString());
        	len=len+1;
        	
        	s1=temparray1[len]+search[len];
        	t2.setText(s1.toUpperCase().toString());
        	len=len+1;
        	if(search[len].equalsIgnoreCase("Ap"))
        	{
        		tempblood="A+";
        	}
        	if(search[len].equalsIgnoreCase("Bp"))
        	{
        		tempblood="B+";
        	}
        	if(search[len].equalsIgnoreCase("Op"))
        	{
        		tempblood="O+";
        	}
        	if(search[len].equalsIgnoreCase("Abp"))
        	{
        		tempblood="AB+";
        	}
        	if(search[len].equalsIgnoreCase("An"))
        	{
        		tempblood="A-";
        	}
        	if(search[len].equalsIgnoreCase("Bn"))
        	{
        		tempblood="B-";
        	}
        	if(search[len].equalsIgnoreCase("On"))
        	{
        		tempblood="O-";
        	}
        	if(search[len].equalsIgnoreCase("Abn"))
        	{
        		tempblood="AB-";
        	}
        	s1=temparray1[len]+tempblood;
        	t3.setText(s1.toUpperCase().toString());
        	len=len+1;
        	
        	s1=temparray1[len]+search[len];
        	t4.setText(s1.toUpperCase().toString());
        	len=len+1;
        	
        	s1=temparray1[len]+search[len];
        	t5.setText(s1.toUpperCase().toString());
        	len=len+1;
        	
        	s1=temparray1[len]+search[len];
        	t6.setText(s1.toUpperCase().toString());
        	len=len+1;
        	
        	s1=temparray1[len]+search[len];
        	t7.setText(s1.toUpperCase().toString());
        	
        	b1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					
				//	Intent in=new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+m1));
					Intent in=new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+5556));
					startActivity(in);
					
				}
			});
        	b2.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent in1=new Intent(act4.this,act5.class);
					in1.putExtra("mobile",umobile );
					startActivity(in1);
					
				}
			});
        }catch (Exception e) {
			// TODO: handle exception
        	Toast.makeText(getBaseContext(), "Error 1="+e.getMessage(), Toast.LENGTH_LONG).show();
		}
        
        }catch (Exception e) {
			// TODO: handle exception
        	Toast.makeText(getBaseContext(), "Error 2="+e.getMessage(), Toast.LENGTH_LONG).show();
		}
        }catch (Exception e) {
			// TODO: handle exception
        	Toast.makeText(getBaseContext(), "Error 3="+e.getMessage(), Toast.LENGTH_LONG).show();
		}
    }

    public void GetRecords()
    {
   	 	urlString = "http://192.168.1.2/blood/dbselect.php";
		    try{
    	    	 HTTPDataHandler hh = new HTTPDataHandler(getBaseContext());
			     String  stream = hh.GetHTTPData(urlString);
			    // Toast.makeText(getBaseContext(), "inside the getrecords", Toast.LENGTH_LONG).show();
			     String data="";
			     String s1="";
			     
			     
			     if(stream !=null){
		                try{
		                //	Toast.makeText(getBaseContext(), "inside the try", Toast.LENGTH_LONG).show();
		                    // Get the full HTTP Data as JSONObject
		                    JSONObject reader= new JSONObject(stream);

		                    //Get the instance of JSONArray that contains JSONObjects
		                    JSONArray jsonArray = reader.optJSONArray("result");
		    
		                    //Iterate the jsonArray and print the info of JSONObjects
		                   
		                    if(jsonArray.length()>0) // check for data from remote server
		                    {
		                    	//Toast.makeText(getBaseContext(), "inside if", Toast.LENGTH_LONG).show();
		                      for(int i=0; i < jsonArray.length(); i++)
		                      {
		                    	 // Toast.makeText(getBaseContext(), "inside for", Toast.LENGTH_LONG).show();
		                         JSONObject jsonObject = jsonArray.getJSONObject(i);
		                         String name = jsonObject.optString("Name").toString();
		                         String age = jsonObject.optString("Age").toString();
		                         String blood = jsonObject.optString("Blood_Group").toString();
		                         String mobile = jsonObject.optString("Mobile").toString();
		                         String email = jsonObject.optString("Email").toString();
		                         String address = jsonObject.optString("Address").toString();
		                         String city = jsonObject.optString("City").toString();
		                        data = "Name = "+ name +" \n Age= "+ age +" \n Blood_Group="+blood+"\n mobile="+mobile+"\n Email="+email+"\n Address="+address+"\n City="+city;
                          	//	Toast.makeText(getBaseContext(), data, Toast.LENGTH_LONG).show();
		                         s1=s1+data;
		                         
		                         if(name.equalsIgnoreCase(tempname) && mobile.equalsIgnoreCase(tempmobile))
		                         {
		                       //  Toast.makeText(getBaseContext(), "condition true", Toast.LENGTH_LONG).show();
		                        	 
		                        	
		                        	 
		                        	try{ 
		                        	 search[index1]=name;
		                        	// Toast.makeText(getBaseContext(), search[index1], Toast.LENGTH_LONG).show();
		                        	 index1=index1+1;
		                        	 search[index1]=age;
		                        	// Toast.makeText(getBaseContext(), search[index1], Toast.LENGTH_LONG).show();
		                        	 index1=index1+1;
		                        	 search[index1]=blood;
		                        	// Toast.makeText(getBaseContext(), search[index1], Toast.LENGTH_LONG).show();
		                        	 index1=index1+1;
		                        	 search[index1]=mobile;
		                        	 umobile=search[index1];
		                        	// Toast.makeText(getBaseContext(), search[index1], Toast.LENGTH_LONG).show();
		                        	 index1=index1+1;
		                        	 search[index1]=email;
		                        	// Toast.makeText(getBaseContext(), search[index1], Toast.LENGTH_LONG).show();
		                        	 index1=index1+1;
		                        	 search[index1]=address;
		                        	// Toast.makeText(getBaseContext(), search[index1], Toast.LENGTH_LONG).show();
		                        	 index1=index1+1;
		                        	 search[index1]=city;
		                        	 //Toast.makeText(getBaseContext(), search[index1], Toast.LENGTH_LONG).show();
		                        	 //Toast.makeText(getBaseContext(), "one record added", Toast.LENGTH_LONG).show();
		                        	 
		                        	}catch(Exception e)
		                        	{
		                        		
		                        		Toast.makeText(getBaseContext(), "adding error = "+e.getMessage(), Toast.LENGTH_LONG).show();
		                        	}
		                         }
		                         		       
		                       }
		                    }
		                    else
		                    {
		                    	data="Record Not Found";
		                    	Toast.makeText(getBaseContext(), data, Toast.LENGTH_LONG).show();
		                    	
		               		}
		                    
		 //					Toast.makeText(getBaseContext(), s1, Toast.LENGTH_LONG).show();

		                }catch(JSONException e){
		                	 Toast.makeText(getBaseContext(), "JSONError"+e.getMessage(), Toast.LENGTH_LONG).show();
		                }
		            }//if statement
			     
		    }catch(Exception e)
		    {
		    	Toast.makeText(getBaseContext(), "Error="+e.getMessage(), Toast.LENGTH_LONG).show();
		    	
		    } 
    	}//GetRecords

}
