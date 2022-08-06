package com.homework.imweb.core.unconnected.command;

import java.time.LocalDateTime;

public interface UnConnectedDescription {

    Long getMemberIdx();

    String getEmail();

    String getName();

    LocalDateTime getJoinDate();

    LocalDateTime getLastLoginDate();
}
