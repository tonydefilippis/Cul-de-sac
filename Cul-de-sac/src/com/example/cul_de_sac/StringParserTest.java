package com.example.cul_de_sac;

import android.test.AndroidTestCase;
import android.content.Context;

// -------------------------------------------------------------------------
/**
 * Tests for the StringParser class.
 *
 * @author Anthony DeFilippis
 * @version 2015.04.26
 */
public class StringParserTest
    extends AndroidTestCase
{
    // ~Fields -------------------------------------------------------------

    private StringParser strParse;
    private Status       stat;
    private Context      cont;
    private Location loc;
    private Story story;

    // ~Set up -------------------------------------------------------------
    /**
     * Setting up fields for the tests
     */
    public void setUp()
    {
        stat = new Status();
        cont = getContext();
        story = new Story(stat);
        loc = new Location(story);
        strParse = new StringParser(cont, stat);
    }


    /**
     * Test cases that extend AndroidTestCase must have a parameterless
     * constructor that calls super() and passes it the screen/activity class
     * being tested.
     */
    public StringParserTest()
    {
        super();
    }


    /**
     * Testing if the constructor works. Passes if the StringParser object is
     * not null after the constructor runs.
     */
    public void testStringParser()
    {
        assertFalse(strParse.equals(null));
    }


    // Testing different strings
    /**
     * Testing if the input string is correctly parsed into the nouns, verbs,
     * ands prepositions and gets the right response.
     */
    public void testParseString1()
    {
        loc.setLocation(7);
        strParse.setString("throw bike over fence");
        assertEquals("You sucessfully get the bike over the fence.",
            strParse.parseString());
    }
    /**
     * Testing if the input string is correctly parsed into the nouns, verbs,
     * ands prepositions and gets the right response.
     */
    public void testParseString2()
    {
        loc.setLocation(7);
        strParse.setString("throw bike fence");
        assertEquals("You sucessfully get the bike over the fence.",
            strParse.parseString());
    }


    /**
     * Testing if the input string is correctly parsed into the nouns, verbs,
     * ands prepositions and gets the right response.
     */
    public void testParseString3()
    {
        strParse.setString("blah");
        assertEquals(strParse.invalidSentence(),
            strParse.parseString());
    }

    /**
     * Testing if the input string is correctly parsed into the nouns, verbs,
     * ands prepositions and gets the right response.
     */
    public void testParseString4()
    {
        loc.setLocation(5);
        stat.addStatus("momKitchen");
        strParse.setString("play baseball with sister");
        assertEquals("You play baseball with your sister.",
            strParse.parseString());
    }

    /**
     * Testing if the input string is correctly parsed into the nouns, verbs,
     * ands prepositions and gets the right response.
     */
    public void testParseString5()
    {
        loc.setLocation(5);
        stat.addStatus("momKitchen");
        strParse.setString("play baseball without sister");
        assertEquals("You play baseball alone.",
            strParse.parseString());
    }
    /**
     * Testing if the input string is correctly parsed into the nouns, verbs,
     * ands prepositions and gets the right response.
     */
    public void testParseString6()
    {
        loc.setLocation(5);
        strParse.setString("play baseball");
        assertEquals("You play baseball alone.",
            strParse.parseString());
    }
    //Testing setter and getter and specific response.
    /**
     * Testing if the string is correctly set.
     */
    public void testSetString()
    {
        strParse.setString("go to room");
        strParse.setString("get shirt");
        assertEquals("get shirt", strParse.getString());
    }


    /**
     * Testing if the string can be retrieved correctly.
     */
    public void testGetString()
    {
        strParse.setString("go to room");
        assertEquals("go to room", strParse.getString());
    }


    /**
     * Just checks if the method actually returns the sentence it should.
     */
    public void testInvalidSentence()
    {
        assertEquals(
            "I don't understand what I am supposed to do.",
            strParse.invalidSentence());
    }

}
