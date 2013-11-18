package com.rushteamc.yahtzoid.game;

import java.io.*;
import java.util.Observable;
import java.util.Observer;

import com.rushteamc.yahtzoid.gui.GameView;

/**
 * Created with IntelliJ IDEA. User: Martin Date: 11/18/13 Time: 9:05 PM To change this
 * template use File | Settings | File Templates.
 */
public class GameShell implements Observer
{
    private static transient final String SAVE_FILE_NAME = "saved_state.dat";

    private GameView view;

    private Game game;

    public GameShell()
    {
        this.setupGame();
    }

    private void setupGame()
    {
        this.view = new GameView();
        this.view.addObserver(this);
    }

    private void newGame()
    {
        // TODO: Ask dynamically.
        Game.initialize("Simen", "Vegard");

        this.game = Game.getInstance();
    }

    public void saveGame()
    {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(SAVE_FILE_NAME))))
        {
            out.writeObject(this.game);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void loadGame()
    {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(SAVE_FILE_NAME))))
        {
            this.game = (Game) in.readObject();

            System.out.println(this.game.getPlayers());
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private void quit()
    {
        // TODO: Ask if the user wants to save.
        System.exit(0);
    }

    @Override
    public void update(Observable o, Object commandAsObject)
    {
        final String command = (String) commandAsObject;

        switch (command)
        {
            case "Save":
                this.saveGame();
                break;
            case "Load":
                this.loadGame();
                break;
            case "New game":
                this.newGame();
                break;
            case "Quit":
                this.quit();
                break;
            default:
                System.err.println("Not implemented");
                break;
        }
    }
}
