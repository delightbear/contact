package com.example.hb2013.contactapp.presentation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.hb2013.contactapp.R;
import com.example.hb2013.contactapp.domain.MemberBean;
import com.example.hb2013.contactapp.service.MemberService;
import com.example.hb2013.contactapp.service.MemberServiceImpl;
import com.example.hb2013.contactapp.util.MemberAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    Button btMypage;
    MemberService service;
    ListView lvMemberlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        service= new MemberServiceImpl(this.getApplicationContext());
        lvMemberlist = (ListView) findViewById(R.id.lvMemberlist);
        btMypage = (Button) findViewById(R.id.btMypage);
        ArrayList<MemberBean> list = service.list();
        Log.d("리스트에 담긴 값의 수:",String.valueOf(list.size()));
        lvMemberlist.setAdapter(new MemberAdapter(list,this));
        lvMemberlist.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int i, long l) {
                Object o= lvMemberlist.getItemAtPosition(i);
                MemberBean member = (MemberBean) o;
                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                intent.putExtra("id",member.getId());
                startActivity(intent);
            }
        });
        btMypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object o= lvMemberlist.getItemAtPosition(0);
                MemberBean member = (MemberBean) o;
                Intent intent = new Intent(ListActivity.this, MypageActivity.class);
                intent.putExtra("id",member.getId());
                startActivity(intent);
            }
        });

        lvMemberlist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View v, int i, long l) {
                Object o= lvMemberlist.getItemAtPosition(i);
                final MemberBean member = (MemberBean) o;
                new AlertDialog.Builder(ListActivity.this)
                        .setTitle("삭제?")
                        .setMessage("정말로 삭제하시겠습니까?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                service.delete(member);
                                Intent intent = new Intent(ListActivity.this, ListActivity.class);
                                startActivity(intent);


                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();

                return true;
            }
        });


    }

}
