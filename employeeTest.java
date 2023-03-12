import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class employeedTest {



	@Test
	void setname() {
		employee employee = new employee();
		employee.setName("Calvin");
		assertEquals("Calvin", employee.name);		
		
	}
	
	@Test
	void setID() {
		employee employee = new employee();
		employee.setID(47);
		assertEquals(47, employee.id);
	}
	
	@Test
	void setPosition() {
		employee employee = new employee();
		employee.setPosition("Waiter");
		assertEquals("Waiter", employee.position);
	}
	
	@Test
	void setWage() {
		employee employee = new employee();
		employee.setWage(13.5);
		assertEquals(13.5, employee.wage);
	}
	
	@Test
	void setHour() {
		employee employee = new employee();
		employee.setHour(2);
		assertEquals(2, employee.hour);
	}


	void setAddress() {
		employee employee = new employee();
		employee.setAddress("Haymarket");
		assertEquals("Haymarket", employee.address);
	}
    void setEmail() {
		employee employee = new employee();
		employee.setEmail("abc@gmail.com");
		assertEquals("abc@gmail.com", employee.email);
	}
    void setDateStarted() {
		employee employee = new employee();
		employee.setDateStarted("1/1/2023");
		assertEquals(2, employee.dateStarted);
	}
    void setBirthday() {
		employee employee = new employee();
		employee.setBirthday("1/1/2000");
		assertEquals("1/1/2000", employee.birthday);
	}
	//------------------------
	employee employee = new employee("Calvin", "Waiter","1/1/2000","Haymarket", "abc@gmail.com",  "1/1/2023", 47, 13.5, 2);
	@Test
	void getName() {	
		assertEquals("Calvin", employee.getName());
	}

	@Test
	void getPosition() {
		assertEquals("Waiter", employee.getPosition());
	}
	
	@Test
	void getID() {
		assertEquals(47, employee.getID());
	}
	
	@Test
	void getWage() {
		assertEquals(13.5, employee.getWage());
	}
	
	@Test
	void getHour() {
		assertEquals(2, employee.getHour());
	}
    @Test
	void getAddress() {
		assertEquals("Haymarket", employee.getAddress());
	}
    @Test
	void getBirthday() {
		assertEquals("1/1/2000", employee.getBirthday());
	}
    @Test
	void getEmail() {
		assertEquals("abc@gmail.com", employee.getEmail());
	}
    @Test
	void getDateStarted() {
		assertEquals("1/1/2023", employee.getDateStarted());
	}
	
	@Test
	void clock_in() {
		assertTrue(employee.clock_in());
		assertFalse(employee.clock_in());
	}
	
	void clock_out() {
		assertTrue(employee.clock_out());
		assertFalse(employee.clock_out());
	}

    
}
