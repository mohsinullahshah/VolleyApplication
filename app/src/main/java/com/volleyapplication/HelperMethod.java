package com.volleyapplication;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.SmsManager;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;


public class HelperMethod {

    private static Context context;

    public HelperMethod(Context context) {
        this.context = context;
    }


    //==================== Intertitial Adds Function ====================================================

    public boolean isConnectingToInternet() {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {

            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED &&   info[i].getState() != NetworkInfo.State.SUSPENDED) {

                        return true;
                    }
        }

        return false;
    }









    public String SharePrefrenceGetValue(String key){
        SharedPreferences prefs  = context.getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
        return prefs.getString(key , "");
    }

    public void SharePrefrenceSaveValue(String key, String value){
        SharedPreferences prefs = context.getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =  prefs.edit();
        editor.putString(key , value);
        editor.commit();
    }


    public void SharePrefrenceSaveBoolean(String key, Boolean value){
        SharedPreferences prefs = context.getApplicationContext().getSharedPreferences("UserWelcome", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =  prefs.edit();
        editor.putBoolean(key , value);
        editor.commit();
    }

    public Boolean SharePrefrenceGetBoolean(String key){
        SharedPreferences prefs  = context.getApplicationContext().getSharedPreferences("UserWelcome", Context.MODE_PRIVATE);
        return prefs.getBoolean(key , false);
    }

    public void SendSmsFunction(String phoneNumber, String message) {
        try {

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            Toast.makeText(context, "SMS sent to: " + phoneNumber, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(context, "SMS faild to: " + phoneNumber, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }


    public void ShowAlertDialog(String title, String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                return;
            }
        });

        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }



    //====================================================================


    public static boolean isEditTextvalidate(EditText[] fields){
        for(int i=0; i<fields.length; i++){
            EditText currentField=fields[i];
            if(currentField.getText().toString().length()<=0){
                return false;
            }
        }
        return true;
    }

    public String SharePrefrenceValuesSave(String key){
        SharedPreferences prefs  = context.getSharedPreferences("bloodbank", Context.MODE_PRIVATE);
        return prefs.getString(key , "");
    }

    public void SharePrefrenceValuesGet(String key, String value){
        SharedPreferences prefs = context.getSharedPreferences("bloodbank", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =  prefs.edit();
        editor.putString(key , value);
        editor.commit();
    }



    //Done
    public void clearApplicationData() {
        File cache = context.getCacheDir();
        File appDir = new File(cache.getParent());
        if (appDir.exists()) {
            String[] children = appDir.list();
            for (String s : children) {
                if (!s.equals("lib")) {
                    deleteDir(new File(appDir, s));
                    // Log.i("EEEEEERRRRRRROOOOOOORRRR", "**************** File /data/data/APP_PACKAGE/" + s + " DELETED *******************");
                }
            }
        }
    }

    //Done
    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }

        return dir.delete();
    }


    public static void ShareAppFunction() {

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        shareIntent.setType("text/plain");
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "http://play.google.com/store/apps/details?id=" + context.getPackageName());
        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT){
            context.startActivity(shareIntent);
        }
        else {
            context.startActivity(Intent.createChooser(shareIntent, "share"));
        }

    }






    //====================================================================
}
