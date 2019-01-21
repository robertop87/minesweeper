package org.appengine.application;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.appengine.domain.Cell;
import org.appengine.domain.CellStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CellApi {

  private int row;
  private int column;
  private CellStatus status;
  private String visibleValue;

  public static CellApi mapFrom(Cell cell) {
    return CellApi.builder()
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
