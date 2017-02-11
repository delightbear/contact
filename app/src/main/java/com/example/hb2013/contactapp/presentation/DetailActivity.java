package com.example.hb2013.contactapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hb2013.contactapp.R;
import com.google.android.gms.common.api.GoogleApiClient;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    Button btUpdate, btList, btCall, btSendMsg, btPos;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        btUpdate = (Button) findViewById(R.id.btUpdate);
        btList = (Button) findViewById(R.id.btList);
        btCall = (Button) findViewById(R.id.btCall);
        btSendMsg = (Button) findViewById(R.id.btSendMsg);
        btPos = (Button) findViewById(R.id.btPos);


        btUpdate.setOnClickListener(this);
        btList.setOnClickListener(this);
        btCall.setOnClickListener(this);
        btSendMsg.setOnClickListener(this);
        btPos.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btList:
                Toast.makeText(DetailActivity.this, "LIST", Toast.LENGTH_LONG).show();
                startActivity(new Intent(DetailActivity.this, ListActivity.class));
                break;

            case R.id.btUpdate:

                Toast.makeText(DetailActivity.this, "UPDATE", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(DetailActivity.this, UpdateActivity.class);
                intent.putExtra("id", "hong");
                startActivity(intent);
                break;

            case R.id.btCall:
                break;

            case R.id.btSendMsg:
                break;

            case R.id.btPos:
                break;

            case R.id.btDel:
                break;

        }

    }


}
