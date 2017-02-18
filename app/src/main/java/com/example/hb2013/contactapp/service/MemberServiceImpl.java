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
        dao.add(bean);


    }

    @Override
    public MemberBean findOne(MemberBean bean) {
        return dao.findOne(bean);
    }

    @Override
    public boolean login(MemberBean bean) {
        //boolean flag =false; // 초기화
        MemberBean member = this.findOne(bean);
        /*if(!member.getId().equals("fail") && member.getPass().equals(bean.getPass())){ // fail이 아니면
            flag = true;   // flag는 true가 된다. (서비스가 던져준 참과 거짓을 판단하여 어느 화면으로 갈지 결정)
        } 라는 부분을 41번처럼 바로 가는 것으로 표현한다.(단순화) */
        return !member.getId().equals("fail") && member.getPass().equals(bean.getPass());
    }

    @Override
    public ArrayList<MemberBean> findSome(String keyword) {
        return null;
    }

    @Override
    public ArrayList<MemberBean> list() {

        return dao.selectAll();
    }

    @Override
    public void update(MemberBean bean) {

    }

    @Override
    public void delete(MemberBean bean) {
        dao.delete(bean);

    }
}
