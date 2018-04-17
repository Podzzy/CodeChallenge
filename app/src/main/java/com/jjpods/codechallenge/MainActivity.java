package com.jjpods.codechallenge;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText urlText;
    //static TextView dataText;
    String url;
    Button rButton;
    static RecyclerView rView;
    RecyclerView.Adapter adapter;
    List<ListItem> lItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlText = findViewById(R.id.urlText);
        //dataText = findViewById(R.id.dataText);
        rButton = findViewById(R.id.rButton);
        rView = findViewById(R.id.recyclerView);
        rView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rView.setHasFixedSize(true);
        rView.setLayoutManager(new LinearLayoutManager(this));



        rButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url = urlText.getText().toString();
                urlData data = new urlData(url,MainActivity.this);
                data.execute();

                /*lItems = data.listItems;
                adapter = new ListAdapter(lItems, getApplicationContext());
                rView.setAdapter(adapter);*/
            }
        });
    }
}
