package com.example.cul_de_sac;

import java.util.Arrays;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Anthony DeFilippis
 * @version 2015.04.26
 */
public class Story
{
    // ~Fields ----------------------------------------------------------
    private ArrayList<String> lookList = new ArrayList<String>();
    private ArrayList<String> useList  = new ArrayList<String>();
    private ArrayList<String> badList  = new ArrayList<String>();
    private Location          loc;
    private Status            stat;


    // ~Constructor ----------------------------------------------------------
    /**
     * Create a new Story object. Also initializes strings of common words to
     * make searching easier.
     *
     * @param status
     *            The status for the current character in the story
     */
    public Story(Status status)
    {
        String[] lookWords =
            new String[] { "look", "glance", "glimpse", "peek", "review",
                "stare", "view", "observe", "behold", "contemplate", "gander",
                "survey", "watch", "examine", "inspect" };
        String[] useWords =
            new String[] { "use", "interact", "service", "touch", "grab",
                "pick", "clean", "wipe", "open", "take", "combine", "open",
                "get", "cook", "heat", "warm", };
        String[] badWords =
            new String[] { "hit", "steal", "pickpocket", "smash", "destroy",
                "break" };
        lookList.addAll(Arrays.asList(lookWords));
        useList.addAll(Arrays.asList(useWords));
        badList.addAll(Arrays.asList(badWords));
        stat = status;
        loc = new Location(this);
    }


    // ~Methods ----------------------------------------------------------
    /**
     * This method returns the description of the room the player is currently
     * in to be displayed.
     *
     * @param locInt
     *            The current location of the player, an integer
     * @return A string with descriptive text
     */
    public String getDescription(int locInt)
    {
        if (locInt == -1)
        {
            return ("Hello and welcome to Cul-de-sac.\nThis is a text-based "
                + "interactive fiction game. Kevin, a neighborhood bully, has "
                + "taken your bike. He is moving away tomorrow. Your goal is to"
                + " retrieve your bike by the end of the day.\n"
                + "If it is your first time"
                + " playing, type \"help me\" below.\nOtherwise, you can type "
                + "\"play game\" to"
                + " begin playing the game.\nRemember to hit enter each time."
                + "\n\n" + "Made by Anthony DeFilippis for CS2114.");
        }
        if (locInt == -2)
        {
            return ("Welcome to the help menu.\nAbove, you can see your "
                + "current location in the world. Text describing that location"
                + " will be here. To interact with the world, simply type "
                + "whatever you want. For instance, if there was a bucket that "
                + "you want to look at, you would type \"look bucket\" without"
                + " the quotations.\nYou will likely lose multiple times, but "
                + "remember, losing is fun!\nFrom here, you can return to the "
                + "start menu, or begin playing the game.\nYou can type "
                + "\"restart game\""
                + " at any time to restart the game from the beginning.");
        }
        if (locInt == 0)
        {
            return bathroomDesc();
        }
        if (locInt == 1)
        {
            return bedroomDesc();

        }
        if (locInt == 2)
        {
            return ("You walk into the hallway outside your "
                + "room that connects to the kitchen downstairs.\n"
                + "You can see stairs that lead to the kitchen and a door that"
                + " leads to your room.");
        }
        if (locInt == 3)
        {
            return kitchenDesc();

        }
        if (locInt == 4)
        {
            return ("You walk into the garage. There is a car "
                + "and a toolbench with lots of tools on it.\n"
                + "You can see a door that leads outside, and a door that leads"
                + " back into the kitchen.");
        }
        if (locInt == 5)
        {
            return getOutsideDesc();

        }
        if (locInt == 6)
        {
            return getKHouseDesc();
        }
        if (locInt == 7)
        {
            return ("There isn't much here except your bike and a large hole. "
                + "Kevin went inside to answer the door, so you are free "
                + "to do whatever you want.\nA fence bordering the "
                + "backyard is the only way to get out.");
        }
        if (locInt == 8)
        {
            return ("Congratulations! You successfully retrieved your bike! "
                + "You congratulate yourself for a job well done, "
                + "and the next day Kevin moves away. If "
                + "you would like to replay the game, just type \"play game\"."
                + " If not, I hope you had fun playing. If you have any "
                + "suggestions or problems, email me at dtony@vt.edu.");
        }
        if (locInt == 21)
        {
            return ("Being so wet, you take a nasty spill as you walk down"
                + " the stairs. Your mother comes rushing to you and puts you"
                + " back into your bed. You lose.");
        }
        if (locInt == 31)
        {
            return ("Your mother catches you improperly dressed. She makes "
                + "you get "
                + "dressed, and then has you spend the rest of the day doing "
                + "chores around the house and playing with your sister. "
                + "You lose.");
        }
        if (locInt == 41)
        {
            return ("Not knowing how to drive, you barely manage to get the car"
                + " out of the driveway without hitting anything. You"
                + " immediately hit your neighbor's car after you begin "
                + "driving."
                + " You are promptly grounded. You lose.");
        }
        if (locInt == 51)
        {
            return ("You walk outside, and hear the door lock behind you."
                + " You are stuck, and decide to play baseball with your"
                + " sister until your mother calls you in for lunch. You spend "
                + "the rest of the weekend playing games. You lose.");
        }
        if (locInt == 61)
        {
            return ("As you climb over the fence, you realize that Kevin is "
                + "currently playing in the backyard. He immediately catches "
                + "you and makes you leave. He then brings his bike inside and "
                + "locks the doors. You lose.");
        }
        if (locInt == 62)
        {
            return ("When you go to knock on the door, it is already slightly "
                + "open and unlocked. Your action pushes it open, and you meet "
                + "a very angry dog. You run from the dog, and its barking "
                + "alerts Kevin, who takes his bike inside and locks all "
                + "the doors. You lose.");
        }
        if (locInt == 71)
        {
            return ("You try to push the bike over the fence, but you are "
                + "too weak to do so. No matter how hard you try, you cannot "
                + "do it. As you are trying, your leg falls into the hole. "
                + "Kevin returns and takes his bike, leaving you trapped in "
                + "the hole for the rest of the day. You eventually get out, "
                + "but it is too late. You lose.");
        }
        else
        {
            return ("You shouldn't be here. Restart the game.");
        }
    }


    /**
     * A method to get the description of the area based on statuses. Just for
     * outside.
     *
     * @return A string description of the area.
     */
    private String getKHouseDesc()
    {
        if (stat.getStatus().contains("doorbellBroken"))
        {
            return ("You approach Kevin's home. You can see a doorbell, "
                + "although it looks broken. There is a door that leads into "
                + "the house. There is a window so you can see into the "
                + "house.\nThere is a fence that leads into Kevin's backyard,"
                + " and the street leads back to the Cul-de-sac.");
        }
        else
        {
            return ("You approach Kevin's home. There is a door that leads "
                + "into the house. There is a window so you can see into the "
                + "house.\nThere is a fence that leads into Kevin's backyard,"
                + " and the street leads back to the Cul-de-sac.");
        }
    }


