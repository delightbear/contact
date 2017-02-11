package com.example.hb2013.contactapp.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hb2013.contactapp.R;

public class MypageActivity extends AppCompatActivity implements View.OnClickListener{
TextView tvId,tvName,tvPhone,tvAddr;
Button btAlbum,btSche,btGoogle,btNaver,btUpdate,btDel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);
        tvId= (TextView) findViewById(R.id.tvId);
        tvName= (TextView) findViewById(R.id.tvName);
        tvPhone= (TextView) findViewById(R.id.tvPhone);
        tvAddr= (TextView) findViewById(R.id.tvAddr);

        btAlbum= (Button) findViewById(R.id.btAlbum);
        btSche= (Button) findViewById(R.id.btSche);
        btGoogle= (Button) findViewById(R.id.btGoogle);
        btNaver= (Button) findViewById(R.id.btNaver);
        btUpdate= (Button) findViewById(R.id.btUpdate);
        btDel= (Button) findViewById(R.id.btDel);

        btAlbum.setOnClickListener(this);
        btSche.setOnClickListener(this);
        btGoogle.setOnClickListener(this);
        btNaver.setOnClickListener(this);
        btUpdate.setOnClickListener(this);
        btDel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btAlbum:

                break;
            case R.id.btSche:

                break;
            case R.id.btGoogle:

                break;
            case R.id.btNaver:

                break;
            case R.id.btUpdate:

                break;
            case R.id.btDel:

                break;
        }

    }
}
