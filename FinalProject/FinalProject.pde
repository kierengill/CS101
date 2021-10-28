import processing.sound.*;

//Initilaizing variables
SoundFile file;
PImage image; 
Checkerboard board1;
Cursor cursor1;
int X, Y, x_1, y_1, s;

//The board is the game board
int board[][] = {

{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 

{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 

{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 

{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 

{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 

{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 

{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 

{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 

{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 

{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 

{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 

{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 

{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 

{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 

{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 

{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 

{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 

{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 

{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};


//Setup defines initial enviroment properties
void setup()

{
  //Standard Sizing and Set Up
  size(800, 800);
  //Create a new instance of the checkerboard class
  board1 = new Checkerboard();
  //Create a new instance of the cursor class
  cursor1 = new Cursor();
  image = loadImage("wood.png");

  X = width/20;

  Y = height/20;

  x_1 = width/2;

  y_1 = height/2;

  //This determines the player's turn, 5 is black and 7 is white
  s = 5;

}


//Main Game Function
void draw()

{
  //Uses the create function of the Checkerboard class
  //This draws the game board
  board1.create();
  
  //Draws the stones on the screen
  stone();
  
  //Uses the create function of the Cursor class
  //Cursor can be customized between options (0, 1 and 2)
  cursor1.create(2);

  //Win or lose conditions
  WoL();

}

//This configures the stones' properties
void stone()

{

  strokeWeight(X*8/10);

  for (int y = 0; y < 19; y++)

  {

    for (int x = 0; x < 19; x++)    

    {

      if (board[y][x] == 5)  

      {

        stroke(0);

        point((x+1)*X, (y+1)*Y);

      }

      else if (board[y][x] == 7)  

      {

        stroke(255);

        point((x+1)*X, (y+1)*Y);

      }

    }

  }

}

//Creating an input function
//This function will be used when the left mouse button is pressed or when the Enter key is pressed
void input()

{
  //This changes the turn from black to white
  if(s == 5 && board[y_1/Y-1][x_1/X-1]==0)

  {

    board[y_1/Y-1][x_1/X-1] = 5;

    s = 7;

  }
  //This changes the turn from white to black
  else if(s == 7 && board[y_1/Y-1][x_1/X-1]==0)

  {

    board[y_1/Y-1][x_1/X-1] = 7;

    s = 5;

  }
  //These loops are to print out the board in the console
  //Looking at the console, you can see where the players placed their stones based on the zeroes, sevens, and fives
  for (int y = 0; y <19; y++)

  {

    for (int x = 0; x <19; x++)

    {

      print(board[y][x]);

      print(" ");

    }

    println("");

  }  

  println("");

}


//End the game
//Input is 0 if black wins and 1 if white wins
void end(int bw)

{
  textSize(width/8);
  
  //Display winning message on screen if black wins
  if(bw == 0)

  {

    fill(0, 200);

    textAlign(CENTER,CENTER);

    text("Black Wins!", width/2, height/2);
    textSize(25);
    fill(0,200);
    text("[PRESS R OR RIGHT-CLICK ANYWHERE TO RESTART THE GAME]", width/2, height/2+100);

  }
  
  //Display winning message on screen if white wins
  else

  {

    fill(255, 200);

    textAlign(CENTER,CENTER);    

    text("White Wins!", width/2, height/2);
    textSize(25);
    fill(255,200);
    text("[PRESS R OR RIGHT-CLICK ANYWHERE TO RESTART THE GAME]", width/2, height/2+100);

  }
  
  //Create a new instance of the soundfile
  file = new SoundFile(this,"TaDa.mp3");
  //Play the soundfile for the winner
  file.play();
  
  //Stops running the draw function, hence it stops updating the screen
  //The draw function will resume when the loop function is called
  noLoop();

}


//Win or lose conditions
//Checks the four possible orientations for any 5 in a row
//Calls the end function accordingly
void WoL()

{

  for (int y = 0; y < 15; y++)

  {

    for (int x = 0; x < 15; x++)

    {

      if (board[y][x]+board[y][x+1]+board[y][x+2]+board[y][x+3]+board[y][x+4] == 25)  end(0);

      else if (board[y][x]+board[y][x+1]+board[y][x+2]+board[y][x+3]+board[y][x+4] == 35) end(1);

    }

  }



  for (int x = 0; x < 15; x++)

  {

    for (int y = 0; y < 15; y++)

    {

      if (board[y][x]+board[y+1][x]+board[y+2][x]+board[y+3][x]+board[y+4][x] == 25)  end(0);

      else if (board[y][x]+board[y+1][x]+board[y+2][x]+board[y+3][x]+board[y+4][x] == 35)  end(1);

    }

  }



  for (int y = 0; y < 15; y++)

  {

    for (int x = 0; x < 15; x++)

    {

      if (board[y][x]+board[y+1][x+1]+board[y+2][x+2]+board[y+3][x+3]+board[y+4][x+4] == 25)  end(0);

      else if (board[y][x]+board[y+1][x+1]+board[y+2][x+2]+board[y+3][x+3]+board[y+4][x+4] == 35)  end(1);  

    }

  }



  for (int y = 0; y < 15; y++)

  {

    for (int x = 0; x < 15; x++)

    {

      if (board[y][x+4]+board[y+1][x+3]+board[y+2][x+2]+board[y+3][x+1]+board[y+4][x] == 25)  end(0);

      else if (board[y][x+4]+board[y+1][x+3]+board[y+2][x+2]+board[y+3][x+1]+board[y+4][x] == 35)  end(1);

    }

  }

}


//Function to reset the game so that it can be replayed
void reset()

{

  for(int y = 0 ; y < 19 ; y++)

    for(int x = 0 ; x < 19 ; x++)

      board[y][x] = 0;

  s = 5;

}


//Manages the keyboard input
void keyPressed()

{
  //Allows use of the arrow keys to move the cursor
  //Enter key to input a stone (calls the input function)
  //R key to reset the game
  switch(keyCode)

  {

  case UP:

    y_1 -= Y;

    break;

  case DOWN:

    y_1 += Y;

    break;

  case LEFT:

    x_1 -= X;

    break;

  case RIGHT:

    x_1 += X;

    break;      

  case 10:

    input();

    break;
    
  case 82:

    reset();
    
    loop();

    break;

  }

}


//Manages mouse input
void mousePressed()

{
  //When left clicked, place a stone (calls the input function)
  if(mouseButton == LEFT)  input();

  //When right clicked, reset the game
  if(mouseButton == RIGHT)

  {

    reset();

    loop();

  }

}



//Configures the display of the movement of the cursor when the mouse is moved
void mouseMoved()

{

  for (int x = 1; x <=19; x++) 

    if (mouseX >= X * x - X/2 && mouseX < X * x + X/2)

      x_1 = X*x;

  for (int y = 1; y <=19; y++) 

    if (mouseY >= Y * y - Y/2 && mouseY < Y * y + Y/2)

      y_1 = Y*y;

}
