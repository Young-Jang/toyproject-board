package toyproject.board.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import toyproject.board.domain.model.Member;
import toyproject.board.domain.repository.MemberRepository;

import java.util.Optional;

public interface MemberJPARepository extends JpaRepository<Member,Long>, MemberRepository {
    Optional<Member> findById(Long id);
    Member save(Member member);
}
