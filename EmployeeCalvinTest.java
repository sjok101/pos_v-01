import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeCalvinTest {

	
	@Test
	void setname() {
		EmployeeCalvin employee = new EmployeeCalvin();
		employee.setName("Calvin");
		assertEquals("Calvin", employee.name);		
		
	}
	
	@Test
	void setID() {
		EmployeeCalvin employee = new EmployeeCalvin();
		employee.setID(47);
		assertEquals(47, employee.id);
	}
	
	@Test
	void setPosition() {
		EmployeeCalvin employee = new EmployeeCalvin();
		employee.setPosition("Waiter");
		assertEquals("Waiter", employee.position);
	}
	
	@Test
	void setWage() {
		EmployeeCalvin employee = new EmployeeCalvin();
		employee.setWage(13.5);
		assertEquals(13.5, employee.wage);
	}
	
	@Test
	void setHour() {
		EmployeeCalvin employee = new EmployeeCalvin();
		employee.setHour(2);
		assertEquals(2, employee.hour);
	}
	
	//------------------------
	EmployeeCalvin employee = new EmployeeCalvin("Calvin", "Waiter", 47, 13.5, 2);
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
	void clock_in() {
		assertTrue(employee.clock_in());
		assertFalse(employee.clock_in());
	}
	
	void clock_out() {
		assertTrue(employee.clock_out());
		assertFalse(employee.clock_out());
	}
	
	
}