    /**
     * A method that returns a string of the current location.
     *
     * @param locInt
     *            The current location of the player, an integer
     * @return A string containing the name of that location.
     */
    public String locationName(int locInt)
    {
        if (loc.getLocation() == -1)
        {
            return ("Start Menu");
        }
        if (loc.getLocation() == -2)
        {
            return ("Help Menu");
        }
        if (loc.getLocation() == 0)
        {
            return ("Bathroom");
        }
        if (loc.getLocation() == 1)
        {
            return ("Your Room");
        }
        if (loc.getLocation() == 2)
        {
            return ("Hallway");
        }
        if (loc.getLocation() == 3)
        {
            return ("Kitchen");
        }
        if (loc.getLocation() == 4)
        {
            return ("Garage");
        }
        if (loc.getLocation() == 5)
        {
            return ("Cul-de-sac");
        }
        if (loc.getLocation() == 6)
        {
            return ("Kevin's Home");
        }
        if (loc.getLocation() == 7)
        {
            return ("Kevin's Backyard");
        }
        if (loc.getLocation() == 8)
        {
            return ("You win!");
        }
        if (loc.getLocation() == 21)
        {
            return ("Fell down the stairs\nGame Over");
        }
        if (loc.getLocation() == 31)
        {
            return ("Caught while not properly dressed\nGame Over");
        }
        if (loc.getLocation() == 41)
        {
            return ("Drove car without knowing how\nGame Over");
        }
        if (loc.getLocation() == 51)
        {
            return ("Forgotten house key\nGame Over");
        }
        if (loc.getLocation() == 61)
        {
            return ("Caught by Kevin\nGame Over");
        }
        if (loc.getLocation() == 62)
        {
            return ("Attacked by dog\nGame Over");
        }
        else
        {
            return ("Hole");
        }
    }


    /**
     * A method to get the response text to be displayed above the text entry
     * field. Also changes the location of the player and adds or removes
     * statuses appropriately.
     *
     * @param verb
     *            The verb contained in the sentence
     * @param nounResults
     *            Nouns contained in the sentence
     * @param prepResults
     *            Prepositions contained in the sentence
     * @return A string containing the response text for an action
     */
    public String getResponse(
        String verb,
        ArrayList<String> nounResults,
        ArrayList<String> prepResults)
    {
        // Global responses
        if (verb.equals("restart"))
        {
            if (nounResults.contains("game"))
            {
                loc.setLocation(-1);
                stat.removeAllStatus();
                return ("Have fun!");
            }
        }
        if (lookList.contains(verb) && loc.getLocation() >= 0)
        {
            if (nounResults.contains("me") || nounResults.contains("myself"))
            {
                return getSelfDesc();
            }
        }
        // Help screen responses
        if (loc.getLocation() == -2)
        {
            return helpResponse(verb, nounResults, prepResults);
        }
        // Start screen response
        if (loc.getLocation() == -1)
        {
            return startResponse(verb, nounResults, prepResults);
        }
        // For actions when in the bathroom.
        if (loc.getLocation() == 0)
        {
            return bathroomResponse(verb, nounResults, prepResults);
        }
        // For actions when in the bedroom.
        if (loc.getLocation() == 1)
        {
            return bedroomResponse(verb, nounResults, prepResults);
        }
        if (loc.getLocation() == 2)
        {
            return hallwayResponse(verb, nounResults, prepResults);
        }
        if (loc.getLocation() == 3)
        {
            return kitchenResponse(verb, nounResults, prepResults);
        }
        if (loc.getLocation() == 4)
        {
            return garageResponse(verb, nounResults, prepResults);
        }
        if (loc.getLocation() == 5)
        {
            return outsideResponse(verb, nounResults, prepResults);
        }
        if (loc.getLocation() == 6)
        {
            return kHouseResponse(verb, nounResults, prepResults);
        }
        if (loc.getLocation() == 7)
        {
            return kBackyardResponse(verb, nounResults, prepResults);
        }
        if (loc.getLocation() == 8)
        {
            return helpResponse(verb, nounResults, prepResults);
        }
        if (loc.getLocation() == 21)
        {
            return helpResponse(verb, nounResults, prepResults);
        }
        if (loc.getLocation() == 31)
        {
            return helpResponse(verb, nounResults, prepResults);
        }
        if (loc.getLocation() == 41)
        {
            return helpResponse(verb, nounResults, prepResults);
        }
        if (loc.getLocation() == 51)
        {
            return helpResponse(verb, nounResults, prepResults);
        }
        if (loc.getLocation() == 61)
        {
            return helpResponse(verb, nounResults, prepResults);
        }
        if (loc.getLocation() == 62)
        {
            return helpResponse(verb, nounResults, prepResults);
        }
        if (loc.getLocation() == 71)
        {
            return helpResponse(verb, nounResults, prepResults);
        }
        return "Sorry, you can't do that from here.";
    }


    /**
     * A method to get the response text to be displayed above the text entry
     * field. Also changes the location of the player and adds or removes
     * statuses appropriately. Just for in Kevin's backyard.
     *
     * @param verb
     *            The verb contained in the sentence
     * @param nounResults
     *            Nouns contained in the sentence
     * @param prepResults
     *            Prepositions contained in the sentence
     * @return A string containing the response text for an action
     */
    private String kBackyardResponse(
        String verb,
        ArrayList<String> nounResults,
        ArrayList<String> prepResults)
    {
        if (nounResults.contains("bike"))
        {
            if (nounResults.contains("fence"))
            {
                if (useList.contains(verb) || verb.equals("push")
                    || verb.equals("throw"))
                {
                    if (stat.getStatus().contains("isWeak"))
                    {
                        loc.setLocation(71);
                        return ("You fail to get the bike over the fence.");
                    }
                    else
                    {
                        loc.setLocation(8);
                        return ("You sucessfully get the bike over the fence.");
                    }
                }
            }
            if (useList.contains(verb))
            {
                return ("You can ride your bike after you take it back.");
            }
            if (lookList.contains(verb))
            {
                return ("A large bike which would be hard to push over the "
                    + "fence. It would require you to be strong.");
            }
            if (badList.contains(verb))
            {
                return ("It's your bike. You could take it if you could "
                    + "get it over the fence.");
            }
        }
        if (nounResults.contains("hole"))
        {
            return ("You don't want anything to do with that hole.");
        }
        // Going other places
        if (verb.equals("go") || verb.equals("walk") || verb.equals("jump")
            || verb.equals("climb") || verb.equals("enter"))
        {
            if (nounResults.contains("fence"))
            {
                loc.setLocation(6);
                return ("You climb the fence back to the front of Kevin's "
                    + "house.");
            }
        }
        if (nounResults.contains("fence"))
        {
            if (useList.contains(verb))
            {
                return ("You cannot unlock the fence.");
            }
            if (lookList.contains(verb))
            {
                return ("You see the front of Kevin's house from over the "
                    + "fence.");
            }
            if (badList.contains(verb))
            {
                return ("You have no interest in harming the innocent fence.");
            }
        }
        return ("You can't do that from here.");
    }


