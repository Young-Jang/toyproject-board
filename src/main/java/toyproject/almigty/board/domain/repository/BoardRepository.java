package toyproject.almigty.board.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import toyproject.almigty.board.domain.model.Board;
import toyproject.almigty.board.domain.model.User;
import toyproject.almigty.board.rest.DTO.BoardDto;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    List<Board> findByTitleContaining(String keyword);
    Board findByUser(User user);
    Page<Board> findAllBy(PageRequest pageRequest);
    Optional<Board> findById(Long id);
    Board save(Board board);
    void deleteById(Long id);
    long count();
}
