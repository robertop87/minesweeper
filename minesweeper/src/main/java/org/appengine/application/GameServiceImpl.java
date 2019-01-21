package org.appengine.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import lombok.extern.java.Log;
import lombok.val;
import org.appengine.domain.Cell;
import org.appengine.domain.Game;
import org.appengine.persistence.CellRepository;
import org.appengine.persistence.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log
@Service
public class GameServiceImpl implements GameService {

  private final Random random = new Random();

  private CellRepository cellRepository;
  private GameRepository gameRepository;

  @Autowired
  public GameServiceImpl(CellRepository cellRepository,
      GameRepository gameRepository) {
    this.cellRepository = cellRepository;
    this.gameRepository = gameRepository;
  }


  @Override
  public Game createGame(String playerName, int boardSize, int initRow, int initCol) {
    Game newGame = this.gameRepository.save(new Game(playerName));
    log.info(String.format("New Game Created: %s", newGame));
    this.generateCells(newGame, boardSize, initRow, initCol);
    return newGame;
  }

  @Override
  public Optional<Cell> getCellBy(Long gameId, int row, int col) {
    return this.cellRepository.getCell(gameId, row, col);
  }

  @Override
  public List<Cell> getCells(Long gameId) {
    return this.cellRepository.getCells(gameId);
  }

  private void generateCells(Game game, int boardSize, int initRow, int initCol) {
    List<Cell> cells = new ArrayList<>(boardSize*boardSize);
    for (int row = 0; row < boardSize; row++) {
      for (int col = 0; col < boardSize; col++) {
        val cell = Cell.builder()
            .row(row)
            .col(col)
            .game(game)
            .value((initRow == row && initCol == col)
                ? Cell.empty
                : this.randomCellValue())
            .build();
        cells.add(cell);
      }
    }
    this.cellRepository.saveAll(cells);
    log.info(String.format("New Board %s", cells));
  }

  private String randomCellValue() {
    return this.random.nextBoolean() ? Cell.empty : Cell.mine;
  }
}