    /**
     * A method to get the response text to be displayed above the text entry
     * field. Also changes the location of the player and adds or removes
     * statuses appropriately. Just for outside Kevin's house.
     *
     * @param verb
     *            The verb contained in the sentence
     * @param nounResults
     *            Nouns contained in the sentence
     * @param prepResults
     *            Prepositions contained in the sentence
     * @return A string containing the response text for an action
     */
    private String kHouseResponse(
        String verb,
        ArrayList<String> nounResults,
        ArrayList<String> prepResults)
    {
        // Going other places
        if (verb.equals("go") || verb.equals("walk") || verb.equals("jump")
            || verb.equals("climb") || verb.equals("enter"))
        {
            if (nounResults.contains("cul-de-sac")
                || nounResults.contains("street")
                && !nounResults.contains("kevin's"))
            {
                loc.setLocation(5);
                return ("You walk back to the  Cul-de-sac.");
            }
            if (nounResults.contains("fence")
                || nounResults.contains("backyard"))
            {
                if (stat.getStatus().contains("kevinPlaying"))
                {
                    loc.setLocation(61);
                    return ("Kevin immediately catches you jumping the fence.");
                }
                else
                {
                    loc.setLocation(7);
                    return ("You jump the fence into Kevin's backyard.");
                }
            }
            if (nounResults.contains("house") || nounResults.contains("home"))
            {
                return ("It's rude not to knock first.");
            }
        }
        if (nounResults.contains("fence") || nounResults.contains("backyard"))
        {
            if (useList.contains(verb))
            {
                return ("You cannot unlock the fence.");
            }
            if (lookList.contains(verb))
            {
                if (stat.getStatus().contains("kevinPlaying"))
                {
                    return ("You see Kevin riding on your bike in the backyard."
                        + " He would surely catch you if you entered now.");
                }
                else
                {
                    return ("Your bike is in his backyard, on the ground.");
                }
            }
            if (badList.contains(verb))
            {
                return ("You have no interest in harming the innocent fence.");
            }
        }
        if (nounResults.contains("window") || nounResults.contains("house")
            || nounResults.contains("home"))
        {
            if (useList.contains(verb))
            {
                return ("You can't do anything to that.");
            }
            if (lookList.contains(verb))
            {
                return ("Inside the house you see a dog patrolling around."
                    + " The dog looks very large.");
            }
            if (badList.contains(verb))
            {
                return ("Vandalism is wrong.");
            }
        }
        if (nounResults.contains("doorbell"))
        {
            if (verb.equals("fix"))
            {
                if (stat.getStatus().contains("hasScrewdriver")
                    && stat.getStatus().contains("hasHotWire"))
                {
                    stat.getStatus().remove("doorbellBroken");
                    return ("You fix the broken doorbell.");
                }
                else if (stat.getStatus().contains("hasWire"))
                {
                    return ("It looks like you need to heat the wire first.");
                }
                else
                {
                    return ("You don't have the right items to fix the "
                        + "doorbell.");
                }
            }
            if (useList.contains(verb) || verb.equals("ring"))
            {
                if (stat.getStatus().contains("doorbellBroken"))
                {
                    return ("It seems broken.");
                }
                else
                {
                    stat.removeStatus("kevinPlaying");
                    return ("You ring the fixed doorbell, and hear Kevin leave"
                        + " his bike and begin to come inside.");
                }
            }
            if (lookList.contains(verb))
            {
                if (!stat.getStatus().contains("doorbellBroken"))
                {
                    return ("A fixed doorbell.");
                }
                else
                {
                    return ("A broken doorbell. With some wire and a screwdriver"
                        + " you might be able to fix it.");
                }
            }
            if (badList.contains(verb))
            {
                return ("There's no need to break it again.");
            }
        }
        if (nounResults.contains("door"))
        {
            if (useList.contains(verb) || verb.equals("knock"))
            {
                loc.setLocation(62);
                return ("You go to knock on the door.");
            }
            if (lookList.contains(verb))
            {
                return ("It seems slightly open. Even the slightest knock "
                    + "will make it fully open.");
            }
            if (badList.contains(verb))
            {
                return ("It's your bike you want, not a door.");
            }
        }
        // General looking around.
        if (lookList.contains(verb)
            && (nounResults.contains("around") || nounResults.contains("area")))
        {
            return ("You look around the area. "
                + "You don't gain any new insight.");

        }
        return ("You can't do that here.");
    }


    /**
     * A method to get the description of the area based on statuses. Just for
     * outside.
     *
     * @return A string description of the area.
     */
    private String getOutsideDesc()
    {
        StringBuilder str = new StringBuilder();
        str.append("You walk outside. It is a bright, sunny day. It looks like "
            + "it is around noon. ");
        if (stat.getStatus().contains("momKitchen"))
        {
            str.append("Your sister is playing baseball in "
                + "the front yard. Your mother is watching her from the "
                + "window. ");
        }
        if (!stat.getStatus().contains("momKitchen"))
        {
            str.append("Your mother is talking to your sister about "
                + "personal responsibility. ");
        }
        str.append("Kevin's house sits on on the end of " + "the Cul-de-sac.");
        if (!stat.getStatus().contains("tookRock"))
        {
            str.append("\nThere is a rock lying on the ground.");
        }

        return str.toString();
    }


