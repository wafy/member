package com.homework.imweb.core.member;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "member",
indexes = @Index(name ="idx_last_login_time", columnList = "last_login_time"))
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(length = 100)
    private String email;

    @Column(length = 50)
    private String name;

    private LocalDateTime joinDate;

    @Column(name = "last_login_time")
    private LocalDateTime lastLoginTime;

    public Member() {}

    private Member(String email,
                   String name,
                   LocalDateTime joinDate,
                   LocalDateTime lastLoginTime) {
        this.email = email;
        this.name = name;
        this.joinDate = joinDate;
        this.lastLoginTime = lastLoginTime;
    }

    public static Member of(String email,
                            String name,
                            LocalDateTime joinDate,
                            LocalDateTime lastLoginTime) {
        return new Member(email, name, joinDate, lastLoginTime);
    }

}
