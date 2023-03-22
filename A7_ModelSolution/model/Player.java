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

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The player in the space invaders game.
 */
public class Player extends GameObject {
    public static final int WIDTH = 46;
    public static final int HEIGHT = 25;

    /** The distance to move when it is time to move. */
    public static final int MOVE_DISTANCE = 15;

    /** The decrease in the score every time hit. */
    public static final int HIT_DECREMENT = 20;

    /** The initial number of lives for the Player. */
    public static final int INITIAL_NUM_LIVES = 4;

    /** The number of lives remaining for the Player. */
    protected int lives;

    /** The current score for the Player. */
    protected int score;

    /** How frequently (in terms of ticks) the player is to change image. */
    public static final int CHANGE_FREQ = 0;

    /** A Timer to limit the rate of laser fire */
    private Timer laserRechargeTimer;

    /** A boolean to indicate if the laser is being recharged */
    private boolean laserRecharging;

    /** A boolean to indicate if the laser is overheated */
    private boolean laserOverheated;

    /** A integer to indicate the laser's current heat level */
    private int laserHeatLevel;

    /** A constant to indicate the laser's maximum heat level */
    private final int LASER_HEAT_MAXIMUM = 5;

    /** A Timer to count down the overheated state */
    private Timer laserOverHeatDelay;

    /** A Timer to allow the laser to cool down */
    private Timer laserCoolDownTimer;
    /**
     * Initialize the player.
     */
    public Player(int x, int y, Game game) {
        super(x, y, game, "player");
        width = WIDTH;
        height = HEIGHT;
        lives = INITIAL_NUM_LIVES;
        score = 0;
        laserRecharging = false;
        laserRechargeTimer = new Timer(300, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                laserRecharging = false;
            }
        });
        laserRechargeTimer.setRepeats(false);

        laserHeatLevel = 0;
        laserOverheated = false;

        laserOverHeatDelay = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                laserOverheated = false;
                laserRecharging = false;
                laserHeatLevel = 0;
            }
        });
        laserOverHeatDelay.setRepeats(false);

        laserCoolDownTimer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // reduce the heat by one
                if (laserHeatLevel > 0 && !laserOverheated) {
                    laserHeatLevel += -1;
                }
                // restart the timer if the heat is still positive
                if  (laserHeatLevel > 0) {
                    laserCoolDownTimer.restart();
                }
            }
        });
    }

    /**
     * No actions for the player at clock ticks.
     */
    protected void update() {}

    /**
     * Move to the left.
     */
    public void moveLeft() {
        if (!laserOverheated) x = Math.max(x - MOVE_DISTANCE, 0);
    }

    /**
     * Move to the right.
     */
    public void moveRight() {
        if (!laserOverheated) x = Math.min(x + MOVE_DISTANCE, game.getWidth() - width);
    }

    /**
     * If canFire, fire a laser.
     */
    public void fire() {
        if (!laserRecharging && !laserOverheated) {
            // create the laser object
            int laserX = x + (width - Laser.WIDTH) / 2;
            int laserY = y - Laser.HEIGHT;
            game.addLaser(new Laser(laserX, laserY, game));

            // recharge state mechanics:
            laserRecharging = true;
            laserRechargeTimer.start();

            // laser heat mechanics
            laserHeatLevel += 1;
            laserCoolDownTimer.restart();

            if (laserHeatLevel >= LASER_HEAT_MAXIMUM) {
                laserOverheated = true;
                laserOverHeatDelay.start();
            }
        }
    }

    /**
     * Handle the collision with another object.
     * 
     * @param other the object that collided with this instance
     */
    protected void collide(GameObject other) {
        lives = lives - 1;
        moveToLeftSide();
        if (lives == 0) {
            isDead = true;
        }
        score = score - HIT_DECREMENT;

        // when the player is destroyed, the state is reset.
        laserOverheated = false;
        laserHeatLevel = 0;
        laserRecharging = false;
        laserCoolDownTimer.stop();
        laserRechargeTimer.stop();
        laserOverHeatDelay.stop();
    }

    /**
     * Move to the left side.
     */
    public void moveToLeftSide() {
        x = 0;
    }

    /**
     * @return the number of lives still remaining
     */
    public int getLives() {
        return lives;
    }

    /**
     * Set a new value for the number of lives.
     * 
     * @param lives the new value for the lives field
     */
    public void setLives(int lives) {
        this.lives = lives;
        if (lives == 0) {
            isDead = true;
        }
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param amount the amount by which the score is to be increased
     */
    public void increaseScore(int amount) {
        score = score + amount;
    }

    /**
     * @return the laser's heat level
     */
    int getHeatLevel() {
        return laserHeatLevel;
    }

    /**
     * @return true if the player is overheated
     */
    public boolean isOverheated() {
        return laserOverheated;
    }
}
