import java.util.Objects;

public class Car extends Vehicule {

	
	private final int value;
	private final int vetuste;
	private final String licencePlate;

	public Car(String brand, String licencePlate, int value) {
		this(brand, licencePlate, value, 0);
	}

	public Car(String brand, String licencePlate, int value, int collection) {
		this(brand, licencePlate, value, collection, null);
	}

	public Car(String brand, String licencePlate, int value, Discount d) {
		this(brand, licencePlate, value, 0, d);
	}

	public Car(String brand, String licencePlate, int value, int collection, Discount d) {
		super(brand, d);
		if (brand == null)
			throw new NullPointerException();
		this.licencePlate = Objects.requireNonNull(licencePlate);
		if (value < 0)
			throw new IllegalArgumentException("negative value");
		int computedValue = value - collection * 1000;
		if (computedValue * 2 < value)
			throw new IllegalArgumentException("too old");
		this.value = computedValue;
		this.vetuste = collection;
	}

	public int getValue() {
		return value;
	}
	
	public String getLicencePlate() {
		return licencePlate;
	}

	@Override
	public String toString() {
		return "Voiture " + getBrand() + " " + value;
	}

	public boolean equals(Car c) {
		// primitif first
		return value == c.value && getBrand().equals(c.getBrand()) && c.getLicencePlate().equals(licencePlate);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Car))
			return false;
		return equals((Car) obj);
	}

	@Override
	public int hashCode() {
		return 42;
	}
/**
 * The second level comparison of elements,
 * if they are of the same type (if condition is false)
 * check equality of their content.
 */
	@Override
	public int compareTo(Object o) {
		if (!(o instanceof Car)) {
			return super.compareTo(o);
		}
		Car c = (Car) o;
		return (getBrand()+licencePlate+getValue()+vetuste).compareTo(c.getBrand()+c.licencePlate+c.getValue()+c.vetuste);
	}


}
