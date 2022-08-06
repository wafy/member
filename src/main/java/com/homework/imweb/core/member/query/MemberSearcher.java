package com.homework.imweb.core.member.query;

import com.homework.imweb.core.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberSearcher {
    private final MemberSearchRepository memberSearchRepository;

    public Optional<Member> findByIdx(Long idx) {
        Member savedMember = memberSearchRepository.findByIdx(idx)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원번호입니다."));

        return Optional.of(memberSearchRepository.getById(idx));
    }
}
