package com.example.hb2013.contactapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hb2013.contactapp.R;
import com.example.hb2013.contactapp.domain.MemberBean;
import com.example.hb2013.contactapp.service.MemberService;
import com.example.hb2013.contactapp.service.MemberServiceImpl;

public class UpdateActivity extends AppCompatActivity {
    TextView tvID,tvName;
    EditText etPhone,etAddr,etPass,etPhoto;
    Button btUpdate,btCancel;
    MemberService service;
    MemberBean member;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        final Intent intent = this.getIntent();
        String id=intent.getExtras().getString("id");
        /*15-16줄: Detail의 수정버튼에서 보내온 intent의 값을 getextra를 이용하여 가져오는 것 */

        service = new MemberServiceImpl(this.getApplicationContext());
        member.setId(id);
        member=service.findOne(member);

        tvID= (TextView) findViewById(R.id.tvId);
        tvName= (TextView) findViewById(R.id.tvName);
        etPhone= (EditText) findViewById(R.id.etPhone);
        etAddr= (EditText) findViewById(R.id.etAddr);
        etPhoto= (EditText) findViewById(R.id.etPhoto);
        etPass= (EditText) findViewById(R.id.etPass);
        btUpdate= (Button) findViewById(R.id.btUpdate);
        btCancel= (Button) findViewById(R.id.btCancel);

        tvID.setText(member.getId());
        tvName.setHint(member.getName());
        etAddr.setHint(member.getAddr());
        etPass.setHint(member.getPass());
        etPhone.setHint(member.getPhone());
        etPhoto.setHint(member.getProfile());

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                member.setId(tvID.getText().toString());
                member.setName(tvName.getText().toString());
                String pass="";
                /*
                if(etPass.getText().equals("")){ //gettext가 NULL이면 값을 안바꿨으면
                    pass = member.getPass(); // 이전의 값을 다시 가져가라
                }else{
                    pass=etPass.getText().toString(); //새로 값을 가져가라
                }
                member.setPass(pass);
                이 61~66의 코드를 아래에 한줄로 표현한다.*/

                member.setPass((etPass.getText().equals(""))?member.getPass():etPass.getText().toString());
                member.setAddr((etPass.getText().equals(""))?member.getAddr():etAddr.getText().toString());
                member.setPhone((etPhone.getText().equals(""))?member.getPhone():etPass.getText().toString());
                member.setProfile((etPhoto.getText().equals(""))?member.getProfile():etPhoto.getText().toString());

                service.update(member);


            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateActivity.this,DetailActivity.class);
                intent.putExtra("id",member.getId());
                startActivity(intent);

            }
        });





    }
}
