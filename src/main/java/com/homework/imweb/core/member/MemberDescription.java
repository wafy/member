package com.homework.imweb.core.member;

import java.time.LocalDateTime;

public interface MemberDescription {

    String getEmail();

    String getName();

    LocalDateTime getJoinDate();

    LocalDateTime getLastLoginDate();
}
