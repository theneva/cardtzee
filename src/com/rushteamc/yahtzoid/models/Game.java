package com.rushteamc.yahtzoid.models;

import java.io.*;
import java.util.ArrayList;

import com.rushteamc.yahtzoid.models.actors.Player;
import com.rushteamc.yahtzoid.models.game_things.cards.CardType;
import com.rushteamc.yahtzoid.models.game_things.cards.Deck;

/**
 * Created with IntelliJ IDEA. User: Martin Date: 11/18/13 Time: 8:18 PM To change this
 * template use File | Settings | File Templates.
 */
public class Game implements Serializable
{
    private static transient final int MAX_PLAYERS = 4;

    private Deck round, wild;

    private ArrayList<Player> players;

    public Game(String playerNames[])
    {
        this.round = new Deck(CardType.ROUND);
        this.wild = new Deck(CardType.WILD);

        setUpPlayers(playerNames);
    }

    private void setUpPlayers(String... playerNames)
    {
        if (playerNames.length > MAX_PLAYERS)
        {
            System.err.println("Fuck you.");
            System.exit(0);
        }

        for (int i = 0; i < playerNames.length; i++)
        {
            String currentName = playerNames[i];
            this.players.add(new Player(currentName));
        }
    }

    public void saveGame()
    {
        try {
            FileOutputStream fileOut = new FileOutputStream(new File("saved_state.dat"));
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(this);

            out.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
