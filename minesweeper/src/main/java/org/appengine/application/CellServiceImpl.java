package org.appengine.application;

import java.util.List;
import java.util.Optional;
import org.appengine.domain.Cell;
import org.appengine.domain.CellStatus;
import org.appengine.persistence.CellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CellServiceImpl implements CellService {

  private CellRepository repository;

  @Autowired
  public CellServiceImpl(CellRepository repository) {
    this.repository = repository;
  }

  @Override
  public void markCell(Long cellId) {
    this.repository.findById(cellId).ifPresent(cell -> {
      switch (cell.getStatus()) {
        case CLOSED:
          cell.setStatus(CellStatus.MARKED);
          break;
        case MARKED:
          cell.setStatus(CellStatus.CLOSED);
          break;
        default: break;
      }
      this.repository.save(cell);
    });
  }

  @Override
  public void openCell(Long cellId) {
    this.repository.findById(cellId).ifPresent(cell -> {
      switch (cell.getStatus()) {
        case CLOSED: case MARKED:
          cell.setStatus(CellStatus.OPENED);
          break;
        default: break;
      }
      this.repository.save(cell);
    });
  }

  @Override
  public Optional<Cell> getCellBy(Long gameId, int row, int column) {
    return this.repository.getCell(gameId, row, column);
  }

  @Override
  public List<Cell> getCells(Long gameId) {
    return this.repository.getCells(gameId);
  }

  @Override
  public void saveAll(List<Cell> cells) {
    this.repository.saveAll(cells);
  }

  @Override
  public Long getGameId(Long cellId) {
    return this.repository.findById(cellId).map(cell -> cell.getGame().getId()).orElse(0L);
  }
}
