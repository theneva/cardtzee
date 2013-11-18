package com.rushteamc.yahtzoid.models.actors;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA. User: Martin Date: 11/18/13 Time: 8:07 PM To change this
 * template use File | Settings | File Templates.
 */
public class Player extends Person implements Serializable
{
    public Player(String name)
    {
        super(name);
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
