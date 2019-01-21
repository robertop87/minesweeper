package org.appengine.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Game {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String playerName;

  public Game(String playerName) {
    this.playerName = playerName;
  }
}
