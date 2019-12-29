import processing.core.PApplet;
public class Player
{
    PApplet applet;
    int size;
    int myColor;
    int xPos,yPos;
    int pos;
    int property;
    boolean inJail;
    boolean incomeTax;
    int[] houseLevel = new int[8];
    public Player(PApplet app)
    {
        applet = app;
        size = 20;
        myColor = 255;
        pos = 0;
        property = 1500;
        inJail = false;
        incomeTax = false;
        houseLevel[0] = 1;
        houseLevel[1] = 2;
        houseLevel[2] = 1;
        houseLevel[3] = 1;
        houseLevel[4] = 2;
        houseLevel[5] = 2;
        houseLevel[6] = 1;
        houseLevel[7] = 1;
    }
    //property
    public int getProperty()
    {
        return property;
    }

    public void setProperty(int amount)
    {
        property += amount;
        if (property + amount < 0)
        {
            property = 0;
        }
    }
    
    public void upGrade(int x)
    {
        houseLevel[x] += 1;
    }
    public int getHouseLevel(int x)
    {
        return houseLevel[x];
    }
    
    //position
    public int getPos()
    {
        return pos;
    }

    public void move(int x)
    {
        pos += x;
    }

    //incomeTax
    public void incomeTax(int pos)
    {
        if(pos == 2 && incomeTax == false)
        {
            property -= property * 0.25;
            incomeTax = true;
        }
        if(pos == 10 && incomeTax == false)
        {
            property -= property * 0.25;
            incomeTax = true;
        }
        if(pos == 20 && incomeTax == false)
        {
            property -= property * 0.25;
            incomeTax = true;
        }
        if(pos == 27 && incomeTax == false)
        {
            property -= property * 0.25;
            incomeTax = true;
        }
        incomeTax = false;
    }
}