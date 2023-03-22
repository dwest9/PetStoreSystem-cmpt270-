
// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09



package newview;

import view.ViewPanel;

import javax.swing.*;
import java.awt.*;

public class EnergywindowPanel extends ViewPanel {

    public EnergywindowPanel(){
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalGlue());


        JLabel space = new JLabel("Energy Level: " );
        space.setForeground(Color.BLACK);
        space.setAlignmentX((Component.TOP_ALIGNMENT));
        add(space);
        add(Box.createVerticalGlue());


    }

}

