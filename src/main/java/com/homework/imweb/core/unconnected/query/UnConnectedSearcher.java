package com.homework.imweb.core.unconnected.query;

import com.homework.imweb.core.unconnected.UnConnectedMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UnConnectedSearcher {

    private final UnConnectedSearchRepository connectedSearchRepository;

    public Optional<UnConnectedMember> findByMemberIdx(Long idx) {
        return connectedSearchRepository.findByMemberIdx(idx);
    }
}
