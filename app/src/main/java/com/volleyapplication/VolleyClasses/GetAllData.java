package com.volleyapplication.VolleyClasses;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.volleyapplication.MessageEventBus;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAllData {

    Context context;

    public GetAllData(Context context) {
        this.context = context;
    }


    public void GetAllDataFunction()
    {



        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String message = jsonObject.getString("message");
                    boolean isSuccess = jsonObject.getBoolean("success");


                    List<ModalObject> list = new ArrayList<>();
                    JSONArray jsonArray = jsonObject.getJSONArray("full_info");

                    if(jsonArray !=null && jsonArray.length()>0)
                    {
                        for(int i = 0; i<jsonArray.length(); i++)
                        {
                            JSONObject object = jsonArray.getJSONObject(i);
                            ModalObject modalObject = new ModalObject();

                            String id = object.getString("id");
                            String name = object.getString("name");
                            String contact_no = object.getString("contact_no");
                            String address = object.getString("address");

                            modalObject.setId(id);
                            modalObject.setName(name);
                            modalObject.setContact_no(contact_no);
                            modalObject.setAddress(address);

                            list.add(modalObject);
                        }

                    }


                    if(isSuccess)
                    {
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        };


        GetAllDataRequest addRecordRequest = new GetAllDataRequest(listener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(addRecordRequest);


    }






    public class GetAllDataRequest extends StringRequest {

        private Map<String, String> params;

        public GetAllDataRequest(Response.Listener<String> listener)
        {

            super(Method.POST, ServerUrls.GetAllData, listener,null);
            setRetryPolicy(new DefaultRetryPolicy(30000, 0,1));
            params = new HashMap<>();


        }

        public Map<String, String> getParams()
        {
            return params;
        }
    }
}
