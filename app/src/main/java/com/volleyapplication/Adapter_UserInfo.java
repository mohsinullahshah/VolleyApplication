package com.volleyapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.volleyapplication.VolleyClasses.ModalObject;

import java.util.ArrayList;
import java.util.List;

public class Adapter_UserInfo extends RecyclerView.Adapter<Adapter_UserInfo.MyViewHolder> {


    Context context;
    List<ModalObject> list = new ArrayList<>();

    public Adapter_UserInfo(Context context, List<ModalObject> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_info, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        ModalObject object = list.get(position);

        myViewHolder.txtId.setText(object.getId());
        myViewHolder.txtName.setText(object.getName());
        myViewHolder.txtContactNo.setText(object.getContact_no());
        myViewHolder.txtAddress.setText(object.getAddress());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView txtId,txtName, txtContactNo, txtAddress;

        public MyViewHolder(@NonNull View view) {
            super(view);

            txtId = (TextView) view.findViewById(R.id.txtId);
            txtName = (TextView) view.findViewById(R.id.txtName);
            txtContactNo = (TextView) view.findViewById(R.id.txtContactNo);
            txtAddress = (TextView) view.findViewById(R.id.txtAddress);


        }
    }
}
