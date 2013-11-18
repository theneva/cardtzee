package com.rushteamc.yahtzoid.models.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Observable;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA. User: Martin Date: 11/18/13 Time: 9:07 PM To change this
 * template use File | Settings | File Templates.
 */
public class GameView extends Observable implements ActionListener
{
    private JFrame frame;

    public GameView()
    {
        this.frame = new JFrame("Cardtzee");

        JPanel panelButtons = new JPanel(new GridLayout(1, 4, 5, 5));

        String buttonLabels[] =
        {
                "New game", "Save", "Load", "Quit"
        };

        for (String buttonLabel : buttonLabels)
        {
            JButton currentButton = new JButton(buttonLabel);
            currentButton.addActionListener(this);
            panelButtons.add(currentButton);
        }

        this.frame.add(new TextArea());
        this.frame.add(panelButtons, BorderLayout.SOUTH);

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.frame.setSize(600, 400);
        this.frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        System.out.println("From actionPerformed: " + command);

        super.setChanged();
        super.notifyObservers(command);
    }
}
