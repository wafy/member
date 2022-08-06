package com.homework.imweb.core.member.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberDeleter {

    private final MemberRepository memberRepository;


    public void delete(Long idx) {
        memberRepository.deleteByIdx(idx);
    }
}
