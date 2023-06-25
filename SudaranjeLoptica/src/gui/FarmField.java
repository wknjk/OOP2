package gui;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;

public class FarmField extends Panel{
	int rows;
	int columns;
	Field selected_field;
	ArrayList<Field> all_fields = new ArrayList<>();
	ArrayList<Field> fields_with_active_acter = new ArrayList<>();
	public FarmField(int rows, int columns) {
		super(new GridLayout(rows, columns, 5, 5));
		this.rows = rows;
		this.columns = columns;
		initialize();
		setFocusable(false);
	}
		
	private void initialize() {
		 
		for (int i = 0; i < rows*columns; i ++ ) {
			Field new_field = new BrownField(this);
			add(new_field);
			all_fields.add(new_field);}
		this.selected_field = all_fields.get(0);
		this.selected_field.rect(true);	
		}
	
		
	public void add_acter(Chicken acter) throws  doubleActerException{
		
			
			selected_field.add_acter(acter);
			acter.add_field(selected_field);
			acter.add_farm_field(this);
			
		
		
	}
	
	public void remove_acter() {
		try {
			selected_field.remove_acter();
		}
		catch(noActerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private synchronized ArrayList<Field> getSurroundingFields(Field field) {
		BrownField curr_field;
		ArrayList<Field> surroundingFields = new ArrayList<>();
		if (field instanceof BrownField) //zasto tu ne moze odmah da bude BrownField pa stvari????? 
			curr_field = (BrownField) field;
		else return null;
		int index = all_fields.indexOf(curr_field); //i proveri kada stignes da l ovo moze bez casta??
		
		int row = index/ columns;
		int col = index % columns;
		
		for (int i = row - 1; i < row +2; i++)
			for (int j = col - 1; j < col +2; j++) {
				if (i < 0 || i >= rows || j < 0 || j>=columns) continue;
				
				surroundingFields.add(all_fields.get(i*columns+j));
				
			}
		
		return surroundingFields;
	}
		
	public synchronized void doWork(Field field_with_acter) {
		
		try {
			ArrayList<Field> surroundingFields = getSurroundingFields(field_with_acter);
			ActiveActer acter = field_with_acter.get_acter();
			synchronized (acter) {
				ArrayList<Field> surrounding_fields_without_acter = new ArrayList<>();
				for (Field surr_field: surroundingFields) {
					if (!surr_field.haveActer()) surrounding_fields_without_acter.add(surr_field);
				}
				if (surrounding_fields_without_acter.isEmpty()) {
					
					return;
				}
				Collections.shuffle(surrounding_fields_without_acter);
				
				Field new_field = surrounding_fields_without_acter.get(0);
				
				
				
				new_field.add_acter(acter);
				
				Chicken acter1 = (Chicken) field_with_acter.get_acter();
				acter1.add_field(new_field);
				field_with_acter.remove_acter();
				
			}}
				catch(Exception e) {
					System.out.println(e.getMessage());
					}
			}
			
			
			
			
		
	
	public void moveSelection(int direction) {
		// 1 - up, 2 - right, 3 - down, 4 - left (clockwise direction)
		int index = all_fields.indexOf(selected_field);
		int row = index / columns;
		int col = index % columns;
		switch(direction) {
		case(1):
			if(row - 1 < 0) return;
			row = row -1;
			
			break;
		case(2):
			if (col+1 >= columns) return;
			col = col + 1;		
			break;
		case(3):
			if (row+1 >= rows) return;
			row = row+1;
			break;
		case(4):
			if (col-1<0) return;
			col = col - 1;
			break;
		
			
		}
		changeSelection(row, col);
	}
	
	private void changeSelection(int row, int col) {
		Field new_field = all_fields.get(row*columns + col);
		selected_field.rect(false);
		selected_field = new_field;
		selected_field.rect(true);
		
	}
	
	public synchronized void finish_all() {
		for (Field field: all_fields) {
			if (field.haveActer()) {
				
				try {
					Chicken acter = (Chicken)field.get_acter();
					acter.finish();
				} catch (noActerException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
				
			}
		}
	}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
