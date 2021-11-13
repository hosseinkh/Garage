
public class Bike extends Vehicule {

	public Bike(String brand) {
		this(brand, null);
	}

	public Bike(String brand, Discount d) {
		super(brand, d);
	}

	@Override
	public int getValue() {
		return 100;
	}
    
	public boolean equals(Object o) {
		if (! (o instanceof Bike)) {
			return false;
		}
		Bike b = (Bike) o;
		return this.getRealValue() == b.getRealValue() && this.getBrand().equals(b.getBrand());
	}
	/**
	 * comparing elements in the second layer
	 * if they are of the same type (the if condition is false) check equality 
	 * of their values.
	 */
	public int compareTo(Object o) {
		if (!(o instanceof Bike)) {
			return super.compareTo(o);
		}
		Bike b = (Bike) o;
		return (getBrand()+getRealValue()).compareTo(b.getBrand()+b.getRealValue());
	}
		
	
}
