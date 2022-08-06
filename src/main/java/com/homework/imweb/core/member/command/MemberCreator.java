package com.homework.imweb.core.member.command;

import com.homework.imweb.core.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberCreator {

    private final MemberRepository memberRepository;

    public void create(Member member) {
        memberRepository.save(member);
    }
}
