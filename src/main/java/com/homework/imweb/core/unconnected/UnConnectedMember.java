package com.homework.imweb.core.unconnected;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "unconnected_member")
public class UnConnectedMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private Long memberIdx;

    @Column(length = 100)
    private String email;

    @Column(length = 50)
    private String name;

    private LocalDateTime joinDate;

    private LocalDateTime lastLoginTime;

    public UnConnectedMember() {}


    private UnConnectedMember(Long memberIdx,
                              String email,
                              String name,
                              LocalDateTime joinDate,
                              LocalDateTime lastLoginDate) {
        this.memberIdx = memberIdx;
        this.email = email;
        this.name = name;
        this.joinDate = joinDate;
        this.lastLoginTime = lastLoginDate;
    }

   public static UnConnectedMember of(Long memberIdx,
                               String email,
                               String name,
                               LocalDateTime joinDate,
                               LocalDateTime lastLoginDate) {
        return new UnConnectedMember(memberIdx, email, name, joinDate, lastLoginDate);
   }

}
