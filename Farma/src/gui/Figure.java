package gui;
import java.awt.*;
public abstract class Figure {

	protected Vector pos_vect;
	protected Vector move_vect;
	protected double r;
	Color color;
	
	Figure(Vector pos_vect, Vector move_vect, double r){ // dodaj defoult za r!!
		
		this.move_vect = move_vect;
		this.pos_vect = pos_vect;
		this.r = r;
	}
	Figure(Vector pos_vect, Vector move_vect){
		this(pos_vect,move_vect,20);
	}
	
	public Vector getPos_vect() {
		return pos_vect;
	}
	public void setPos_vect(Vector pos_vect) {
		this.pos_vect = pos_vect;
	}
	public Vector getMove_vect() {
		return move_vect;
	}
	public void setMove_vect(Vector move_vect) {
		this.move_vect = move_vect;
	}
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	
	public boolean vector_figure_overlap(Vector vector) {
		double dist = Math.sqrt(Math.pow((this.pos_vect.getX() - vector.getX()), 2)+ Math.pow(this.pos_vect.getY() - vector.getY(), 2));
		return dist <= r;
		
	}
	public boolean figure_figure_overlap(Figure fig) {
		double dist = Math.sqrt(Math.pow((this.pos_vect.getX() - fig.getPos_vect().getX()), 2)+ Math.pow(this.pos_vect.getY() - fig.getPos_vect().getY(), 2));
		return dist <= (r+fig.getR());
	}
	
	public Color getColor() {
		return color;
	}
	
	public abstract void paint(Graphics g);
	
	public void move(int step) {
		pos_vect.setX(pos_vect.getX() + step*move_vect.getX());
		pos_vect.setY(pos_vect.getY() + step*move_vect.getY());
	}
	/// da li cu ovde sta jos
}
