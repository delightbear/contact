package com.example.hb2013.contactapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hb2013.contactapp.R;
import com.example.hb2013.contactapp.domain.MemberBean;
import com.example.hb2013.contactapp.service.MemberService;
import com.example.hb2013.contactapp.service.MemberServiceImpl;
import com.example.hb2013.contactapp.util.Phone;


public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView ivProfile;
    TextView tvId, tvName, tvEmail, tvPhone, tvAddr;
    Button btCall, btMessge, btMap, btDel, btEdit, btList;



    MemberService service;
    MemberBean member;
    Phone phone;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        service=new MemberServiceImpl(this);
        member = new MemberBean();
        phone= new Phone(this,this);
        Intent intent =this.getIntent();
        String id=intent.getExtras().getString("id");
        member.setId(id);
        member = service.findOne(member);



        btCall = (Button) findViewById(R.id.btCall);
        btMessge = (Button) findViewById(R.id.btMessge);
        btMap = (Button) findViewById(R.id.btMap);
        btDel = (Button) findViewById(R.id.btDel);
        btEdit = (Button) findViewById(R.id.btEdit);
        btList = (Button) findViewById(R.id.btList);

        ivProfile = (ImageView) findViewById(R.id.ivProfile);
        tvId = (TextView) findViewById(R.id.tvId);
        tvName = (TextView) findViewById(R.id.tvName);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvAddr = (TextView) findViewById(R.id.tvAddr);

        //ivProfile
        int temp = getResources().getIdentifier(this.getPackageName()
                +":drawable/default_profile",null,null);
        ivProfile.setImageDrawable(
                getResources()
                 .getDrawable(temp,this.getApplicationContext().getTheme()));

        tvId.setText(member.getId());
        tvName.setText(member.getName());
        tvEmail.setText(member.getEmail());
        tvPhone.setText(member.getPhone());
        tvAddr.setText(member.getAddr());

        btCall.setOnClickListener(this);
        btMessge.setOnClickListener(this);
        btMap.setOnClickListener(this);
        btDel.setOnClickListener(this);
        btEdit.setOnClickListener(this);
        btList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btCall :
                phone.directCall(member.getPhone());

                break;
            case R.id.btMessge :
                Intent smsIntent = new Intent(DetailActivity.this,MessageActivity.class);
                smsIntent.putExtra("phone",member.getPhone());
                startActivity(smsIntent);
                break;
            case R.id.btMap :
                break;
            case R.id.btDel :
                break;
            case R.id.btEdit :
                Intent intent = new Intent(DetailActivity.this, UpdateActivity.class);
                intent.putExtra("id", "hyun");
                Toast.makeText(DetailActivity.this, "Go EDIT", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;
            case R.id.btList :
                Toast.makeText(DetailActivity.this, "GO LiST", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DetailActivity.this, ListActivity.class));
                break;
        }
    }



}
