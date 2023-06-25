package gui;

import java.awt.*;
import java.util.ArrayList;

public class Scene extends Canvas implements Runnable{

	long time_wait = 100; //ms
	int pixel_move = 3;
	boolean working;
	Thread thread;
	Disc disk;
	ArrayList<Figure> all_figures = new ArrayList<>();
	Scene(Simulation s){
		setBackground(Color.GRAY);
		working = false;
		setVisible(true);
		
		this.thread = new Thread(this);
		thread.start();
		
		
	}
	
	@Override
	public void paint(Graphics g) {
		if (!working) {
			System.out.println("pauza jee");
			g.setFont(new Font("Times New Roman", Font.BOLD, 40));
			g.drawString("PAUZA", getWidth()/2-70, getHeight()/2);
		}
		
		for (Figure figure : all_figures)
			figure.paint(getGraphics());
		
		
	}
	public  void space_clicked() {
		if (working == false) { //ako nije radila
			working = true; //neka radi
			start_scene();
		}
		
		else { //ako jeste radila
			working = false; //nek ne radi
			//pause_scene();
		}
		}
	
	
	private synchronized void start_scene() {
		    
		        working = true;
		        this.notify();
		        System.out.println("start scene");
		    
	}
//	private synchronized void pause_scene() {
//		
//		        System.out.println("pause scene"+working);
//		        
//	        try {
//	            while (!working) {
//	            	System.out.println("ceka");
//	            	this.wait();
//	           
//	            }
//	       	
//	        }	
//	        catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
//		 
//		    
//		
//	}
	@Override
	public void run() {
		
		try {	
			while(!thread.isInterrupted()) {
				synchronized (this) {
					while(!working) {
						repaint();
						wait();
						
					}
				}
				
			///	System.out.println("woking"+ working);
				
				if (working)	// ja msm da ja zelim da sihronizujem working??? al onda nece moci niko drugi da mu pristupi!	
					move();
					repaint();			
					thread.sleep(time_wait);
				
		}
		} catch (InterruptedException e) {
			
		}
		
		
	}
	public void finish_scene() {
		if (thread== null) return;
		thread.interrupt();
		
		try {
			thread.join();
			thread = null;	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void add_figure(int x, int y) {
		if (working) return;
		Disc figure1 = new Disc(new Vector(x,y), Vector.randomVector());
		for (Figure figure: all_figures)
			if (figure1.figure_figure_overlap(figure))
				return;
		
		
		
		if (figure1.vector_figure_overlap(new Vector(figure1.getPos_vect().getX(),0))) return;
		if (figure1.vector_figure_overlap(new Vector(figure1.getPos_vect().getX(),this.getHeight()))) return;
		if (figure1.vector_figure_overlap(new Vector(this.getWidth(),figure1.getPos_vect().getY()))) return;
		if (figure1.vector_figure_overlap(new Vector(0,figure1.getPos_vect().getY()))) return;
		
		
		
		all_figures.add(figure1);
		repaint();
		
	}
	
	public boolean is_working() {
		return working;
	}

	private void move() {
		for(int i = 0; i<all_figures.size();i++) {
			Figure figure = all_figures.get(i);
			Vector pos_vect = figure.getPos_vect();
			
			
			wall_collision(figure);
			for (int j = i+1; j<all_figures.size();j++) {
				Figure figure2 = all_figures.get(j);
				
				if (figure.figure_figure_overlap(figure2)) {
					
					Vector mov_vect_1 = figure.getMove_vect();
					figure.setMove_vect(figure2.getMove_vect());
					figure2.setMove_vect(mov_vect_1);
					
					
				
				}
				
			}
			
		}
		for (Figure figure: all_figures) {
			figure.move(pixel_move);
		}
		
	}
	private void wall_collision(Figure figure) {
		
		Vector move_vect = figure.move_vect;
		double move_vect_x = move_vect.getX();
		double move_vect_y = move_vect.getY();
		if (figure.vector_figure_overlap(new Vector(figure.getPos_vect().getX(),0))){
			if (move_vect_y<0)
				figure.setMove_vect(new Vector(move_vect_x, -move_vect_y));
		}
		if(figure.vector_figure_overlap(new Vector(figure.getPos_vect().getX(),this.getHeight()))) {
			//figure.setPos_vect(new Vector(figure.getR(),figure.getPos_vect().getY())); // da ga vrati tako da ne udara ukoliko oce da me udari! mnogo komplikacije!!
			if (move_vect_y>0)
				figure.setMove_vect(new Vector(move_vect_x, -move_vect_y));
		
			
		}
		if (figure.vector_figure_overlap(new Vector(0,figure.getPos_vect().getY()))) {
			if(move_vect_x<0)
			figure.setMove_vect(new Vector(-move_vect_x, move_vect_y));
		}
		if(figure.vector_figure_overlap(new Vector(this.getWidth(),figure.getPos_vect().getY()))) {
			if(move_vect_x>0)
			figure.setMove_vect(new Vector(-move_vect_x, move_vect_y));
			
		}
		
		
	}
	
}
