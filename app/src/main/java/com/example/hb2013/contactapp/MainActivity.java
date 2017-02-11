package com.example.hb2013.contactapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hb2013.contactapp.presentation.SigninActivity;
import com.example.hb2013.contactapp.presentation.SignupActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btSignUp, btSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSignUp=(Button) findViewById(R.id.btSignUp);
        btSignIn=(Button) findViewById(R.id.btSignIn);
        btSignIn.setOnClickListener(this);
        btSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) // 온클릭이 발생한 v(버튼)의 아이디를 가져온다
        {
            //SignUp 버튼을 눌렀을 때
            case R.id.btSignUp:
                //signup 화면으로 이동
                /*
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
                책에선 이렇게 하지만 메모리사용을 줄이기 위해 아래와 같이 간단하게 하겠음.
                 */
                //생성자로 객체 생성
                // MainActivity.this = this.getApplicationContext()가 from이고, SignupActivity.clss는 to 라고 생각하면 됨.
                //ApplicationContext는 위치라고 생각하면 됨. 현재 위치.
                // java가 컴파일을 하면 class가 되기 때문에 프로그램 실행중에 불러오는 것이니 class로 불러옴.
                /*

                객체 = instance 인스턴스, Reference 레퍼런스, object 오브젝트, class 클래스
                class : 디파인의 목적의 객체
                object : 모든 객체의 아버지? 상속구조의 최상위의 객체
                reference : 기능을 가져오는 (참조하는) 객체
                instance : 어떠한 값이 담겨져 있을 때(리얼값)의 객체

                 */
                /*
                Toast t =Toast.makeText(MainActivity.this, "Go to Add",Toast.LENGTH_LONG);
                t.show();
                정석적인 자바의 문법으로 하면 44~45처럼 쓰지만...?
                */
                Toast.makeText(MainActivity.this, "Go to Add",Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, SignupActivity.class));
                /* 57-58번은 생성하는 방식이니 기억해둘것 */
                break;

            //Signin 버튼을 눌렀을 때
            case R.id.btSignIn:
                Toast.makeText(MainActivity.this, "Go to Login",Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, SigninActivity.class));
                break;

        }

    }
}
