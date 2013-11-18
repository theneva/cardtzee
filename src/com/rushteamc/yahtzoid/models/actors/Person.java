package com.rushteamc.yahtzoid.models.actors;

/**
 * Created with IntelliJ IDEA. User: Martin Date: 11/18/13 Time: 8:16 PM To change this
 * template use File | Settings | File Templates.
 */
public class Person
{
    private String name;

    public Person(String name)
    {
        this.setName(name);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
