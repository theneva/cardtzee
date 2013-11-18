package com.rushteamc.yahtzoid.models;

import java.io.*;
import java.util.Observable;
import java.util.Observer;

import com.rushteamc.yahtzoid.models.gui.GameView;

/**
 * Created with IntelliJ IDEA. User: Martin Date: 11/18/13 Time: 9:05 PM To change this
 * template use File | Settings | File Templates.
 */
public class GameShell implements Observer
{
    private static transient final String SAVE_FILE_NAME = "saved_state.dat";

    private GameView view;

    private Game game;

    public GameShell(String... playerNames)
    {
        this.setupGame();
    }

    private void setupGame()
    {
        this.view = new GameView();
        this.view.addObserver(this);
    }

    public void saveGame()
    {
        try
        {
            FileOutputStream fileOut = new FileOutputStream(new File(SAVE_FILE_NAME));
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(this);

            out.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void loadGame()
    {
        try
        {
            FileInputStream fileIn = new FileInputStream(new File(SAVE_FILE_NAME));
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Game savedGame = (Game) in.readObject();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Observable o, Object commandAsObject)
    {
        String command = (String) commandAsObject;
        System.out.println("From update in GameShell: " + command);
    }
}
