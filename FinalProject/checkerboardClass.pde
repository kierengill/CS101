//Checkerboard class
class Checkerboard {
  
  //Configures the properties of the checkerboard display
  void create()
  {
  
    image(image,0,0,width,height);
  
    strokeWeight(1); 
  
    stroke(10); 
  
    for (int horizontal = 1; horizontal <= 19; horizontal++)
  
      line(X, Y*horizontal, X*19, Y*horizontal); 
  
    for (int vertical = 1; vertical <= 19; vertical++)
  
      line(X*vertical, Y, X*vertical, Y*19); 
  
  
  
    strokeWeight(width/100); 
  
    for (int y = 4; y <=16; y+=6)
  
      for (int x = 4; x <=16; x+=6)
  
        point(x*X, y*Y); 
  
  }




}
