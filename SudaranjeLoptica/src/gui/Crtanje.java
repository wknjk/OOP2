package gui;
import java.awt.*; import java.awt.event.*;
public class Crtanje extends Frame{
private class Platno extends Canvas{
public void paint(Graphics g){
 int sirina=getWidth(),visina=getHeight();
 
 g.setColor(Color.RED);
 
 // Fill the entire canvas with the color
 g.fillRect(0, 0, getWidth(), getHeight());
 
 g.drawLine(0, 0, sirina-1, visina-1);
 g.translate(sirina-1-sirina/3, 0);
 g.setColor(Color.RED);g.fillRect(0, 0, sirina/3, visina/3);
 g.setColor(Color.GREEN);g.drawRect(0, 0,sirina/3, visina/3);
 g.translate(-sirina+1+sirina/3, visina-1-visina/3);
 g.setColor(Color.YELLOW); g.fillOval(0, 0, sirina/3,
visina/3);
 g.setColor(Color.BLUE); g.drawOval(0,0, sirina/3, visina/3);
}
}
public Crtanje(){
super("Crtanje"); add(new Platno()); 
setVisible(true);
setSize(500,500);
}
public static void main(String[] args){ new Crtanje(); }
}