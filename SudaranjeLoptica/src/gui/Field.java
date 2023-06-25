package gui;
import java.awt.*;
import java.awt.event.*;
public class Field extends Canvas{
	private Color bgColor;
	private FarmField farmField;
	private boolean is_selected;
	private boolean have_acter;
	private ActiveActer active_acter;
	
	public Field() {};
	// ####### konstruktor
	public Field(Color color, FarmField farmField) {
		setFocusable(false);
		bgColor = color;
		this.farmField = farmField;
		
		//active_acter = new Chicken(3,3);
	
		
		
		
		
		
	}
	public void rect(boolean is_rect) {
		is_selected = is_rect;
		repaint();
	}
	
	
//	public boolean isSelected(boolean selected) {
//		return selected;
//		
//	}
	
//	
	public void paint(Graphics g){
		
		
		
//		 int sirina=getWidth(),visina=getHeight();
//		 g.setColor(bgColor);
//		 g.fillRect(0, 0, sirina, visina);
//		 
//		 if (is_selected) {
//			 g.setColor(Color.RED);
//			 g.drawRect((int)0.1*sirina, (int)0.1*visina, (int)(sirina*0.8), (int)(visina*0.8));
//			 
//			 
//		 }
//		 int width = getWidth();
//		 int height = getHeight();
//		 if (have_acter) {
//			 active_acter.paint(this.getGraphics(), width, height);
//		 }
		
		int width = getWidth();
	    int height = getHeight();
	    int rectWidth = (int) (width * 0.8);
	    int rectHeight = (int) (height * 0.8);
	    int rectX = (width - rectWidth) / 2;
	    int rectY = (height - rectHeight) / 2;

	    g.setColor(bgColor);
	    g.fillRect(0, 0, width, height);

	    if (is_selected) {
	        g.setColor(Color.RED);
	        g.drawRect(rectX, rectY, rectWidth, rectHeight);
	    }

	    if (have_acter) {
	        active_acter.paint(this.getGraphics(), width, height);
	    }

		 
		}
	
	public synchronized void add_acter(ActiveActer acter) throws doubleActerException{
		if (have_acter) throw new doubleActerException();
		
		have_acter = true;
		active_acter = acter;
		//active_acter.initialize(); pusi kuku
		repaint();
		return;
	}

	public synchronized void remove_acter() throws noActerException{
		if (!have_acter) throw new noActerException();
		
		have_acter = false;
		active_acter = null;
		repaint();
		return;
				
	}
	
	public ActiveActer get_acter() throws noActerException{
		if (!have_acter) throw new noActerException();
		return active_acter;
	}
	
	public boolean haveActer() {
		return have_acter;
	}
	
	
	
	
//	public static void main(String[] args) {
//		Field f = new Field();
//		
//	}
	
	
}
