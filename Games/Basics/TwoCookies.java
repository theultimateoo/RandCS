import java.applet.Applet;
import java.awt.*;

public class TwoCookies extends Applet{
  public void paint(Graphics page){
    page.setColor(Color.white);
    page.fillRect(50,50,60,100);// 50-110, 50-150
    
    page.setColor(Color.green); //top cookie
    page.fillOval(65,65,30,30); //diameter 30
    
    page.setColor(Color.black); //bottom cookie
    page.fillOval(65,105,30,30); 
  }
}