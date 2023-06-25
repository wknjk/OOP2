package gui;
import java.awt.*;
public class BrownField extends Field {
	static final Color Brown = new Color (139, 69, 19);
	public BrownField(FarmField farmField) {
		super(Brown, farmField);
	}
}
