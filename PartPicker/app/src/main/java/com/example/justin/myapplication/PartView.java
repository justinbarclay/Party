package com.example.justin.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartView extends Activity implements PartWatcher {
    private Button edit;
    private TextView name;
    private TextView location;
    private TextView count;
    PartsController partsApi;
    String partID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit =(Button) findViewById(R.id.edit);

        name =(TextView) findViewById(R.id.name);
        location =(TextView) findViewById(R.id.location);
        count =(TextView) findViewById(R.id.count);
        partsApi = new PartsController(this);
        partID = getIntent().getStringExtra("partID");
        partsApi.getPart(partID);
    }


    public void setPart(Part part){
        name.setText(part.getName());
        location.setText(part.getLocation());
        count.setText(part.getCount());
    }

    public void setPartList(ArrayList<HashMap<String,String>> parts){}
}