    /**
     * A method to get the response text to be displayed above the text entry
     * field. Also changes the location of the player and adds or removes
     * statuses appropriately. Just for outside.
     *
     * @param verb
     *            The verb contained in the sentence
     * @param nounResults
     *            Nouns contained in the sentence
     * @param prepResults
     *            Prepositions contained in the sentence
     * @return A string containing the response text for an action
     */
    private String outsideResponse(
        String verb,
        ArrayList<String> nounResults,
        ArrayList<String> prepResults)
    {
        if (nounResults.contains("sister") || nounResults.contains("sibling")
            || nounResults.contains("mom"))
        {
            if (!stat.getStatus().contains("momKitchen"))
            {
                return ("Both your sister and our mom are currently busy.");
            }
        }
        if (nounResults.contains("baseball"))
        {
            if (verb.equals("play"))
            {
                if (!(prepResults == null))
                {
                    if ((nounResults.contains("sibling") || nounResults
                        .contains("sister"))
                        && !(prepResults.contains("without")))
                    {
                        return ("You play baseball with your sister.");
                    }
                    else if (prepResults.contains("without"))
                    {
                        return ("You play baseball alone.");
                    }
                }
                else
                {
                    return ("You play baseball alone.");
                }
            }
            if (lookList.contains(verb))
            {
                return ("Your sister is currently playing baseball.");
            }
            if (useList.contains(verb))
            {
                return ("Maybe you should consider playing.");
            }
            if (badList.contains(verb))
            {
                return ("Why would you want to do that?");
            }
        }
        if (nounResults.contains("sibling") || nounResults.contains("sister"))
        {
            if (useList.contains(verb) || verb.equals("hug")
                || verb.equals("talk"))
            {
                if (stat.getStatus().contains("isNaked"))
                {
                    loc.setLocation(31);
                    return ("Your sister alerts your mother that you are "
                        + "outside"
                        + " improperly dressed.");
                }
                else
                {
                    return ("Your sister asks you if you would like to play"
                        + " baseball with her.");
                }
            }
            if (lookList.contains(verb))
            {
                return ("Your sister, 3 years younger than yourself. "
                    + "She is currently playing baseball.");
            }
            if (badList.contains(verb))
            {
                return ("You wouldn't do that to your lovely sister.");
            }
        }
        if (nounResults.contains("rock"))
        {
            if ((nounResults.contains("home") || nounResults.contains("window"))
                && !nounResults.contains("kevin's")
                && (useList.contains(verb) || verb.equals("throw")))
            {
                stat.getStatus().remove("momKitchen");
                stat.getStatus().remove("hasRock");
                return ("As your sister is swinging at a ball, you throw the"
                    + " rock at the window. Your mother comes out to reprimand "
                    + "your sister for breaking it.");
            }
            else if (!stat.getStatus().contains("tookRock"))
            {
                if (useList.contains(verb))
                {
                    if (stat.getStatus().contains("hasBag"))
                    {
                        stat.getStatus().add("hasRock");
                        stat.getStatus().add("tookRock");
                        return ("You put the rock in your backpack.");
                    }
                    else
                    {
                        return ("You don't have any way to carry the rock.");
                    }
                }
            }
            else if (nounResults.contains("kevin's"))
            {
                return ("Throwing a rock at his house won't get your "
                    + "bike back.");
            }
            else
            {
                return ("You aren't sure what to do with the rock.");
            }
        }
        // Going other places
        if (verb.equals("go") || verb.equals("walk") || verb.equals("enter"))
        {
            if (nounResults.contains("garage")
                || nounResults.contains("inside")
                || nounResults.contains("home")
                || nounResults.contains("house")
                && !nounResults.contains("kevin's")
                && !nounResults.contains("kevins"))
            {
                loc.setLocation(4);
                return ("You walk into the garage.");
            }
            if (nounResults.contains("kevin's")
                || nounResults.contains("kevins"))
            {
                loc.setLocation(6);
                return ("You walk to the front door of Kevin's house.");
            }
        }
        if (useList.contains(verb))
        {
            if (nounResults.contains("garage")
                || nounResults.contains("inside")
                || nounResults.contains("home")
                || nounResults.contains("house")
                && !nounResults.contains("kevin's")
                && nounResults.contains("door")
                && !nounResults.contains("kevins"))
            {
                loc.setLocation(4);
                return ("You walk into the garage.");
            }
            else
            {
                return ("What door do you want to use?");
            }
        }
        // General looking around.
        if (lookList.contains(verb)
            && (nounResults.contains("around") || nounResults.contains("area")))
        {
            return ("You look around the area. "
                + "You don't gain any new insight.");

        }
        return ("You can't do that from here.");
    }


    /**
     * A method to get the response text to be displayed above the text entry
     * field. Also changes the location of the player and adds or removes
     * statuses appropriately. Just for the garage.
     *
     * @param verb
     *            The verb contained in the sentence
     * @param nounResults
     *            Nouns contained in the sentence
     * @param prepResults
     *            Prepositions contained in the sentence
     * @return A string containing the response text for an action
     */
    private String garageResponse(
        String verb,
        ArrayList<String> nounResults,
        ArrayList<String> prepResults)
    {
        if (nounResults.contains("car"))
        {
            if (lookList.contains(verb))
            {
                return ("Looking at the car, you are unable to discern the"
                    + " model. You wish you knew more about cars. You don't "
                    + "know how to drive.");
            }
            if (useList.contains(verb) || verb.equals("drive"))
            {
                if (stat.getStatus().contains("hasCarKey"))
                {
                    loc.setLocation(41);
                    return ("You don't really know how to drive, but you "
                        + "decided to do it anyway.");
                }
                else
                {
                    return ("You don't have the keys to drive the car.");
                }
            }
            if (badList.contains(verb))
            {
                return ("You don't want to do that.");
            }
        }
        if (nounResults.contains("tool") || nounResults.contains("tools")
            || nounResults.contains("toolbench"))
        {
            if (useList.contains(verb))
            {
                return ("You play around with the tools.");
            }
            if (lookList.contains(verb))
            {
                return ("There appears to be a screwdriver and wire on the "
                    + "toolbench.");
            }
            if (badList.contains(verb))
            {
                return ("You don't want to do that.");
            }
        }
        if (nounResults.contains("screwdriver"))
        {
            if (useList.contains(verb))
            {
                if (!stat.getStatus().contains("hasScrewdriver"))
                {
                    if (stat.getStatus().contains("hasBag"))
                    {
                        stat.getStatus().add("hasScrewdriver");
                        return ("You take the screwdriver.");
                    }
                    else
                    {
                        return ("You would take the screwdriver, but you have "
                            + "nowhere to put it.");
                    }
                }
                if (stat.getStatus().contains("hasScrewdriver"))
                {
                    return ("You are already carrying that.");
                }
            }
            if (lookList.contains(verb))
            {
                return ("It's a screwdriver.");
            }
            if (badList.contains(verb))
            {
                return ("You don't want to do that.");
            }
        }
        if (nounResults.contains("wire"))
        {
            if (useList.contains(verb))
            {
                if (!stat.getStatus().contains("hasWire")
                    && !stat.getStatus().contains("hasHotWire"))
                {
                    if (stat.getStatus().contains("hasBag"))
                    {
                        stat.getStatus().add("hasWire");
                        return ("You take the wire.");
                    }
                    else
                    {
                        return ("You would take the wire, but you have "
                            + "nowhere to put it.");
                    }
                }
                else
                {
                    return ("You already have that.");
                }
            }
            if (lookList.contains(verb))
            {
                return ("It's some electrical wire.");
            }
            if (badList.contains(verb))
            {
                return ("You don't want to do that.");
            }
        }
        // Going other places
        if (verb.equals("go") || verb.equals("walk") || verb.equals("enter"))
        {
            if (nounResults.contains("kitchen")
                || nounResults.contains("inside"))
            {
                loc.setLocation(3);
                return ("You walk into the kitchen.");
            }
            if (nounResults.contains("outside")
                || nounResults.contains("cul-de-sac")
                || nounResults.contains("neighborhood"))
            {
                if (stat.getStatus().contains("hasHouseKey"))
                {
                    loc.setLocation(5);
                    return ("You walk outside.");
                }
                else
                {
                    loc.setLocation(51);
                    return ("You forgot the house key.");
                }
            }
        }
        if (useList.contains(verb))
        {
            if (nounResults.contains("kitchen") && nounResults.contains("door"))
            {
                loc.setLocation(3);
                return ("You walk back into the kitchen.");
            }
            if (nounResults.contains("outside") && nounResults.contains("door"))
            {
                if (stat.getStatus().contains("hasHouseKey"))
                {
                    loc.setLocation(5);
                    return ("You walk outside.");
                }
                else
                {
                    loc.setLocation(51);
                    return ("You forgot the house key.");
                }
            }
            else if (nounResults.contains("door"))
            {
                return ("What door do you want to use?");
            }
        }
        // General looking around.
        if (lookList.contains(verb)
            && (nounResults.contains("around") || nounResults.contains("area")))
        {
            return ("You look around the area. "
                + "You don't gain any new insight.");

        }

        return "You dont want do that here.";
    }


