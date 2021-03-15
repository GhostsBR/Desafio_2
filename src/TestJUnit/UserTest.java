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
		user.setIdUser(1);	
		assertEquals(1,user.getIdUser());
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
	void testSetIdUserIgualZero() {
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
	void testSetNameUserVazio(){
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> user.setNameUser(""));	
		assertEquals("Erro: informado um nome vazio ou com mais de 50 caracteres!",exception.getMessage());
	}
	
	@Test
	void testSetNameUserEspasosVazios(){
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> user.setNameUser("    "));	
		assertEquals("Erro: informado um nome vazio ou com mais de 50 caracteres!",exception.getMessage());
	}
	
	@Test
	void testSetNameUserCheio(){
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> user.setNameUser("123456789012345678901234567890123456789012345678952"));	
		assertEquals("Erro: informado um nome vazio ou com mais de 50 caracteres!",exception.getMessage());
	}
	
	
}
