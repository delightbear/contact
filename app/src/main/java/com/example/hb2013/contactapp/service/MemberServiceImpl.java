package com.example.hb2013.contactapp.service;

import android.content.Context;

import com.example.hb2013.contactapp.dao.MemberDAO;
import com.example.hb2013.contactapp.domain.MemberBean;

import java.util.ArrayList;

/**
 * Created by hb2013 on 2017-02-04.
 */

public class MemberServiceImpl implements MemberService {
    MemberDAO dao;

    public MemberServiceImpl(Context context) {
        dao = new MemberDAO(context);

    }

    @Override
    public void add(MemberBean bean) {


    }

    @Override
    public MemberBean findOne(MemberBean bean) {
        return dao.findOne(bean);
    }

    @Override
    public ArrayList<MemberBean> findSome(String keyword) {
        return null;
    }

    @Override
    public ArrayList<MemberBean> list() {
        return null;
    }

    @Override
    public void update(MemberBean bean) {

    }

    @Override
    public void delete(MemberBean bean) {

    }
}