    /**
     * A method to get the description of the area based on statuses. Just for
     * the kitchen.
     *
     * @return A string description of the area.
     */
    private String kitchenDesc()
    {
        StringBuilder str = new StringBuilder();
        str.append("You walk into the kitchen.");
        if (stat.getStatus().contains("momKitchen"))
        {
            str.append(" You see your mom preparing food at the stove.");
        }
        str.append(" You also see a large window with a view"
            + " of the Cul-de-sac.\n");
        if (!stat.getStatus().contains("hasCarKey")
            && stat.getStatus().contains("momKitchen"))
        {
            str.append("You see a faint glimmer of something"
                + " in your mother's pocket.\n");
        }
        str.append("From here, there is a door going to the garage, and a "
            + "stairway that leads to an upstairs hallway.");
        return str.toString();
    }


    /**
     * A method to get the response text to be displayed above the text entry
     * field. Also changes the location of the player and adds or removes
     * statuses appropriately. Just for the kitchen.
     *
     * @param verb
     *            The verb contained in the sentence
     * @param nounResults
     *            Nouns contained in the sentence
     * @param prepResults
     *            Prepositions contained in the sentence
     * @return A string containing the response text for an action
     */
    private String kitchenResponse(
        String verb,
        ArrayList<String> nounResults,
        ArrayList<String> prepResults)
    {
        if (nounResults.contains("window"))
        {
            if (lookList.contains(verb))
            {
                return ("You look outside the window to see your sister playing"
                    + "baseball.");
            }
            if (useList.contains(verb))
            {
                return ("Your mother already opened the window slightly, and "
                    + "it doesn't seem like she wants it closed.");
            }
            if (badList.contains(verb))
            {
                return ("If you did that from inside you would surely"
                    + " get caught.");
            }
        }
        if (nounResults.contains("mom") || nounResults.contains("mother"))
        {
            if (!stat.getStatus().contains("momKitchen"))
            {
                return ("Your mother isn't here.");
            }
            if (lookList.contains(verb))
            {

                return ("Your mother, cooking lunch. She has a set of car keys"
                    + " slightly exposed in her back pocket.");
            }
            if (useList.contains(verb) || verb.equals("hug")
                || verb.equals("talk"))
            {
                if (stat.getStatus().contains("wetClothes")
                    || stat.getStatus().contains("isNaked"))
                {
                    loc.setLocation(31);
                    return ("Your mother catches you improperly dressed.");
                }
                else
                {
                    return ("Your mother tells you to clean your room before"
                        + " going outside.");
                }
            }
            if (badList.contains(verb))
            {
                return ("You would do that to your own mother?");
            }
        }
        if (nounResults.contains("key") || nounResults.contains("keys")
            || nounResults.contains("car") || nounResults.contains("pocket"))
        {
            if (!stat.getStatus().contains("momKitchen"))
            {
                return ("The keys aren't here.");
            }
            if (lookList.contains(verb))
            {
                return ("A set of keys to the car that is located in the "
                    + "garage is in your mother's back pocket.");
            }
            if (verb.equals("steal") || useList.contains(verb)
                || verb.equals("pickpocket"))
            {
                if (stat.getStatus().contains("hasBag")
                    && !stat.getStatus().contains("hasCarKey"))
                {
                    stat.addStatus("hasCarKey");
                    return ("You stealthily steal the car keys from your mom.");
                }
                else if (stat.getStatus().contains("hasCarKey"))
                {
                    return ("You already took the key.");
                }
                else
                {
                    return ("You would take the keys from your mom, but you"
                        + " dont have a place to put them.");
                }
            }
            if (badList.contains(verb))
            {
                return ("Why would you do that?");
            }
        }
        if (nounResults.contains("stove") || nounResults.contains("wire"))
        {
            if (useList.contains(verb))
            {
                if (stat.getStatus().contains("momKitchen"))
                {
                    return ("You are unable to use the stove while your mother "
                        + "is using it. Find a way to distract her.");
                }
                else if (!stat.getStatus().contains("hasWire"))
                {
                    return ("You can use the stove, but you have nothing to use"
                        + " on it.");
                }
                else
                {
                    stat.removeStatus("hasWire");
                    stat.addStatus("hasHotWire");
                    return ("You heat the wire on the stove, carefully storing"
                        + " it.");
                }
            }
            if (lookList.contains(verb))
            {
                return ("A stove, still hot from use.");
            }
            if (badList.contains(verb))
            {
                return ("Why would you do that?");
            }
        }
        if (nounResults.contains("food"))
        {
            return ("The food isn't ready yet. Your mother is making it.");
        }
        // Going other places
        if (verb.equals("go") || verb.equals("walk") || verb.equals("enter"))
        {
            if (nounResults.contains("garage"))
            {
                if (stat.getStatus().contains("bedIsMessy")
                    || stat.getStatus().contains("deskIsMessy"))
                {
                    return ("Your mother does not allow you to go into "
                        + "the garage.");
                }
                else
                {
                    loc.setLocation(4);
                    return ("You walk into the garage.");
                }
            }
            if (nounResults.contains("stairs")
                || nounResults.contains("hallway")
                || nounResults.contains("hall")
                || nounResults.contains("upstairs"))
            {
                loc.setLocation(2);
                return ("You walk up the stairs and into the hallway.");
            }
        }
        if (useList.contains(verb))
        {
            if (nounResults.contains("garage") && nounResults.contains("door"))
            {
                loc.setLocation(4);
                return ("You open the door and walk into the garage.");
            }
            else if (nounResults.contains("door"))
            {
                return ("What door do you want to use?");
            }
        }
        return "You can't do that here.";
    }


