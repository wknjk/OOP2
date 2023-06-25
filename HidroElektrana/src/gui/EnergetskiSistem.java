package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EnergetskiSistem extends Frame{

	Plac plac;
	Baterija baterija;
	//Button dugme; mislim da mi ipak ne treba da bude globalna!
	public EnergetskiSistem(int redovi, int kolone, int kapacitetBaterije) {
		setSize(500,500);
		setResizable(false);
		
		baterija = new Baterija(kapacitetBaterije);
		plac = new Plac(redovi, kolone);
		
		namesti();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e){
				plac.stopirajSveProizvodjace();
				dispose();
				
			}
			});
		
		setVisible(true); // je l ovo ze i na pocetku?
	}
	
	private void namesti() {
		
		Panel panel = new Panel();
		Button dugme = new Button("Dodaj");
	
		dugme.addActionListener((ae) -> {		
				Proizvodjac proizvodjac = new Hidroelektrana(baterija);
				plac.dodaj(proizvodjac);
				
			}
		);
		
		
		panel.add(dugme);
		add(panel,BorderLayout.NORTH);
		add(plac);
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		new EnergetskiSistem(5, 5, 100);
	}
	
	
}
