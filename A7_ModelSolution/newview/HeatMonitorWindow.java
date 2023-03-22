/*
  CMPT 270 Course Material
  Copyright (c) 2003-2021
  J.P. Tremblay and Grant Cheston
  All rights reserved.

  This document contains resources for homework assigned to students of
  of CMPT 270 and shall not be distributed without permission.  Posting this
  file to a public or private website, or providing this file to any person
  not registered in CMPT 270 constitutes Academic Misconduct according to
  to the University of Saskatchewan Policy on Academic Misconduct.
 */

package newview;

import model.GameInfoProvider;
import model.GameObserver;
import util.PropertiesDiskStorage;
import view.ImageCache;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * A window to show the invader image and a count of the number of invaders remaining.
 */
public class HeatMonitorWindow extends JFrame {
    /**
     * Initialize the frame, add the panel, and set the frame visible.
     * 
     * @param gameInfo the interface to access the invader count
     */
    public HeatMonitorWindow(GameInfoProvider gameInfo) {
        setTitle("Heat Monitor");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(250, 175);
        add(new HeatMonitorPanel(gameInfo));
        setVisible(true);
    }

    /**
     * The panel to show the invader image and a count of the number of invaders remaining.
     */
    private class HeatMonitorPanel extends JPanel implements GameObserver {
        /**
         * The interface to access the invader count.
         */
        private GameInfoProvider gameInfo;

        /**
         * The number of invaders when the game was last checked.
         */
        private int count;
        /**
         * The laser heat build-up when the game was last checked.
         */
        private int heat;
        /**
         * A list of the images of an invader.
         */
        private List<BufferedImage> images;

        private BufferedImage invader_image;
        /**
         * An iterator for the list of images.
         */
        private Iterator<BufferedImage> imagesIter;

        /**
         * Initialize the fields of the panel ready for the first painting.
         * 
         * @param gameInfo the interface to access the invader count
         */
        public HeatMonitorPanel(GameInfoProvider gameInfo) {
            this.gameInfo = gameInfo;
            gameInfo.addObserver(this); // this instance must be notified when the game changes

            List<String> imageNames = PropertiesDiskStorage.getInstance().getProperties("invader");
            images = new LinkedList<BufferedImage>();
            for (String name : imageNames)
                images.add(ImageCache.getInstance().getImage(name));
            imagesIter = images.iterator();
            invader_image = imagesIter.next();
        }


        /**
         * The action to perform whenever the game changes.
         */
        public void gameChanged() {
            // check the game for pertinent changes
            int newCount = gameInfo.getInvaderCount();
            int newHeat = gameInfo.getPlayerHeat();

            // animate the invader image in the panel
            if (newCount != count) {
                count = newCount;
                if (!imagesIter.hasNext())
                    imagesIter = images.iterator();
                invader_image = imagesIter.next();
                repaint();
            }
            // post the new heat level in the panel
            else if (newHeat != heat) {
                heat = newHeat;
                repaint();
            }
        }

        /**
         * Paint the new contents of the panel.
         * 
         * @param g the Graphics to be used for painting
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            g2.setPaint(Color.BLACK);
            g2.fillRect(0, 0, getWidth(), getHeight());

            g2.drawImage(invader_image, 100, 25, 50, 50, null);

            Paint oldColor = g2.getPaint();
            if (!gameInfo.getPlayerOverheated()) {
                g2.setPaint(Color.GREEN);
                g2.drawString("Current heat level: " + gameInfo.getPlayerHeat(), 20, 110);
            }
            else {
                g2.setPaint(Color.RED);
                g2.drawString("OVERHEATED! Cooling down...", 20, 110);
            }
            g2.setPaint(oldColor);        }

        public static final long serialVersionUID = 1;
    }

    public static final long serialVersionUID = 1;
}