    /**
     * A method to get the response text to be displayed above the text entry
     * field. Also changes the location of the player and adds or removes
     * statuses appropriately. Just for the hallway.
     *
     * @param verb
     *            The verb contained in the sentence
     * @param nounResults
     *            Nouns contained in the sentence
     * @param prepResults
     *            Prepositions contained in the sentence
     * @return A string containing the response text for an action
     */
    private String hallwayResponse(
        String verb,
        ArrayList<String> nounResults,
        ArrayList<String> prepResults)
    {
        // General looking around.
        if (lookList.contains(verb))
        {
            if (nounResults.contains("around") || nounResults.contains("area"))
            {
                return ("You look around the area. "
                    + "You don't gain any new insight.");
            }
            else
            {
                return ("There isn't much here to look at.");
            }

        }

        // Going other places
        if (verb.equals("go") || verb.equals("walk") || verb.equals("enter"))
        {
            if (nounResults.contains("bedroom") || nounResults.contains("room"))
            {
                loc.setLocation(1);
                return ("You walk back into your bedroom.");
            }
            if (nounResults.contains("kitchen")
                || nounResults.contains("stairs")
                || nounResults.contains("downstairs"))
            {
                if (!stat.getStatus().contains("isWet"))
                {
                    loc.setLocation(3);
                    return ("You walk down the stairs and into the kitchen.");
                }
                else
                {
                    loc.setLocation(21);
                    return ("You fell down the stairs and into the kitchen.");
                }
            }
        }
        if (useList.contains(verb))
        {
            if (nounResults.contains("room") || nounResults.contains("door")
                || nounResults.contains("doorway")
                || nounResults.contains("bedroom"))
            {
                loc.setLocation(1);
                return ("You walk back into your bedroom.");
            }
            if (nounResults.contains("stairs")
                || nounResults.contains("downstairs"))
            {
                if (!stat.getStatus().contains("isWet"))
                {
                    loc.setLocation(3);
                    return ("You walk down the stairs and into the kitchen.");
                }
                else
                {
                    loc.setLocation(21);
                    return ("You fell down the stairs and into the kitchen.");
                }
            }
        }
        return ("You don't understand why you would want do that.");
    }


    /**
     * A method to get the response text to be displayed above the text entry
     * field. Also changes the location of the player and adds or removes
     * statuses appropriately. Just for the start screen.
     *
     * @param verb
     *            The verb contained in the sentence
     * @param nounResults
     *            Nouns contained in the sentence
     * @param prepResults
     *            Prepositions contained in the sentence
     * @return A string containing the response text for an action
     */
    private String startResponse(
        String verb,
        ArrayList<String> nounResults,
        ArrayList<String> prepResults)
    {
        if (nounResults.contains("me"))
        {
            if (verb.equals("help"))
            {
                loc.setLocation(-2);
                return ("Enter text here.");
            }
        }
        if (nounResults.contains("game"))
        {
            if (verb.equals("play") || verb.equals("start"))
            {
                stat.removeAllStatus();
                stat.addStatus("isWet");
                stat.addStatus("isNaked");
                stat.addStatus("isWeak");
                stat.addStatus("bedIsMessy");
                stat.addStatus("deskIsMessy");
                stat.addStatus("momKitchen");
                stat.addStatus("kevinPlaying");
                stat.addStatus("doorbellBroken");
                loc.setLocation(0);
                return ("What do you want to do?");
            }
        }
        return "Sorry, you can't do that from here.";
    }


    /**
     * A method to get the response text to be displayed above the text entry
     * field. Also changes the location of the player and adds or removes
     * statuses appropriately. Just for the help screen.
     *
     * @param verb
     *            The verb contained in the sentence
     * @param nounResults
     *            Nouns contained in the sentence
     * @param prepResults
     *            Prepositions contained in the sentence
     * @return A string containing the response text for an action
     */
    private String helpResponse(
        String verb,
        ArrayList<String> nounResults,
        ArrayList<String> prepResults)
    {
        if (verb.equals("play") || verb.equals("start")
            && nounResults.contains("game"))
        {
            stat.removeAllStatus();
            stat.addStatus("isWet");
            stat.addStatus("isNaked");
            stat.addStatus("isWeak");
            stat.addStatus("bedIsMessy");
            stat.addStatus("deskIsMessy");
            stat.addStatus("momKitchen");
            stat.addStatus("kevinPlaying");
            stat.addStatus("doorbellBroken");
            loc.setLocation(0);
            return ("What do you want to do?");
        }
        if (verb.equals("return") && nounResults.contains("menu"))
        {
            loc.setLocation(-1);
            return ("Have fun!");
        }
        return "Sorry, you can't do that from here.";
    }


    /**
     * A method to get the description of the area based on statuses. Just for
     * the bedroom.
     *
     * @return A string description of the area.
     */
    private String bedroomDesc()
    {
        StringBuilder str = new StringBuilder();
        str.append("You enter the bedroom, ");
        if (stat.getStatus().contains("deskIsMessy")
            || stat.getStatus().contains("bedIsMessy"))
        {
            str.append("which is very messy.\n");
        }
        else
        {
            str.append("which looks pretty clean.\n");
        }
        if (stat.getStatus().contains("isNaked"))
        {
            str.append("Today's clothes are thrown about the floor, ");
        }
        if (stat.getStatus().contains("bedIsMessy")
            && stat.getStatus().contains("deskIsMessy"))
        {
            str.append("your bed is unmade, and your desk is covered in "
                + "trash. ");
        }
        if (stat.getStatus().contains("bedIsMessy")
            && !stat.getStatus().contains("deskIsMessy"))
        {
            str.append("and your bed is unmade. ");
        }
        if (stat.getStatus().contains("deskIsMessy")
            && !stat.getStatus().contains("bedIsMessy"))
        {
            str.append("and your desk is covered in trash. ");
        }
        str.append("There is a nice set of weights put away in the corner. ");
        if (!stat.getStatus().contains("hasBag"))
        {
            str.append("You see the glimmer of something"
                + " shiny in your backpack, which is on your bed.");
        }
        str.append("\nFrom here, you can see the door to your bathroom and a "
            + "door"
            + " that leads out into the hallway, then downstairs into the"
            + " kitchen.");

        return str.toString();
    }


