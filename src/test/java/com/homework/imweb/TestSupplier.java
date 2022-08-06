package com.homework.imweb;

import com.homework.imweb.core.member.command.MemberCreator;
import com.homework.imweb.core.member.command.MemberDeleter;
import com.homework.imweb.core.member.command.MemberRepository;
import com.homework.imweb.core.member.query.MemberSearchRepository;
import com.homework.imweb.core.member.query.MemberSearcher;
import com.homework.imweb.core.unconnected.command.UnConnectedCreator;
import com.homework.imweb.core.unconnected.command.UnConnectedMemberRepository;
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

    @Autowired
    @Getter(AccessLevel.PROTECTED)
    private MemberSearchRepository memberSearchRepository;


    @Autowired
    @Getter(AccessLevel.PROTECTED)
    private UnConnectedMemberRepository unConnectedMemberRepository;


    private MemberCreator memberCreator;

    private MemberDeleter memberDeleter;

    private MemberSearcher memberSearcher;

    private UnConnectedCandidateSearcher unConnectedCandidateSearcher;

    private UnConnectedCreator unConnectedCreator;




    protected UnConnectedCandidateSearcher getUnConnectedCandidateSearcher() {
        return unConnectedCandidateSearcher == null ?
                new UnConnectedCandidateSearcher(unConnectedCandidateRepository): unConnectedCandidateSearcher;
    }

    protected MemberCreator getMemberCreator() {
        return memberCreator == null ? new MemberCreator(memberRepository): memberCreator;
    }

    protected MemberDeleter getMemberDeleter() {
        return memberDeleter == null ? new MemberDeleter(memberRepository): memberDeleter;
    }

    protected MemberSearcher getMemberSearcher() {
        return memberSearcher == null ? new MemberSearcher(memberSearchRepository): memberSearcher;
    }

    protected UnConnectedCreator getUnConnectedCreator() {
        return unConnectedCreator == null ? new UnConnectedCreator(unConnectedMemberRepository): unConnectedCreator;
    }



    protected void memberDeleteAll() {
        memberRepository.deleteAll();
    }


}
