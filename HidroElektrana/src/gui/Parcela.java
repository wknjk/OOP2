package gui;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Parcela extends Label{

	char oznaka;
	Color boja_pozadine;
	
	private static final Color boja_fonta = Color.WHITE;
	private static final Font SERIF_14 = new Font("Serif", Font.BOLD, 14);

	
	Parcela(char oznaka, Color pozadina){
		this.oznaka = oznaka;
		this.boja_pozadine = pozadina;
		this.setFont(SERIF_14);
		this.setForeground(boja_fonta);
		this.setBackground(pozadina);
		this.setText(String.valueOf(oznaka));
		this.setAlignment(Label.CENTER);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 Container parent =  getParent();
				 if (parent instanceof Plac) {
					 Plac plac = (Plac) parent;
					 plac.promeniSelekciju(Parcela.this); //da li moze samo this?
				 }
				
			}
			
		});
		
		
	}
	
	public void promeni_pozadinu(Color nova_pozadina) {
		this.boja_pozadine = nova_pozadina;
	}
	
	
	
}
