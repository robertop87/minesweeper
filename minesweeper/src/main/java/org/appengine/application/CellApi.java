package org.appengine.application;

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

  private long id;
  private int row;
  private int column;
  private CellStatus status;
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
