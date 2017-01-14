package com.example.justin.myapplication;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPart extends Activity implements Message {
    private Button save;
    private PartsController api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_part_view);

        save = (Button) findViewById(R.id.save);
        api = new PartsController(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }

    private void save() {
        EditText name = (EditText) findViewById(R.id.name);
        EditText location = (EditText) findViewById(R.id.location);
        EditText count = (EditText) findViewById(R.id.count);

        Part part = new Part(name.getText().toString(), location.getText().toString(), count.getText().toString());
        System.out.println(part.toString());
        api.savePart(part);
    }

    public void message(String successMessage,Boolean success ){
        if(success) {
            Toast.makeText(this, "Part added", Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(this, "There was an error adding the part", Toast.LENGTH_LONG).show();
        }
    }

}
