package org.appengine.application;

import org.appengine.domain.Game;

public interface GameService {

  Game createGame(String playerName, int initRow, int initCol);

  String getCellValue(Long gameId, int row, int col);
}
