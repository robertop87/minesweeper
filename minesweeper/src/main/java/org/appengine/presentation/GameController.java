package org.appengine.presentation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.appengine.application.BoardApi;
import org.appengine.application.GameAction;
import org.appengine.application.GameConfigApi;
import org.appengine.application.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/game")
@Api(value = "game-controller", description = "Operations to play the game")
public class GameController {

  private final GameService gameService;

  @Autowired
  public GameController(GameService gameService) {
    this.gameService = gameService;
  }

  @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ApiOperation(value = "Create a new Board for a Game", response = BoardApi.class)
  public BoardApi createNewGame(
      @RequestBody @Valid GameConfigApi gameConfigApi) {
    return this.gameService.newBoard(gameConfigApi);
  }


  @PostMapping(value = "/openCell/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ApiOperation(value = "Open a cell", response = BoardApi.class)
  public BoardApi openCell(@PathVariable long id) {
    return this.gameService.play(id, GameAction.OPEN_CELL);
  }

  @PostMapping(value = "/markCell/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ApiOperation(value = "Mark/unmark a cell", response = BoardApi.class)
  public BoardApi markCell(@PathVariable long id) {
    return this.gameService.play(id, GameAction.MARK_CELL);
  }

  @GetMapping(value = "/resume/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ApiOperation(value = "Resume a previous game board", response = BoardApi.class)
  public BoardApi resumeGame(@PathVariable long id) {
    return this.gameService.resumeBoard(id);
  }
}
