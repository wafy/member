package com.homework.imweb;

import com.homework.imweb.core.member.command.MemberCreator;
import com.homework.imweb.core.member.command.MemberRepository;
import com.homework.imweb.core.unconnected.query.UnConnectedCandidateRepository;
import com.homework.imweb.core.unconnected.query.UnConnectedCandidateSearcher;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class TestSupplier implements ForTestOnly {

    @Autowired
    @Getter(AccessLevel.PROTECTED)
    private MemberRepository memberRepository;
    @Autowired
    @Getter(AccessLevel.PROTECTED)
    private UnConnectedCandidateRepository unConnectedCandidateRepository;


    private MemberCreator memberCreator;

    private UnConnectedCandidateSearcher unConnectedCandidateSearcher;


    protected UnConnectedCandidateSearcher getUnConnectedCandidateSearcher() {
        return unConnectedCandidateSearcher == null ?
                new UnConnectedCandidateSearcher(unConnectedCandidateRepository): unConnectedCandidateSearcher;
    }

    protected MemberCreator getMemberCreator() {
        return memberCreator == null ? new MemberCreator(memberRepository): memberCreator;
    }
    protected void memberDeleteAll() {
        memberRepository.deleteAll();
    }


}
