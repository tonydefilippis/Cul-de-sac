package com.example.cul_de_sac;

import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 * A class containing all tests for the Location class.
 *
 * @author Anthony DeFilippis
 * @version 2015.04.26
 */
public class LocationTest
    extends TestCase
{
    // ~Fields ----------------------------------------------------------------
    private Story    story;
    private Location loc;
    private Status   stat;


    // ~Set up ----------------------------------------------------------------
    /**
     * A method to set up parameters before each test.
     */
    public void setUp()
    {
        stat = new Status();
        story = new Story(stat);
        loc = new Location(story);
    }


    // ~Tests -----------------------------------------------------------------
    /**
     * A method to test the constructor of the location class. Passes if the
     * constructed location is not null.
     */
    public void testLocation()
    {
        assertFalse(loc.equals(null));
    }


    /**
     * A method to test if the given location is the correct location. Passes if
     * the set location is the same as the retrieved.
     */
    public void testGetLocation()
    {
        loc.setLocation(5);
        assertTrue(loc.getLocation() == 5);
    }


    /**
     * Testing if setting the locations results in a change of the location.
     * Passes if the set location changes after being set again.
     */
    public void testSetLocation()
    {
        loc.setLocation(5);
        loc.setLocation(3);
        assertTrue(loc.getLocation() == 3);
    }


    /**
     * Testing if the name of the location is correctly retrieved. Passes if the
     * string of the name and the know name are the same.
     */
    public void testGetLocationName()
    {
        loc.setLocation(0);
        assertEquals("Bathroom", loc.getLocationName());
    }


    /**
     * Testing if the description of the location is correctly retrieved. Passes
     * if the string of the description and the known description are the same.
     */
    public void testGetLocationDescription()
    {
        stat.addStatus("isWet");
        loc.setLocation(0);
        assertEquals(
            "You step out of the shower into a sunny saturday morning. "
                + "You are covered in water, and proceed to look around the "
                + "room. There is a mirror, two sinks, and a cabinet full of "
                + "the usual stuff you would find in a bathroom."
                + "\nA dry towel lays on the floor across the room.\n"
                + "A door connects this room to your bedroom.",
            loc.getLocationDescription());
    }

}
