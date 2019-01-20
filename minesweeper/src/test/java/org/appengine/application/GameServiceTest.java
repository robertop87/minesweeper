package org.appengine.application;

import lombok.val;
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
    val game = this.gameService.createGame("tester", 4, 4);
    this.gameService.getCellValue(game.getId(), 4, 4);
  }
}