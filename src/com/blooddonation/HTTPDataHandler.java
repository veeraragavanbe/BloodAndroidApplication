package com.blooddonation;

import java.net.HttpURLConnection;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import android.content.Context;
import android.widget.Toast;


public class HTTPDataHandler {
		
    static String stream = null;
    Context context;
    
    public HTTPDataHandler(Context c){
    	context=c;
    }

    public String GetHTTPData(String urlString){
    	//Toast.makeText(context,"inside gethttpdata  ", Toast.LENGTH_LONG).show();
   	 	        try{
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//            Toast.makeText(context,"inside try block ", Toast.LENGTH_LONG).show();
            // Check the connection status
            if(urlConnection.getResponseCode() == 200)
            {
                // if response code = 200 ok
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                // Read the BufferedInputStream
                BufferedReader r = new BufferedReader(new InputStreamReader(in));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = r.readLine()) != null) {
                	// Toast.makeText(context,"data="+line, Toast.LENGTH_LONG).show();
                    sb.append(line);
                }
                stream = sb.toString();
                // End reading...............

                // Disconnect the HttpURLConnection
                urlConnection.disconnect();
            }
            else
            {
            	Toast.makeText(context,"Url Connection Code !=200", Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
        	
        	Toast.makeText(context,"Error="+e.getMessage(), Toast.LENGTH_LONG).show();
      
        }finally {

        }
       
        return stream;
    }
}
