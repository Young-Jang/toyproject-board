package toyproject.almigty.board.domain.repository;

import toyproject.almigty.board.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
}
