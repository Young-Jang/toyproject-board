package toyproject.almigty.board.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toyproject.almigty.board.domain.model.Board;
import toyproject.almigty.board.domain.model.User;
import toyproject.almigty.board.domain.repository.BoardRepository;

import java.util.List;

@Repository
public interface BoardJPARepository extends BoardRepository, JpaRepository<Board, Long> {

    List<Board> findByTitleContaining(String keyword);
    Board findByUser(User user);
}