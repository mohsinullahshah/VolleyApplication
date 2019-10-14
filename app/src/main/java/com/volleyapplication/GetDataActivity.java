package com.volleyapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.volleyapplication.VolleyClasses.GetAllData;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class GetDataActivity extends AppCompatActivity {


    Button btnGetData;
    TextView txtData;

    RecyclerView recycler_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);

        btnGetData = (Button)findViewById(R.id.btnGetData);

        recycler_view = (RecyclerView)findViewById(R.id.recycler_view);


        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GetAllData getAllData = new GetAllData(GetDataActivity.this);
                getAllData.GetAllDataFunction();
            }
        });
    }






}
