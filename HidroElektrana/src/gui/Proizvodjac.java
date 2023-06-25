package gui;

import java.awt.Color;

public abstract class Proizvodjac extends Parcela implements Runnable{
	private int osnovnoVreme;
	private Baterija baterija;
	private Thread nit_proizvodjaca;
	Proizvodjac(char oznaka, Color boja, int osnovnoVreme, Baterija baterija){
		super(oznaka, boja);
		this.osnovnoVreme = osnovnoVreme;
		this.baterija = baterija;
		
		nit_proizvodjaca = new Thread(this); // jer smem da mu posaljem neku runnable klasu/interfejs je l
		nit_proizvodjaca.start();
	}
	
	private int ukupnoVreme() {
		
		return osnovnoVreme + (int)(Math.random()*300);
	}
	
	

	public abstract boolean uspesnaProizvodnja(int count);
	
	public abstract int jediniceEnergije();
	
	public abstract void setujCount(int count);
		

	@Override
	public void run() {
		// napuni bateriju za toliko
		
		// spavaj ovoliko
		Color prvaBoja = getForeground();
		try {
		while (!Thread.interrupted()) {
			
				Thread.sleep(ukupnoVreme());
				System.out.println(jediniceEnergije()); // da ja vidim koliko mi ispisuje!
				
				if (uspesnaProizvodnja(jediniceEnergije())) {
					baterija.dodaj(jediniceEnergije());
					setForeground(Color.RED);
					
				}
				Thread.sleep(300);
				// Reset color
				setForeground(prvaBoja);
		}
			} catch (InterruptedException e) {				
			}
			
		
		// budi crven ovoliko
		
	}
	
	public void zavrsi() {
		if (nit_proizvodjaca == null) {
			return;
		}
		nit_proizvodjaca.interrupt();
		
		try {
			nit_proizvodjaca.join();
			nit_proizvodjaca = null;
		} catch (InterruptedException e) {
			
		}
		
	}
	
}
