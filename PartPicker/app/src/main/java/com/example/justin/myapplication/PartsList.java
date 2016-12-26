package com.example.justin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class PartsList extends Activity implements PartWatcher {
    private ListView partsList;
    private PartsController partsApi;
    private PartsAdapter partsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parts_list_view);
        partsApi = new PartsController(this);

        partsAdapter = new PartsAdapter(this, new ArrayList<HashMap<String, String>>());
        partsList = (ListView) findViewById(R.id.partsList);
        partsList.setAdapter(partsAdapter);
    }

    @Override
    public void onResume(){
        super.onResume();
        partsApi.getAllParts();
        partsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), PartView.class);
                intent.putExtra("partID", ((HashMap<String,String>) parent.getItemAtPosition(position)).get("id"));
                startActivity(intent);
            }
        });
    }

    public void setPartList(ArrayList<HashMap<String,String>> parts){
        partsAdapter.clear();
        partsAdapter.addAll(parts);
        partsAdapter.notifyDataSetChanged();
    }

    public void setPart(Part part){}

}
