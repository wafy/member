package com.homework.imweb.core.unconnected.command;

import com.homework.imweb.core.member.Member;

import java.time.LocalDateTime;

public class UnConnectedCommand implements UnConnectedDescription {

    private Long memberIdx;

    private String email;

    private String name;

    private LocalDateTime joinDate;

    private LocalDateTime lastLoginDate;

    @Override
    public Long getMemberIdx() {
        return this.memberIdx;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public LocalDateTime getJoinDate() {
        return this.joinDate;
    }

    @Override
    public LocalDateTime getLastLoginDate() {
        return this.lastLoginDate;
    }

    public UnConnectedCommand(Member member)  {
        this.memberIdx = member.getIdx();
        this.email = member.getEmail();
        this.name = member.getName();
        this.joinDate = member.getJoinDate();
        this.lastLoginDate = member.getLastLoginTime();

    }
}
