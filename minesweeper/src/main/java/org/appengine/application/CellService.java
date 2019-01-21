package org.appengine.application;

import java.util.List;
import java.util.Optional;
import org.appengine.domain.Cell;

public interface CellService {

  void markCell(Long cellId);

  void openCell(Long cellId);

  Optional<Cell> getCellBy(Long gameId, int row, int column);

  List<Cell> getCells(Long gameId);

  void saveAll(List<Cell> cells);

  Long getGameId(Long cellId);
}
