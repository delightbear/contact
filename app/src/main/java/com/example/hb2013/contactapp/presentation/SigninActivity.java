package com.example.hb2013.contactapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hb2013.contactapp.R;
import com.example.hb2013.contactapp.domain.MemberBean;
import com.example.hb2013.contactapp.service.MemberService;
import com.example.hb2013.contactapp.service.MemberServiceImpl;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etID, etPass;
    Button btLogin, btCancel;
    MemberService service;
    MemberBean member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        service = new MemberServiceImpl(this.getApplicationContext());
        member = new MemberBean();
        etID = (EditText) findViewById(R.id.etID);
        etPass = (EditText) findViewById(R.id.etPass);

        btLogin = (Button) findViewById(R.id.btLogin);
        btCancel = (Button) findViewById(R.id.btCancel);

        btLogin.setOnClickListener(this);
        btCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btLogin:
                String id=etID.getText().toString();
                String pass=etPass.getText().toString();
                member.setId(id);
                member.setPass(pass);
                if(service.login(member)) { //true를 리턴하면
                    Log.d("로그인:","성공");
                    startActivity(new Intent(SigninActivity.this, ListActivity.class)); //리스트화면으로
                }else{
                    Toast.makeText(SigninActivity.this,"로그인실패",Toast.LENGTH_LONG).show();
                    //startActivity(new Intent(SigninActivity.this, SigninActivity.class));//다시 로그인화면
                }

                //Intent i = new Intent(SigninActivity.this, DetailActivity.class);
                //startActivity(i);
                //Toast.makeText(SigninActivity.this, "LOGIN",Toast.LENGTH_LONG).show();
                //startActivity(new Intent(SigninActivity.this, DetailActivity.class));

                break;
            case R.id.btCancel:

                break;

        }
    }
}
