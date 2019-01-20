package org.appengine.application;

import java.util.Optional;
import lombok.val;
import org.appengine.domain.Cell;
import org.appengine.domain.Game;
import org.appengine.persistence.CellRepository;
import org.appengine.persistence.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

  private CellRepository cellRepository;
  private GameRepository gameRepository;

  @Autowired
  public GameServiceImpl(CellRepository cellRepository,
      GameRepository gameRepository) {
    this.cellRepository = cellRepository;
    this.gameRepository = gameRepository;
  }


  @Override
  public Game createGame(String playerName, int initRow, int initCol) {
    return this.gameRepository.save(new Game());
  }

  @Override
  public String getCellValue(Long gameId, int row, int col) {
    Optional<Cell> cell = this.cellRepository.getCell(row, col, gameId);
    if (cell.isPresent()) {
      return cell.get().getValue();
    }

    return "invalid";
  }
}
