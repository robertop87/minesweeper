package org.appengine.presentation;

import javax.validation.Valid;
import org.appengine.application.BoardApi;
import org.appengine.application.GameAction;
import org.appengine.application.GameConfigApi;
import org.appengine.application.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GameController {

  private final GameService gameService;

  @Autowired
  public GameController(GameService gameService) {
    this.gameService = gameService;
  }

  @PostMapping("/game/create")
  @ResponseBody
  public BoardApi createNewGame(
      @RequestBody @Valid GameConfigApi gameConfigApi) {
    return this.gameService.newBoard(gameConfigApi);
  }

  @PostMapping("/game/openCell/{id}")
  @ResponseBody
  public BoardApi openCell(@PathVariable long id) {
    return this.gameService.play(id, GameAction.OPEN_CELL);
  }

  @PostMapping("/game/markCell/{id}")
  @ResponseBody
  public BoardApi markCell(@PathVariable long id) {
    return this.gameService.play(id, GameAction.MARK_CELL);
  }
}
