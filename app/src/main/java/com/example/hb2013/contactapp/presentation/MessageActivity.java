package com.example.hb2013.contactapp.presentation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hb2013.contactapp.R;

public class MessageActivity extends AppCompatActivity {
    TextView tvToSms;
    EditText etMessage;
    Button btSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        tvToSms= (TextView) findViewById(R.id.tvToSms);
        tvToSms.setText(this.getIntent().getExtras().getString("phone"));
        etMessage.findViewById(R.id.etMessage);
        btSend = (Button) findViewById(R.id.btSend);
        btSend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSMS();
            }
        });
    }

    protected void sendSMS() {
        Log.i("Send SMS", "");
        String telNo=tvToSms.getText().toString();
        Uri smsUri=Uri.parse("tel:"+telNo);
        Intent smsIntent = new Intent(Intent.ACTION_VIEW,smsUri);
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address", telNo);
        smsIntent.putExtra("sms_body", etMessage.getText().toString());
        try {
            startActivity(smsIntent);
            finish();
            Log.i("Finished sending SMS...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MessageActivity.this,
                    "SMS faild, please try again later.",
                    Toast.LENGTH_LONG).show();
        }
    }
}
