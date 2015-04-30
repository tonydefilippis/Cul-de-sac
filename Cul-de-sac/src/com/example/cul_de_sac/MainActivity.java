package com.example.cul_de_sac;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

// -------------------------------------------------------------------------
/**
 * This is the main class for the display that the user will see upon
 * interacting with the app.
 *
 * @author Anthony DeFilippis
 * @version 2015.04.26
 */
public class MainActivity
    extends ActionBarActivity
{
    private Location     location;
    private TextView     locName;
    private TextView     locDescript;
    private String       inputText;
    private StringParser strParse;
    private TextView     response;
    private Context      cont;
    private Status       stat;
    private Story        story;


    /**
     * Called when the app is created. Instantiates a new status, story, and
     * location, as well as the string parser. Gets the context for files.
     * Establishes the beginning location and creates a listener for when the
     * user hits enter on the search field.
     *
     * @param savedInstanceState
     *            The last saved state of the display.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cont = getApplicationContext();
        inputText = new String();
        stat = new Status();
        story = new Story(stat);
        location = new Location(story);
        strParse = new StringParser(cont, stat);
        System.out.println("main status");
        location.setLocation(-1);
        updateView();
        // Establishing a listener for enter key presses in the search field
        final EditText editText = (EditText)findViewById(R.id.inputText);
        editText.setOnKeyListener(new OnKeyListener() {

            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if (event.getAction() == KeyEvent.ACTION_DOWN
                    && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)
                {
                    inputText = editText.getText().toString();
                    onEnter();
                    editText.setText("");
                    locName.requestFocus();
                    return false;
                }

                return false;
            }
        });
    }


    /**
     * A method to update the text of the view for the current location.
     */
    private void updateView()
    {
        locName = (TextView)findViewById(R.id.nameText);
        locName.setText(location.getLocationName());
        locDescript = (TextView)findViewById(R.id.descriptText);
        locDescript.setText(location.getLocationDescription());
        response = (TextView)findViewById(R.id.responseText);
    }


    /**
     * The method called when enter is pressed. Parses the input and receives a
     * response, then update the view.
     */
    private void onEnter()
    {
        strParse.setString(inputText.toLowerCase());
        response.setText(strParse.parseString());
        updateView();
    }
}
