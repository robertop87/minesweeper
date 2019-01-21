package org.appengine.application;

import io.swagger.annotations.ApiModelProperty;
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
  @ApiModelProperty(notes = "The player name", required = true)
  private String playerName;

  @Min(3)
  @ApiModelProperty(notes = "The board size", required = true)
  private int boardSize;

  @Min(0)
  @ApiModelProperty(notes = "The initial row position", required = true)
  private int initRow;

  @Min(0)
  @ApiModelProperty(notes = "The initial column position", required = true)
  private int initColumn;
}
