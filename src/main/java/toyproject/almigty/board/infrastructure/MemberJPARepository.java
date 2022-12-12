package toyproject.almigty.board.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toyproject.almigty.board.domain.model.Member;
import toyproject.almigty.board.domain.repository.MemberRepository;

import java.util.Optional;

@Repository
public interface MemberJPARepository extends JpaRepository<Member,Long>, MemberRepository {
    Optional<Member> findById(Long id);
    Member save(Member member);
}
