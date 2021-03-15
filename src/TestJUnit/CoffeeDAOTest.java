package TestJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import CustomExceptions.CustomException;
import Model.Coffee;
import Model.CoffeeDAO;

class CoffeeDAOTest {
	
	//@InjectMocks
	private CoffeeDAO coffeeDao;
	
	Coffee coffee = new Coffee();

	@Test
	public void testCreateCoffee() throws CustomException {
		Coffee coffee = new Coffee(1,"cafe"); 	
		coffeeDao.createCoffee(coffee);
		//verify(coffeeDao, times()).insertNewItem(Mockito.any(Coffee.class));
	    assertEquals("cafe", coffee);
	}
	/*
	void testDeleteCoffee() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateCoffee() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCoffees() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCoffee() {
		fail("Not yet implemented");
	}*/

}
