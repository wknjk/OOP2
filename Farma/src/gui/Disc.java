package gui;

import java.awt.Color;
import java.awt.*;

public class Disc extends Figure{
	
	Color color;
	public Disc(Vector pos_vect, Vector move_vect, double r) {
		super(pos_vect,move_vect,r);
		this.color = Color.BLUE;
	}
	public Disc(Vector pos_vect, Vector move_vect) {
		super( pos_vect,  move_vect);
	}
	@Override
	public void paint(Graphics g) {
		
			Color prev_col = g.getColor();
			g.setColor(Color.blue);
			
			
		
			
			int centerX = (int)(pos_vect.getX()-r/2);;
		    int centerY =(int)(pos_vect.getY()-r/2);
		    int radius = (int)getR();

	        int[] xPoints = new int[8];
	        int[] yPoints = new int[8];

	        // Calculate the coordinates of the points on the octagon
	        for (int i = 0; i < 8; i++) {
	            double angle = 2 * Math.PI * i / 8;
	            xPoints[i] = centerX + (int) (radius * Math.cos(angle));
	            yPoints[i] = centerY + (int) (radius * Math.sin(angle));
	        }

	        // Draw the octagon
	        g.fillPolygon(xPoints, yPoints, 8);
			
			
			g.setColor(prev_col);
		}
	
	
		
	}
	
	

