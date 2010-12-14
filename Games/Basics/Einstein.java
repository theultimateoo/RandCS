//From Java Software Solutions for AP Computer Science page 101

import java.applet.Applet;//Applet class from applet package
import java.awt.*;//Graphics capabilities from awt package

public class Einstein extends Applet{
  public void paint(Graphics page){
    page.drawRect(50,50,40,40);
    page.drawRect(60,80,225,30);
    page.drawOval(75,65,20,20);
    page.drawLine(35,60,100,120);
    page.drawString("out of clutter, find simplicity.",110,70);
    page.drawString("--Albert Einstein",130,100);
  }
}