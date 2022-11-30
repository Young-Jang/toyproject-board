package toyproject.board.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toyproject.board.domain.model.Member;
import toyproject.board.domain.repository.MemberRepository;

import javax.json.JsonMergePatch;
import javax.json.JsonStructure;
import javax.json.JsonValue;

@Service
@RequiredArgsConstructor
public class PatchMemberService {
    private final MemberRepository memberRepository;
    private final ObjectMapper objectMapper;

    @Transactional
    public void patchMemberInfo(Long id,JsonMergePatch jsonMergePatch){
        Member member = memberRepository.findById(id).orElseThrow(RuntimeException::new);
        Member mergedMember = mergeMember(member,jsonMergePatch);
        member.patchMember(mergedMember);
        memberRepository.save(member);
    }

    private Member mergeMember(Member originMember, JsonMergePatch jsonMergePatch) {
        JsonStructure target = objectMapper.convertValue(originMember, JsonStructure.class);
        JsonValue patchedPerson = jsonMergePatch.apply(target);
        return objectMapper.convertValue(patchedPerson, Member.class);
    }

}
