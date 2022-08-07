package com.homework.imweb.core.unconnected.command;

import com.homework.imweb.TestSupplier;
import com.homework.imweb.core.member.Member;
import com.homework.imweb.core.member.fixture.MemberFixture;
import com.homework.imweb.core.unconnected.UnConnectedMember;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;

@SpringBootTest
@DisplayName("IssueService")
class IssueServiceTest extends TestSupplier {

    Member savedMember;

    ForkJoinPool pool = new ForkJoinPool(
            1, ForkJoinPool.defaultForkJoinWorkerThreadFactory, null, true);

    private IssueService issueService;

    private IssueService getIssueService() {
        return issueService == null ? new IssueService(pool, getUnConnectedCreator(), getMemberDeleter()): issueService;
    }


    @Nested
    @DisplayName("unConnectedIssue 메소드")
    class Describe_unConnectedIssue_method {

        private LocalDateTime _장기미사용_고객_조건 = LocalDateTime.now().minusMonths(3);
        @BeforeEach
        void prepareData() {
            memberDeleteAll();
            savedMember = getMemberCreator().create(MemberFixture._회원가입(_장기미사용_고객_조건));
        }

        @Nested
        @DisplayName("마지막 로그인으로 부터 3개월이 지난 사용자 장기 미사용 처리 요청이면")
        class Context_unConnected_member {

            @Test
            @DisplayName("회원테이블에서 소프트딜리트후  장기 미사용 테이블에 등록한다")
            void it_returns_delete_and_unconnected_save() {
                List<Member> candidate = getUnConnectedCandidateSearcher().findUnConnectedCandidate(LocalDate.now());
                getIssueService().unConnectedIssue(candidate);
                Optional<UnConnectedMember> unConnectedMember = getUnConnectedSearcher().findByMemberIdx(savedMember.getIdx());
                Assertions.assertNotNull(unConnectedMember.get());
            }
        }
    }
}