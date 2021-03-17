package TestJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import Controller.CoffeeController;
import Database.DatabaseCreator;
import Model.Coffee;
import Model.CoffeeDAO;
@RunWith(MockitoJUnitRunner.class)


class CoffeeControllerTest {

	
	
	@Mock
	private CoffeeDAO coffeeDao;
	
	@InjectMocks
	private CoffeeController coffeeController;
	
	
	
	@Test
	void testInsertCoffee() {
		Coffee coffee = new Coffee(1,"cafe"); 	
	
	}

	@Test
	void testFindCoffees() {
		fail("Not yet implemented");
	}

}
