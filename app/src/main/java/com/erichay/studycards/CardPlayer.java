package com.erichay.studycards;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CardPlayer extends Activity
{
    private ArrayList<Card> cards;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_player_layout);

        //Get the intent that was given to us
        Intent intent = getIntent();
        //Get the cards from the intent
        cards = (ArrayList<Card>)intent.getSerializableExtra("cards");


    }

    private void randomizeCards()
    {
        long seed = System.nanoTime();
        Collections.shuffle(cards, new Random(seed));
    }


}
