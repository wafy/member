package com.homework.imweb.core.member.query;

import com.homework.imweb.TestSupplier;
import com.homework.imweb.core.member.fixture.MemberFixture;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@DisplayName("UnConnectedCandidateSearcher")
class UnConnectedCandidateSearcherTest extends TestSupplier {

    @Nested
    @DisplayName("findByUnConnectedCandidate 메소드")
    class Describe_findByUnConnectedCandidate_method {
        long givenCandidateCount = 3;

        @BeforeEach
        void prepareData() {
            memberDeleteAll();
            getMemberCreator().create(MemberFixture._회원가입());
            getMemberCreator().create(MemberFixture._회원가입());

            for (int i = 1; i <= 3; i++) {
                getMemberCreator().create(MemberFixture._회원가입(LocalDateTime.now().minusMonths(3 + i)));
            }
        }

        @Nested
        @DisplayName("마지막 로그인 날짜가 오늘로부터 3개월 이전날짜로 요청이 오면")
        class Context_last_login_date {

            @Test
            @DisplayName("마지막 로그인 날짜가 3개월 지난 사용자아이디를 모두 반환한다")
            void it_returns_last_login_user() {
                LocalDateTime givenLastLoginDate = LocalDateTime.now().minusMonths(3);
                List<Long> resultCount = getUnConnectedCandidateSearcher().findUnConnectedCandidate(givenLastLoginDate);

                Assertions.assertEquals(givenCandidateCount, resultCount.size());
            }
        }
    }
}