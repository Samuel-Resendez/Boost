package com.example.samresendez.boost;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SamResendez on 11/12/16.
 */

public class getDataTask extends AsyncTask {

    SearchActivity mainActiv;

    List<donationInfo> donateList;
    @Override
    protected Object doInBackground(Object[] objects) {
        String urlString = "http://ec2-35-162-210-203.us-west-2.compute.amazonaws.com/organization/";

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream istream = connection.getInputStream();

            BufferedReader bf = new BufferedReader( new InputStreamReader(istream));
            String line = "";
            StringBuilder sb = new StringBuilder();

            while((line = bf.readLine()) !=null) {

                sb.append(line);

            }

            bf.close();
            istream.close();
            //connection.disconnect();
            donateList = new ArrayList<>();
            JSONArray result = new JSONArray(sb.toString());

            for(int i=0 ; i<result.length();i++) {
                JSONObject j = result.getJSONObject(i);
                Log.e("Here is obj:", j.toString());
                String name = j.getString("org_name");
                String descrip = j.getString("short_description");
                String id = Integer.toString(j.getInt("id"));
                String imgUrl = j.getString("icon_url");
                Log.e("Urls:",imgUrl);
                donationInfo donateInf = new donationInfo(name, descrip,id, imgUrl);
                donateList.add(donateInf);
            }

        }
        catch(Exception e) {
            Log.e("I butchered it: ",e.toString());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        mainActiv.donationList = donateList;
       // Log.e("Heres the main list: ", Integer.toString(mainActiv.donationList.size()));
        //mainActiv.mRecyclerView.invalidate();
        mainActiv.mRecyclerView.setAdapter(new donationAdapter(donateList));
        if(mainActiv.donationList == null) {
            Context context = mainActiv.getApplicationContext();
            CharSequence text = "Unfortunately couldn't retrieve data!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}
