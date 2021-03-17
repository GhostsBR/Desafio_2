package TestJUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import CustomExceptions.CustomException;
import Model.User;

class UserTest {
	
	User user = new User();

	@Test
	void testSetIdUser() throws CustomException {
		int valorEsperado = 1;
		user.setIdUser(valorEsperado);
		int valorRecebido = user.getIdUser();
		assertEquals( valorEsperado, valorRecebido);
	}
	/*
	@Test
	void testSetIdUserNull() {
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> user.setIdUser(null));	
		assertEquals("Erro: informado um Id nulo!",exception.getMessage());
	}
	
	@Test
	void testSetIdUserNegativo() {
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> user.setIdUser(-2));	
		assertEquals("Erro: informado um Id negativo ou igual a zero!",exception.getMessage());
	}
	
	@Test
	void testSetIdUserEqualZero() {
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> user.setIdUser(0));	
		assertEquals("Erro: informado um Id negativo ou igual a zero!",exception.getMessage());
	}
	*/

	@Test
	void testSetNameUser() throws CustomException {
		user.setNameUser("Thiago");	
		assertEquals("Thiago",user.getNameUser());
	}
	
	@Test
	void testSetNameUserNull(){
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> user.setNameUser(null));	
		assertEquals("Erro: informado um nome nulo!",exception.getMessage());
	}
	
	
	@Test
	void testSetNameUserEmpty(){
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> user.setNameUser(""));	
		assertEquals("Erro: informado um nome vazio ou com mais de 50 caracteres!",exception.getMessage());
	}
	
	@Test
	void testSetNameUserEmptySpaces(){
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> user.setNameUser("    "));	
		assertEquals("Erro: informado um nome vazio ou com mais de 50 caracteres!",exception.getMessage());
	}
	
	@Test
	void testSetNameUserMaximum(){
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> user.setNameUser("123456789012345678901234567890123456789012345678952"));	
		assertEquals("Erro: informado um nome vazio ou com mais de 50 caracteres!",exception.getMessage());
	}
	
	
}
