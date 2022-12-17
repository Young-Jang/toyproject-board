package toyproject.almigty.board.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toyproject.almigty.board.domain.model.Board;
import toyproject.almigty.board.domain.model.User;
import toyproject.almigty.board.domain.repository.BoardRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardJPARepository extends BoardRepository, JpaRepository<Board, Long> {

    List<Board> findByTitleContaining(String keyword);
    Board findByUser(User user);
    Page<Board> findAllBy(PageRequest pageRequest);
    Optional<Board> findById(Long id);
    Board save(Board board);
    void deleteById(Long id);
    long count();
}