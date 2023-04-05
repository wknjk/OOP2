package masina;

public class Dodavanje implements Operacija {

	private int broj;
	
	@Override
	public void izvrsi(Stek stek) {
		
		stek.dodaj(broj);
	}
	
	public Dodavanje(int broj) {
		this.broj = broj;
	}
}
