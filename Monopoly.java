import processing.core.*;
public class Monopoly extends PApplet
{
    PImage go;
    PImage jail, goToJail;
    PImage chance;
    PImage house1,house2,house3;
    PImage incomeTax;
    PImage gameOver;
    Player1 player1;
    int Dice1, Dice2;
    int pos1 = 0;
    Player2 player2;
    int pos2 = 0;
    int rand;
    int House1 = 0;
    int House2 = 0;
    String event;
    boolean rolled;
    boolean tax;
    boolean jailed1,jailed2;
    int round = 1;
    boolean alreadyBought = false;
    boolean rent1,rent2;
    boolean random1, random2;
    boolean upGraded;
    public static void main(String[] args)
    {
        PApplet.main(new String[] {"Monopoly"});
    }

    public void setup()
    {
        player1 = new Player1(this);
        player2 = new Player2(this);
    }

    public void settings()
    {
        size(1000,700);
        go = loadImage("go.gif");
        jail = loadImage("jail.png");
        goToJail = loadImage("GoToJail.png");
        chance = loadImage("chance.png");
        house1 = loadImage("house1.png");
        house2 = loadImage("house2.png");
        house3 = loadImage("house3.png");
        incomeTax = loadImage("IncomeTax.png");
        gameOver = loadImage("gameover.jpg");
    }

    public void roll1()
    {
        Dice1 = (int)(Math.random() * 6) + 1;
        if(round%2 != 0)
        {
            pos1 += Dice1;
        }

        if (pos1 >= 29)
        {
            pos1 -= 29;
            player1.setProperty(200);
        }
    }

    public void roll2()
    {
        Dice2 = (int)(Math.random() * 6) + 1;
        if(round%2 == 0)
        {
            pos2 += Dice2;
        }

        if (pos2 >= 29)
        {
            pos2 -= 29;
            player2.setProperty(200);
        }
    }

    public void buy(int x, int y)
    {
        if (keyPressed)
        {
            if (key == 'b')
            {
                if(alreadyBought == false && round%2 == 0)
                {
                    if (x == 1)
                    {
                        player1.buyHouse(0,player2); 
                    }
                    if (x == 4)
                    {
                        player1.buyHouse(1,player2);
                    }
                    if (x == 5)
                    {
                        player1.buyHouse(2,player2);
                    }
                    if (x == 8)
                    {
                        player1.buyHouse(3,player2);
                    }
                    if (x == 11)
                    {
                        player1.buyHouse(4,player2);
                    }
                    if (x == 18)
                    {
                        player1.buyHouse(5,player2);
                    }
                    if (x == 22)
                    {
                        player1.buyHouse(6,player2);
                    }
                    if(x == 25)
                    {
                        player1.buyHouse(7,player2);
                    }
                    House1++;
                    upGraded = true;
                }

                if(alreadyBought == false && round%2 != 0)
                {
                    if (y == 1)
                    {
                        player2.buyHouse(0, player1); 
                    }
                    if (y == 4)
                    {
                        player2.buyHouse(1, player1);
                    }
                    if (y == 5)
                    {
                        player2.buyHouse(2, player1);
                    }
                    if (y == 8)
                    {
                        player2.buyHouse(3, player1);
                    }
                    if (y == 11)
                    {
                        player2.buyHouse(4, player1);
                    }
                    if (y == 18)
                    {
                        player2.buyHouse(5, player1);
                    }
                    if (y == 22)
                    {
                        player2.buyHouse(6, player1);
                    }
                    if(y == 25)
                    {
                        player2.buyHouse(7, player1);
                    }
                    House2++;
                    upGraded = true;
                }
                alreadyBought = true;
            }
        }
    }

    public void randomChance1()
    {
        rand = (int)(Math.random() * 13);
        if(pos1 == 3 || pos1 == 14 || pos1 == 15 || pos1 == 19 || pos1 == 29)
        {
            if(rand == 0)
            {
                pos1 -= 1;
                event = "go back 1 step";
            }
            else if(rand == 1)
            {
                pos1 -= 2;
                event = "go back 2 steps";
            }
            else if(rand == 2)
            {
                pos1 -= 3;
                event = "go back 3 steps";
            }
            else if(rand == 3)
            {
                pos1 += 1;
                event = "go forward 1 step";
            }
            else if(rand == 4)
            {
                pos1 += 2;
                event = "go forward 2 steps";
            }
            else if(rand == 5)
            {
                pos1 += 3;
                event = "go forward 3 steps";
            }
            else if(rand == 6)
            {
                player1.setProperty(100);
                event = "add $100";
            }
            else if(rand == 7)
            {
                player1.setProperty(200);
                event = "add $200";
            }
            else if(rand == 8)
            {
                player1.setProperty(300);
                event = "add $300";
            }
            else if(rand == 9)
            {
                player1.setProperty(-100);
                event = "lost $100";
            }
            else if(rand == 10)
            {
                player1.setProperty(-200);
                event = "lost $200";
            }
            else if(rand == 11)
            {
                player1.setProperty(-300);
                event = "lost $300";
            }
            else if(rand == 12)
            {
                pos1 = 9;
                player1.setProperty(-400);
                event = "go in jail and lost $400";
            }
        }
    }

