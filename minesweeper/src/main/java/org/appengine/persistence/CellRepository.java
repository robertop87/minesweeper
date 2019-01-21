package org.appengine.persistence;

import java.util.Optional;
import org.appengine.domain.Cell;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CellRepository extends CrudRepository<Cell, Long> {

  @Query(value = "SELECT c FROM Cell c JOIN FETCH c.game g "
      + "WHERE c.row = :row "
      + "AND c.col = :col AND g.id = :gameId")
  Optional<Cell> getCell(
      @Param("gameId") long gameId,
      @Param("row") int row,
      @Param("col") int col);
}
