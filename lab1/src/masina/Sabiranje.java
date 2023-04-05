package masina;

public class Sabiranje implements Operacija {

	@Override
	public void izvrsi(Stek stek) {
		int broj1 = stek.ukloni();
		if (broj1 == -1000) return;
		int broj2 = stek.ukloni();
		if (broj2 == -1000) return;

		stek.dodaj(broj1 + broj2);

	}

}
