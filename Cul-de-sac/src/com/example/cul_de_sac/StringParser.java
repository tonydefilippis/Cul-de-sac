package com.example.cul_de_sac;

import java.io.IOException;
import android.content.Context;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;

// -------------------------------------------------------------------------
/**
 * This is a class purely for parsing string input and comparing it to the word
 * bank of the project to determine program response.
 *
 * @author Anthony DeFilippis
 * @version 2015.04.26
 */
public class StringParser
{
    // ~Fields ----------------------------------------------------------------
    private StringTokenizer   tokenizer;
    private String            parseThis;
    private ArrayList<String> nouns;
    private ArrayList<String> verbs;
    private ArrayList<String> preps;
    private ArrayList<String> tokens;
    private Context           cont;
    private Story             story;


    // ~Constructor ----------------------------------------------------------
    /**
     * Create a new StringParser object.
     *
     * @param context
     *            The context that the files containing the word banks are
     *            stored.
     * @param stat
     *            The current statuses affecting the player
     */
    public StringParser(Context context, Status stat)
    {
        cont = context;
        story = new Story(stat);
        generateNouns();
        generatePreps();
        generateVerbs();
    }


    // ~ Methods -------------------------------------------------------------
    /**
     * This method takes a string and breaks it down into recognizable tokens.
     *
     * @return An arraylist of specific words
     */
    private ArrayList<String> makeTokens()
    {
        tokens = new ArrayList<String>();
        tokenizer = new StringTokenizer(parseThis);
        while (tokenizer.hasMoreTokens())
        {
            tokens.add(tokenizer.nextToken());
        }
        return tokens;
    }


    /**
     * A method to generate a list of possible nouns to be used by the player.
     */
    private void generateNouns()
    {
        nouns = new ArrayList<String>();
        Scanner in = null;
        try
        {
            in = new Scanner(cont.getAssets().open("nouns.txt"));
            in.useDelimiter(" ");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        while (in != null && in.hasNext())
        {
            nouns.add(in.next());
        }
    }


    /**
     * A method to generate a list of possible verbs to be used by the player.
     */
    private void generateVerbs()
    {
        verbs = new ArrayList<String>();
        Scanner in = null;
        try
        {
            in = new Scanner(cont.getAssets().open("verbs.txt"));
            in.useDelimiter(" ");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        while (in != null && in.hasNext())
        {
            verbs.add(in.next());
        }
    }


    /**
     * A method to generate a list of possible prepositions to be used by the
     * player.
     */
    private void generatePreps()
    {
        preps = new ArrayList<String>();
        Scanner in = null;
        try
        {
            in = new Scanner(cont.getAssets().open("prepositions.txt"));
            in.useDelimiter(" ");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        while (in != null && in.hasNext())
        {
            preps.add(in.next());
        }
    }


    /**
     * A method that uses the stored string, and checks the string's tokens
     * against the word banks and passes it for a response.
     *
     * @return A string with the response for the input.
     */
    public String parseString()
    {
        if (parseThis != null)
        {
            makeTokens();
            ArrayList<Integer> verbIndex = containsVerb();
            ArrayList<Integer> nounIndex = containsNoun();
            ArrayList<Integer> prepIndex = containsPrep();
            ArrayList<String> verbResults = new ArrayList<String>();
            ArrayList<String> nounResults = new ArrayList<String>();
            ArrayList<String> prepResults = new ArrayList<String>();
            for (int i = 0; i < verbIndex.size(); i++)
            {
                if (verbIndex.get(0) != -1)
                {
                    verbResults.add(verbs.get(verbIndex.get(0)));
                }
            }
            for (int j = 0; j < nounIndex.size(); j++)
            {
                if (nounIndex.get(0) != -1)
                {
                    nounResults.add(nouns.get(nounIndex.get(j)));
                }
            }
            for (int k = 0; k < prepIndex.size(); k++)
            {
                if (prepIndex.get(0) != -1)
                {
                    prepResults.add(preps.get(prepIndex.get(k)));
                }
            }
            if (nounIndex.size() < 1 || verbIndex.size() > 1
                || verbIndex.size() < 1 || verbIndex.get(0) == -1
                || nounIndex.get(0) == -1)
            {
                return invalidSentence();
            }
            else if (prepIndex.size() == 0)
            {
                return resolveAction(
                    verbs.get(verbIndex.get(0)),
                    nounResults,
                    null);
            }
            else
            {
                return resolveAction(
                    verbs.get(verbIndex.get(0)),
                    nounResults,
                    prepResults);
            }
        }
        return null;
    }


    /**
     * A method that sets the string to be parsed by this class
     *
     * @param str
     *            The string to be parsed.
     */
    public void setString(String str)
    {
        parseThis = str;
    }


    /**
     * A method that gets the string to be parsed by this class
     *
     * @return The string to be parsed.
     */
    public String getString()
    {
        return parseThis;
    }


    /**
     * Seeing if the phrase contains a verb, returns the index in the verbs
     * ArrayList that the verb is in, or -1 otherwise.
     *
     * @return An arraylist of integers for where in the verb word bank the user
     *         input verb is located.
     */
    private ArrayList<Integer> containsVerb()
    {
        ArrayList<Integer> verbIndex = new ArrayList<Integer>();
        if (tokens == null || tokens.size() == 0)
        {
            verbIndex.add(-1);
            return verbIndex;
        }
        else
        {
            for (int i = 0; i < verbs.size(); i++)
            {
                if (tokens.contains(verbs.get(i)))
                {
                    verbIndex.add(i);
                    return verbIndex;
                }
            }
        }
        verbIndex.add(-1);
        return verbIndex;
    }


    /**
     * Seeing if the phrase contains a noun, returns the index in the nouns
     * ArrayList that the verb is in, or zero otherwise.
     *
     * @return An arraylist of integers for where in the noun word bank the user
     *         input nouns are located.
     */
    private ArrayList<Integer> containsNoun()
    {
        ArrayList<Integer> nounIndex = new ArrayList<Integer>();
        if (tokens == null || tokens.size() == 0)
        {
            nounIndex.add(-1);
            return nounIndex;
        }
        else
        {
            for (int i = 0; i < nouns.size(); i++)
            {

                if (tokens.contains(nouns.get(i)))
                {
                    nounIndex.add(i);

                }
            }
            return nounIndex;
        }
    }


    /**
     * Seeing if the phrase contains a preposition, returns the index in the
     * prepositions ArrayList that the verb is in, or zero otherwise.
     *
     * @return An arraylist of integers for where in the prep word bank the user
     *         input prepositions are located.
     */
    private ArrayList<Integer> containsPrep()
    {
        ArrayList<Integer> prepIndex = new ArrayList<Integer>();
        if (tokens == null || tokens.size() == 0)
        {
            prepIndex.add(-1);
            return prepIndex;
        }
        else
        {
            for (int i = 0; i < preps.size(); i++)
            {
                if (tokens.contains(preps.get(i)))
                {
                    prepIndex.add(i);
                }
            }
            return prepIndex;
        }
    }


    /**
     * A string response for sentences that don't make any sense or are
     * unrecognizable by the program.
     *
     * @return A string response.
     */
    public String invalidSentence()
    {
        return ("I don't understand what I am supposed to do.");
    }


    /**
     * Method that takes the resulting verb, nouns and prepositions and looks
     * for a response for them in the story class.
     *
     * @return A string containing the approprirate response for the input.
     */
    private String resolveAction(
        String verb,
        ArrayList<String> nounResults,
        ArrayList<String> prepResults)
    {
        return story.getResponse(verb, nounResults, prepResults);
    }
}
