package org.appengine.application;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.appengine.domain.Cell;
import org.appengine.domain.Game;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardApi {

  private long gameId;
  private String playerName;
  private List<CellApi> cells;

  private BoardApi mapFrom(Game game, List<Cell> cells) {
    return BoardApi.builder()
        .gameId(game.getId())
        .playerName(game.getPlayerName())
        .cells(cells.stream()
            .map(CellApi::mapFrom)
            .collect(Collectors.toList()))
        .build();
  }
}
