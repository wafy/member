package com.homework.imweb.core.unconnected.query;

import com.homework.imweb.core.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UnConnectedCandidateRepository extends JpaRepository<Member, Long> {

    @Query(value = "select * from member where date(last_login_time) <= :unConnectedDate", nativeQuery = true)
    List<Member> findByUnConnectedCandidate(@Param("unConnectedDate") LocalDate unConnectedDate);

}
