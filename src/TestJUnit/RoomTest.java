package TestJUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import CustomExceptions.CustomException;
import Model.Room;

class RoomTest {
	
	Room room = new Room();
	
	@Test
	void testSetIdRoom() throws CustomException {
		room.setIdRoom(1);	
		assertEquals(1,room.getIdRoom());
	}

	@Test
	void testSetIdRoomNull() {
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> room.setIdRoom(null));	
		assertEquals("Erro: informado um ID nulo!",exception.getMessage());
	}
	
	@Test
	void testSetIdRoomNegative() {
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> room.setIdRoom(-1));	
		assertEquals("Erro: informado um ID negativo ou igual a zero!",exception.getMessage());
	}
	
	@Test
	void testSetIdRoomEqualZero() {
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> room.setIdRoom(0));	
		assertEquals("Erro: informado um ID negativo ou igual a zero!",exception.getMessage());
	}

	@Test
	void testSetNameRoom() throws CustomException {
		room.setNameRoom("Sala");	
		assertEquals("Sala",room.getNameRoom());
	}
	
	@Test
	void testSetNameRoomNull() {
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> room.setNameRoom(null));	
		assertEquals("Erro: informado um nome nulo!",exception.getMessage());
	}
	
	@Test
	void testSetNameRoomEmpty() {
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> room.setNameRoom(""));	
		assertEquals("Erro: informado um nome vazio ou com mais de 50 caracteres!",exception.getMessage());
	}
	
	@Test
	void testSetNameRoomEmptySpaces() {
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> room.setNameRoom("     "));	
		assertEquals("Erro: informado um nome vazio ou com mais de 50 caracteres!",exception.getMessage());
	}
	
	@Test
	void testSetNameRoomMaximum() {
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> room.setNameRoom("123456789012345678901234567890123456789012345678952"));	
		assertEquals("Erro: informado um nome vazio ou com mais de 50 caracteres!",exception.getMessage());
	}
	
	@Test
	void testSetCapacityRoom() throws CustomException {
		room.setCapacityRoom(20);
		assertEquals(20,room.getCapacityRoom());
		}
	
	@Test
	void testSetCapacityRoomNull() throws CustomException {
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> room.setCapacityRoom(null));	
		assertEquals("Erro: informado uma capacidade nula!",exception.getMessage());
	}
	
	@Test
	void testSetCapacityRoomNegative() throws CustomException {
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> room.setCapacityRoom(-20));	
		assertEquals("Erro: informado uma capacidade negativa ou igual a zero!",exception.getMessage());
	}
	
	@Test
	void testSetCapacityRoomEqualZero() throws CustomException {
		CustomException exception = Assertions.assertThrows(CustomException.class, () -> room.setCapacityRoom(0));	
		assertEquals("Erro: informado uma capacidade negativa ou igual a zero!",exception.getMessage());
	}
	
	
}
