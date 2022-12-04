package toyproject.board.application;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toyproject.board.domain.command.CreateMemberCommand;
import toyproject.board.domain.model.Member;
import toyproject.board.domain.repository.MemberRepository;

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
