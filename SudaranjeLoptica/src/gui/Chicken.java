package gui;

import java.awt.Color;
import java.awt.Graphics;

public class Chicken extends ActiveActer{
	
	Color color = Color.WHITE;
	FarmField farm_field;
	Field field;
	Thread thread;
	public Chicken(int min, int max) {
		super(Color.WHITE,min,max);
		
		
	}

	@Override
	public void paint(Graphics g,int x, int y) {
//		Color prev_color = g.getColor();
//		int centar_x = x/3;
//		int centar_y = y/3;
//		int size_big = x/2;
//		int size_small = x/4;
//		g.setColor(color);
//		g.fillOval(centar_x, centar_y , size_big, size_big);
//		g.setColor(Color.RED);
//		g.fillOval(centar_x, centar_y , size_small, size_small);
//		g.setColor(prev_color);
		 Color prev_color = g.getColor();
		
		    int center_x = x / 2;
		    int center_y = y / 2;
		    int size_big = Math.min(x, y) * 2 / 3;
		    int size_small = size_big / 2;

		    g.setColor(color);
		    int bigCircleX = center_x - size_big / 2;
		    int bigCircleY = center_y - size_big / 2;
		    g.fillOval(bigCircleX, bigCircleY, size_big, size_big);

		    g.setColor(Color.RED);
		    int smallCircleX = center_x - size_small / 2;
		    int smallCircleY = center_y - size_small / 2;
		    g.fillOval(smallCircleX, smallCircleY, size_small, size_small);

		    g.setColor(prev_color);
	}

	public void add_field(Field field) {
		this.field = field;
		
	}
	public void add_farm_field(FarmField farm_field) {
		this.farm_field = farm_field;
	}
	
	
	@Override
	public void run() {
		//cekanje
		try {
			while (!Thread.interrupted()) {
			wait_time();
			farm_field.doWork(field);


			
			}
		} catch (InterruptedException e) {
			
		}
		
		
		
	}
	
	
	
	
}
