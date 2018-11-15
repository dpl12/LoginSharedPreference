package com.example.dpl.loginsharedpreference.Control;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dpl.loginsharedpreference.R;
import com.example.dpl.loginsharedpreference.Utils.ActivityCollector;
import com.example.dpl.loginsharedpreference.Utils.BaseActivity;

public class SuccessActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        findViewById(R.id.finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.example.dpl.loginsharedpreference.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }
}
