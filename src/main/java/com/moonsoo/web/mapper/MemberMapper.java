package com.moonsoo.web.mapper;

import com.moonsoo.web.entity.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MemberMapper {
    @Insert("insert into member(username, password) values(#{username},#{password})")
    void insert(@Param("username") String username, @Param("password") String password);

    @Select("select*from member")
    List<Member> list();

    @Update("create table  if not exists member(id int auto_increment, username varchar(255) not null, password varchar(255) not null, primary key(id))")
    void init();
}
