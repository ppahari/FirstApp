package com.example.realnapster.firstapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText userName,pswdBox;
    Button loginBtn;
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    private View.OnClickListener onBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            btnClicked();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginBtn =findViewById(R.id.loginButton);
        loginBtn.setOnClickListener(onBtnClickListener);
    }

    private  void btnClicked(){
        userName = findViewById(R.id.userText);
        pswdBox = findViewById(R.id.pswdText);
        loginBtn= findViewById(R.id.loginButton);
        sp = getBaseContext().getSharedPreferences("MyPref",0);
        StringBuilder user = new StringBuilder(userName.getText().toString());
        StringBuilder pswd = new StringBuilder(pswdBox.getText().toString());
        editor = sp.edit();
        editor.putString("User Key",user.toString());
        editor.putString("Password Key",pswd.toString());
        editor.commit();
        Toast.makeText(this,"Thanks! Saved",Toast.LENGTH_LONG).show();

    }
}
