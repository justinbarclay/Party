package com.example.justin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class PartsList extends Activity implements PartWatcher {
    private ListView partsList;
    private PartsController partsApi;
    private PartsAdapter partsAdapter;
    private Button scan;
    private IntentIntegrator integrator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parts_list_view);
        partsApi = new PartsController(this);

        partsAdapter = new PartsAdapter(this, new ArrayList<HashMap<String, String>>());
        partsList = (ListView) findViewById(R.id.partsList);
        partsList.setAdapter(partsAdapter);
        scan = (Button) findViewById(R.id.scan);
        integrator = new IntentIntegrator(this);

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan a barcode");
                integrator.setCameraId(0);  // Use a specific camera of the device
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(true);
                integrator.initiateScan();
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        partsApi.getAllParts();
        partsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viewPart(((HashMap<String,String>) parent.getItemAtPosition(position)).get("id"));
            }
        });
    }
    private void viewPart(String id){
        Intent intent = new Intent(getBaseContext(), PartView.class);
        intent.putExtra("partID", id);
        startActivity(intent);
    }
    public void setPartList(ArrayList<HashMap<String,String>> parts){
        partsAdapter.clear();
        partsAdapter.addAll(parts);
        partsAdapter.notifyDataSetChanged();
    }

    public void setPart(Part part){}


    // Get the results:
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                viewPart(result.getContents().substring(3));
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
