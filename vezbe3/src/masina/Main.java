package masina;

public class Main {

	public static void main(String[] args) {
		Stek stek = new Stek(3);
		stek.dodaj(10);
		System.out.println("Uklonjena vrednost je: " + stek.ukloni());
		Operacija[] operacije = { new Dodavanje(5), new Dodavanje(-7), new Sabiranje() };
		for(Operacija operacija : operacije) {
			
			operacija.izvrsi(stek);
			System.out.println(stek);
		}
	}
}

