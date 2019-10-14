package com.volleyapplication.VolleyClasses;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UpdateRecord {

    Context context;

    public UpdateRecord(Context context) {
        this.context = context;
    }


    public void UpdateRecordFunction(String id, String name, String contact_no, String address) {



        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String message = jsonObject.getString("message");
                    boolean isSuccess = jsonObject.getBoolean("success");

                    if(isSuccess)
                    {
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.d("AddRecordFunctionLog", "response : " + response);

            }
        };


        UpdateRecordRequest updateRecordRequest = new UpdateRecordRequest(id, name, contact_no, address, listener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(updateRecordRequest);


    }




    public class UpdateRecordRequest extends StringRequest {

        private Map<String, String> params;

        public UpdateRecordRequest(String id, String name, String contact_no, String address, Response.Listener<String> listener)
        {

            super(Method.POST, ServerUrls.UpdateRecord, listener,null);
            setRetryPolicy(new DefaultRetryPolicy(30000, 0,1));
            params = new HashMap<>();
            params.put("id", id);
            params.put("name", name);
            params.put("contact_no", contact_no);
            params.put("address", address);

        }

        public Map<String, String> getParams()
        {
            return params;
        }
    }
}
