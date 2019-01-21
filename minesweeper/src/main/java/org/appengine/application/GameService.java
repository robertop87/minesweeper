package org.appengine.application;

import org.appengine.domain.Game;

public interface GameService {

  Game createGame(String playerName, int boardSize, int initRow, int initCol);

  BoardApi newBoard(GameConfigApi gameConfigApi);

  BoardApi play(Long cellId, GameAction gameAction);

  BoardApi resumeBoard(Long gameId);
}
