import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class Garage {
	private final ArrayList<Vehicule> list = new ArrayList<>();
	private final int id;
	private static int NB = 1;

	public Garage() {
		this.id = NB++;
	}
	
	public ArrayList<Vehicule> getList(){
		return list;
	}
/**
 * 
 * @param car
 */
	public void addVehicule(Vehicule car) {
        ListIterator<Vehicule> iterator =  list.listIterator();
        while(iterator.hasNext()) {
        	if(iterator.next().compareTo(car) > 0) {
        		//System.out.println("check to add");
        		break;
        	}
        }
        //System.out.println("add"+car);
        iterator.add(car);
	}
/**
 * String representation of the garage, instead of using String it is more 
 * convenient to use StringBuilders which are the modifiable version of Strings
 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Garage id " + id);
		for (Vehicule c : list) {
			sb.append(c.toString()).append("\n");
		}
		return sb.toString();
	}
/**
 * 
 * @return val is the real value of a vehicule after discount(if there is any)
 */
	public int getValue() {
		int val = 0;
		for (Vehicule c : list) {
			val += c.getRealValue();
		}
		return val;
	}

	public void protectionism(String brand) {
		Iterator<Vehicule> it = list.iterator();
		while (it.hasNext()) {

			it.remove();
		}
	}
/**
 * Method equals with the parameter Garage g (it is not a override of equals 
 * in class Object)
 * @param g the object of type Garage
 * @return true if the list of elements in garages are equal, false otherwise
 */
	public boolean equals(Garage g) {
	
		return this.list.equals(g.list);
		
	}
	/**
	 * override of equals in class Object
	 * It verifies equality of the two garage, after sorting their content
	 */
	public boolean equals(Object o) {
		if (!(o instanceof Garage)) {
			return false;
		}
		Garage g = (Garage) o;
		Collections.sort(this.list);
		Collections.sort(g.list);
		return this.equals(g);
		
	}
}
