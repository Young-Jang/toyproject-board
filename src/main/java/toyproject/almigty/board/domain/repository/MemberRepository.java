package toyproject.almigty.board.domain.repository;

import toyproject.almigty.board.domain.model.Member;

import java.util.Optional;

public interface MemberRepository {
    Optional<Member> findById(Long id);
    Member save(Member member);
}
