package com.example.hb2013.contactapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.hb2013.contactapp.R;

public class UpdateActivity extends AppCompatActivity {
    EditText etID, etName, etPhone, etAddr, etProfile;
    Button btSubmit, btCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Intent intent = this.getIntent();
        String id=intent.getExtras().getString("id");
        /*15-16줄: Detail의 수정버튼에서 보내온 intent의 값을 getextra를 이용하여 가져오는 것 */

        etID = (EditText) findViewById(R.id.etID);
        etName = (EditText) findViewById(R.id.etName);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etAddr = (EditText) findViewById(R.id.etAddr);
        btSubmit = (Button) findViewById(R.id.btSubmit);
        btCancel = (Button) findViewById(R.id.btCancel);


    }
}
