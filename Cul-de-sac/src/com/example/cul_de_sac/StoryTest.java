package com.example.cul_de_sac;

import java.util.ArrayList;
import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Anthony DeFilippis
 * @version 2015.04.26
 */
public class StoryTest
    extends TestCase
{
    // ~Fields ----------------------------------------------------------------
    private Status   stat;
    private Location loc;
    private Story    stor;


    // ~Set up ----------------------------------------------------------------
    public void setUp()
    {
        stat = new Status();
        stor = new Story(stat);
        loc = new Location(stor);
    }


    /**
     * Testing if the constructor works. Pass if story is not null after
     * construction.
     */
    public void testStory()
    {

        assertNotNull(stor);
    }

    //Begin testing different descriptions
    /**
     * Testing if the correct description is returned for -1.
     */
    public void testGetDescriptionLocNegOne()
    {
        loc.setLocation(-1);
        assertEquals(
            "Hello and welcome to Cul-de-sac.\nThis is a text-based "
                + "interactive fiction game. Kevin, a neighborhood bully, has "
                + "taken your bike. He is moving away tommorow. Your goal is to"
                + " retrieve your bike by the end of the day.\n"
                + "If it is your first time"
                + " playing, type \"help me\" below.\nOtherwise, you can type "
                + "\"play game\" to"
                + " begin playing the game.\nRemember to hit enter each time."
                + "\n\n" + "Made by Anthony DeFilippis for CS2114.",
            stor.getDescription(-1));
    }


    /**
     * Testing if the correct description is returned for -2.
     */
    public void testGetDescriptionLocNegTwo()
    {
        loc.setLocation(-1);
        assertEquals(
            "Welcome to the help menu.\nAbove, you can see your "
                + "current location in the world. Text descriding that location"
                + " will be here. To interact with the world, simply type "
                + "whatever you want. For instance, if there was a bucket that "
                + "you want to look at, you would type \"look bucket\" without"
                + " the quotations.\nYou will likely lose multiple times, but "
                + "remember, losing is fun!\nFrom here, you can return to the "
                + "start menu, or begin playing the game. You can type "
                + "\"restart game\""
                + " at any time to restart the game from the beginning.",
            stor.getDescription(-2));
    }


    /**
     * Testing if the correct description is returned for 0.
     */
    public void testGetDescriptionLocZero()
    {
        loc.setLocation(0);
        assertEquals(
            "You step out of the shower into a sunny saturday morning "
                + "and proceed to look around the room. There is a mirror, two "
                + "sinks, and a cabinet full of the usual stuff you would find "
                + "in a bathroom."
                + "\nAn used towel lays on the floor across the room.\n"
                + "A door connects this room to your bedroom.",
            stor.getDescription(0));
    }


    /**
     * Testing if the correct description is returned for 1.
     */
    public void testGetDescriptionLocOne()
    {
        stat.addStatus("isNaked");
        stat.addStatus("deskIsMessy");
        stat.addStatus("bedIsMessy");
        loc.setLocation(1);
        assertEquals("You enter the bedroom, which is very messy.\nToday's "
            + "clothes are thrown about the floor, your bed is unmade, and "
            + "your desk is covered in trash. There is a nice set of "
            + "weights put away in the corner. You see the glimmer of "
            + "something shiny in your backpack, which is on your bed.\n"
            + "From here, you can see the door to your bathroom and "
            + "a door that leads out into the hallway, then downstairs "
            + "into the kitchen.", stor.getDescription(1));
    }


    /**
     * Testing if the correct description is returned for 2.
     */
    public void testGetDescriptionLocTwo()
    {
        loc.setLocation(2);
        assertEquals("You walk into the hallway outside your "
            + "room that connects to the kitchen downstairs.\n"
            + "You can see stairs that lead to the kitchen and a door that"
            + " leads to your room.", stor.getDescription(2));
    }


    /**
     * Testing if the correct description is returned for 5.
     */
    public void testGetDescriptionLocFive()
    {
        stat.addStatus("momKitchen");
        loc.setLocation(5);
        assertEquals(
            "You walk outside.It is a bright, sunny day. It looks like "
                + "it is around noon. Your sister is playing baseball in "
                + "the front yard. Your mother is watching her from the "
                + "window. Kevin's house sits on on the end of the Cul-de-sac."
                + "\nThere is a rock lying on the ground.",
            stor.getDescription(5));
    }


    /**
     * Testing if the correct description is returned for 3.
     */
    public void testGetDescriptionLocThree()
    {
        stat.addStatus("momKitchen");
        loc.setLocation(3);
        assertEquals(
            "You walk into the kitchen. You see your mom preparing food at the "
                + "stove. You also see a large window with a view of the Cul-de-sac"
                + ".\nYou see a faint glimmer of something in your mother's pocket."
                + "\nFrom here, there is a door going to the garage, and a "
                + "stairway that leads to an upstairs hallway.",
            stor.getDescription(3));
    }


    /**
     * Testing if the correct description is returned for 4.
     */
    public void testGetDescriptionLocFour()
    {
        loc.setLocation(4);
        assertEquals("You walk into the garage. There is a car "
            + "and a toolbench with lots of tools on it.\n"
            + "You can see a door that leads outside, and a door that leads"
            + " back into the kitchen.", stor.getDescription(4));
    }


    /**
     * Testing if the correct description is returned for 6.
     */
    public void testGetDescriptionLocSix()
    {
        loc.setLocation(6);
        assertEquals(
            "You approach Kevin's home. There is a door that leads "
                + "into the house. There is a window so you can see into the "
                + "house.\nThere is a fence that leads into Kevin's backyard,"
                + " and the street leads back to the Cul-de-sac.",
            stor.getDescription(6));
    }


    /**
     * Testing if the correct description is returned for 7.
     */
    public void testGetDescriptionLocSeven()
    {
        loc.setLocation(7);
        assertEquals(
            "There isn't much here except your bike and a large hole. "
                + "Kevin went inside to answer the door, so you are free "
                + "to do whatever you want.\nA fence bordering the "
                + "backyard is the only way to get out.",
            stor.getDescription(7));
    }


    /**
     * Testing if the correct description is returned for 8.
     */
    public void testGetDescriptionLocEight()
    {
        loc.setLocation(8);
        assertEquals(
            "Congratulations! You successfully retrieve your bike. "
                + "You congratulate yourself for a job well done, "
                + "and the next day Kevin moves away. If "
                + "you would like to replay the game, just type \"play game\"."
                + " If not, I hope you had fun playing. If you have any "
                + "suggestions or problems, email me at dtony@vt.edu.",
            stor.getDescription(8));
    }


    /**
     * Testing if the correct description is returned for 21.
     */
    public void testGetDescriptionLoc21()
    {
        loc.setLocation(21);
        assertEquals("Being so wet, you take a nasty spill as you walk down"
            + " the stairs. Your mother comes rushing to you and put you"
            + " back into your bed. You lose.", stor.getDescription(21));
    }


    /**
     * Testing if the correct description is returned for 31.
     */
    public void testGetDescriptionLoc31()
    {
        loc.setLocation(31);
        assertEquals("Your mother catches you improperly dressed. She makes "
            + "you get "
            + "dressed, and then has you spend the rest of the day doing "
            + "chores around the house and playing with your sister. "
            + "You lose.", stor.getDescription(31));
    }


    /**
     * Testing if the correct description is returned for 41.
     */
    public void testGetDescriptionLoc41()
    {
        loc.setLocation(41);
        assertEquals(
            "Not knowing how to drive, you barely manage to get the car"
                + " out of the driveway without hitting anything. You"
                + " immediately hit your neighbor's car after you being driving."
                + " You are promptly grounded. You lose.",
            stor.getDescription(41));
    }


    /**
     * Testing if the correct description is returned for 51.
     */
    public void testGetDescriptionLoc51()
    {
        loc.setLocation(51);
        assertEquals(
            "You walk outside, and hear the door lock behind you."
                + " You are stuck, and decide to play baseball with your"
                + " sister your mother calls you in for lunch. You spend "
                + "the rest of your weekend playing games. You lose.",
            stor.getDescription(51));
    }


    /**
     * Testing if the correct description is returned for 61.
     */
    public void testGetDescriptionLoc61()
    {
        loc.setLocation(61);
        assertEquals("As you climb over the fence, you realize that Kevin is "
            + "currently playing in the backyard. He immediately catches "
            + "you and makes you leave. He then brings his bike inside and "
            + "locks the doors. You lose.", stor.getDescription(61));
    }


    /**
     * Testing if the correct description is returned for 62.
     */
    public void testGetDescriptionLoc62()
    {
        loc.setLocation(62);
        assertEquals(
            "When you go to knock on the door, it is already slightly "
                + "open and unlocked. Your action pushes it open, and you meet "
                + "a very angry dogYou run from the dog, and it's barking "
                + "alerts Kevin, who takes his bike inside and locks all "
                + "the doors. You lose.",
            stor.getDescription(62));
    }


    /**
     * Testing if the correct description is returned for 71.
     */
    public void testGetDescriptionLoc71()
    {
        loc.setLocation(71);
        assertEquals("You try to push the bike over the fence, but you are "
            + "too weak to do so. No matter how hard you try, you cannot "
            + "do it. As you are trying, your leg falls into the hole. "
            + "Kevin returns and takes his bike, leaving you trapped in "
            + "the hole for the rest of the day. You eventually get out, "
            + "but it is too late. You lose.", stor.getDescription(71));
    }


    /**
     * Testing if the correct description is returned for a loc with no
     * description.
     */
    public void testGetDescriptionLocNone()
    {
        loc.setLocation(20);
        assertEquals(
            "You shouldn't be here. Restart the game.",
            stor.getDescription(20));
    }


    // Begin testing for different names
    /**
     * Testing if the correct name is returned for -2.
     */
    public void testLocationNameNegTwo()
    {
        loc.setLocation(-2);
        assertEquals("Help Menu", stor.locationName(-2));
    }


    /**
     * Testing if the correct name is returned for -1.
     */
    public void testLocationNameNegOne()
    {
        loc.setLocation(-1);
        assertEquals("Start Menu", stor.locationName(-1));
    }


    /**
     * Testing if the correct name is returned for 0.
     */
    public void testLocationNameZero()
    {
        loc.setLocation(0);
        assertEquals("Bathroom", stor.locationName(0));
    }


    /**
     * Testing if the correct name is returned for 1.
     */
    public void testLocationNameOne()
    {
        loc.setLocation(1);
        assertEquals("Your Room", stor.locationName(1));
    }


    /**
     * Testing if the correct name is returned for 2.
     */
    public void testLocationNameTwo()
    {
        loc.setLocation(2);
        assertEquals("Hallway", stor.locationName(2));
    }


    /**
     * Testing if the correct name is returned for 3.
     */
    public void testLocationNameThree()
    {
        loc.setLocation(3);
        assertEquals("Kitchen", stor.locationName(3));
    }


    /**
     * Testing if the correct name is returned for 4.
     */
    public void testLocationName4()
    {
        loc.setLocation(4);
        assertEquals("Garage", stor.locationName(4));
    }


    /**
     * Testing if the correct name is returned for 5.
     */
    public void testLocationName5()
    {
        loc.setLocation(5);
        assertEquals("Cul-de-sac", stor.locationName(5));
    }


    /**
     * Testing if the correct name is returned for 6.
     */
    public void testLocationName6()
    {
        loc.setLocation(6);
        assertEquals("Kevin's Home", stor.locationName(6));
    }


    /**
     * Testing if the correct name is returned for 7.
     */
    public void testLocationName7()
    {
        loc.setLocation(7);
        assertEquals("Kevin's Backyard", stor.locationName(7));
    }


    /**
     * Testing if the correct name is returned for 8.
     */
    public void testLocationName8()
    {
        loc.setLocation(8);
        assertEquals("You win!", stor.locationName(8));
    }


    /**
     * Testing if the correct name is returned for 21.
     */
    public void testLocationName21()
    {
        loc.setLocation(21);
        assertEquals("Fell down the stairs\nGame Over", stor.locationName(21));
    }


    /**
     * Testing if the correct name is returned for 31.
     */
    public void testLocationName31()
    {
        loc.setLocation(31);
        assertEquals(
            "Caught while not properly dressed\nGame Over",
            stor.locationName(31));
    }


    /**
     * Testing if the correct name is returned for 41.
     */
    public void testLocationName41()
    {
        loc.setLocation(41);
        assertEquals(
            "Drove car without knowing how\nGame Over",
            stor.locationName(41));
    }


    /**
     * Testing if the correct name is returned for 51.
     */
    public void testLocationName51()
    {
        loc.setLocation(51);
        assertEquals("Forgotten house key\nGame Over", stor.locationName(51));
    }


    /**
     * Testing if the correct name is returned for 61.
     */
    public void testLocationName61()
    {
        loc.setLocation(61);
        assertEquals("Caught by Kevin\nGame Over", stor.locationName(61));
    }


    /**
     * Testing if the correct name is returned for 62.
     */
    public void testLocationName62()
    {
        loc.setLocation(62);
        assertEquals("Attacked by dog\nGame Over", stor.locationName(62));
    }


    /**
     * Testing if the correct name is returned for any unnamed section.
     */
    public void testLocationNameNone()
    {
        loc.setLocation(20);
        assertEquals("Hole", stor.locationName(20));
    }


    // Begin testing for different response scenarios

    /**
     * Testing the response for the global restart game indicator.
     */
    public void testGetResponseRestart()
    {
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("game");
        verb = "restart";
        assertEquals(stor.getResponse(verb, nounList, null), "Have fun!");
    }


    /**
     * Testing the response for the look me response.
     */
    public void testGetResponseLookMe()
    {
        loc.setLocation(0);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("me");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You are a teenager who is currently enrolled in "
                + "highschool. You are wearing a clean set of clothes. "
                + "You have cleaned your room. "
                + "You have used that rock to cooerce your mother "
                + "outside. Kevin is currently distracted answering the door. "
                + "You have fixed the doorbell. ");
    }


    /**
     * Testing the response for the look me failed response.
     */
    public void testGetResponseLookMeFail()
    {
        loc.setLocation(-1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("myself");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Sorry, you can't do that from here.");
    }


    /**
     * Testing the response for the help response screen.
     */
    public void testGetResponseHelpPlay()
    {
        loc.setLocation(-2);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("game");
        verb = "play";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "What do you want to do?");
    }


    /**
     * Testing the response for the help response screen.
     */
    public void testGetResponseHelpStart()
    {
        loc.setLocation(-2);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("game");
        verb = "start";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "What do you want to do?");
    }


    /**
     * Testing the response for the help response screen.
     */
    public void testGetResponseHelpReturn()
    {
        loc.setLocation(-2);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("menu");
        verb = "return";
        assertEquals(stor.getResponse(verb, nounList, null), "Have fun!");
    }


    /**
     * Testing the response for the help response screen.
     */
    public void testGetResponseHelpInvalid()
    {
        loc.setLocation(-2);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("window");
        verb = "return";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Sorry, you can't do that from here.");
    }


    /**
     * Testing the response for the start response screen.
     */
    public void testGetResponseStartPlay()
    {
        loc.setLocation(-1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("game");
        verb = "play";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "What do you want to do?");
    }


    /**
     * Testing the response for the start response screen.
     */
    public void testGetResponseStartStart()
    {
        loc.setLocation(-1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("game");
        verb = "start";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "What do you want to do?");
    }


    /**
     * Testing the response for the start response screen.
     */
    public void testGetResponseStartInvalid()
    {
        loc.setLocation(-1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("window");
        verb = "return";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Sorry, you can't do that from here.");
    }


    /**
     * Testing the response for the start response screen.
     */
    public void testGetResponseStartHelp()
    {
        loc.setLocation(-1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("me");
        verb = "help";
        assertEquals(stor.getResponse(verb, nounList, null), "Enter text here.");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBathMirLook()
    {
        loc.setLocation(0);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("mirror");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "The mirror is very foggy. You are unable to see your"
                + " reflection.");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBathMirUse()
    {
        loc.setLocation(0);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("mirror");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You attempt to wipe the mirror clean. Nothing" + " changes.");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBathMirBad()
    {
        loc.setLocation(0);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("mirror");
        verb = "destroy";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Why would you do that?");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBathSinkLook()
    {
        loc.setLocation(0);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("sink");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "The sinks are a little messy, but work nonetheless.");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBathSinksUse()
    {
        loc.setLocation(0);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("sinks");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You wash your hands.");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBathSinkBad()
    {
        loc.setLocation(0);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("sink");
        verb = "destroy";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Why would you do that?");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBathRoomLook()
    {
        loc.setLocation(0);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("room");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You cannot see your whole room through the doorway."
                + " You can see a bed, but it is far away.");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBathDoorUse()
    {
        loc.setLocation(0);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("door");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You use the door to get into your room.");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBathBedRoomBad()
    {
        loc.setLocation(0);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("bedroom");
        verb = "destroy";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Why would you do that?");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBathDoorwayBad()
    {
        loc.setLocation(0);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("doorway");
        verb = "destroy";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Why would you do that?");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBathShowerLook()
    {
        loc.setLocation(0);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("shower");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "A perfectly average shower.");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBathShowerUse()
    {
        loc.setLocation(0);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("shower");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You already took a shower today, and you don't "
                + "feel like taking one again.");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBathShowerBad()
    {
        loc.setLocation(0);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("shower");
        verb = "destroy";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Why would you do that?");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBathCabinetLook()
    {
        loc.setLocation(0);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("cabinet");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "There is nothing interesting in the cabinets.");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBathCabinetsUse()
    {
        loc.setLocation(0);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("cabinets");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You open the cabinets, but there is still nothing"
                + " interesting inside them.");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBathCabinetBad()
    {
        loc.setLocation(0);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("cabinet");
        verb = "destroy";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Why would you do that?");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBathTowelLook()
    {
        loc.setLocation(0);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("towel");
        verb = "look";
        assertEquals(stor.getResponse(verb, nounList, null), "A dry towel.");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBathTowelUse1()
    {
        loc.setLocation(0);
        stat.addStatus("isWet");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("towel");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You use the towel to dry yourself.");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBathTowelUse2()
    {
        loc.setLocation(0);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("towel");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You are already dry.");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBathTowelBad()
    {
        loc.setLocation(0);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("towel");
        verb = "destroy";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Why would you do that?");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBathLookAround()
    {
        loc.setLocation(0);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("around");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You look around the area. " + "You don't gain any new insight.");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBathLookArea()
    {
        loc.setLocation(0);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("area");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You look around the area. " + "You don't gain any new insight.");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBathNoResp()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("grass");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You don't understand why you would want do that.");
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedDeskLook1()
    {
        loc.setLocation(1);
        stat.addStatus("deskIsMessy");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("desk");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "A desk covered in trash.");
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedDeskLook2()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("desk");
        verb = "look";
        assertEquals(stor.getResponse(verb, nounList, null), "A clean desk.");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBedDeskUse1()
    {
        loc.setLocation(1);
        stat.addStatus("deskIsMessy");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("desk");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You clean your desk, and also look in the drawers."
                + " You find nothing interesting.");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBedDeskUse2()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("desk");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You already cleaned your desk.");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBedDeskBad()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("desk");
        verb = "destroy";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            ("Why would you do that?"));
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedWeightLook()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("weight");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "A nice set of weights.");
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedWeightsUse()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("weights");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You lift the weights and feel a little stronger."
                + " This may help later.");
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedWeightBad()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("bed");
        verb = "destroy";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Why would you do that?");
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedKeyLook()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("key");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "It looks like a key to your house.");
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedKeyUse1()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("key");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You would take the key, but you have no way of" + " carrying it.");
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedKeyUse2()
    {
        loc.setLocation(1);
        stat.getStatus().add("hasBag");
        stat.getStatus().add("hasHouseKey");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("key");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "A key to your house, currently inside your " + "backpack.");
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedKeyBad()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("key");
        verb = "destroy";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Why would you do that?");
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedBagLook()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("bag");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You examine the backpack closely, and notice a key to"
                + " your house hanging outside the outer pocket.");
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedBackpackUse1()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("backpack");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You take the backpack and put it on your back."
                + " You make note of the house key inside of it.");
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedBackpackUse2()
    {
        loc.setLocation(1);
        stat.getStatus().add("hasBag");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("backpack");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You already are carrying your backpack.");
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedBagBad()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("bag");
        verb = "destroy";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Why would you do that?");
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedBedLook1()
    {
        loc.setLocation(1);
        stat.addStatus("bedIsMessy");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("bed");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "An unmade bed. A backpack lies on top of it.");
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedBedLook2()
    {
        loc.setLocation(1);
        stat.addStatus("bedIsMessy");
        stat.addStatus("hasBag");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("bed");
        verb = "look";
        assertEquals(stor.getResponse(verb, nounList, null), "An unmade bed.");
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedBedLook3()
    {
        loc.setLocation(1);
        stat.addStatus("hasBag");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("bed");
        verb = "look";
        assertEquals(stor.getResponse(verb, nounList, null), "A clean bed.");
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedBedLook4()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("bed");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "A clean bed. A backpack lies on top of it.");
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedBedUse1()
    {
        loc.setLocation(1);
        stat.addStatus("bedIsMessy");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("bed");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You tidy your bed. How nice of you.");
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedBedUse2()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("bed");
        verb = "make";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You already made your bed.");
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedBedSleep1()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("bed");
        verb = "sleep";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You don't feel like resting now.");
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedBedSleep2()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("bed");
        verb = "rest";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You don't feel like resting now.");
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedBedBad()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("bed");
        verb = "destroy";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            ("Why would you do that?"));
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedClothesLook()
    {

        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("clothes");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            ("Clothes to be worn."));
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedClothesUse1()
    {

        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("shirt");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            ("You already took the clothes."));
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedClothesUse2()
    {

        loc.setLocation(1);
        stat.addStatus("isNaked");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("pants");
        verb = "wear";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            ("You put on your clothes. " + "Your shorts do not have pockets."));
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedClothesUse3()
    {

        loc.setLocation(1);
        stat.addStatus("isNaked");
        stat.addStatus("isWet");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("shoes");
        verb = "put";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            ("You put on your clothes, but now they are "
                + "wet just like you. " + "Your shorts do not have pockets."));
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedClothesBad1()
    {

        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("shoe");
        verb = "destroy";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            ("Why would you do that?"));
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedClothesBad2()
    {

        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("shorts");
        verb = "destroy";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            ("Why would you do that?"));
    }


    /**
     * Testing the response for the bedroom response screen.
     */
    public void testGetResponseBedClothesBad3()
    {

        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("dressed");
        verb = "destroy";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            ("Why would you do that?"));
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBedLookAround()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("around");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You look around the area. " + "You don't gain any new insight.");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBedLookArea()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("area");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You look around the area. " + "You don't gain any new insight.");
    }


    /**
     * Testing the response for the bathroom response screen.
     */
    public void testGetResponseBedNoResp()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("grass");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You don't understand why you would want do that.");
    }


    /**
     * Testing if the response for the bathroom response screen.
     */
    public void testGetResponseBedGoResp1()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("bathroom");
        verb = "go";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk into the bathroom from your room.");
    }


    /**
     * Testing if the response for the bathroom response screen.
     */
    public void testGetResponseBedGoResp2()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("kitchen");
        verb = "walk";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk into the hallway from your room.");
    }


    /**
     * Testing if the response for the bathroom response screen.
     */
    public void testGetResponseBedGoResp3()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("stairs");
        verb = "enter";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk into the hallway from your room.");
    }


    /**
     * Testing if the response for the bathroom response screen.
     */
    public void testGetResponseBedGoResp4()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("hallway");
        verb = "enter";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk into the hallway from your room.");
    }


    /**
     * Testing if the response for the bathroom response screen.
     */
    public void testGetResponseBedGoResp5()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("hall");
        verb = "enter";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk into the hallway from your room.");
    }


    /**
     * Testing if the response for the bathroom response screen.
     */
    public void testGetResponseBedGoResp6()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("stairwell");
        verb = "enter";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk into the hallway from your room.");
    }


    /**
     * Testing if the response for the bathroom response screen.
     */
    public void testGetResponseBedGoResp7()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("downstairs");
        verb = "enter";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk into the hallway from your room.");
    }


    /**
     * Testing if the response for the bathroom response screen.
     */
    public void testGetResponseBedDoorResp1()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("room");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You should clean specific objects in your room.");
    }


    /**
     * Testing if the response for the bathroom response screen.
     */
    public void testGetResponseBedDoorResp2()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("door");
        nounList.add("bathroom");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk into the bathroom from your room.");
    }


    /**
     * Testing if the response for the bathroom response screen.
     */
    public void testGetResponseBedDoorResp3()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("bathroom");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Which door should you use?");
    }


    /**
     * Testing if the response for the bathroom response screen.
     */
    public void testGetResponseBedDoorResp4()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("kitchen");
        nounList.add("door");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk into the hallway from your room.");
    }


    /**
     * Testing if the response for the bathroom response screen.
     */
    public void testGetResponseBedDoorResp6()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("stairs");
        nounList.add("door");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk into the hallway from your room.");
    }


    /**
     * Testing if the response for the bathroom response screen.
     */
    public void testGetResponseBedDoorResp7()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("hallway");
        nounList.add("door");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk into the hallway from your room.");
    }


    /**
     * Testing if the response for the bathroom response screen.
     */
    public void testGetResponseBedDoorResp8()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("hall");
        nounList.add("door");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk into the hallway from your room.");
    }


    /**
     * Testing if the response for the bathroom response screen.
     */
    public void testGetResponseBedDoorResp9()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("stairwell");
        nounList.add("door");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk into the hallway from your room.");
    }


    /**
     * Testing if the response for the bathroom response screen.
     */
    public void testGetResponseBedDoorResp10()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("downstairs");
        nounList.add("door");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk into the hallway from your room.");
    }


    /**
     * Testing if the response for the bathroom response screen.
     */
    public void testGetResponseBedDoorResp11()
    {
        loc.setLocation(1);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("door");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Which door should you use?");
    }


    /**
     * Testing the response for the hallway response screen.
     */
    public void testGetResponseHallLookAround()
    {
        loc.setLocation(2);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("around");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You look around the area. " + "You don't gain any new insight.");
    }


    /**
     * Testing the response for the hallway response screen.
     */
    public void testGetResponseHallLookArea()
    {
        loc.setLocation(2);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("area");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You look around the area. " + "You don't gain any new insight.");
    }


    /**
     * Testing the response for the hallway response screen.
     */
    public void testGetResponseHallLook()
    {
        loc.setLocation(2);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("grass");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "There isn't much here to look at.");
    }


    /**
     * Testing the response for the hallway response screen.
     */
    public void testGetResponseHallUse1()
    {
        loc.setLocation(2);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("bedroom");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk back into your bedroom.");
    }


    /**
     * Testing the response for the hallway response screen.
     */
    public void testGetResponseHallUse2()
    {
        loc.setLocation(2);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("room");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk back into your bedroom.");
    }


    /**
     * Testing the response for the hallway response screen.
     */
    public void testGetResponseHallUse3()
    {
        loc.setLocation(2);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("doorway");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk back into your bedroom.");
    }


    /**
     * Testing the response for the hallway response screen.
     */
    public void testGetResponseHallUse4()
    {
        loc.setLocation(2);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("door");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk back into your bedroom.");
    }


    /**
     * Testing the response for the hallway response screen.
     */
    public void testGetResponseHallUse5()
    {
        loc.setLocation(2);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("stairs");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk down the stairs and into the kitchen.");
    }


    /**
     * Testing the response for the hallway response screen.
     */
    public void testGetResponseHallUse6()
    {
        loc.setLocation(2);
        stat.addStatus("isWet");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("downstairs");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You fell down the stairs and into the kitchen.");
    }


    /**
     * Testing the response for the hallway response screen.
     */
    public void testGetResponseHallGo1()
    {
        loc.setLocation(2);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("bedroom");
        verb = "go";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk back into your bedroom.");
    }


    /**
     * Testing the response for the hallway response screen.
     */
    public void testGetResponseHallGo2()
    {
        loc.setLocation(2);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("room");
        verb = "walk";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk back into your bedroom.");
    }


    /**
     * Testing the response for the hallway response screen.
     */
    public void testGetResponseHallGo3()
    {
        loc.setLocation(2);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("kitchen");
        verb = "walk";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk down the stairs and into the kitchen.");
    }


    /**
     * Testing the response for the hallway response screen.
     */
    public void testGetResponseHallGo4()
    {
        loc.setLocation(2);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("stairs");
        verb = "walk";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk down the stairs and into the kitchen.");
    }


    /**
     * Testing the response for the hallway response screen.
     */
    public void testGetResponseHallGo5()
    {
        loc.setLocation(2);
        stat.addStatus("isWet");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("downstairs");
        verb = "walk";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You fell down the stairs and into the kitchen.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseKitchenWindowLook()
    {
        loc.setLocation(3);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("window");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You look outside the window to see your sister playing"
                + "baseball.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseKitchenWindowUse()
    {
        loc.setLocation(3);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("window");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Your mother already opened the window slightly, and "
                + "it doesn't seem like she wants it closed.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseKitchenWindowBad()
    {
        loc.setLocation(3);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("window");
        verb = "destroy";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "If you did that from inside you would surely" + " get caught.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseKitchenMomLook1()
    {
        loc.setLocation(3);
        stat.addStatus("momKitchen");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("mom");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Your mother, cooking lunch. She has a set of car keys"
                + " slightly exposed in her back pocket.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseKitchenMomLook2()
    {
        loc.setLocation(3);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("mother");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Your mother isn't here.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseKitchenMomUse1()
    {
        loc.setLocation(3);
        stat.addStatus("wetClothes");
        stat.addStatus("momKitchen");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("mom");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Your mother catches you improperly dressed");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseKitchenMomUse2()
    {
        loc.setLocation(3);
        stat.addStatus("isNaked");
        stat.addStatus("momKitchen");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("mom");
        verb = "hug";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Your mother catches you improperly dressed");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseKitchenMomUse3()
    {
        loc.setLocation(3);
        stat.addStatus("momKitchen");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("mom");
        verb = "talk";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Your mother tells you to clean your room before"
                + " going outside.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseKitchenMomBad()
    {
        loc.setLocation(3);
        stat.addStatus("momKitchen");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("mom");
        verb = "destroy";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You would do that to your own mother?");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseKitchenStoveLook1()
    {
        loc.setLocation(3);
        stat.addStatus("momKitchen");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("stove");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "A stove, still hot from use.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseKitchenStoveUse1()
    {
        loc.setLocation(3);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("wire");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You can use the stove, but you have nothing to use" + " on it.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseKitchenStoveUse2()
    {
        loc.setLocation(3);
        stat.addStatus("momKitchen");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("stove");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You are unable to use the stove while your mother "
                + "is using it. Find a way to distract her.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseKitchenStoveUse3()
    {
        loc.setLocation(3);
        stat.addStatus("hasWire");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("wire");
        verb = "heat";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You heat the wire on the stove, carefully storing" + " it.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseKitchenStoveUse4()
    {
        loc.setLocation(3);
        stat.addStatus("hasWire");
        stat.addStatus("momKitchen");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("stove");
        verb = "cook";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You are unable to use the stove while your mother "
                + "is using it. Find a way to distract her.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseKitchenStoveBad()
    {
        loc.setLocation(3);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("stove");
        verb = "destroy";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Why would you do that?");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseKitchenFood()
    {
        loc.setLocation(3);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("food");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "The food isn't ready yet. Your mother is making it.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseGarageGo1()
    {
        loc.setLocation(3);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("garage");
        verb = "go";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk into the garage.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseGarageGo2()
    {
        loc.setLocation(3);
        stat.addStatus("bedIsMessy");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("garage");
        verb = "walk";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Your mother does not allow you to go into the garage.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseGarageGo3()
    {
        loc.setLocation(3);
        stat.addStatus("deskIsMessy");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("garage");
        verb = "enter";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Your mother does not allow you to go into the garage.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseGarageGo4()
    {
        loc.setLocation(3);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("stairs");
        verb = "go";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk up the stairs and into the hallway.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseGarageGo5()
    {
        loc.setLocation(3);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("hallway");
        verb = "go";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk up the stairs and into the hallway.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseGarageGo6()
    {
        loc.setLocation(3);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("hall");
        verb = "go";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk up the stairs and into the hallway.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseGarageGo7()
    {
        loc.setLocation(3);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("upstairs");
        verb = "go";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk up the stairs and into the hallway.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseGarageGo8()
    {
        loc.setLocation(3);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("garage");
        nounList.add("door");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You open the door and walk into the garage.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseGarageGo9()
    {
        loc.setLocation(3);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("door");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "What door do you want to use?");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseGarageGo10()
    {
        loc.setLocation(3);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("door");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "What door do you want to use?");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseKitchenNone()
    {
        loc.setLocation(3);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("grass");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You can't do that here.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseKitchenKeyLook1()
    {
        loc.setLocation(3);
        stat.addStatus("momKitchen");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("key");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "A set of keys to the car that is located in the "
                + "garage is in your mother's back pocket.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseKitchenKeyLook2()
    {
        loc.setLocation(3);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("keys");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "The keys aren't here.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseKitchenKeyUse1()
    {
        loc.setLocation(3);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("car");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "The keys aren't here.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseKitchenKeyUse2()
    {
        loc.setLocation(3);
        stat.addStatus("momKitchen");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("pocket");
        verb = "steal";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You would take the keys from your mom, but you"
                + " dont have a place to put them.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseKitchenKeyUse3()
    {
        loc.setLocation(3);
        stat.addStatus("hasCarKey");
        stat.addStatus("momKitchen");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("keys");
        verb = "pickpocket";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You already took the key.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseKitchenKeyUse4()
    {
        loc.setLocation(3);
        stat.addStatus("hasBag");
        stat.addStatus("momKitchen");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("keys");
        verb = "pickpocket";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You stealthily steal the car keys from your mom.");
    }


    /**
     * Testing the response for the kitchen response screen.
     */
    public void testGetResponseKitchenKeyBad()
    {
        loc.setLocation(3);
        stat.addStatus("momKitchen");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("key");
        verb = "destroy";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Why would you do that?");
    }


    /**
     * Testing the response for the garage response screen.
     */
    public void testGetResponseGarageCarLook()
    {
        loc.setLocation(4);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("car");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "Looking at the car, you are unable to discern the"
                + " model. You wish you knew more about cars. You don't "
                + "know how to drive.");
    }


    /**
     * Testing the response for the garage response screen.
     */
    public void testGetResponseGarageCarUse1()
    {
        loc.setLocation(4);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("car");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You don't have the keys to drive the car.");
    }


    /**
     * Testing the response for the garage response screen.
     */
    public void testGetResponseGarageCarUse2()
    {
        loc.setLocation(4);
        stat.addStatus("hasCarKey");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("car");
        verb = "drive";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You don't really know how to drive, but you "
                + "decided to do it anyway.");
    }


    /**
     * Testing the response for the garage response screen.
     */
    public void testGetResponseGarageCarBad()
    {
        loc.setLocation(4);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("car");
        verb = "destroy";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You don't want to do that.");
    }


    /**
     * Testing the response for the garage response screen.
     */
    public void testGetResponseGarageLookScrewdriver()
    {
        loc.setLocation(4);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("screwdriver");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "It's a screwdriver.");
    }


    /**
     * Testing the response for the garage response screen.
     */
    public void testGetResponseGarageUseScewdriver1()
    {
        loc.setLocation(4);
        stat.addStatus("hasScrewdriver");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("screwdriver");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You are already carrying that.");
    }


    /**
     * Testing the response for the garage response screen.
     */
    public void testGetResponseGarageUseScewdriver2()
    {
        loc.setLocation(4);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("screwdriver");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You would take the screwdriver, but you have "
                + "nowhere to put it.");
    }


    /**
     * Testing the response for the garage response screen.
     */
    public void testGetResponseGarageUseScewdriver3()
    {
        loc.setLocation(4);
        stat.addStatus("hasBag");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("screwdriver");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You take the screwdriver.");
    }


    /**
     * Testing the response for the garage response screen.
     */
    public void testGetResponseGarageScrewdriverBad()
    {
        loc.setLocation(4);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("screwdriver");
        verb = "destroy";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You don't want to do that.");
    }


    /**
     * Testing the response for the garage response screen.
     */
    public void testGetResponseGarageToolLook()
    {
        loc.setLocation(4);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("tools");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "There appears to be a screwdriver and wire on the " + "toolbench.");
    }


    /**
     * Testing the response for the garage response screen.
     */
    public void testGetResponseGarageToolUse()
    {
        loc.setLocation(4);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("toolbench");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You play around with the tools.");
    }


    /**
     * Testing the response for the garage response screen.
     */
    public void testGetResponseGarageToolBad()
    {
        loc.setLocation(4);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("tool");
        verb = "destroy";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You don't want to do that.");
    }


    /**
     * Testing the response for the garage response screen.
     */
    public void testGetResponseGarageLookWire()
    {
        loc.setLocation(4);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("wire");
        verb = "look";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "It's some electrical wire.");
    }


    /**
     * Testing the response for the garage response screen.
     */
    public void testGetResponseGarageUseWire1()
    {
        loc.setLocation(4);
        stat.addStatus("hasWire");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("wire");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You already have that.");
    }


    /**
     * Testing the response for the garage response screen.
     */
    public void testGetResponseGarageUseWire2()
    {
        loc.setLocation(4);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("wire");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You would take the wire, but you have " + "nowhere to put it.");
    }


    /**
     * Testing the response for the garage response screen.
     */
    public void testGetResponseGarageUseWire3()
    {
        loc.setLocation(4);
        stat.addStatus("hasBag");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("wire");
        verb = "use";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You take the wire.");
    }


    /**
     * Testing the response for the garage response screen.
     */
    public void testGetResponseGarageWireBad()
    {
        loc.setLocation(4);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("wire");
        verb = "destroy";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You don't want to do that.");
    }


    /**
     * Testing the response for the garage response screen.
     */
    public void testGetResponseGarageGo12()
    {
        loc.setLocation(4);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("kitchen");
        verb = "go";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk into the kitchen.");
    }


    /**
     * Testing the response for the garage response screen.
     */
    public void testGetResponseGarageGo13()
    {
        loc.setLocation(4);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("inside");
        verb = "walk";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk into the kitchen.");
    }


    /**
     * Testing the response for the garage response screen.
     */
    public void testGetResponseGarageGo14()
    {
        loc.setLocation(4);
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("outside");
        verb = "enter";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You forgot the house key.");
    }


    /**
     * Testing the response for the garage response screen.
     */
    public void testGetResponseGarageGo15()
    {
        loc.setLocation(4);
        stat.addStatus("hasHouseKey");
        ArrayList<String> nounList = new ArrayList<String>();
        String verb = new String();
        nounList.add("neighborhood");
        verb = "walk";
        assertEquals(
            stor.getResponse(verb, nounList, null),
            "You walk outside.");
    }

    //With writing three thousand lines of tests, I believe it shows that
    //I have tested the response generator extensively. For almost every
    //scenario. This coupled with the StringParser parseString tests shows
    //sufficient testing for the Story class.

    //I have also played the game a lot and have many others play it and
    //had no errors.

    /**
     * Testing the self description for no modifiers.
     */
    public void testGetSelfDesc1()
    {
        assertEquals("You are a teenager who is currently enrolled in "
            + "highschool. You are wearing a clean set of clothes. "
            + "You have cleaned your room. "
            + "You have used that rock to cooerce your mother "
            + "outside. Kevin is currently distracted answering the door. "
            + "You have fixed the doorbell. ", stor.getSelfDesc());
    }


    /**
     * Testing the self description for most modifiers.
     */
    public void testGetSelfDesc2()
    {
        stat.addStatus("isNaked");
        stat.addStatus("wetClothes");
        stat.addStatus("isWet");
        stat.addStatus("deskIsMessy");
        stat.addStatus("hasBag");
        stat.addStatus("hasHouseKey");
        stat.addStatus("hasCarKey");
        stat.addStatus("hasScrewdriver");
        stat.addStatus("hasWire");
        stat.addStatus("hasHotWire");
        stat.addStatus("tookRock");
        stat.addStatus("momKitchen");
        stat.addStatus("kevinPlaying");
        stat.addStatus("doorbellBroken");
        stat.addStatus("isWeak");
        assertEquals("You are a teenager who is currently enrolled in "
            + "highschool. You are currently not wearing any clothes. You did "
            + "remember to put on clothes, but you did not "
            + "dry yourself off after your shower. Your clothes are now "
            + "wet, but you are less wet than before. You are soaking wet "
            + "after your shower. You are currently wearing your backpack. "
            + "You have a key to your house. "
            + "You have a key to the car in the garage. "
            + "You are in possession of a screwdriver. "
            + "You are holding some wire. " + "You have heated the wire. "
            + "You have taken a rock from outside. "
            + "You are feeling particularly weak today. ", stor.getSelfDesc());
    }


    /**
     * Testing self description for the last modifier.
     */
    public void testGetSelfDesc3()
    {
        stat.addStatus("bedIsMessy");
        assertEquals("You are a teenager who is currently enrolled in "
            + "highschool. You are wearing a clean set of clothes. "
            + "You have used that rock to cooerce your mother "
            + "outside. Kevin is currently distracted answering the door. "
            + "You have fixed the doorbell. ", stor.getSelfDesc());
    }
}
