package com.example.hb2013.contactapp.util;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by hb2013 on 2017-02-25.
 */

public class BackPressCloseHandler {
    private long backKeyPressedTime=0;
    private Toast toast;
    private Activity activity;

    public BackPressCloseHandler(Activity activity) {

        this.activity = activity;
    }
    public void onBackPressed(){
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime=System.currentTimeMillis();
            Toast.makeText(activity,"\'뒤로\'버튼을 한번 더 누르면 종료됩니다",
                    Toast.LENGTH_LONG).show();
        }
    }




}
