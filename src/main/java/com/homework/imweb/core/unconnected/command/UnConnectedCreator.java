package com.homework.imweb.core.unconnected.command;

import com.homework.imweb.core.unconnected.UnConnectedMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UnConnectedCreator {
    private final UnConnectedMemberRepository unConnectedMemberRepository;



    public void create(UnConnectedDescription description) {
       UnConnectedMember unConnectedMember =  UnConnectedMember.of(
                description.getMemberIdx(),
                description.getEmail(),
                description.getName(),
                description.getJoinDate(),
                description.getLastLoginDate());

        unConnectedMemberRepository.save(unConnectedMember);

    }
}
