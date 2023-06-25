package gui;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Simulation extends Frame{

	Scene scene;
	public Simulation() {
		setSize(500,500);
		scene = new Scene(this);
		
		add(scene, BorderLayout.CENTER);
		
		populateWindow();
		setVisible(true);
		
	}
	
	public void populateWindow() {
	
		
		addWindowListener(new WindowAdapter() {//
			@Override
			public void windowClosing(WindowEvent e) {
				scene.finish_scene();
				dispose();
			}
		});
		
		scene.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if ( e.getButton() == MouseEvent.BUTTON1) {
		            scene.add_figure(e.getX(), e.getY());;
		            System.out.println("levo dugme pritisnuto");
						super.mouseClicked(e);
				
			}
		}});
		      
		scene.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				
				switch(keyCode) {
					case KeyEvent.VK_SPACE:
						scene.space_clicked();
						System.out.println("space pritisnut");
						//scene.space_clicked();
						
						break;
					case KeyEvent.VK_ESCAPE:
						scene.finish_scene();
						System.out.println("esc pritisnuto");
						//scene.finish_scene();
						break;
					}
				}
			
			});
		}
		
	
	public static void main(String[] args) {
		Simulation simulation = new Simulation();
	}
}