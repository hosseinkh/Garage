/**
 * Since there are shared parameters and methods between cars and bikes, 
 * and more importantly because the cars and bikes should be saved in the
 * same data structure (type collection), we define Vehicule as abstract class.
 * This class implements Comparable due to the last exercice which demands to
 * compare two garages. Comparison between two garage means comparing their 
 * including elements one by one. However, since the elements might not be entered
 * in the same order in both garages we need to sort them before verifying their equality 
 * @author hosseinkhani
 *
 */
public abstract class Vehicule implements Comparable{
	private Discount d;
	private final String brand;

	public abstract int getValue();

	public Vehicule(String brand, Discount d) {
		this.brand = brand;
		this.d = d;
	}

	public Vehicule(String brand) {
		this(brand, null);
	}
  /**
   * override of method compareTo at the first level
   * are the two elements have the same type?
   */
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
    	Vehicule v = (Vehicule) o;
		return this.getClass().getName().compareTo(v.getClass().getName());
	}

	public int getRealValue() {
		if (d == null) {
			return getValue();
		} else {
			return d.getVal();
		}
	}

	public String getBrand() {
		return brand;
	}

	public void setDiscount(Discount d) {
		this.d = d;
	}
}