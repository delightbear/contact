package com.example.hb2013.contactapp.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hb2013.contactapp.R;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener{
    EditText etID, etPass;
    Button btSubmit, btCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etID= (EditText) findViewById(R.id.etID);
        etPass= (EditText) findViewById(R.id.etPass);

        btSubmit= (Button) findViewById(R.id.btSubmit);
        btCancel= (Button) findViewById(R.id.btCancel);

        btSubmit.setOnClickListener(this);
        btCancel.setOnClickListener(this);

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btSubmit:

                break;
            case R.id.btCancel:

                break;

        }
    }
}
