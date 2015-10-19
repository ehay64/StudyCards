package com.erichay.studycards;

public class Card
{
    public String definition;
    public String answer;

    public Card()
    {
        definition = "null";
        answer = "null";
    }

    public Card(String d, String a)
    {
        this.definition = d;
        this.answer = a;
    }
}
