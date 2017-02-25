package com.example.hb2013.contactapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hb2013.contactapp.presentation.SigninActivity;
import com.example.hb2013.contactapp.presentation.SignupActivity;
import com.example.hb2013.contactapp.service.MemberService;
import com.example.hb2013.contactapp.service.MemberServiceImpl;
import com.example.hb2013.contactapp.util.BackPressCloseHandler;


public class MainActivity extends AppCompatActivity{
    Button btJoin,btLogin;
    MemberService service;
    private BackPressCloseHandler backPressCloseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        android.support.v7.app.ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        */
         // customBar= LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_bar,null);
         //  actionBar.setCustomView(customBar);
         //  menu_home= (TextView) findViewById(menu_home);
        btJoin= (Button) findViewById(R.id.btJoin);
        btLogin= (Button) findViewById(R.id.btLogin);
        //    btKakaoStory= (Button) findViewById(R.id.btKakaoStory);
        service = new MemberServiceImpl(this.getApplicationContext());
        backPressCloseHandler = new BackPressCloseHandler(this);

        btJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Go to Add",Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, SignupActivity.class));
            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SigninActivity.class));
            }
        });
    }


}

