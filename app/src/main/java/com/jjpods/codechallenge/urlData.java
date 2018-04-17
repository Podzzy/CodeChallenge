package com.jjpods.codechallenge;

import android.os.AsyncTask;
import android.util.Log;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;

/**
 * Created by jjpod on 4/17/2018.
 */

public class urlData extends AsyncTask<Void,Void,Void>{
    String mURL = "";
    String jData = "";
    //JSONObject jData;



    public urlData(String targetURL){
        mURL = targetURL;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            HttpURLConnection urlConnection;
            URL url = new URL(mURL);
            urlConnection = (HttpURLConnection)url.openConnection();

            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader= new BufferedReader(inputStreamReader);

            String line= "";

            while(line != null){
                line = bufferedReader.readLine();
                jData = jData + line + "\n";
            }

            bufferedReader.close();

            Log.i("TAG", "JSON OBJECT: "+ jData);

            urlConnection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void v) {
        super.onPostExecute(v);
        MainActivity.dataText.setText(jData);

    }

}
