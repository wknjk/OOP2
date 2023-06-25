package gui;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;	
import java.awt.event.WindowListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class FarmSimulation extends Frame{

	FarmField farmField;
	int money_value; 
	public FarmSimulation(int rows, int columns) {
		farmField = new FarmField(rows, columns);
		
		setSize(500,500);
		
		populateWindow();
		setVisible(true);
		
	}
	private void populateWindow() {
		
		Panel console = new Panel();
		Button chickenBuying = new Button("Kokoska(300)");
		chickenBuying.setForeground(Color.red);
		chickenBuying.setFocusable(false);
		money_value = 2000;
		Label money = new Label("Novac: "+money_value);
		
		chickenBuying.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chicken chicken = new Chicken(500, 1000);
				try {
				farmField.add_acter(chicken);
				money_value -= 300;
				
				money.setText("Novac: "+ money_value);
				}
				
			catch(doubleActerException exception ) {
				chicken.finish();
				System.out.println(exception.getMessage());
			
			}	
				if (money_value<300) chickenBuying.setEnabled(false);
			}
		});
		money.setFocusable(false);// treba da mozes da menjas to alo! 
		console.setLayout(new GridLayout(2,1));
		
		console.add(money);
		console.add(chickenBuying);
	    console.setFocusable(false); 

        add(farmField, BorderLayout.CENTER);
        add(console, BorderLayout.EAST);
	    requestFocus();
	   

	    addKeyListener(new KeyAdapter() {
	        @Override
		    public void keyPressed(KeyEvent e) {
		        int keyCode = e.getKeyCode();

		        switch (keyCode) {
		            case KeyEvent.VK_UP:
		                // Handle up arrow key pressed
		            	farmField.moveSelection(1);
		                break;
		            case KeyEvent.VK_DOWN:
		            	
		                // Handle down arrow key pressed
		            	farmField.moveSelection(3);
		                break;
		            case KeyEvent.VK_LEFT:
		            	farmField.moveSelection(4);
		                break;
		            case KeyEvent.VK_RIGHT:
		            	farmField.moveSelection(2);
		                break;
		            default:
		                // Handle other keys if needed
		                break;
		        }
		    }});
		
	
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				farmField.finish_all();
				dispose();
			}
		});

	}
	
	public static void main(String[] args) {
		FarmSimulation sim = new FarmSimulation(5, 5);
	}
}
