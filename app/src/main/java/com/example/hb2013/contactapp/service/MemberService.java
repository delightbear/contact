package com.example.hb2013.contactapp.service;

import com.example.hb2013.contactapp.domain.MemberBean;

import java.util.ArrayList;

/**
 * Created by hb2013 on 2017-02-04.
 */

public interface MemberService {
    //CREATE
    public void add(MemberBean bean);

    //READ ONE
    public MemberBean findOne(MemberBean bean); // 비번이 있어서 보안하는 것임
    public boolean login(MemberBean bean);

    //READ SOME
    public ArrayList<MemberBean> findSome(String keyword);

    //READ ALL
    public ArrayList<MemberBean> list();

    //UPDATE
    public void update(MemberBean bean);

    //DELETE
    public void delete(MemberBean bean);

}
