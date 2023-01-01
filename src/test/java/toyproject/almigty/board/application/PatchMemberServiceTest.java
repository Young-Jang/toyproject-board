package toyproject.almigty.board.application;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import toyproject.almigty.board.domain.model.Member;
import toyproject.almigty.board.domain.repository.MemberRepository;

import javax.json.JsonMergePatch;
import javax.json.JsonStructure;
import javax.json.JsonValue;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PatchMemberServiceTest {

    @InjectMocks
    private PatchMemberService patchMemberService;

    @Mock
    private MemberRepository memberRepository;
    @Mock
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("member를 patch한다.")
    public void patchMember() throws Exception{
        //given
        Member member = Member
                .builder()
                .id(1L)
                .userId("jy")
                .address("seoul")
                .email("b116104@test.com")
                .phone("010-0000-0000")
                .username("jy")
                .build();
        given(memberRepository.findById(anyLong())).willReturn(Optional.of(member));
        given(memberRepository.save(any())).willReturn(null);

        given(objectMapper.convertValue(any(), (TypeReference<Object>) any())).willReturn(null);
        //when
        assertDoesNotThrow(() -> {
        patchMemberService.patchMemberInfo(1L, new JsonMergePatch() {
            @Override
            public JsonValue apply(JsonValue target) {
                return null;
            }

            @Override
            public JsonValue toJsonValue() {
                return null;
            }
        });});

        //then
    }

}