package com.example.samresendez.boost;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by SamResendez on 11/13/16.
 */

public class imageDownloadTask extends AsyncTask {

    ImageView iV;
    String urlString;

    @Override
    protected Bitmap doInBackground(Object[] objects) {

        Bitmap mIcon_val= null;

        try {
            URL newurl = new URL(urlString);
            URLConnection connect = newurl.openConnection();
            InputStream istream = connect.getInputStream();
            mIcon_val = BitmapFactory.decodeStream(istream);

            istream.close();
        } catch(Exception e) {
            Log.e("We failed: ",e.toString());
        }


        return mIcon_val;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        iV.setImageBitmap((Bitmap)o);

    }
}
