package com.example.samresendez.boost;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

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

        String urlString = "ec2-35-162-210-203.us-west-2.compute.amazonaws.com/register";
        String urlParams = "email="+mEmail+"&username="+mUserName+"&password="+mPassword;

        try {

            URL url = new URL(urlString);
            
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
