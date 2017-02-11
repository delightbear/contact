package com.example.hb2013.contactapp.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hb2013.contactapp.domain.MemberBean;

import java.util.ArrayList;

/**
 * Created by hb2013 on 2017-02-11.
 */
//String sql은 sql을 위해 만든 string이기 때문에 쿼리문이 들어가는 부분에선
//미리 String sql = String.format("%S","");을 적어놓고 나중에 채워놓는 것도 한 방법이다.

public class MemberDAO extends SQLiteOpenHelper{
    public MemberDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "", null, 1);

    }
    //id,pass,name,phone,addr,profile
    @Override
    public void onCreate(SQLiteDatabase db) { // 테이블 생성 쿼리문 넣을 곳
        String sql=String.format("%s","CREATE TABLE Member\n" +
                "(\n" +
                " id text(10) PRIMARY KEY,\n" + // PRIMARY KEY 중복허용하지않음.
                " pass text(10),\n" +
                " name text(10),\n" +
                " phone text(13),\n" + //하이픈까지 합쳐서 13글자
                " addr text(10),\n" +
                " profile text(10));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    //CREATE
    public void add(MemberBean bean){
        String sql=String.format("INSERT INTO Member " +
                "(id,pass,name,phone,addr,profile) VALUES " +
                "('%s','%s','%s','%s','%s','%s');",
                bean.getId(),bean.getPass(),bean.getName(),bean.getPhone()
                ,bean.getAddr(),bean.getProfile());


    }

    //READ ONE
    public MemberBean findOne(MemberBean bean){
        MemberBean member = new MemberBean();

        String sql=String.format("SELECT id,pass,name,phone,addr,profile " +
                "FROM Member WHERE id = '%s'",bean.getId());
        //bean으로 넘어온 값의 ID를 가져온다. ID를 비교해서 하나의 값을 꺼내온다
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
        return list;
    }

    //READ ALL
    public ArrayList<MemberBean> selectAll(){
        ArrayList<MemberBean> list = new ArrayList<MemberBean>();
        String sql="SELECT id,pass,name,phone,addr,profile\n" +
                " FROM Member;";
                //컬럼부분 = 읽어올 데이터 분류? 스키마?
                //테이블 부분 = 클래스가 됨?

        return list;

    }

    //UPDATE
    public void update(MemberBean bean){


        String sql = String.format("UPDATE Member SET pass='%s'," +
                "phone='%s', addr='%s', profile='%s' WHERE id='%s';",
                bean.getPass(), bean.getPhone(), bean.getAddr(), bean.getProfile(),
                bean.getId());

    }

    //DELETE
    public void delete(MemberBean bean){
    String sql = String.format("DELETE FROM Member " +
            "WHERE id='%s'; ", bean.getId());

    }



}