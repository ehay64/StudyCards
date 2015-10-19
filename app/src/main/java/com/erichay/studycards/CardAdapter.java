package com.erichay.studycards;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CardAdapter extends ArrayAdapter<Card>
{
    Context context;
    int layoutResourceId;
    ArrayList<Card> cards;
    Card card;

    public CardAdapter(Context context, int layoutResourceId, ArrayList<Card> cards)
    {
        super(context, layoutResourceId, cards);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.cards = cards;
        card = cards.get(0);
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        //If there's no convertView, make a new one
        if (convertView == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        //Get the card we'll be putting in this view
        card = cards.get(position);

        //Fill the view with the items of the card
        ((TextView)convertView.findViewById(R.id.definition)).setText(card.definition);
        ((TextView)convertView.findViewById(R.id.answer)).setText(card.answer);

        return convertView;
    }
}
