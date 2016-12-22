package com.example.samresendez.boost;

import android.os.AsyncTask;
import android.util.Log;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by SamResendez on 11/13/16.
 */

public class boostAsyncTask extends AsyncTask {

    String mUserName;
    String amount;
    String id;


    @Override
    protected Object doInBackground(Object[] objects) {

        String urlString = "http://ec2-35-162-210-203.us-west-2.compute.amazonaws.com/donate";


        try {
            Log.e("Are we here?","We are here!");
            Unirest.post(urlString).field("username",mUserName).field("orgid",id).field("amount",amount).asJson();
            /*
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);

            OutputStream ostream = connection.getOutputStream();
            ostream.write(urlParams.getBytes());
            ostream.flush();
            ostream.close();
            */

        }catch (Exception e) {
            Log.e("I'm a bonobo: ",e.toString());
        }
        return null;
    }
}
