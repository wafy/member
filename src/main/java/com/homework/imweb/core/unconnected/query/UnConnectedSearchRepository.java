package com.homework.imweb.core.unconnected.query;

import com.homework.imweb.core.unconnected.UnConnectedMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnConnectedSearchRepository extends JpaRepository<UnConnectedMember, Long> {

    Optional<UnConnectedMember> findByMemberIdx(Long idx);
}
