package toyproject.almigty.board.application;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toyproject.almigty.board.domain.command.CreateMemberCommand;
import toyproject.almigty.board.domain.model.Member;
import toyproject.almigty.board.domain.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class CreateMemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void createMember(CreateMemberCommand createMemberCommand){
        Member member = new Member(createMemberCommand);
        memberRepository.save(member);
    }
}
