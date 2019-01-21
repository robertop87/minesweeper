package org.appengine.application;

import static org.junit.Assert.assertEquals;

import lombok.val;
import org.appengine.domain.Cell;
import org.appengine.domain.CellStatus;
import org.appengine.persistence.CellRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class GameServiceTest {

  @Autowired
  private GameService gameService;

  @Autowired
  private CellService cellService;

  @Autowired
  private CellRepository cellRepository;

  @Test
  public void testCreateNewGameFirstCellIsEmpty() {
    val game = this.gameService.createGame("tester", 9, 4, 4);
    val firstCellValue = this.gameService.getCellBy(game.getId(), 4, 4);
    assertEquals(Cell.empty, firstCellValue.get().getValue());
  }

  @Test
  public void testCreateNewGameFirstCellIsOpened() {
    val game = this.gameService.createGame("tester", 9, 4, 4);
    val firstCellValue = this.gameService.getCellBy(game.getId(), 4, 4);
    assertEquals(CellStatus.OPENED, firstCellValue.get().getStatus());
  }

  @Test
  public void testNewGameShouldHaveEnoughCellForBoardSizeBasic() {
    val boardSize = 6;
    val game = this.gameService.createGame("tester", boardSize, 0, 0);
    val numberOfCells = this.gameService.getCells(game.getId()).size();
    assertEquals(boardSize*boardSize, numberOfCells);
  }

  @Test
  public void testNewGameShouldHaveEnoughCellForBoardSizeIntermediate() {
    val boardSize = 9;
    val game = this.gameService.createGame("tester", boardSize, 0, 0);
    val numberOfCells = this.gameService.getCells(game.getId()).size();
    assertEquals(boardSize*boardSize, numberOfCells);
  }

  @Test
  public void testNewGameShouldHaveEnoughCellForBoardSizeExpert() {
    val boardSize = 15;
    val game = this.gameService.createGame("tester", boardSize, 0, 0);
    val numberOfCells = this.gameService.getCells(game.getId()).size();
    assertEquals(boardSize*boardSize, numberOfCells);
  }

  @Test
  public void testCellClosedCanBeOpened() {
    val game = this.gameService.createGame("tester", 3, 0, 0);
    Cell testCell = this.cellRepository.save(Cell.builder()
        .status(CellStatus.CLOSED)
        .game(game)
        .row(-1)
        .col(-1)
        .value(Cell.empty)
        .build());

    this.cellService.openCell(testCell.getId());

    val result = this.cellRepository.findById(testCell.getId());
    assertEquals(CellStatus.OPENED, result.get().getStatus());
  }

  @Test
  public void testCellClosedCanBeMarked() {
    val game = this.gameService.createGame("tester", 3, 0, 0);
    Cell testCell = this.cellRepository.save(Cell.builder()
        .status(CellStatus.CLOSED)
        .game(game)
        .row(-1)
        .col(-1)
        .value(Cell.empty)
        .build());

    this.cellService.markCell(testCell.getId());

    val result = this.cellRepository.findById(testCell.getId());
    assertEquals(CellStatus.MARKED, result.get().getStatus());
  }

  @Test
  public void testCellMarkedCanBeOpened() {
    val game = this.gameService.createGame("tester", 3, 0, 0);
    Cell testCell = this.cellRepository.save(Cell.builder()
        .status(CellStatus.MARKED)
        .game(game)
        .row(-1)
        .col(-1)
        .value(Cell.empty)
        .build());

    this.cellService.openCell(testCell.getId());

    val result = this.cellRepository.findById(testCell.getId());
    assertEquals(CellStatus.OPENED, result.get().getStatus());
  }

  @Test
  public void testCellOpenedCannotBeMarked() {
    val game = this.gameService.createGame("tester", 3, 0, 0);
    Cell testCell = this.cellRepository.save(Cell.builder()
        .status(CellStatus.OPENED)
        .game(game)
        .row(-1)
        .col(-1)
        .value(Cell.empty)
        .build());

    this.cellService.markCell(testCell.getId());

    val result = this.cellRepository.findById(testCell.getId());
    assertEquals(CellStatus.OPENED, result.get().getStatus());
  }

  @Test
  public void testCellMarkedCanBeClosed() {
    val game = this.gameService.createGame("tester", 3, 0, 0);
    Cell testCell = this.cellRepository.save(Cell.builder()
        .status(CellStatus.MARKED)
        .game(game)
        .row(-1)
        .col(-1)
        .value(Cell.empty)
        .build());

    this.cellService.markCell(testCell.getId());

    val result = this.cellRepository.findById(testCell.getId());
    assertEquals(CellStatus.CLOSED, result.get().getStatus());
  }
}
