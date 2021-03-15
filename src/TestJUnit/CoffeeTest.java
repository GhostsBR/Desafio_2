package TestJUnit;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import CustomExceptions.CustomException;
import Model.Coffee;
import Model.User;

public class CoffeeTest {


	Coffee coffee = new Coffee();
	
	@Test
	public void testSetIdCoffeeNull()  {
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> coffee.setIdCoffee(null));	
		assertEquals("Erro: informado um ID nulo!",exception.getMessage());
		
	}
	
	@Test
	public void testSetIdCoffeeNegativo() {
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> coffee.setIdCoffee(-1));	
		assertEquals("Erro: informado um ID negativo ou igual a 0!",exception.getMessage());
		
	}
	
	@Test
	public void testSetIdCoffeeIgualZero() {
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> coffee.setIdCoffee(0));	
		assertEquals("Erro: informado um ID negativo ou igual a 0!",exception.getMessage());
		
	}
	
	@Test
	public void testSetIdCoffeeIgualCerto() throws CustomException {
		coffee.setIdCoffee(1);	
		assertEquals(1,coffee.getIdCoffee());
	}
	
	@Test
	public void testSetNameCoffee() {
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> coffee.setNameCoffee(null));	
		assertEquals("Erro: informado um nome nulo!",exception.getMessage());
	}
	
	@Test
	public void testSetNameCoffeeCerto() throws CustomException {
		coffee.setNameCoffee("Jeferson");
		assertEquals("Jeferson",coffee.getNameCoffee());
		System.out.println("Teste realizado com sucesso");
	}
	
		@Test
	public void testSetNameCoffeeMaior() {
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> coffee.setNameCoffee("123456789012345678901234567890123456789012345678952"));	
		assertEquals("Erro: informado um nome vazio ou com mais de 50 caracteres!",exception.getMessage());
				
	}
		
		@Test
		public void testSetNameCoffeeVazio() {
			CustomException exception = Assertions.assertThrows(CustomException.class, () -> coffee.setNameCoffee(""));	
			assertEquals("Erro: informado um nome vazio ou com mais de 50 caracteres!",exception.getMessage());
		}
		
		@Test
		public void testSetNameCoffeeEspasosVazio() {
			CustomException exception = Assertions.assertThrows(CustomException.class, () -> coffee.setNameCoffee("     "));	
			assertEquals("Erro: informado um nome vazio ou com mais de 50 caracteres!",exception.getMessage());
		}
		
	
					
		
}





















