package com.volleyapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.volleyapplication.VolleyClasses.AddRecord;

public class AddRecordActivity extends AppCompatActivity {

    EditText etName, etContactNumber, etAddress;
    Button btnSave, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        etName = (EditText)findViewById(R.id.etName);
        etContactNumber = (EditText)findViewById(R.id.etContactNumber);
        etAddress = (EditText)findViewById(R.id.etAddress);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnClear = (Button)findViewById(R.id.btnClear);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddRecord addRecord = new AddRecord(AddRecordActivity.this);
                addRecord.AddRecordFunction(etName.getText().toString(),etContactNumber.getText().toString(),etAddress.getText().toString());

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


}
