package gui;

public class Vector {
	
		private double x, y;
		
		public Vector(double x, double y) {
			this.x = x;
			this.y = y;
		}
		

		
		
		public double getX() {
			return x;
		}


		public void setX(double x) {
			this.x = x;
		}


		public double getY() {
			return y;
		}


		public void setY(double y) {
			this.y = y;
		}


		public Vector ort() {
			double magnitude = Math.sqrt(x*x+y*y);
			return new Vector(x/magnitude, y/magnitude);
		}
		
		public static Vector randomVector() {
			double x =  Math.random()*2 - 1;
			double y =  Math.random()*2 - 1;
			while(x == 0 && y == 0)
			{
				x =  Math.random()*2 - 1;
				y =  Math.random()*2 - 1;
			}
			return new Vector(x,y);
		}
		
		
		
	}
