package org.appengine.application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.appengine.domain.Cell;
import org.appengine.domain.Game;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardApi {

  private long gameId = 0;
  private String playerName = "Nobody";
  private List<CellApi> cells = new ArrayList<>(0);

  public static BoardApi mapFrom(Game game, List<Cell> cells) {
    return BoardApi.builder()
        .gameId(game.getId())
        .playerName(game.getPlayerName())
        .cells(cells.stream()
            .map(CellApi::mapFrom)
            .collect(Collectors.toList()))
        .build();
  }
}
