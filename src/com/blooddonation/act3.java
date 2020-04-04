package com.blooddonation;


	import org.json.JSONArray;
	import org.json.JSONException;
	import org.json.JSONObject;
	import android.app.Activity;
import android.content.Intent;
	import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
	import android.widget.ArrayAdapter;
	import android.widget.ListView;
	import android.widget.ScrollView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

		public class act3 extends Activity {
			private static String urlString;
			/** Called when the activity is first created. */
			String uscity,usblood;
			int index1=0;
			String search[]=new String[100];
			String mobile1[]=new String[100];
			ScrollView sview;
			ListView lv1;
	

				@Override
				public void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.main3);
				try{
					//Toast.makeText(getBaseContext(), "inside the act 3", Toast.LENGTH_LONG).show();	             	
        
				usblood=getIntent().getExtras().getString("blood");
				uscity=getIntent().getExtras().getString("city"); 
				//Toast.makeText(getBaseContext(),"blood group,city="+usblood.toString()+","+uscity.toString(), Toast.LENGTH_LONG).show();
				try
				{
					GetRecords();
					int len=index1;
					 final String listdata[]=new String[index1];
	//Toast.makeText(getBaseContext(), "length of search array"+len, Toast.LENGTH_LONG).show();
					//Toast.makeText(getBaseContext(), "the array values printed", Toast.LENGTH_LONG).show();
       for( int j = 0; j<len;j++)
     {    	 
      String t=search[j]+"("+mobile1[j]+")";
    listdata[j]=t;	  
    	   
   //Toast.makeText(getBaseContext(), search[j], Toast.LENGTH_LONG).show();
    
     }
       if(index1==0)
       {
    	   Toast.makeText(getBaseContext(), "No Data Mached", Toast.LENGTH_LONG).show();
    	   Intent in=new Intent(act3.this,act2.class);
    	   startActivity(in);
       }
       
       
    lv1=(ListView) findViewById(R.id.listView1);
    ArrayAdapter<String> ad=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listdata);
    ad.notifyDataSetChanged();
    lv1.setAdapter(ad);
     lv1.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			//Toast.makeText(getBaseContext(), "selected item is"+listdata[arg2], Toast.LENGTH_LONG).show();
			String clickdata=listdata[arg2];
			
			//Toast.makeText(getBaseContext(), clickdata, Toast.LENGTH_LONG).show();
			for(int i=0;i<index1;i++)
			{
				//Toast.makeText(getBaseContext(), "inside for", Toast.LENGTH_LONG).show();
				String t=search[i]+"("+mobile1[i]+")";
				if(clickdata.equalsIgnoreCase(t))
				{
					//Toast.makeText(getBaseContext(), "condition true", Toast.LENGTH_LONG).show();
					Intent in=new Intent(act3.this,act4.class);
					String tempname=search[i];
					String tempmobile=mobile1[i];
					in.putExtra("name",tempname );
					in.putExtra("mobile",tempmobile );
					startActivity(in);
				}
			}
			

			
		}
	});
       
       }catch (Exception e) {
		// TODO: handle exception	
    	   Toast.makeText(getBaseContext(), "Error1 = "+e.getMessage().toString(), Toast.LENGTH_LONG).show();
	}
        
        }catch (Exception e) {
		// TODO: handle exception
    //	   Toast.makeText(getBaseContext(), "Error1 = "+e.getMessage(), Toast.LENGTH_LONG).show();
	}    

            }
    
    
    public void GetRecords()
    {
   	 	urlString = "http://192.168.1.2/blood/dbselect.php";
		    try{
    	    	 HTTPDataHandler hh = new HTTPDataHandler(getBaseContext());
			     String  stream = hh.GetHTTPData(urlString);
			     //Toast.makeText(getBaseContext(), "inside the getrecords", Toast.LENGTH_LONG).show();
			     String data="";
			     String s1="";
			     
			     
			     if(stream !=null){
		                try{
		                	//Toast.makeText(getBaseContext(), "inside the try", Toast.LENGTH_LONG).show();
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
		                         
		                         if(blood.equalsIgnoreCase(usblood) && city.equalsIgnoreCase(uscity))
		                         {
		  //                       Toast.makeText(getBaseContext(), "condition true", Toast.LENGTH_LONG).show();
		                        	 
		                        	// Toast.makeText(getBaseContext(), "blood="+blood, Toast.LENGTH_LONG).show();
		                        	// Toast.makeText(getBaseContext(), "usblood="+usblood, Toast.LENGTH_LONG).show();
		                        	// Toast.makeText(getBaseContext(), "city="+city, Toast.LENGTH_LONG).show();
		                        	// Toast.makeText(getBaseContext(), "uscity="+uscity, Toast.LENGTH_LONG).show();
		                        	 
		                        	try{ 
		                        	 search[index1]=name;
		                        	 mobile1[index1]=mobile;
		//				Toast.makeText(getBaseContext(), "one record added", Toast.LENGTH_LONG).show();
		                        	 index1=index1+1;
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
		                    
		 //Toast.makeText(getBaseContext(), s1, Toast.LENGTH_LONG).show();

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




