package com.erichay.studycards;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class CardViewer extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_viewer_layout);

        //Get the toolbar and set it's title to white
        //also set it's menu
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorAccent));
        toolbar.inflateMenu(R.menu.toolbar_menu);

        //Make a new array of cards
        CardHolder.cards = new ArrayList<Card>();
        //Load cards from the external file to the array
        loadCards();

        //Make a new adapter for the cards
        CardAdapter adapter = new CardAdapter(this, R.layout.card_list_layout, CardHolder.cards);
        //Get the ListView and set the adapter
        ListView listView = (ListView)findViewById(R.id.card_list_view);
        listView.setAdapter(adapter);

    }

    public void startCards(MenuItem i)
    {
        //Toast.makeText(this, "Almost Implemented", Toast.LENGTH_LONG).show();

        //Create a new intent for the CardPlayer
        Intent intent = new Intent(this, CardPlayer.class);
        //Start the activity
        startActivity(intent);
    }

    private void loadCards()
    {
        //Attempt to open the card file
        File path = Environment.getExternalStoragePublicDirectory("Documents/StudyCards");
        File cardFile = new File(path, "cards.csv");

        //If the file does not exist, tell the user and leave this method
        //Otherwise, we'll continue
        if (!cardFile.exists())
        {
            Toast.makeText(this, "Couldn't Open File", Toast.LENGTH_LONG).show();
            return;
        }

        //Some variables we'll need
        String line; //This will hold an entire line - an entire card
        String definition; //This will hold the definition part of the card
        String answer; //This will hold the answer part of the card
        BufferedReader reader; //We'll use this to read from the external file

        try
        {
            //Attempt to create a new reader
            reader = new BufferedReader(new FileReader(cardFile));

            //Do this until reader.readLine() throws an exception
            do
            {
                //Get the next card
                line = reader.readLine();
                //Get the definition
                definition = line.substring(0, line.indexOf(";")).trim();
                //Get the answer
                answer = line.substring(line.indexOf(";") + 1, line.length()).trim();

                //Add the card to the array
                CardHolder.cards.add(new Card(definition, answer));
            } while (true);

        }
        catch (Exception e)
        {

        }
    }

}
