package com.example.samresendez.boost;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;


import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by SamResendez on 11/12/16.
 */

public class registerAsyncTask extends AsyncTask {

    String mEmail;
    String mUserName;
    String mPassword;

    @Override
    protected Object doInBackground(Object[] objects) {

        String urlString = "http://ec2-35-162-210-203.us-west-2.compute.amazonaws.com/register";
        String urlParams = "email=" + mEmail + "&username=" + mUserName + "&password=" + mPassword;

        try {

            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);

            OutputStream ostream = connection.getOutputStream();

            ostream.write(urlParams.getBytes());
            ostream.flush();
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
