package com.rushteamc.yahtzoid.game;

import java.io.Serializable;
import java.util.ArrayList;

import com.rushteamc.yahtzoid.exceptions.NotInitializedException;
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

    private static Game instance;

    private Deck round, wild;

    private ArrayList<Player> players;

    private Game(String... playerNames)
    {
        this.round = new Deck(CardType.ROUND);
        this.wild = new Deck(CardType.WILD);

        this.setUpPlayers(playerNames);
    }

    public static void initialize(String... playerNames)
    {
        instance = new Game(playerNames);
    }

    public static Game getInstance()
    {
        if (instance == null) throw new NotInitializedException();
        return instance;
    }

    private void setUpPlayers(String... playerNames)
    {
        if (playerNames.length > MAX_PLAYERS)
        {
            System.err.println("Fuck you.");
            System.exit(0);
        }

        this.players = new ArrayList<>();

        for (int i = 0; i < playerNames.length; i++)
        {
            String currentName = playerNames[i];
            this.players.add(new Player(currentName));
        }
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }
}
