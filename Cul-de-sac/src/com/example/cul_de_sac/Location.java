package com.example.cul_de_sac;

// -------------------------------------------------------------------------
/**
 * This class pertains to the locations in a given story, ways to get and set
 * those locations and receive the names and descriptions of them.
 *
 * @author Anthony DeFilippis (dtony)
 * @version 2015.04.24
 */
public class Location

{

    private static int locationInt;
    private Story      story;


    // ----------------------------------------------------------
    /**
     * Create a new Location object.
     *
     * @param stor
     *            The story for which the locations exit in.
     */
    public Location(Story stor)
    {
        story = stor;
    }


    /**
     * A getter method for the location variable. Returns the int associated
     * with that location.
     *
     * @return The value of the current location.
     */
    public int getLocation()
    {
        return locationInt;
    }


    /**
     * A setter method for the location variable. Returns the int associated
     * with that location.
     *
     * @param locInt
     */
    public void setLocation(int locInt)
    {
        locationInt = locInt;
    }


    /**
     * Returns a string of the name of the location number.
     *
     * @return A string of the name of the current location.
     */
    public String getLocationName()
    {
        return story.locationName(locationInt);
    }


    /**
     * Returns a string containing the description of the current location.
     *
     * @return A string of the description of the location.
     */
    public String getLocationDescription()
    {
        return story.getDescription(locationInt);
    }
}
