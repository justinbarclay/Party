package com.example.justin.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button edit;
    DatabaseController api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit =(Button) findViewById(R.id.edit);
        api = new DatabaseController();
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                api.getProduct("1");
            }
        });
    }
}
