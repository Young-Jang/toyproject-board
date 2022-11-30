package toyproject.board.domain.repository;

import org.springframework.stereotype.Repository;
import toyproject.board.domain.model.Member;

import java.util.Optional;

public interface MemberRepository {
    Optional<Member> findById(Long id);
    Member save(Member member);
}
