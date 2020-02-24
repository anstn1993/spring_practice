package com.moonsoo.web.service;

import com.moonsoo.web.entity.Member;
import com.moonsoo.web.mapper.MemberMapper;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@AllArgsConstructor
public class MemberService {

    private MemberMapper memberMapper;


    @Transactional
    public void insert(String username, String password) {

//        memberDao.insert(username, password);
        memberMapper.insert(username, password);
    }

    public List<Member> list() {

//        return memberDao.list();
        return memberMapper.list();
    }

    @PostConstruct
    public void init() {
        memberMapper.init();
    }

}
