package com.homework.imweb.core.member.command;

import com.homework.imweb.core.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member save(Member member);

    void deleteByIdx(Long idx);
}
