package com.example.hb2013.contactapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hb2013.contactapp.R;
import com.example.hb2013.contactapp.domain.MemberBean;
import com.example.hb2013.contactapp.service.MemberService;
import com.example.hb2013.contactapp.service.MemberServiceImpl;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etID, etPass, etName, etPhone, etAddr,etEmail;
    Button btSubmit, btCancel;
    MemberService service;
    MemberBean member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  //부모를 가져오고
        setContentView(R.layout.activity_signup); // 화면을 만들고
        service = new MemberServiceImpl(this.getApplicationContext());  //서비스를 생성자로 가져오고
        member = new MemberBean();           //멤버도
        etID= (EditText) findViewById(R.id.etID);
        etPass= (EditText) findViewById(R.id.etPass);
        etName= (EditText) findViewById(R.id.etName);
        etPhone= (EditText) findViewById(R.id.etPhone);
        etEmail= (EditText) findViewById(R.id.etEmail);
        etAddr =(EditText) findViewById(R.id.etAddr);

        btSubmit= (Button) findViewById(R.id.btSubmit);
        btCancel= (Button) findViewById(R.id.btCancel);

        btSubmit.setOnClickListener(this);
        btCancel.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btSubmit:
                member.setId(etID.getText().toString());
                member.setPass(etPass.getText().toString());
                member.setName(etName.getText().toString());
                member.setEmail(etEmail.getText().toString());
                member.setPhone(etPhone.getText().toString());
                member.setAddr(etAddr.getText().toString());
                member.setProfile("");

                service.add(member);

                Intent intent = new Intent(SignupActivity.this, SigninActivity.class);
                startActivity(intent);

                break;
            case R.id.btCancel:

                break;

        }
    }
}
