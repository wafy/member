package com.homework.imweb.core.unconnected.command;

import com.homework.imweb.core.member.Member;
import com.homework.imweb.core.member.command.MemberDeleter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

@Service
@RequiredArgsConstructor
public class IssueService {

    private final ForkJoinPool joinPool;

    private final UnConnectedCreator unConnectedCreator;

    private final MemberDeleter memberDeleter;




    public boolean unConnectedIssue(List<Member> candidates) {

        try {
            joinPool.submit(() ->
                    candidates.parallelStream().forEach(
                            this::tryIssue
                    )).get();
        } catch (InterruptedException  | ExecutionException ex) {
            return false;
        }
        return true;
    }

    private boolean tryIssue(final Member member) {
        try {
            unConnectedCreator.create(new UnConnectedCommand(member));
            memberDeleter.delete(member.getIdx());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
