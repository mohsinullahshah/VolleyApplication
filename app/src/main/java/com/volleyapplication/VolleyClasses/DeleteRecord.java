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

public class DeleteRecord {

    Context context;

    public DeleteRecord(Context context) {
        this.context = context;
    }


    public void DeleteRecordFunction(String id) {



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


        DeleteRecordRequest deleteRecordRequest = new DeleteRecordRequest(id, listener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(deleteRecordRequest);


    }




    public class DeleteRecordRequest extends StringRequest {

        private Map<String, String> params;

        public DeleteRecordRequest(String id, Response.Listener<String> listener)
        {

            super(Method.POST, ServerUrls.DeleteRecord, listener,null);

            setRetryPolicy(new DefaultRetryPolicy(30000, 0,1));

            params = new HashMap<>();
            params.put("id", id);


        }

        public Map<String, String> getParams()
        {
            return params;
        }
    }
}
