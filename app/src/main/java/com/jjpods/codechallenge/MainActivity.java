package com.jjpods.codechallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText urlText;
    static TextView dataText;
    String url;
    Button rButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlText = findViewById(R.id.urlText);
        dataText = findViewById(R.id.dataText);
        rButton = findViewById(R.id.rButton);

        rButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url = urlText.getText().toString();
                urlData data = new urlData(url);
                data.execute();

            }
        });
    }
}
