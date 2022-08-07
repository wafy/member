package com.homework.imweb.core.member.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemberDeleter {

    private final MemberRepository memberRepository;


    @Transactional
    public void delete(Long idx) {
        memberRepository.softDelete(idx);
    }
}
