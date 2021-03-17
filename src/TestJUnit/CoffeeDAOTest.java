package TestJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import CustomExceptions.CustomException;
import Database.ConnectionFactory;
import Database.DatabaseCreator;
import Model.Coffee;
import Model.CoffeeDAO;
@RunWith(MockitoJUnitRunner.class)
class CoffeeDAOTest {
	@Mock
	private DatabaseCreator database;
	
	@Mock
	private ConnectionFactory connection;
	
	@InjectMocks
	 CoffeeDAO coffeeDao = new  CoffeeDAO();
	
	Coffee coffee = new Coffee();

	@Test
	public void testCreateCoffee() throws CustomException {
		Coffee coffee = new Coffee(1,"cafe"); 	
		coffeeDao.createCoffee(coffee);
		//verify(coffeeDao, times()).insertNewItem(Mockito.any(Coffee.class));
	    assertEquals("cafe", coffeeDao.getCoffee(1));
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
