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

package gameResults;

import java.io.Serializable;

/**
 * The player's id, level and score from a play of the game.
 */
public class GameResult implements Serializable {
    public static final long serialVersionUID = 1L;

    /**
     * The identifier for the player who obtained the game result.
     */
    private String id;

    /**
     * The score obtain in the play of the game.
     */
    private int score;

    /**
     * The level attained in the play of the game.
     */
    private int level;

    /**
     * Initialize this instance with the argument values.
     * 
     * @param id the id of the player
     * @param score the score attained in the play
     * @param level the level attained in the play
     */
    public GameResult(String id, int score, int level) {
        this.id = id;
        this.score = score;
        this.level = level;
    }

    /**
     * @return the level attained in the play of the game
     */
    public int getLevel() {
        return level;
    }

    /**
     * @return the id of the player for the game result
     */
    public String getId() {
        return id;
    }

    /**
     * @return the score attained in the play of the game
     */
    public int getScore() {
        return score;
    }

    /**
     * @return the id, level and score in a string
     */
    @Override
    public String toString() {
        return id + "," + score + "," + level;
    }
}