    /**
     * A method to get the response text to be displayed above the text entry
     * field. Also changes the location of the player and adds or removes
     * statuses appropriately. Just for the bedroom.
     *
     * @param verb
     *            The verb contained in the sentence
     * @param nounResults
     *            Nouns contained in the sentence
     * @param prepResults
     *            Prepositions contained in the sentence
     * @return A string containing the response text for an action
     */
    private String bedroomResponse(
        String verb,
        ArrayList<String> nounResults,
        ArrayList<String> prepResults)
    {
        if (nounResults.contains("desk"))
        {
            if (lookList.contains(verb))
            {
                if (stat.getStatus().contains("deskIsMessy"))
                {
                    return ("A desk covered in trash.");
                }
                else
                {
                    return ("A clean desk.");
                }
            }
            if (useList.contains(verb))
            {
                if (stat.getStatus().contains("deskIsMessy"))
                {
                    stat.removeStatus("deskIsMessy");
                    return ("You clean your desk, and also look in the drawers."
                        + " You find nothing interesting.");
                }
                else
                {
                    return ("You already cleaned your desk.");
                }
            }
            if (badList.contains(verb))
            {
                return ("Why would you do that?");
            }
        }
        if (nounResults.contains("weight") || nounResults.contains("weights"))
        {
            if (lookList.contains(verb))
            {
                return ("A nice set of weights.");
            }
            if (useList.contains(verb) || verb.equals("lift"))
            {
                stat.removeStatus("isWeak");
                return ("You lift the weights and feel a little stronger."
                    + " This may help later.");
            }
            if (badList.contains(verb))
            {
                return ("Why would you do that?");
            }
        }
        if (nounResults.contains("bag") || nounResults.contains("backpack"))
        {
            if (lookList.contains(verb))
            {
                return ("You examine the backpack closely, and notice a key to"
                    + " your house hanging outside the outer pocket.");
            }
            if (useList.contains(verb))
            {
                if (!stat.getStatus().contains("hasBag"))
                {
                    stat.addStatus("hasBag");
                    stat.addStatus("hasHouseKey");
                    return ("You take the backpack and put it on your back."
                        + " You make note of the house key inside of it.");
                }
                else
                {
                    return ("You already are carrying your backpack.");
                }
            }
            if (badList.contains(verb))
            {
                return ("Why would you do that?");
            }
        }
        if (nounResults.contains("key"))
        {
            if (lookList.contains(verb))
            {
                return ("It looks like a key to your house.");
            }
            if (useList.contains(verb))
            {
                if (!stat.getStatus().contains("hasBag"))
                {
                    return ("You would take the key, but you have no way of"
                        + " carrying it.");
                }
                if (stat.getStatus().contains("hasHouseKey"))
                {
                    return ("A key to your house, currently inside your "
                        + "backpack.");
                }
            }
            if (badList.contains(verb))
            {
                return ("Why would you do that?");
            }
        }
        if (nounResults.contains("bed"))
        {
            if (lookList.contains(verb))
            {
                if (stat.getStatus().contains("bedIsMessy")
                    && !stat.getStatus().contains("hasBag"))
                {
                    return ("An unmade bed. A backpack lies on top of it.");
                }
                if (stat.getStatus().contains("bedIsMessy")
                    && stat.getStatus().contains("hasBag"))
                {
                    return ("An unmade bed.");
                }
                if (!stat.getStatus().contains("bedisMessy")
                    && stat.getStatus().contains("hasBag"))
                {
                    return ("A clean bed.");
                }
                if (!stat.getStatus().contains("bedisMessy")
                    && !stat.getStatus().contains("hasBag"))
                {
                    return ("A clean bed. A backpack lies on top of it.");
                }
            }
            if (useList.contains(verb) || verb.equals("make"))
            {
                if (stat.getStatus().contains("bedIsMessy"))
                {
                    stat.removeStatus("bedIsMessy");
                    return ("You tidy your bed. How nice of you.");
                }
                else
                {
                    return ("You already made your bed.");
                }

            }
            if (verb.contains("sleep") || verb.contains("rest"))
            {
                return ("You don't feel like resting now.");
            }
            if (badList.contains(verb))
            {
                return ("Why would you do that?");
            }
        }
        if (nounResults.contains("clothes") || nounResults.contains("shirt")
            || nounResults.contains("pants") || nounResults.contains("shoes")
            || nounResults.contains("shoe") || nounResults.contains("shorts")
            || nounResults.contains("dressed"))
        {
            if (useList.contains(verb) || verb.equals("wear")
                || verb.equals("put"))
            {
                if (stat.getStatus().contains("isNaked"))
                {
                    if (stat.getStatus().contains("isWet"))
                    {
                        stat.removeStatus("isNaked");
                        stat.addStatus("wetClothes");
                        stat.removeStatus("isWet");
                        return ("You put on your clothes, but now they are "
                            + "wet just like you. "
                            + "Your shorts do not have pockets.");
                    }
                    if (!stat.getStatus().contains("isWet"))
                    {
                        stat.removeStatus("isNaked");
                        return ("You put on your clothes. "
                            + "Your shorts do not have pockets.");
                    }
                }
                else
                {
                    return ("You already took the clothes.");
                }
            }
            if (lookList.contains(verb))
            {
                return ("Clothes to be worn.");
            }
            if (badList.contains(verb))
            {
                return ("Why would you do that?");
            }
        }
        // General looking around.
        if (lookList.contains(verb)
            && (nounResults.contains("around") || nounResults.contains("area")))
        {
            return ("You look around the area. "
                + "You don't gain any new insight.");

        }
        // Going other places
        if (verb.equals("go") || verb.equals("walk") || verb.equals("enter"))
        {
            if (nounResults.contains("bathroom"))
            {
                loc.setLocation(0);
                return ("You walk into the bathroom from your room.");
            }
            if (nounResults.contains("kitchen")
                || nounResults.contains("stairs")
                || nounResults.contains("hallway")
                || nounResults.contains("hall")
                || nounResults.contains("stairwell")
                || nounResults.contains("downstairs"))
            {
                loc.setLocation(2);
                return ("You walk into the hallway from your room.");
            }
        }
        if (useList.contains(verb))
        {
            if (nounResults.contains("room"))
            {
                return ("You should clean specific objects in your room.");
            }
            if (nounResults.contains("door")
                && nounResults.contains("bathroom"))
            {
                return bedroomResponse("go", nounResults, null);
            }
            else if (nounResults.contains("door")
                && (nounResults.contains("kitchen")
                    || nounResults.contains("stairs")
                    || nounResults.contains("hallway")
                    || nounResults.contains("hall")
                    || nounResults.contains("stairwell") || nounResults
                        .contains("downstairs")))
            {
                return bedroomResponse("go", nounResults, null);
            }
            else
            {
                return ("Which door should you use?");
            }
        }
        return "You don't understand why you would want do that.";
    }


