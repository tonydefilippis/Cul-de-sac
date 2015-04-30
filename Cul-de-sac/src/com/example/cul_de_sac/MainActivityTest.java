package com.example.cul_de_sac;

import android.test.ActivityTestCase;

// -------------------------------------------------------------------------
/**
 * Tests for the MainActivity class.
 *
 * @author Anthony DeFilippis
 * @version 2015.04.26
 */
public class MainActivityTest
    extends ActivityTestCase
{
    // ~Fields ----------------------------------------------------------------

    // ~Set up ----------------------------------------------------------------
    /**
     * Setting up the app for testing.
     */
    public void setUp()
    {
        // Does nothing.
    }


    /**
     * Test cases that extend AndroidTestCase must have a parameterless
     * constructor that calls super() and passes it the screen/activity class
     * being tested.
     */
    public MainActivityTest()
    {
        super();
    }


    // ~Tests -----------------------------------------------------------------
    /**
     * Testing if the app is made correctly. This is hard to test without
     * observing the proper creation of the app. If other tests work then so
     * does this one.
     */
    public void testOnCreate()
    {
        // Unable to test. Visually confirmed app's creation.
    }
}
