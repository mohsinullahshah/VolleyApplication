package com.volleyapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.volleyapplication.VolleyClasses.DeleteRecord;
import com.volleyapplication.VolleyClasses.UpdateRecord;

public class UpdateRecordActivity extends AppCompatActivity {

    EditText etId, etName, etContactNumber, etAddress;
    Button btnUpdate, btnDelete, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record);

        etId = (EditText)findViewById(R.id.etId);
        etName = (EditText)findViewById(R.id.etName);
        etContactNumber = (EditText)findViewById(R.id.etContactNumber);
        etAddress = (EditText)findViewById(R.id.etAddress);

        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnClear = (Button)findViewById(R.id.btnClear);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = etId.getText().toString();
                String name = etName.getText().toString();
                String contact_number = etContactNumber.getText().toString();
                String address = etAddress.getText().toString();

                UpdateRecord updateRecord = new UpdateRecord(UpdateRecordActivity.this);
                updateRecord.UpdateRecordFunction(id,name,contact_number,address);

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = etId.getText().toString();

                DeleteRecord deleteRecord = new DeleteRecord(UpdateRecordActivity.this);
                deleteRecord.DeleteRecordFunction(id);

            }
        });


    }


}
