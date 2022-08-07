package com.homework.imweb.core.unconnected.query;

import com.homework.imweb.core.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UnConnectedCandidateSearcher {
    private final UnConnectedCandidateRepository unConnectedCandidateRepository;


    public List<Member> findUnConnectedCandidate(LocalDate lastLoginDate) {
        return unConnectedCandidateRepository.findByUnConnectedCandidate(lastLoginDate);
    }
}
