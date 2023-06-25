package gui;

public class Baterija {

	private int trenutna_energija;
	private int kapacitet;
	
	Baterija(int kapacitet){
		this.kapacitet = kapacitet;
		trenutna_energija = this.kapacitet;
	}
	
	public synchronized void dodaj(int kolicina) {
		this.trenutna_energija += kolicina;
		if (this.trenutna_energija > kapacitet) this.trenutna_energija = kapacitet;
	}
	
	public synchronized boolean punaBaterija() {
		return (trenutna_energija == kapacitet);
	}
	
	public synchronized void isprazni() {
		this.trenutna_energija = 0;
		
		
	}
		
}