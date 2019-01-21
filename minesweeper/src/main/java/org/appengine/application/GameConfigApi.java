package org.appengine.application;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameConfigApi {

  @NotEmpty
  private String playerName;

  @Min(3)
  private int boardSize;

  @Min(0)
  private int initRow;

  @Min(0)
  private int initColumn;
}
