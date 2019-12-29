import processing.core.*;
public class Player1 extends Player
{
    int[] allxPos = new int[30];
    int[] allyPos = new int[30];
    boolean[] player1House = new boolean[8];
    public Player1(PApplet app)
    {
        super(app);
        //x position
        allxPos[0] = 30;
        for(int i = 1; i < 10; i++)
        {
            allxPos[i] = allxPos[i-1] + 100;
        }
        for(int i = 10; i < 16; i++)
        {
            allxPos[i] = allxPos[9];
        }
        for(int i = 16; i < 25; i++)
        {
            allxPos[i] = allxPos[i-1] - 100;
        }
        for(int i = 25; i < 30; i++)
        {
            allxPos[i] = allxPos[24];
        }

        //y position
        allyPos[0] = 650;
        for(int i = 1; i < 10; i++)
        {
            allyPos[i] = allyPos[0];
        }
        for(int i = 10; i < 16; i++)
        {
            allyPos[i] = allyPos[i-1] - 100;
        }
        for(int i = 16; i < 25; i++)
        {
            allyPos[i] = allyPos[15];
        }
        for(int i = 25; i < 30; i++)
        {
            allyPos[i] = allyPos[i-1] + 100;
        }

        for (int i = 0; i < player1House.length; i++)
        {
            player1House[i] = false;
        }
    }

    public void buyHouse(int x, Player2 player2)
    {
        if(player2.getHouse(x) == false)
        {
            player1House[x] = true;
            setProperty(-(houseLevel[x] * 100));
        }
    }

    public boolean getHouse(int x)
    {
        return player1House[x];
    }

    public void rent(Player2 player, int pos)
    {
        if(pos == 1)
        {
            if(player.getHouse(0) == true)
            {
                setProperty(-(houseLevel[0] * 100));
                player.setProperty(houseLevel[0] * 100);
            }
        }

        if(pos == 4)
        {
            if(player.getHouse(1) == true)
            {
                setProperty(-(houseLevel[0] * 100));
                player.setProperty(houseLevel[0] * 100);
            }
        }

        if(pos == 5)
        {
            if(player.getHouse(2) == true)
            {
                setProperty(-(houseLevel[0] * 100));
                player.setProperty(houseLevel[0] * 100);
            }
        }

        if(pos == 6)
        {
            if(player.getHouse(3) == true)
            {
                setProperty(-(houseLevel[0] * 100));
                player.setProperty(houseLevel[0] * 100);
            }
        }

        if(pos == 11)
        {
            if(player.getHouse(4) == true)
            {
                setProperty(-(houseLevel[0] * 100));
                player.setProperty(houseLevel[0] * 100);
            }
        }

        if(pos == 18)
        {
            if(player.getHouse(5) == true)
            {
                setProperty(-(houseLevel[0] * 100));
                player.setProperty(houseLevel[0] * 100);
            }
        }

        if(pos == 22)
        {
            if(player.getHouse(6) == true)
            {
                setProperty(-(houseLevel[0] * 100));
                player.setProperty(houseLevel[0] * 100);
            }
        }

        if(pos == 25)
        {
            if(player.getHouse(7) == true)
            {
                setProperty(-(houseLevel[0] * 100));
                player.setProperty(houseLevel[0] * 100);
            }
        }
    }

    public void show(int r, int g, int b, int pos)
    {
        applet.fill(r,b,g);
        applet.ellipse(allxPos[pos],allyPos[pos],size,size);
    }
}