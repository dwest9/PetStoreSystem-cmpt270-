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

// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09


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

    /* The initial number of lives for the Player. */
    public static final int INITIAL_NUM_LIVES = 4;

    /* The number of lives remaining for the Player. */
    protected int lives;

    /* The current score for the Player. */
    protected int score;

    /** How frequently (in terms of ticks) the player is to change image. */
    public static final int CHANGE_FREQ = 0;

    /** A Timer to limit the rate of laser fire */
    private Timer laserRechargeTimer;

    /** An integer to indicate the energy level of the tank */
    private int tankenergylevel;

    /** A boolean to indicate if the laser is out of energy */
    private boolean outOfenergy;

    /** A boolean to indicate if the laser is in low power mode */
    private boolean lowPowermode;

    /** A boolean to indicate if player move or not */
    private boolean movementLimit;

    /** A Timer for low energy state */
    private Timer timerlowPowerstate;

    /** A Timer to allow the laser to regenerate */
    private Timer energyRegeneration;

    /** A Timer to limit player movement speed */
    private Timer playermovementTimer;


    /** A constant to indicate the laser's minimum energy level */
    private final int Tank_Minimum_Level = 0;



    /** A boolean to indicate if the laser is being recharged */
    private boolean laserRecharging;


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
        laserRechargeTimer = new Timer(200, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                laserRecharging = false;
            }
        });
        laserRechargeTimer.setRepeats(false);

        tankenergylevel=0;
        outOfenergy=false;
        lowPowermode=false;

        timerlowPowerstate = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outOfenergy = false;
                laserRecharging = false;
                tankenergylevel = 5;
            }
        });
        timerlowPowerstate.setRepeats(false);



        playermovementTimer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movementLimit = false;
            }
        });


        energyRegeneration = new Timer(350, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // increase the energy by one
                if (tankenergylevel < 5 && outOfenergy && lowPowermode) {
                    tankenergylevel += 1;
                }
                // restart the timer if the energy is still low
                if  (tankenergylevel < 5) {
                    energyRegeneration.restart();
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
        if(!lowPowermode) {
            movementLimit = true;
            x = Math.max(x - MOVE_DISTANCE, 0);
            playermovementTimer.start();
        }
    }

    /**
     * Move to the right.
     */
    public void moveRight() {
        if(!lowPowermode) {
            movementLimit = true;
            x = Math.min(x + MOVE_DISTANCE, game.getWidth() - width);
            playermovementTimer.start();
        }
    }

    /**
     * If canFire, fire a laser.
     */
    public void fire() {
        if (!laserRecharging && !outOfenergy && !lowPowermode) {   //creating laser object
            int laserX = x + (width - Laser.WIDTH) / 2;
            int laserY = y - Laser.HEIGHT;
            game.addLaser(new Laser(laserX, laserY, game));
            laserRecharging = true;  //recharge mode
            laserRechargeTimer.start();

            // laser energy mechanics
            tankenergylevel -= 1;
            energyRegeneration.restart();

            if (tankenergylevel <= Tank_Minimum_Level){
                outOfenergy = true;
                lowPowermode = true;
                timerlowPowerstate.start();

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
}
