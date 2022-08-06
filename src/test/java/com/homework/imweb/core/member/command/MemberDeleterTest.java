package com.homework.imweb.core.member.command;

import com.homework.imweb.TestSupplier;
import com.homework.imweb.core.member.Member;
import com.homework.imweb.core.member.fixture.MemberFixture;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@DisplayName("MemberDeleter")
class MemberDeleterTest extends TestSupplier {

    Member savedMember;

    @Nested
    @DisplayName("delete 메소드")
    class Describe_delete_method {

        @BeforeEach
        void prepareData() {
            memberDeleteAll();
            savedMember = getMemberCreator().create(MemberFixture._회원가입());
        }

        @Nested
        @DisplayName("회원아이디로 삭제 요청이면")
        class Context_request_member_idx {

            @Test
            @DisplayName("요청한 아이디의 회원을 삭제한다")
            void it_returns_delete_id() {
                getMemberDeleter().delete(savedMember.getIdx());
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> getMemberSearcher().findByIdx(savedMember.getIdx()));
            }
        }
    }
}