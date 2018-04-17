package com.jjpods.codechallenge;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jjpod on 4/17/2018.
 */

public class urlData extends AsyncTask<Void,Void,Void>{
    String mURL = "";
    String jData = "";
    JSONObject jObject;
    JSONArray jsonArray;
    List<ListItem> listItems;
    RecyclerView.Adapter adapter;
    Context context;




    public urlData(String targetURL, Context context){
        mURL = targetURL;
        this.context = context;
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

            jObject = new JSONObject(jData);

            listItems = new ArrayList<>();
            try {
                jsonArray = jObject.getJSONArray("data");

                for(int i = 0; i<jsonArray.length(); i++){
                    JSONObject o = jsonArray.getJSONObject(i);
                    Log.i("TAG",o.getString("name"));
                    ListItem item = new ListItem(o.getString("name"),o.getString("city"),o.getString("state"),o.getString("endDate"));
                    listItems.add(item);
                }

                adapter = new ListAdapter(listItems, context);
                MainActivity.rView.setAdapter(adapter);


            } catch (JSONException e) {
                e.printStackTrace();
            }

            bufferedReader.close();

            Log.i("TAG", "JSON OBJECT: "+ jData);

            urlConnection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void v) {
        super.onPostExecute(v);



    }


}
