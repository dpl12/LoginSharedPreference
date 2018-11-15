package com.example.dpl.loginsharedpreference.Control;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dpl.loginsharedpreference.R;
import com.example.dpl.loginsharedpreference.Utils.BaseActivity;

public class MainActivity extends BaseActivity {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;
    private CheckBox rememberPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accountEdit= (EditText) findViewById(R.id.account);
        passwordEdit= (EditText) findViewById(R.id.password);
        rememberPass= (CheckBox) findViewById(R.id.remember_pass);
        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        login= (Button) findViewById(R.id.login);
        boolean isRemember=preferences.getBoolean("remember_password",false);
        if (isRemember){//将密码和账号设置到文本框中
            String account=preferences.getString("account","");
            String password=preferences.getString("password","");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account=accountEdit.getText().toString().trim();
                String password=passwordEdit.getText().toString().trim();
                if (account.equals("admin")&&password.equals("123")){
                    editor=preferences.edit();
                    if (rememberPass.isChecked()) {
                        editor.putString("account", account);
                        editor.putString("password", password);
                        editor.putBoolean("remember_password", true);
                    }else {
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent=new Intent(MainActivity.this,SuccessActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(MainActivity.this,"输入有误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
