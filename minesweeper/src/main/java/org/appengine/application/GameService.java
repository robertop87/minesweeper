package org.appengine.application;

import java.util.List;
import java.util.Optional;
import org.appengine.domain.Cell;
import org.appengine.domain.Game;

public interface GameService {

  Game createGame(String playerName, int boardSize, int initRow, int initCol);

  Optional<Cell> getCellBy(Long gameId, int row, int col);

  List<Cell> getCells(Long gameId);
}
