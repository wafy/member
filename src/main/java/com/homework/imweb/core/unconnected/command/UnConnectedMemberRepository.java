package com.homework.imweb.core.unconnected.command;

import com.homework.imweb.core.unconnected.UnConnectedMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnConnectedMemberRepository extends JpaRepository<UnConnectedMember, Long> {

    UnConnectedMember save(UnConnectedMember member);
}
