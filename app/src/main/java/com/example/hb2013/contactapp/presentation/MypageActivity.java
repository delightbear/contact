package com.example.hb2013.contactapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hb2013.contactapp.R;

public class MypageActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView iv_photo;
    TextView tvId,tvPass,tvName,tvPhone,tvAddr;
    Button btAlbum, btSchedule, btMyhomepage, btNaver,btDelete,btUnregist,btUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);
        iv_photo = (ImageView) findViewById(R.id.iv_photo);
        tvId= (TextView) findViewById(R.id.tvId);
        tvName= (TextView) findViewById(R.id.tvName);
        tvPhone= (TextView) findViewById(R.id.tvPhone);
        tvAddr= (TextView) findViewById(R.id.tvAddr);

        btAlbum= (Button) findViewById(R.id.btAlbum);
        btSchedule= (Button) findViewById(R.id.btSchedule);
        btMyhomepage= (Button) findViewById(R.id.btMyhomepage);
        btNaver= (Button) findViewById(R.id.btNaver);
        btUpdate= (Button) findViewById(R.id.btUpdate);
        btDelete= (Button) findViewById(R.id.btDelete);
        btUnregist = (Button) findViewById(R.id.btUnregist);

        btAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MypageActivity.this, AlbumActivity.class));

            }
        });
        btSchedule.setOnClickListener(this);
        btMyhomepage.setOnClickListener(this);
        btNaver.setOnClickListener(this);
        btUpdate.setOnClickListener(this);
        btDelete.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

    }
}
