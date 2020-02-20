package com.moonsoo.web.entity;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter @Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor//username, password
public class Member {
    private int id;

    @NonNull private String username;

    @NonNull private String password;

    public Member(ResultSet rs) {
        try {
            this.id = rs.getInt("id");
            this.username = rs.getString("username");
            this.password = rs.getString("password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
