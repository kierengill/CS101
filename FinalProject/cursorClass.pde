//Cursor class
class Cursor{
  
  //Configures the properties of the cursor display
  //Takes (0,1 and 2) as inputs and displays a dot, X, and square respectively
  void create(int mode)
  {
  
    switch(mode)
  
    {
  
    case 0:
  
      stroke(255);
  
      strokeWeight(width/100);
  
      point(x_1, y_1);
  
      break;    
  
    case 1:
  
      stroke(255);
  
      strokeWeight(1);
  
      line(x_1-X/2, y_1-Y/2, x_1+X/2, y_1+Y/2);
  
      line(x_1+X/2, y_1-Y/2, x_1-X/2, y_1+Y/2);
  
      break;
  
    case 2:
  
      stroke(255);
  
      strokeWeight(1);
  
      noFill();
  
      rect(x_1-X/2, y_1-Y/2, X, Y);
  
      break;
  
    }
  
  }

}
