package com.homework.imweb.core.member.fixture;

import com.homework.imweb.core.member.Member;

import java.time.LocalDateTime;

public class MemberFixture {

    public static final String givenEmail= "호순이@imweb.com";

    public static final String givenName = "호순이";

    public static final LocalDateTime givenJoinDate = LocalDateTime.now();

    public static Member _회원가입() {
        return Member.of(givenEmail, givenName, givenJoinDate, givenJoinDate);
    }

    public static Member _회원가입(LocalDateTime lastLoginDate) {
        return Member.of(givenEmail, givenName, givenJoinDate, lastLoginDate);
    }
}