    public void randomChance2()
    {
        rand = (int)(Math.random() * 13);
        if(pos2 == 3 || pos2 == 14 || pos2 == 15 || pos2 == 19 || pos2 == 29)
        {
            if(rand == 0)
            {
                pos2 -= 1;
                event = "go back 1 step";
            }
            else if(rand == 1)
            {
                pos2 -= 2;
                event = "go back 2 steps";
            }
            else if(rand == 2)
            {
                pos2 -= 3;
                event = "go back 3 steps";
            }
            else if(rand == 3)
            {
                pos2 += 1;
                event = "go forward 1 step";
            }
            else if(rand == 4)
            {
                pos2 += 2;
                event = "go forward 2 steps";
            }
            else if(rand == 5)
            {
                pos2 += 3;
                event = "go forward 3 steps";
            }
            else if(rand == 6)
            {
                player2.setProperty(100);
                event = "add $100";
            }
            else if(rand == 7)
            {
                player2.setProperty(200);
                event = "add $200";
            }
            else if(rand == 8)
            {
                player2.setProperty(300);
                event = "add $300";
            }
            else if(rand == 9)
            {
                player2.setProperty(-100);
                event = "lost $100";
            }
            else if(rand == 10)
            {
                player2.setProperty(-200);
                event = "lost $200";
            }
            else if(rand == 11)
            {
                player2.setProperty(-300);
                event = "lost $300";
            }
            else if(rand == 12)
            {
                pos2 = 9;
                player2.setProperty(-400);
                event = "go in jail and lost $400";
            }
        }
    }
    
    public void gameOver()
    {
        if (round != 1)
        {
            if (player1.getProperty() == 0 || player2.getProperty() == 0)
            {
                Dice1 = 0;
                Dice2 = 0;
                image(gameOver,200,200,512,288);
            }
        }
    }

