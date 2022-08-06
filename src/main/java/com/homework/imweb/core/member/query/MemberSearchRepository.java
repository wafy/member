package com.homework.imweb.core.member.query;

import com.homework.imweb.core.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberSearchRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByIdx(Long idx);
}
