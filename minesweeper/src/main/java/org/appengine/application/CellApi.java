package org.appengine.application;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.appengine.domain.Cell;
import org.appengine.domain.CellStatus;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CellApi {

  @ApiModelProperty(notes = "The cell ID")
  private long id;
  @ApiModelProperty(notes = "The cell row position")
  private int row;
  @ApiModelProperty(notes = "The cell column position")
  private int column;
  @ApiModelProperty(notes = "The cell status")
  private CellStatus status;
  @ApiModelProperty(notes = "The value visible for UI")
  private String visibleValue;

  public static CellApi mapFrom(Cell cell) {
    return CellApi.builder()
        .id(cell.getId())
        .row(cell.getRow())
        .column(cell.getCol())
        .status(cell.getStatus())
        .visibleValue(visibleValueOf(cell))
        .build();
  }

  public static String visibleValueOf(Cell cell) {
    switch (cell.getStatus()) {
      case MARKED: return Cell.flag;
      case OPENED: return cell.getValue();
      default: return Cell.empty;
    }
  }
}