    public void draw()
    {
        background(0);
        stroke(255);
        line(0,100,1000,100);
        line(0,600,1000,600);
        line(100,0,100,700);
        line(900,0,900,700);
        for (int horizontal = 200; horizontal < 600; horizontal+=100)
        {
            line(0,horizontal,100,horizontal);
            line(900,horizontal,1000,horizontal);
        }
        for (int vertical = 200; vertical < 900; vertical+=100)
        {
            line(vertical,0,vertical,100);
            line(vertical,600,vertical,700);
        }

        //GO
        image(go,0,600,100,100);

        //Jail and Go to jail
        image(jail,900,600,100,100);
        image(goToJail,0,0,100,100);

        //chance
        image(chance,900,0,100,100);
        image(chance,300,600,100,100);
        image(chance,900,100,100,100);
        image(chance,500,0,100,100);
        image(chance,0,500,100,100);

        //tax
        image(incomeTax,200,600,100,100);
        image(incomeTax,900,500,100,100);
        image(incomeTax,400,0,100,100);
        image(incomeTax,0,300,100,100);

        if (keyPressed)
        {
            if (key == 'r')
            {
                if(rolled == false && round%2 != 0)
                {
                    roll1();
                    rolled = true;
                    alreadyBought = false;
                    rent1 = false;
                    random1 = false;
                    upGraded = false;
                    tax = false;
                    event = "";
                    round++;
                }
            }
            if (key == 't')
            {
                if (rolled == false && round%2 == 0)
                {
                    roll2();
                    rolled = true;
                    alreadyBought = false;
                    rent2 = false;
                    random2 = false;
                    upGraded = false;
                    tax = false;
                    event = "";
                    round++;
                }
            }
            rolled = false;
        }

        //player info
        line(200, 150, 800, 150);
        line(200, 150, 200, 350);
        line(800, 150, 800, 350);
        line(200, 350, 800, 350);
        line(500, 150, 500, 350);
        textSize(32);
        fill(255, 255, 255);
        text(" Player1", 200, 190);
        int money1 = player1.getProperty();
        text(" Property: $" + money1 , 200, 250);
        text(" House: " + House1, 200, 310);
        text(" Player2", 500, 190);
        int money2 = player2.getProperty();
        text(" Property: $" + money2, 500, 250);
        text(" House: " + House2, 500, 310);

        //dice
        line(200, 500, 350, 500);
        line(200, 500, 200, 550);
        line(350, 500, 350, 550);
        line(200, 550, 350, 550);
        textSize(25);
        if (round%2 == 0)
        {
            text(" Dice: " + Dice1, 200, 530);
        }
        else if (round%2 != 0)
        {
            text(" Dice: " + Dice2, 200, 530);
        }
        
        //Random chance
        line(200, 400, 200, 450);
        line(200, 400, 800, 400);
        line(200, 450, 800, 450);
        line(800, 400, 800, 450);
        text(" Random chance: " + event, 200, 430);
        
        //round
        text("Round: " + round, 500,530);

        //rent
        if(rent1 == false)
        {
            player1.rent(player2, pos1);
            rent1 = true;
        }
        if(rent2 == false)
        {
            player2.rent(player1,pos2);
            rent2 = true;
        }

        //incomeTax
        if (tax == false)
        {
            if (round % 2 == 0)
            {
                player1.incomeTax(pos1);
                tax = true;
            }
            if (round % 2 != 0)
            {
                player2.incomeTax(pos2);
                tax = true;
            }
        }
        
        //jail
        if(pos1 == 24)
        {
            pos1 = 9;
            player1.setProperty(-400);
        }
        if(pos2 == 24)
        {
            pos2 = 9;
            player2.setProperty(-400);
        }

        //randomChance
        if(random1 == false)
        {
            randomChance1();
            random1 = true;
        }
        if(random2 == false)
        {
            randomChance2();
            random2 = true;
        }

        //dice
        line(200, 500, 350, 500);
        line(200, 500, 200, 550);
        line(350, 500, 350, 550);
        line(200, 550, 350, 550);
        textSize(25);

        buy(pos1,pos2);
        
        for (int i = 0; i < 8; i++)
        {
            if(player1.getHouse(i) == true)
            {
                stroke(255,204,0);
                if(i == 0)
                {
                    line(100,600,200,600);
                }
                if(i == 1)
                {
                    line(400,600,500,600);
                }
                if(i == 2)
                {
                    line(500,600,600,600);
                }
                if(i == 3)
                {
                    line(800,600,900,600);
                }
                if(i == 4)
                {
                    line(900,400,900,500);
                }
                if(i == 5)
                {
                    line(600,100,700,100);
                }
                if(i == 6)
                {
                    line(200,100,300,100);
                }
                if(i == 7)
                {
                    line(100,100,100,200);
                }
            } 

            if(player2.getHouse(i) == true)
            {
                stroke(48,139,206);
                if(i == 0)
                {
                    line(100,600,200,600);
                }
                if(i == 1)
                {
                    line(400,600,500,600);
                }
                if(i == 2)
                {
                    line(500,600,600,600);
                }
                if(i == 3)
                {
                    line(800,600,900,600);
                }
                if(i == 4)
                {
                    line(900,400,900,500);
                }
                if(i == 5)
                {
                    line(600,100,700,100);
                }
                if(i == 6)
                {
                    line(200,100,300,100);
                }
                if(i == 7)
                {
                    line(100,100,100,200);
                }
            } 
        }
        
        //houses
        if(player1.getHouseLevel(0) == 1)
        {
            image(house1,120,610,55,84);
        }
        else if(player1.getHouseLevel(0) == 2)
        {
            image(house2,120,610,55,84);
        }
        else if(player1.getHouseLevel(0) == 3)
        {
            image(house3,120,610,55,84);
        }

        if(player1.getHouseLevel(1) == 2)
        {
            image(house2,420,610,55,84);
        }
        else if(player1.getHouseLevel(1) == 3)
        {
            image(house3,420,610,55,84);
        }

        if(player1.getHouseLevel(2) == 1)
        {
            image(house1,820,610,55,84);
        }
        else if(player1.getHouseLevel(2) == 2)
        {
            image(house2,820,610,55,84);
        }
        else if(player1.getHouseLevel(2) == 3)
        {
            image(house3,820,610,55,84);
        }

        if(player1.getHouseLevel(3) == 1)
        {
            image(house1,920,410,55,84);
        }
        else if(player1.getHouseLevel(3) == 2)
        {
            image(house2,920,410,55,84);
        }
        else if(player1.getHouseLevel(3) == 3)
        {
            image(house3,920,410,55,84);
        }

        if(player1.getHouseLevel(4) == 2)
        {
            image(house2,620,10,55,84);
        }
        else if(player1.getHouseLevel(4) == 3)
        {
            image(house3,620,10,55,84);
        }

        if(player1.getHouseLevel(5) == 1)
        {
            image(house1,220,10,55,84);
        }
        else if(player1.getHouseLevel(5) == 2)
        {
            image(house2,220,10,55,84);
        }
        else if(player1.getHouseLevel(5) == 3)
        {
            image(house3,220,10,55,84);
        }

        if(player1.getHouseLevel(6) == 1)
        {
            image(house1,20,110,55,84);
        }
        else if(player1.getHouseLevel(6) == 2)
        {
            image(house2,20,110,55,84);
        }
        else if(player1.getHouseLevel(6) == 3)
        {
            image(house3,20,110,55,84);
        }

        if(player1.getHouseLevel(7) == 1)
        {
            image(house1,520,610,55,84);
        }
        else if(player1.getHouseLevel(7) == 2)
        {
            image(house2,520,610,55,84);
        }
        else if(player1.getHouseLevel(7) == 3)
        {
            image(house3,520,610,55,84);
        }
        
        //player
        player1.show(255,204,0,pos1);
        player2.show(48,139,206,pos2);
        
        gameOver();
    }
}