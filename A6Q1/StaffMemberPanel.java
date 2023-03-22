
// Name: David Emmanuel
// NSID: doe869
// Student: 11298443
// Course: cmpt270
// Lab section: Section T09


package gui;

import commands.AssignStaffToAnimal;
import commands.CommandArguments;
import commands.DropAssociation;
import containers.AnimalMapAccess;
import entities.Manager;
import entities.StaffMember;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The panel to show staff member information and operations.
 */
public class StaffMemberPanel extends JPanel {

    /**
     * The panel to display the information for a staff member, and accept operations on the staff member.
     */
    public StaffMemberPanel(StaffMember staffMember) {
        staff_member_build(staffMember);
    }

    /** this builds the information of the staff member
     *
     * @param staffMember the staff member whose information is to be displayed and on whom operations can be
     *        done
     */
    private void staff_member_build(StaffMember staffMember) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        if(staffMember instanceof Manager) {
            add(new JLabel("Manger: " + staffMember.getEmployeeID()));
        } else {
            add(new JLabel("StaffMember: " + staffMember.getEmployeeID()));
        }
        // a panel for adding an animal to the staff member list of animals
        JPanel addPanel = addanimalPanel(staffMember);
        add(addPanel);
        addPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        // a panel to access a specific animal
        JPanel accessPanel = access_animal(staffMember);
        add(accessPanel);
        add(Box.createVerticalGlue());

        // a panel to remove an animal from the staff member list
        JPanel dropPanel = drop_animal(staffMember);
        add(dropPanel);
        add(Box.createVerticalGlue());

        // an empty panel and an exit button
        JPanel emptyPanel = new JPanel();
        add(emptyPanel);
        emptyPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        add(new JLabel("  ")); // blank line in the panel for spacing
        final JButton exitButton = new JButton("Exit");
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                exitButton.getTopLevelAncestor().setVisible(false);
            }
        });
    }

    /**
     * A panel to access an animal of the staff member.
     *
     * @param staffMember a staff member with the animal
     * @return the panel to access the animal of the staff member
     */
    private JPanel access_animal(final StaffMember staffMember) {
        JPanel accessPanel = new JPanel();
        final JTextField textField = new JTextField(10);
        accessPanel.add(textField);
        JButton accessButton = new JButton("Access animal with animal id");
        accessPanel.add(accessButton);
        accessButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        String animID = textField.getText();

                        if (animID != null) {
                            String animalID = AnimalMapAccess.getInstance().get(animID).getAnimalID();
                            if (staffMember.hasAnimal(animalID)) {
                                AnimalFrame frame = null;
                                try {
                                    frame = new AnimalFrame( animalID );
                                } catch (RuntimeException e) {
                                    textField.setText( "Invalid id: " + textField.getText() );
                                    textField.revalidate();
                                    return;
                                }
                                frame.setLocation( 300, 300 );
                                frame.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
                                frame.setVisible( true );
                                textField.setText( "" );
                                textField.revalidate();
                            } else {
                                textField.setText( textField.getText() + "is not an animal of this staff member" );
                                textField.revalidate();
                            }
                        } else {
                            textField.setText( "Empty field: " + textField.getText() );
                            textField.revalidate();
                        }
                    }
                }
        );
        return accessPanel;
    }

    /**
     * A panel to drop a staff member-animal association.
     *
     * @param staffMember a staff member with the animal
     * @return the panel to drop a staff member-animal association
     */
    private JPanel drop_animal(final StaffMember staffMember) {
        JPanel staffmemberPanel = new JPanel();
        final JTextField textField = new JTextField(10);
        staffmemberPanel.add(textField);
        JButton removeButton = new JButton("Remove animal");
        staffmemberPanel.add(removeButton);
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                DropAssociation dropAssoc = new DropAssociation();
                String animID = textField.getText();
                CommandArguments command_arguments = new CommandArguments();
                command_arguments.aPetID= animID;
                command_arguments.sID = staffMember.getEmployeeID();
                dropAssoc.setCommnadArguments( command_arguments );
                dropAssoc.execute();

                if (dropAssoc.wasSuccessful()) {
                    // recreate the panel as it has changed
                    removeAll();
                    staff_member_build(staffMember);
                    revalidate();
                } else {
                    JOptionPane.showMessageDialog( StaffMemberPanel.this, dropAssoc.getErrorMessage());
                }
            }
        });
        return staffmemberPanel;
    }

    /**
     * A panel to add an animal of the staff member's list of animal.
     *
     * @param staffMember a staff member with the animal
     * @return the panel to add an animal to the staff member's list of animals
     */
    private JPanel addanimalPanel(final StaffMember staffMember) {
        JPanel addstaffmemberPanel = new JPanel();
        final JTextField textField = new JTextField(10);
        addstaffmemberPanel.add(textField);
        JButton addButton = new JButton("Add animal with animal id");
        addstaffmemberPanel.add(addButton);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String animID = textField.getText();

                AssignStaffToAnimal AddAssociation = new AssignStaffToAnimal();
                CommandArguments command_arguments = new CommandArguments();
                command_arguments.aPetID = AnimalMapAccess.getInstance().get( animID).getAnimalID();
                command_arguments.sID = staffMember.getEmployeeID();
                command_arguments.sFirstName= staffMember.getFirstName();
                command_arguments.sLastName= staffMember.getLastName();
                AddAssociation.setCommnadArguments( command_arguments);
                AddAssociation.execute();
                if (AddAssociation.wasSuccessful()) {
                    // this recreates the panel when it has been changed
                    removeAll();
                    staff_member_build(staffMember);
                    revalidate();
                } else {
                    JOptionPane.showMessageDialog( StaffMemberPanel.this, AddAssociation.getErrorMessage());
                }
            }
        });
        return addstaffmemberPanel;
    }

    public static final long serialVersionUID = 1;
}
