package com.example.phonepermission;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;
import android.Manifest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] PERMISSIONS=new String[]{
                Manifest.permission.CALL_PHONE
        };
        if(!hasPermissions(MainActivity.this,PERMISSIONS)){
            ActivityCompat.requestPermissions(MainActivity.this,PERMISSIONS,1);
        }
    }
    private boolean hasPermissions(Context context,String...PERMISSIONS){
        if(context != null && PERMISSIONS != null){
            for(String permission: PERMISSIONS){
                if(ActivityCompat.checkSelfPermission(context,permission)!= PackageManager.PERMISSION_GRANTED){
                    return false;

                }
            }
        }
        return true;
    }

    public void onRequestPermissionsResult(int requestCode,@NonNull String[] permissions,@NonNull int[]grantResults){
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        if(requestCode==1){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"Calling Permission is granted",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"Calling Permission is denied",Toast.LENGTH_LONG).show();
            }
        }
    }
}