package com.rushteamc.yahtzoid.models;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA. User: Martin Date: 11/18/13 Time: 7:49 PM To change this
 * template use File | Settings | File Templates.
 */
public class Deck extends ArrayList<Card>
{
    private CardType type;

    /** The number of cards that can be held in a single Deck. */
    private int capacity;

    /**
     * Creates a new Deck with a capacity of 52.
     * 
     * @param type
     *            the type of the Deck.
     */
    public Deck(final CardType type)
    {
        this(type, 52);
    }

    public Deck(final CardType type, final int capacity)
    {
        this.setType(type);
        this.setCapacity(capacity);
    }

    public boolean addCard(Card card)
    {
        if (this.size() >= this.capacity) return false;

        this.add(card);
        return true;
    }

    public void shuffle()
    {
        Collections.shuffle(this);
    }

    public Card drawCard()
    {
        return this.remove(this.size() - 1);
    }

    public CardType getType()
    {
        return type;
    }

    public void setType(CardType type)
    {
        this.type = type;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }
}
