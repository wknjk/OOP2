package gui;
import java.awt.*;
import java.util.ArrayList;
public class Plac extends Panel {

	int redovi;
	int kolone;
	
	ArrayList<Parcela> sve_parcele = new ArrayList<>();;
	ArrayList<Proizvodjac> svi_proizvodjaci = new ArrayList<>();;
	Parcela selektovana_parcela = null;
	
	
	
	public Plac(int redovi, int kolone){
		super(new GridLayout(redovi, kolone, 5,5));
		this.redovi = redovi;
		this.kolone = kolone;
		inicijalizacija();
	}
	private void inicijalizacija() {		
			for (int i = 0 ; i< this.redovi*this.kolone; i++) {
				// napravi random
				Parcela parcela = Math.random() <= 0.7 ? new TravnataPovrs() : new VodenaPovrs();
				// dodaj u listu
				sve_parcele.add(parcela);			
				//dodaj na grid!
				add(parcela);				
			}
			
		}
	
	public void promeniSelekciju(Parcela nova_parcela) {
		if (!sve_parcele.contains(nova_parcela)) return;
		if (selektovana_parcela != null ) promeniFont(selektovana_parcela, 14);
		
		selektovana_parcela = nova_parcela;
		promeniFont(selektovana_parcela,20);
		
		
	}
	private void promeniFont(Parcela parcela, int velicina_fonta) {
		Font stari_font = parcela.getFont();
		Font novi_font = stari_font.deriveFont(velicina_fonta);
		parcela.setFont(novi_font);
		}
	
	
	public void dodaj(Proizvodjac proizvodjac) {
		if (selektovana_parcela == null) {
			proizvodjac.zavrsi();
			return;
		}
		if (selektovana_parcela instanceof Proizvodjac) {
			((Proizvodjac) selektovana_parcela).zavrsi();
			svi_proizvodjaci.remove(selektovana_parcela);
			
		}
		int indeks = sve_parcele.indexOf(selektovana_parcela);
		sve_parcele.set(indeks, proizvodjac);
		svi_proizvodjaci.add(proizvodjac);
		
		remove(indeks);
		add(proizvodjac,indeks);
		revalidate();
		
		promeniSelekciju(proizvodjac);
		
		promeniPotrosnju();
	
	}
	
	private void promeniPotrosnju() {
		for (Proizvodjac proizvodjac : svi_proizvodjaci) {
			int brojac_opkruzujucih = 0;
			int indeks_proizvodjaca = sve_parcele.indexOf(proizvodjac);
			int red = indeks_proizvodjaca / this.kolone;
			int kol = indeks_proizvodjaca % this.kolone;
			
			for (int i = red - 1; i< red + 2; i ++ ) 
				for (int j = kol - 1; j< kol + 2; j ++ ) {
					if (i < 0 || i >=redovi || j < 0 || j >= redovi) continue; 
						
					
					int indeks_parcele = i*kolone+j;
					if (indeks_parcele >= kolone*redovi) continue;
					Parcela parcela = sve_parcele.get(indeks_parcele);
					if (parcela instanceof VodenaPovrs)
						brojac_opkruzujucih ++;
					
				}
			proizvodjac.setujCount(brojac_opkruzujucih);
		}
	}
	
	public void stopirajSveProizvodjace() {
		for (Proizvodjac proizvodjac: svi_proizvodjaci)
			proizvodjac.zavrsi();
	}
	
}
		
	
