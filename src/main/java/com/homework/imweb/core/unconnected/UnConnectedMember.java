package com.homework.imweb.core.unconnected;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "unconnected_member")
public class UnConnectedMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(length = 100)
    private String email;

    @Column(length = 50)
    private String name;

    private LocalDateTime joinDate;

    private LocalDateTime lastLoginTime;

}
