package org.appengine.application;

import static org.junit.Assert.assertEquals;

import lombok.val;
import org.appengine.domain.Cell;
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

  @Test
  public void testCreateNewGameFirstCellIsEmpty() {
    val game = this.gameService.createGame("tester", 9, 4, 4);
    val firstCellValue = this.gameService.getCellBy(game.getId(), 4, 4);
    assertEquals(Cell.empty, firstCellValue.get().getValue());
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
}