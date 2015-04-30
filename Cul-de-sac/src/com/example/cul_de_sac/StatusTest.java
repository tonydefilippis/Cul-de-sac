package com.example.cul_de_sac;

import java.util.ArrayList;
import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests for the status class.
 *
 * @author Anthony DeFilippis
 * @version 2015.04.26
 */
public class StatusTest
    extends TestCase
{
    // ~Fields ----------------------------------------------------------------
    private Status            stat;
    private ArrayList<String> statCompare;


    // ~ Set up ----------------------------------------------------------------
    /**
     * Setting up the status for tests.
     */
    public void setUp()
    {
        stat = new Status();
        statCompare = new ArrayList<String>();
    }


    // ~Tests -----------------------------------------------------------------

    /**
     * Testing if the constructor works correctly.
     * Passes if the constructor works and status is not null
     */
    public void testStatus()
    {
        assertFalse(stat.equals(null));
    }


    /**
     * Testing if the status returns the correct status object
     * passes if both are empty arraylists.
     */
    public void testGetStatus()
    {
        assertTrue(stat.getStatus().equals(statCompare));
    }


    /**
     * Testing if addStatus() correctly adds a string.
     * Passes if the arraylist contains the added string.
     */
    public void testAddStatus()
    {
        stat.addStatus("test");
        assertTrue(stat.getStatus().contains("test"));
    }


    /**
     * Testing if removeStatus() correctly removes a string.
     * Passes if the added string no longer exists after removal.
     */
    public void testRemoveStatus()
    {
        stat.addStatus("test");
        stat.removeStatus("test");
        assertFalse(stat.getStatus().contains("test"));
    }


    /**
     * Testing if removeAllStatus() removes all the strings.
     * Passes if the size is 0 after all are removed.
     */
    public void testRemoveAllStatus()
    {
        stat.addStatus("test");
        stat.addStatus("this");
        stat.addStatus("method");
        stat.removeAllStatus();
        assertEquals(0, stat.getStatus().size());
    }
}