    /**
     * A method to get the description of the area based on statuses. Just for
     * the bathroom.
     *
     * @return A string description of the area.
     */
    private String bathroomDesc()
    {
        if (stat.getStatus().contains("isWet"))
        {
            return ("You step out of the shower into a sunny saturday morning."
                + " You are covered in water, and proceed to look around the "
                + "room. There is a mirror, two sinks, and a cabinet full of "
                + "the usual stuff you would find in a bathroom."
                + "\nA dry towel lays on the floor across the room.\n"
                + "A door connects this room to your bedroom.");
        }
        else
        {
            return ("You step out of the shower into a sunny saturday morning "
                + "and proceed to look around the room. There is a mirror, two "
                + "sinks, and a cabinet full of the usual stuff you would find "
                + "in a bathroom."
                + "\nAn used towel lays on the floor across the room.\n"
                + "A door connects this room to your bedroom.");
        }
    }


    /**
     * A method to get the response text to be displayed above the text entry
     * field. Also changes the location of the player and adds or removes
     * statuses appropriately. Just for the bathroom.
     *
     * @param verb
     *            The verb contained in the sentence
     * @param nounResults
     *            Nouns contained in the sentence
     * @param prepResults
     *            Prepositions contained in the sentence
     * @return A string containing the response text for an action
     */
    private String bathroomResponse(
        String verb,
        ArrayList<String> nounResults,
        ArrayList<String> prepResults)
    {
        // Interactions with the mirror
        if (nounResults.contains("mirror"))
        {
            if (lookList.contains(verb))
            {
                return ("The mirror is very foggy. You are unable to see your"
                    + " reflection.");
            }
            if (useList.contains(verb))
            {
                return ("You attempt to wipe the mirror clean. Nothing"
                    + " changes.");
            }
            if (badList.contains(verb))
            {
                return ("Why would you do that?");
            }
        }
        // Interactions with the sink
        if (nounResults.contains("sink") || nounResults.contains("sinks"))
        {
            if (lookList.contains(verb))
            {
                return ("The sinks are a little messy, but work nonetheless.");
            }
            if (useList.contains(verb))
            {
                return ("You wash your hands.");
            }
            if (badList.contains(verb))
            {
                return ("Why would you do that?");
            }
        }
        // Interactions with other room / doorway
        if (nounResults.contains("room") || nounResults.contains("door")
            || nounResults.contains("doorway")
            || nounResults.contains("bedroom"))
        {
            if (verb.equals("go") || verb.equals("walk")
                || verb.equals("enter"))
            {
                loc.setLocation(1);
                return ("You walk from the bathroom to your room.");
            }
            if (lookList.contains(verb))
            {
                return ("You cannot see your whole room through the doorway."
                    + " You can see a bed, but it is far away.");
            }
            if (useList.contains(verb))
            {
                loc.setLocation(1);
                return ("You use the door to get into your room.");
            }
            if (badList.contains(verb))
            {
                return ("Why would you do that?");
            }
        }
        // Interactions with the shower
        if (nounResults.contains("shower"))
        {
            if (lookList.contains(verb))
            {
                return ("A perfectly average shower.");
            }
            if (useList.contains(verb))
            {
                return ("You already took a shower today, and you don't "
                    + "feel like taking one again.");
            }
            if (badList.contains(verb))
            {
                return ("Why would you do that?");
            }
        }
        // Drawer interaction
        if (nounResults.contains("cabinet") || nounResults.contains("cabinets"))
        {
            if (lookList.contains(verb))
            {
                return ("There is nothing interesting in the cabinets.");
            }
            if (useList.contains(verb))
            {
                return ("You open the cabinets, but there is still nothing"
                    + " interesting inside them.");
            }
            if (badList.contains(verb))
            {
                return ("Why would you do that?");
            }
        }
        // Towel interaction
        if (nounResults.contains("towel"))
        {
            if (lookList.contains(verb))
            {
                return ("A dry towel.");
            }
            if (useList.contains(verb))
            {
                if (stat.getStatus().contains("isWet"))
                {
                    stat.removeStatus("isWet");
                    return ("You use the towel to dry yourself.");
                }
                else
                {
                    return ("You are already dry.");
                }
            }
            if (badList.contains(verb))
            {
                return ("Why would you do that?");
            }
        }
        // General looking around.
        if (lookList.contains(verb)
            && (nounResults.contains("around") || nounResults.contains("area")))
        {
            return ("You look around the area. "
                + "You don't gain any new insight.");

        }

        return "You don't understand why you would want do that.";
    }


    /**
     * A way to get the description of yourself when you look at yourself.
     *
     * @return A string containing all descriptions about yourself.
     */
    public String getSelfDesc()
    {
        StringBuilder str = new StringBuilder();
        str.append("You are a teenager who is currently enrolled in "
            + "highschool. ");
        if (stat.getStatus().contains("isNaked"))
        {
            str.append("You are currently not wearing any clothes. ");
        }
        if (stat.getStatus().contains("wetClothes"))
        {
            str.append("You did remember to put on clothes, but you did not "
                + "dry yourself off after your shower. Your clothes are now "
                + "wet, but you are less wet than before. ");
        }
        else
        {
            str.append("You are wearing a clean set of clothes. ");
        }
        if (stat.getStatus().contains("isWet"))
        {
            str.append("You are soaking wet after your shower. ");
        }
        if (!stat.getStatus().contains("deskIsMessy")
            && !stat.getStatus().contains("bedIsMessy"))
        {
            str.append("You have cleaned your room. ");
        }
        if (stat.getStatus().contains("hasBag"))
        {
            str.append("You are currently wearing your backpack. ");
        }
        if (stat.getStatus().contains("hasHouseKey"))
        {
            str.append("You have a key to your house. ");
        }
        if (stat.getStatus().contains("hasCarKey"))
        {
            str.append("You have a key to the car in the garage. ");
        }
        if (stat.getStatus().contains("hasScrewdriver"))
        {
            str.append("You are in possession of a screwdriver. ");
        }
        if (stat.getStatus().contains("hasWire"))
        {
            str.append("You are holding some wire. ");
        }
        if (stat.getStatus().contains("hasHotWire"))
        {
            str.append("You have heated the wire. ");
        }
        if (stat.getStatus().contains("tookRock"))
        {
            str.append("You have taken a rock from outside. ");
        }
        if (!stat.getStatus().contains("momKitchen"))
        {
            str.append("You have used that rock to cooerce your mother "
                + "outside. ");
        }
        if (!stat.getStatus().contains("kevinPlaying"))
        {
            str.append("Kevin is currently distracted answering the door. ");
        }
        if (!stat.getStatus().contains("doorbellBroken"))
        {
            str.append("You have fixed the doorbell. ");
        }
        if (stat.getStatus().contains("isWeak"))
        {
            str.append("You are feeling particularly weak today. ");
        }
        return str.toString();

    }

}
