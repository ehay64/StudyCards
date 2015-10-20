package com.erichay.studycards;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CardPlayer extends Activity
{
    private ArrayList<Card> cards;
    private TextView text;
    private int position;
    private boolean side;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_player_layout);

        //Make a copy of the array
        cards = new ArrayList<Card>(CardHolder.cards);
        //Randomize the cards
        randomizeCards();

        //Get the TextView we'll be putting stuff in
        text = (TextView)findViewById(R.id.text);

        //Init some stuff
        position = 0;
        side = true;

        playCards(null);
    }

    private void randomizeCards()
    {
        long seed = System.nanoTime();
        Collections.shuffle(cards, new Random(seed));
    }

    public void playCards(View v)
    {

        //Check to see if we're done
        if (position == cards.size())
        {
            finish();
        }
        else if (side)
        {
            text.setTextSize(32);
            text.setText(cards.get(position).definition);
            side = !side;
        }
        else
        {
            text.setTextSize(16);
            text.setText(cards.get(position).answer);
            side = !side;
            position++;
        }

    }

}
