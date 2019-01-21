package org.appengine.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.extern.java.Log;
import lombok.val;
import org.appengine.domain.Cell;
import org.appengine.domain.CellStatus;
import org.appengine.domain.Game;
import org.appengine.persistence.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log
@Service
public class GameServiceImpl implements GameService {

  private final Random random = new Random();

  private GameRepository gameRepository;
  private CellService cellService;

  @Autowired
  public GameServiceImpl(GameRepository gameRepository, CellService cellService) {
    this.cellService = cellService;
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
  public BoardApi newBoard(GameConfigApi gameConfigApi) {
    val newGame = this.createGame(gameConfigApi.getPlayerName(),
        gameConfigApi.getBoardSize(), gameConfigApi.getInitRow(), gameConfigApi.getInitColumn());
    val gameCells = this.cellService.getCells(newGame.getId());

    return BoardApi.mapFrom(newGame, gameCells);
  }

  @Override
  public BoardApi play(Long cellId, GameAction gameAction) {
    switch (gameAction) {
      case MARK_CELL: this.cellService.markCell(cellId); break;
      case OPEN_CELL: this.cellService.openCell(cellId); break;
      default: break;
    }

    return this.resumeBoard(this.cellService.getGameId(cellId));
  }

  @Override
  public BoardApi resumeBoard(Long gameId) {
    return this.gameRepository.findById(gameId)
        .map(game -> BoardApi
            .mapFrom(game, this.cellService.getCells(game.getId())))
        .orElse(new BoardApi());
  }

  private void generateCells(Game game, int boardSize, int initRow, int initCol) {
    List<Cell> cells = new ArrayList<>(boardSize * boardSize);
    for (int row = 0; row < boardSize; row++) {
      for (int col = 0; col < boardSize; col++) {
        val cell = Cell.builder()
            .row(row)
            .col(col)
            .game(game)
            .value((initRow == row && initCol == col)
                ? Cell.empty
                : this.randomCellValue())
            .status((initRow == row && initCol == col)
                ? CellStatus.OPENED
                : CellStatus.CLOSED)
            .build();
        cells.add(cell);
      }
    }
    this.countAdjacentMines(cells);
    this.cellService.saveAll(cells);
    log.info(String.format("New Board %s", cells));
  }

  private String randomCellValue() {
    return this.random.nextBoolean() ? Cell.empty : Cell.mine;
  }

  private void countAdjacentMines(List<Cell> cells) {
    for (Cell cell: cells) {
      if (cell.getValue().equals(Cell.empty)) {
        int mineCounter = 0;
        for (int ri = -1; ri <= 1; ri++) {
          for (int ci = -1; ci <= 1; ci++) {
            if (this.queryCellValueByPosition(cells,
                cell.getRow() + ri, cell.getCol() + ci)
                .equals(Cell.mine)) {
              mineCounter++;
            }
          }
        }
        if (mineCounter > 0) {
          cell.setValue(Integer.toString(mineCounter));
        }
      }
    }
  }

  private String queryCellValueByPosition(List<Cell> cells, int row, int col) {
    if (row < 0 || col < 0) {
      return Cell.empty;
    }

    return cells.stream()
        .filter(c -> c.getRow() == row)
        .filter(c -> c.getCol() == col)
        .findFirst()
        .map(c -> c.getValue())
        .orElse(Cell.empty);
  }
}

