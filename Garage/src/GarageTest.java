import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GarageTest {

	@Test
	public void garageEquality() {
		 Garage garage1 = new Garage();
		 Garage garage2 = new Garage();

		 Car car1 = new Car("BMW", "42abc75" , 90000);
		 Car car2 = new Car("Lada", "42abc76", 6500, 2);
		 Car car3 = new Car("Lada", "42abc76", 5500, 1);
		 Bike bike1 = new Bike("Scott");
		 Bike bike2 = new Bike("Merlin",new Discount(50));
		 Bike bike3 = new Bike("Merlin");
		 
		 garage1.addVehicule(car1);
		 garage1.addVehicule(bike1);
		 garage1.addVehicule(car2);
		 garage1.addVehicule(bike2);
		 garage1.addVehicule(car3);        
		 garage1.addVehicule(bike3);
		 
		 garage2.addVehicule(bike1);
		 garage2.addVehicule(car1);    
		 garage2.addVehicule(car3); 
		 garage2.addVehicule(car2);
		 garage2.addVehicule(bike3);
		 garage2.addVehicule(bike2);       
		 
		 assertEquals(garage1, garage2);
	}

}
