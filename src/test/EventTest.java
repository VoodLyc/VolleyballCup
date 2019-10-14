package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Event;
import model.InvalidPathException;

class EventTest {
	
	private Event event;
	
	private void setUpScenario1() {
		
		try {
			
			event = new Event("data/test/test.txt");
			
		} catch (InvalidPathException e) {
			
			e.printStackTrace();
		}
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
		try {
			
			event = new Event("data/test/test2.txt");
			
		} catch (InvalidPathException e) {
			
			e.printStackTrace();
		}
		
		assertNull(event.getSpectatorById("4"));
		
	}
}
