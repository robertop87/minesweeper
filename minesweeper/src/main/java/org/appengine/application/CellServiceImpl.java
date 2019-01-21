package org.appengine.application;

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
        case CLOSED: cell.setStatus(CellStatus.MARKED); break;
        case MARKED: cell.setStatus(CellStatus.CLOSED); break;
        default: break;
      }
      this.repository.save(cell);
    });
  }

  @Override
  public void openCell(Long cellId) {
    this.repository.findById(cellId).ifPresent(cell -> {
      switch (cell.getStatus()) {
        case CLOSED: case MARKED: cell.setStatus(CellStatus.OPENED); break;
        default: break;
      }
      this.repository.save(cell);
    });
  }
}
