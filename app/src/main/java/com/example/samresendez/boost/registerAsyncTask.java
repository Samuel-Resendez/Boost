package com.example.samresendez.boost;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by SamResendez on 11/12/16.
 */

public class registerAsyncTask extends AsyncTask {

    String mEmail;
    String mUserName;
    String mPassword;

    @Override
    protected Object doInBackground(Object[] objects) {

        String urlString = "http://ec2-35-162-210-203.us-west-2.compute.amazonaws.com:5000/register";
        String urlParams = "email="+mEmail+"&username="+mUserName+"&password="+mPassword;

        try {



            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);

            Log.e("urlParams;" ,urlParams);
            Log.e("Full Url: ",urlString + urlParams);
            //Safe metrics guys!

            connection.setReadTimeout(15000);
            connection.setConnectTimeout(15000);

            OutputStream ostream = connection.getOutputStream();
            ostream.write(urlParams.getBytes());
            ostream.close();

        }

        catch(Exception e) {
            Log.e("We fucked up boys:",e.toString());
        }

        return null;
    }

    @Override
    protected void onPostExecute(Object o) {

        super.onPostExecute(o);
    }
}
