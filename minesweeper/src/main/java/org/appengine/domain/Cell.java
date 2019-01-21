package org.appengine.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Builder
@ToString(of = {"row", "col", "value"})
@AllArgsConstructor
@NoArgsConstructor
public class Cell {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Transient
  public static final String empty = "";

  @Transient
  public static final String mine = "*";

  @Transient
  public static final String flag = "?";

  private int row;

  private int col;

  private String value;

  @Enumerated(EnumType.STRING)
  private CellStatus status = CellStatus.CLOSED;

  @ManyToOne(fetch = FetchType.LAZY)
  private Game game;
}
