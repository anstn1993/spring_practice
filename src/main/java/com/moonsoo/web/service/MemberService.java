package com.moonsoo.web.service;

import com.moonsoo.web.dao.MemberDao;
import com.moonsoo.web.entity.Member;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
public class MemberService {

    private MemberDao memberDao;

    @Transactional
    public void insert(String username, String password) {
        memberDao.insert(username, password);
    }

    public List<Member> list() {
        return memberDao.list();
    }

}
