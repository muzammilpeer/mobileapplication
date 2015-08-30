package com.ranisaurus.newtorklayer.models;

/**
 * Created by muzammilpeer on 8/31/15.
 */
public class Taglines {
    private String id;

    private String howTo;

    private String tagline;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getHowTo ()
    {
        return howTo;
    }

    public void setHowTo (String howTo)
    {
        this.howTo = howTo;
    }

    public String getTagline ()
    {
        return tagline;
    }

    public void setTagline (String tagline)
    {
        this.tagline = tagline;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", howTo = "+howTo+", tagline = "+tagline+"]";
    }
}
