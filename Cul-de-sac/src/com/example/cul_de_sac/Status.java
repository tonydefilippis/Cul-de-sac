package com.example.cul_de_sac;

import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * This is a class to contain all modifiers that the character in the story can
 * have, along with ways to get and set those modifiers.
 *
 * @author Anthony DeFilippis
 * @version 2015.04.26
 */
public class Status
{
    private static ArrayList<String> status;


    /**
     * The constructor for the modifiers, which are contained in an arraylist of
     * strings. Initializes a new arraylist.
     */
    public Status()
    {
        status = new ArrayList<String>();
    }


    /**
     * A method to get all statuses that are affecting the player.
     *
     * @return An arraylist containing all active statuses.
     */
    public ArrayList<String> getStatus()
    {
        return status;
    }


    /**
     * This method adds statuses to the arraylist. Statuses here are strings.
     *
     * @param str
     *            A string of the status to add to the list.
     */
    public void addStatus(String str)
    {
        status.add(str);
    }


    /**
     * This method removes statuses from the arraylist.
     *
     * @param str
     *            The string of the status to remove from the list.
     */
    public void removeStatus(String str)
    {
        status.remove(str);
    }

    /**
     * A method to remove all the statuses that are currently affecting the
     * character.
     */
    public void removeAllStatus()
    {
        status.clear();
    }
}
