package com.homework.imweb.core.member.command;

import com.homework.imweb.core.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member save(Member member);


    @Query(value = "update member set email ='', name = '', join_date= null, last_login_time = null where idx=:idx",
    nativeQuery = true)
    void softDelete(@Param("idx") Long idx);
}
