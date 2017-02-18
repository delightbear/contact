package com.example.hb2013.contactapp.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.hb2013.contactapp.domain.MemberBean;

import java.util.ArrayList;

/**
 * Created by hb2013 on 2017-02-11.
 */

//String sql은 sql을 위해 만든 string이기 때문에 쿼리문이 들어가는 부분에선
//미리 String sql = String.format("%S","");을 적어놓고 나중에 채워놓는 것도 한 방법이다.

public class MemberDAO extends SQLiteOpenHelper{
    public MemberDAO(Context context) {
        super(context, "testtest.db", null, 1);
        this.getWritableDatabase();
        // "" 은 DB의 주소값을 갖게 됨. null 내가 만든거로 쓰겠다? 1은 버젼이라고 생각하면 됨.

    }



    //id,pass,name,phone,addr,profile
    @Override
    public void onCreate(SQLiteDatabase db) { // 테이블 생성 쿼리문 넣을 곳
        String sql=String.format("%s","CREATE TABLE IF NOT EXISTS Member\n" +
                "(\n" +
                "id text(20) PRIMARY KEY,\n" +
                "pass text(20),\n" +
                "name text(20),\n" +
                "email text(20),\n" +
                "phone text(20),\n" +
                "addr text(20),\n" +
                "profile text(20));");
        db.execSQL(sql);
        db.execSQL("CREATE TABLE IF NOT EXISTS Message(\n" +
                "  \t_id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    sender TEXT(20),\n" +
                "    receiver TEXT(20),\n" +
                "    content TEXT(20),\n" +
                "    writeTime TEXT(20),\n" +
                "    id TEXT,\n" +
                "    FOREIGN KEY(id) REFERENCES Member(id)\n" +
                ");\n");
/*
        db.execSQL("INSERT INTO Member(id,pass,name,email,phone,profile,addr)\n" +
                "VALUES('hong','1','홍길동','hong@test.com','010-1234-5678','default_profile','서울');");
        db.execSQL("INSERT INTO Member(id,pass,name,email,phone,profile,addr)\n" +
                "VALUES('kim','1','김유신','kim@test.com','010-1234-5678','default_profile','서울');");
        db.execSQL("INSERT INTO Member(id,pass,name,email,phone,profile,addr)\n" +
                "VALUES('lee','1','이순신','lee@test.com','010-1234-5678','default_profile','서울');");
        db.execSQL("INSERT INTO Member(id,pass,name,email,phone,profile,addr)\n" +
                "VALUES('park','1','박지성','park@test.com','010-1234-5678','default_profile','부산');");
        db.execSQL("INSERT INTO Member(id,pass,name,email,phone,profile,addr)\n" +
                "VALUES('yoo','1','유비','yoo@test.com','010-1234-5678','default_profile','인천');");
*/

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    //CREATE
    public void add(MemberBean bean){
        String sql=String.format("INSERT INTO Member " +
                "(id,pass,name,email,phone,profile,addr) VALUES " +
                "('%s','%s','%s','%s','%s','%s');",
                bean.getId(),bean.getPass(),bean.getName(), bean.getEmail(), bean.getPhone()
                ,bean.getProfile(),bean.getAddr());

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();


    }

    //READ ONE
    public MemberBean findOne(MemberBean bean){
        MemberBean member = new MemberBean();

        String sql=String.format("SELECT id,pass,name,email,phone,profile,addr " +
                "FROM Member WHERE id = '%s'",bean.getId());
        //bean으로 넘어온 값의 ID를 가져온다. ID를 비교해서 하나의 값을 꺼내온다

        Log.d("login SQL:",sql);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery(sql,null);
        if(cursor.moveToNext()){
            Log.d("ID결과:",cursor.getString(1));
            member.setId(cursor.getString(0));
            member.setPass(cursor.getString(1));
            member.setName(cursor.getString(2));
            member.setEmail(cursor.getString(3));
            member.setPhone(cursor.getString(4));
            member.setProfile(cursor.getString(5));
            member.setAddr(cursor.getString(6));
        } else {
            member.setId("fail");
        }
        Log.d("login result:",member.getId());

        return member;

    } //  비번이 있어서 보안하는 것임
       // 추상을 {}로 바꿨을때 에러가 뜨는건 리턴값이 잇어야 하는데 없어서임
       //  리턴값을 설정해줌 멤버빈은 멤버빈이 리턴하니까 멤버빈을 만들어서 리턴하는 것으로

    //READ SOME
    public ArrayList<MemberBean> findSome(String keyword){
        ArrayList<MemberBean> list = new ArrayList<MemberBean>();
        String sql=String.format("SELECT id,pass,name,phone,addr,profile " +
                "FROM Member WHERE name = '%s'",keyword);
        ; //싱글쿼터(') 주의
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor !=null){
            Log.d("Member ","Exit !!");
            cursor.moveToFirst();
        }
        do{
            MemberBean member = new MemberBean();
            member.setId(cursor.getString(0));
            member.setPass(cursor.getString(1));
            member.setName(cursor.getString(2));
            member.setEmail(cursor.getString(3));
            member.setPhone(cursor.getString(4));
            member.setProfile(cursor.getString(5));
            member.setAddr(cursor.getString(6));
            list.add(member);
        }while(cursor.moveToNext());
        Log.d("Member Count: ",String.valueOf(list.size()));
        return list;
    }

    //READ ALL
    public ArrayList<MemberBean> selectAll(){
        ArrayList<MemberBean> list = new ArrayList<MemberBean>();
        String sql="SELECT id,pass,name,email,phone,profile,addr\n" +
                " FROM Member;";
                //컬럼부분 = 읽어올 데이터 분류? 스키마?
                //테이블 부분 = 클래스가 됨?
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor !=null){
            Log.d("Member ","Exit !!");
            cursor.moveToFirst();
        }
        do{
            MemberBean member = new MemberBean();
            member.setId(cursor.getString(0));
            member.setPass(cursor.getString(1));
            member.setName(cursor.getString(2));
            member.setEmail(cursor.getString(3));
            member.setPhone(cursor.getString(4));
            member.setProfile(cursor.getString(5));
            member.setAddr(cursor.getString(6));
            list.add(member);
        }while(cursor.moveToNext());
        Log.d("Member Count: ",String.valueOf(list.size()));
        return list;

    }

    //UPDATE
    public void update(MemberBean bean){


        String sql = String.format("UPDATE Member SET pass='%s'," +
                "phone='%s', addr='%s', profile='%s' WHERE id='%s';",
                bean.getPass(), bean.getPhone(), bean.getAddr(), bean.getProfile(),
                bean.getId());

        SQLiteDatabase db= this.getWritableDatabase();
        db.execSQL(sql);
        db.close();

    }

    //DELETE
    public void delete(MemberBean bean){
    String sql = String.format("DELETE FROM Member " +
            "WHERE id='%s'; ", bean.getId());

        SQLiteDatabase db= this.getWritableDatabase();
        db.execSQL(sql);
        db.close();

    }



}