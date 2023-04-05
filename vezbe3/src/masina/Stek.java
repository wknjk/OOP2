package masina;

public class Stek {
	public Stek(int kapacitet) {
		this.podaci = new int[kapacitet]; 
		this.kapacitet = kapacitet;
		this.trenutnaPopunjenost = 0;
	}
	
	private int kapacitet;
	private int trenutnaPopunjenost;
	private int[] podaci;
	
	
	public int getKapacitet() {
		return kapacitet;
	}
	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}
	
	
	public void dodaj(int broj) {
		if (trenutnaPopunjenost == kapacitet) return;
		podaci[trenutnaPopunjenost++] = broj;
		
		
	};
	public int ukloni() {
		if (trenutnaPopunjenost == 0) return -1000;
		
		return podaci[--trenutnaPopunjenost];
	}
	
	@Override
	public String toString() {
		if (trenutnaPopunjenost == 0) return "[]";
		StringBuilder sb = new StringBuilder();
		sb.append("["+podaci[0]);
		for(int i = 1; i < trenutnaPopunjenost; i++) {
			sb.append(',').append(podaci[i]);
		}
		sb.append("]");
		return sb.toString();
		}
}
