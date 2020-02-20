package com.moonsoo.web.dao;

import com.moonsoo.web.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    public MemberDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(String username, String password) {
        jdbcTemplate.execute("create table  if not exists member(id int auto_increment, username varchar(255) not null, password varchar(255) not null, primary key(id))");
        jdbcTemplate.update("insert into member(username, password) values(?,?)", new String[]{username, password});
    }

    public List<Member> list() {
//        Statement st = DataSourceUtils.getConnection(dataSource).createStatement();
//        ResultSet rs = st.executeQuery("select*from member");
//        while (rs.next()) {
//            Member member = new Member(rs);
//            log.info(member.toString());
//        }
        return jdbcTemplate.query("select*from member", (resultSet, i) -> new Member(resultSet));
    }

    @PostConstruct
    private void init() {
        jdbcTemplate.execute("create table  if not exists member(id int auto_increment, username varchar(255) not null, password varchar(255) not null, primary key(id))");
        jdbcTemplate.update("insert into member(username, password) values('Moonsoo','1234')");
    }

}
