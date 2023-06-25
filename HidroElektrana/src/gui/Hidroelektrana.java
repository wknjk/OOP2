package gui;

import java.awt.Color;

public class Hidroelektrana extends Proizvodjac{
	
	private int count;
	Hidroelektrana( Baterija baterija){
		
		super('H', Color.BLUE, 1500, baterija);
	}
	
	public  void setujCount(int count) {
		this.count = count;
	}
	@Override
	public boolean uspesnaProizvodnja(int count) {
		return count>= 1;
	}
	
	@Override
	public int jediniceEnergije() {
		return count;
	}

	

}