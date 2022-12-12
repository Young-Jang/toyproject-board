package toyproject.almigty.board.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toyproject.almigty.board.domain.model.User;
import toyproject.almigty.board.domain.repository.UserRepository;

import java.util.Optional;


@Repository
public interface UserJPARepository extends UserRepository, JpaRepository<User,Long> {
    Optional<User> findByEmail(String email); // 이미 email을 통해 생성된 사용자인지 체크
}