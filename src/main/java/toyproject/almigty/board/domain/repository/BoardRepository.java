package toyproject.almigty.board.domain.repository;

import toyproject.almigty.board.domain.model.Board;
import toyproject.almigty.board.domain.model.User;

import java.util.List;

public interface BoardRepository {
    List<Board> findByTitleContaining(String keyword);
    Board findByUser(User user);
}
