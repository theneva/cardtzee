package com.rushteamc.yahtzoid.models;

/**
 * Created with IntelliJ IDEA. User: Martin Date: 11/18/13 Time: 7:42 PM To change this
 * template use File | Settings | File Templates.
 */
public class Card
{
    private CardType type;

    public Card(CardType type)
    {
        this.setType(type);
    }

    public CardType getType()
    {
        return type;
    }

    public void setType(CardType type)
    {
        this.type = type;
    }
}
