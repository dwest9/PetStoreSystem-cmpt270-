/*
  CMPT 270 Course Material
  Copyright (c) 2003-2021
  J.P. Tremblay and Grant Cheston
  All rights reserved.

  This document contains resources for homework assigned to students of
  CMPT 270 and shall not be distributed without permission.  Posting this
  file to a public or private website, or providing this file to any person
  not registered in CMPT 270 constitutes Academic Misconduct according to
  the University of Saskatchewan Policy on Academic Misconduct.
 */

package model;

import java.util.List;

/**
 * The information provided by the GameModel for outside access.
 */
public interface GameInfoProvider {
    void addObserver(GameObserver observer);

    List<GameObject> getGameObjects();

    boolean isOver();

    boolean isPaused();

    int getLevel();

    int getPlayerScore();

    int getPlayerLives();

    int getTick();

    void setInvaderSynchronizationObject(Object reference);

    int getInvaderCount();

    int getPlayerHeat();

    boolean getPlayerOverheated();

}
