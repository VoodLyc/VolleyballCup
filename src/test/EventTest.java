package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Event;
import model.InvalidIdException;
import model.InvalidPathException;
import model.Spectator;

class EventTest {
	
	private Event event;
	
	private void setUpScenario1() {
		
		try {
			
			event = new Event("data/test/test.txt");
			
		} catch (InvalidPathException e) {
			
			e.printStackTrace();
		}
	}
	
	private void setUpScenario2() {
		
		try {
			
			event = new Event("data/test/test.txt");
			
		} catch (InvalidPathException e) {
			
			e.printStackTrace();
		}
		
		event.loadData();
	}
	
	@Test
	void testEvent() {
		
		try {
			
			event = new Event("data/asffsafa");
			
		} catch (InvalidPathException e) {
			
			assertNull(event);
		}
		
		try {
			
			event = new Event("data/test/test.txt");
			assertNotNull(event);
			
		} catch (InvalidPathException e) {
			
			e.printStackTrace();
		}
		
	}

	@Test
	void testGetSpectatorById() {
		
		setUpScenario1();
		
		assertEquals("1\n3\n", event.loadData());
		assertEquals("2", event.getSpectatorById("2").getId());
		assertEquals("6", event.getSpectatorById("6").getId());
		assertEquals("8", event.getSpectatorById("8").getId());
		assertEquals("Ji-hyo", event.getSpectatorById("1").getFirstName());
		assertEquals("Tzu-yu", event.getSpectatorById("9").getFirstName());
		assertEquals("Sana", event.getSpectatorById("5").getFirstName());
		assertEquals("Mina", event.getSpectatorById("7").getFirstName());
		assertEquals("Jeong-yeon", event.getSpectatorById("3").getFirstName());
		assertEquals("Da-hyun", event.getSpectatorById("8").getFirstName());
		assertEquals("Chae-young", event.getSpectatorById("4").getFirstName());
		assertNull(event.getSpectatorById("0"));
		assertNull(event.getSpectatorById("10"));
		assertNull(event.getSpectatorById("134342"));
		assertNull(event.getSpectatorById("-13545"));
		
		event.setRoot(null);
		
		assertNull(event.getSpectatorById("1"));
		
		try {
			
			event = new Event("data/test/test2.txt");
			
		} catch (InvalidPathException e) {
			
			e.printStackTrace();
		}
		
		assertNull(event.getSpectatorById("4"));
	}
	
	@Test
	void testGetSizeBST() throws InvalidIdException {
		
		setUpScenario2();
		
		assertEquals(9, event.getSizeBST());
		
		event.setRoot(null);
		
		assertEquals(0, event.getSizeBST());
		
		event.addSpectator(new Spectator("5", "Sana", "Minatozaki", "minatozakisana@twice.com", "F", "Japan", "12/29/1996"));
		event.addSpectator(new Spectator("1", "Sana", "Minatozaki", "minatozakisana@twice.com", "F", "Japan", "12/29/1996"));
		
		assertEquals(2, event.getSizeBST());
		
		event.addSpectator(new Spectator("9", "Sana", "Minatozaki", "minatozakisana@twice.com", "F", "Japan", "12/29/1996"));
		event.addSpectator(new Spectator("4", "Sana", "Minatozaki", "minatozakisana@twice.com", "F", "Japan", "12/29/1996"));
		event.addSpectator(new Spectator("16", "Sana", "Minatozaki", "minatozakisana@twice.com", "F", "Japan", "12/29/1996"));
		
		assertEquals(5, event.getSizeBST());
		
		event.addSpectator(new Spectator("90", "Sana", "Minatozaki", "minatozakisana@twice.com", "F", "Japan", "12/29/1996"));
		event.addSpectator(new Spectator("2", "Sana", "Minatozaki", "minatozakisana@twice.com", "F", "Japan", "12/29/1996"));
		event.addSpectator(new Spectator("23", "Sana", "Minatozaki", "minatozakisana@twice.com", "F", "Japan", "12/29/1996"));
		event.addSpectator(new Spectator("43", "Sana", "Minatozaki", "minatozakisana@twice.com", "F", "Japan", "12/29/1996"));
		event.addSpectator(new Spectator("13", "Sana", "Minatozaki", "minatozakisana@twice.com", "F", "Japan", "12/29/1996"));
		
		assertEquals(10, event.getSizeBST());
	}
	
	@Test
	void testGetFather() {
		
		setUpScenario2();
		
		assertEquals(event.getSpectatorById("3").getId(), event.getFather(event.getSpectatorById("5")).getId());
		assertEquals(event.getSpectatorById("5").getId(), event.getFather(event.getSpectatorById("4")).getId());
		assertEquals(event.getSpectatorById("7").getId(), event.getFather(event.getSpectatorById("8")).getId());
		assertEquals(event.getSpectatorById("2").getId(), event.getFather(event.getSpectatorById("1")).getId());
		assertEquals(event.getSpectatorById("8").getId(), event.getFather(event.getSpectatorById("9")).getId());
		assertEquals(event.getSpectatorById("3").getId(), event.getFather(event.getSpectatorById("2")).getId());
		assertEquals(event.getSpectatorById("6").getId(), event.getFather(event.getSpectatorById("3")).getId());
		assertEquals(event.getSpectatorById("6").getId(), event.getFather(event.getSpectatorById("7")).getId());
		assertNull(event.getFather(event.getSpectatorById("6")));
		event.setRoot(null);
		assertNull(event.getFather(event.getRoot()));
	}
}
