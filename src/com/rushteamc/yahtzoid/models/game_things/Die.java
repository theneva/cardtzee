package com.rushteamc.yahtzoid.models.game_things;

import java.util.Random;

/**
 * Created with IntelliJ IDEA. User: Martin Date: 11/18/13 Time: 8:08 PM To change this
 * template use File | Settings | File Templates.
 */
public class Die
{

    /** The number of eyes on the die. */
    private int eyes;

    private final Random random;

    public Die(int eyes)
    {
        this.eyes = eyes;

        this.random = new Random();
    }

    /**
     * Rolls the die and returns the result.
     * 
     * @return the result of the roll.
     */
    public int roll()
    {
        return this.random.nextInt(eyes) + 1;
    }

    public int getEyes()
    {
        return eyes;
    }

    public void setEyes(int eyes)
    {
        this.eyes = eyes;
    }
}
