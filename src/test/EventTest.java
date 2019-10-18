package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import model.Competitor;
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
	
	private void setUpScenario3() {
		
		try {
			
			event = new Event("data/test/test3.txt");
			
		} catch (InvalidPathException e) {
			
			e.printStackTrace();
		}
		
		event.loadData();
	}
	
	private void setUpScenario4() {
		
		try {
			
			event = new Event("data/test/test3.txt");
			
		} catch (InvalidPathException e) {
			
			e.printStackTrace();
		}
		
		event.loadData();
		
		event.addCompetitor(new Competitor("9","Tzu-yu","Chou","choutzuyu@twice.com","F","Taiwan","6/24/1999"));
		event.addCompetitor(new Competitor("2","Momo","Hirai","hiraimomo@twice.com","F","Japan","11/9/1996"));
		event.addCompetitor(new Competitor("6","Na-yeon","Im","imnayeon@twice.com","F","South Korea","9/22/1995"));
		event.addCompetitor(new Competitor("3","Jeong-yeon","Yoo","yoojeongyeon@twice.com","F","South Korea","11/1/1996"));
	}
	
	private void setUpScenario5() {
		
		try {
			
			event = new Event("data/test/test3.txt");
			
		} catch (InvalidPathException e) {
			
			e.printStackTrace();
		}
		
		event.loadData();
		
		event.addCompetitor(new Competitor("9","Tzu-yu","Chou","choutzuyu@twice.com","F","Taiwan","6/24/1999"));
		event.addCompetitor(new Competitor("2","Momo","Hirai","hiraimomo@twice.com","F","Japan","11/9/1996"));
		event.addCompetitor(new Competitor("5","Sana","Minatozaki","minatozakisana@twice.com","F","Japan","12/29/1996"));
		event.addCompetitor(new Competitor("1","Ji-hyo","Park","parkjihyo@twice.com","F","South Korea","2/1/1997"));
	}
	
	private void setUpScenario6() {
		
		try {
			
			event = new Event("data/test/test3.txt");
			
		} catch (InvalidPathException e) {
			
			e.printStackTrace();
		}
		
		event.loadData();
		
		event.addCompetitor(new Competitor("6","Na-yeon","Im","imnayeon@twice.com","F","South Korea","9/22/1995"));
		event.addCompetitor(new Competitor("3","Jeong-yeon","Yoo","yoojeongyeon@twice.com","F","South Korea","11/1/1996"));
		event.addCompetitor(new Competitor("7","Mina","Myoui","myouimina@twice.com","F","United States","3/24/1997"));
		event.addCompetitor(new Competitor("8","Da-hyun","Kim","kimdahyun@twice.com","F","South Korea","5/28/1998"));
		event.addCompetitor(new Competitor("4","Chae-young","Son","sonchaeyoung@twice.com","F","South Korea","4/23/1999"));
		event.addCompetitor(new Competitor("9","Tzu-yu","Chou","choutzuyu@twice.com","F","Taiwan","6/24/1999"));
		event.addCompetitor(new Competitor("2","Momo","Hirai","hiraimomo@twice.com","F","Japan","11/9/1996"));
		event.addCompetitor(new Competitor("5","Sana","Minatozaki","minatozakisana@twice.com","F","Japan","12/29/1996"));
		event.addCompetitor(new Competitor("1","Ji-hyo","Park","parkjihyo@twice.com","F","South Korea","2/1/1997"));
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
		assertEquals("Na-yeon", event.getRoot().getFirstName());
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
	
	@Test
	void testDeleteSpectator() {
		
		setUpScenario2();
		
		event.deleteSpectator(event.getSpectatorById("6"));
		assertEquals(event.getRoot(), event.getSpectatorById("7"));
		assertEquals(event.getRoot().getLeftChild(), event.getSpectatorById("3"));
		assertEquals(event.getRoot().getRightChild(), event.getSpectatorById("8"));
		assertEquals(8, event.getSizeBST());
		
		event.deleteSpectator(event.getSpectatorById("7"));
		assertEquals(event.getRoot(), event.getSpectatorById("8"));
		assertEquals(event.getRoot().getLeftChild(), event.getSpectatorById("3"));
		assertEquals(event.getRoot().getRightChild(), event.getSpectatorById("9"));
		assertEquals(7, event.getSizeBST());
		
		event.deleteSpectator(event.getSpectatorById("8"));
		assertEquals(event.getRoot(), event.getSpectatorById("9"));
		assertEquals(event.getRoot().getLeftChild(), event.getSpectatorById("3"));
		assertEquals(event.getRoot().getRightChild(), null);
		assertEquals(6, event.getSizeBST());
		
		event.deleteSpectator(event.getSpectatorById("9"));
		assertEquals(event.getRoot(), event.getSpectatorById("3"));
		assertEquals(event.getRoot().getLeftChild(), event.getSpectatorById("2"));
		assertEquals(event.getRoot().getRightChild(), event.getSpectatorById("5"));
		assertEquals(5, event.getSizeBST());
		
		event.deleteSpectator(event.getSpectatorById("3"));
		assertEquals(event.getRoot(), event.getSpectatorById("5"));
		assertEquals(event.getRoot().getLeftChild(), event.getSpectatorById("4"));
		assertEquals(event.getRoot().getRightChild(), null);
		assertEquals(4, event.getSizeBST());
		
		event.deleteSpectator(event.getSpectatorById("5"));
		assertEquals(event.getRoot(), event.getSpectatorById("4"));
		assertEquals(event.getRoot().getLeftChild(), event.getSpectatorById("2"));
		assertEquals(event.getRoot().getRightChild(), null);
		assertEquals(3, event.getSizeBST());
		
		event.deleteSpectator(event.getSpectatorById("4"));
		assertEquals(event.getRoot(), event.getSpectatorById("2"));
		assertEquals(event.getRoot().getLeftChild(), event.getSpectatorById("1"));
		assertEquals(event.getRoot().getRightChild(), null);
		assertEquals(2, event.getSizeBST());
		
		event.deleteSpectator(event.getSpectatorById("2"));
		assertEquals(event.getRoot(), event.getSpectatorById("1"));
		assertEquals(event.getRoot().getLeftChild(), null);
		assertEquals(event.getRoot().getRightChild(), null);
		assertEquals(1, event.getSizeBST());
		
		event.deleteSpectator(event.getSpectatorById("1"));
		assertEquals(event.getRoot(), null);
		assertEquals(0, event.getSizeBST());
		
		event.loadData();
		
		event.deleteSpectator(event.getSpectatorById("4"));
		assertEquals(event.getRoot(), event.getSpectatorById("6"));
		assertEquals(event.getSpectatorById("5").getLeftChild(), null);
		assertEquals(event.getSpectatorById("5").getRightChild(), null);
		assertEquals(8, event.getSizeBST());
		
		event.deleteSpectator(event.getSpectatorById("1"));
		assertEquals(event.getRoot(), event.getSpectatorById("6"));
		assertEquals(event.getSpectatorById("2").getLeftChild(), null);
		assertEquals(event.getSpectatorById("2").getRightChild(), null);
		assertEquals(7, event.getSizeBST());
		
		event.deleteSpectator(event.getSpectatorById("9"));
		assertEquals(event.getRoot(), event.getSpectatorById("6"));
		assertEquals(event.getSpectatorById("8").getLeftChild(), null);
		assertEquals(event.getSpectatorById("8").getRightChild(), null);
		assertEquals(6, event.getSizeBST());
		
		event.loadData();
		
		event.deleteSpectator(event.getSpectatorById("3"));
		assertEquals(event.getRoot(), event.getSpectatorById("6"));
		assertEquals(event.getSpectatorById("6").getLeftChild(), event.getSpectatorById("5"));
		assertEquals(event.getSpectatorById("6").getRightChild(), event.getSpectatorById("7"));
		assertEquals(8, event.getSizeBST());
		
		setUpScenario3();
		
		event.deleteSpectator(event.getSpectatorById("2"));
		assertEquals(event.getRoot(), event.getSpectatorById("5"));
		assertEquals(event.getSpectatorById("5").getLeftChild(), event.getSpectatorById("3"));
		assertEquals(event.getSpectatorById("5").getRightChild(), event.getSpectatorById("9"));
		assertEquals(9, event.getSizeBST());
	}
	
	@Test
	void testAddCompetitors() {
		
		setUpScenario3();
		
		event.addCompetitors();
		
		assertEquals(5, event.getSizeBST());
		assertEquals(5, event.getSize());
		
		setUpScenario2();
		
		event.addCompetitors();
		
		assertEquals(5, event.getSizeBST());
		assertEquals(4, event.getSize());
	}
	
	@Test
	void testGetCompetitorById() {
		
		setUpScenario4();
		
		assertEquals("3", event.getCompetitorById("3").getId());
		assertEquals("2", event.getCompetitorById("2").getId());
		assertEquals("9", event.getCompetitorById("9").getId());
		assertEquals("6", event.getCompetitorById("6").getId());
		assertNull(event.getCompetitorById("224"));
		assertNull(event.getCompetitorById("-224"));
		
		event.setFirst(null);
		
		assertNull(event.getCompetitorById("-224"));
	}
	
	@Test
	void testSearchSpectator() {
		
		setUpScenario2();
		
		String msg, id, firstName, lastName, email, gender, country, birthdate, search;
		String[] lines, value, data;
		
		msg = event.searchSpectator("2");
		
		lines = msg.split("\n");
		value = lines[0].split(":");
		data = value[1].split(" ");
		id = data[1];
		
		assertEquals("2", id);
		
		value = lines[1].split(":");
		data = value[1].split(" ");
		firstName = data[1];
		
		assertEquals("Momo", firstName);
		
		value = lines[2].split(":");
		data = value[1].split(" ");
		lastName = data[1];
		
		assertEquals("Hirai", lastName);
		
		value = lines[3].split(":");
		data = value[1].split(" ");
		email = data[1];
		
		assertEquals("hiraimomo@twice.com", email);
		
		value = lines[4].split(":");
		data = value[1].split(" ");
		gender = data[1];
		
		assertEquals("F", gender);
		
		value = lines[5].split(":");
		data = value[1].split(" ");
		country = data[1];
		
		assertEquals("Japan", country);
		
		value = lines[6].split(":");
		data = value[1].split(" ");
		birthdate = data[1];
		
		assertEquals("11/9/1996", birthdate);
		
		lines = msg.split("\n\n");
		value = lines[1].split(":");
		search = value[0];
		
		assertEquals("The search took", search);
		
		msg = event.searchSpectator("1");
		
		lines = msg.split("\n");
		value = lines[0].split(":");
		data = value[1].split(" ");
		id = data[1];
		
		assertEquals("1", id);
		
		value = lines[1].split(":");
		data = value[1].split(" ");
		firstName = data[1];
		
		assertEquals("Ji-hyo", firstName);
		
		value = lines[2].split(":");
		data = value[1].split(" ");
		lastName = data[1];
		
		assertEquals("Park", lastName);
		
		value = lines[3].split(":");
		data = value[1].split(" ");
		email = data[1];
		
		assertEquals("parkjihyo@twice.com", email);
		
		value = lines[4].split(":");
		data = value[1].split(" ");
		gender = data[1];
		
		assertEquals("F", gender);
		
		value = lines[5].split(":");
		data = value[1].split(" ");
		country = data[1] + " " + data[2];
		
		assertEquals("South Korea", country);
		
		value = lines[6].split(":");
		data = value[1].split(" ");
		birthdate = data[1];
		
		assertEquals("2/1/1997", birthdate);
		
		lines = msg.split("\n\n");
		value = lines[1].split(":");
		search = value[0];
		
		assertEquals("The search took", search);
		
		msg = event.searchSpectator("9");
		
		lines = msg.split("\n");
		value = lines[0].split(":");
		data = value[1].split(" ");
		id = data[1];
		
		assertEquals("9", id);
		
		value = lines[1].split(":");
		data = value[1].split(" ");
		firstName = data[1];
		
		assertEquals("Tzu-yu", firstName);
		
		value = lines[2].split(":");
		data = value[1].split(" ");
		lastName = data[1];
		
		assertEquals("Chou", lastName);
		
		value = lines[3].split(":");
		data = value[1].split(" ");
		email = data[1];
		
		assertEquals("choutzuyu@twice.com", email);
		
		value = lines[4].split(":");
		data = value[1].split(" ");
		gender = data[1];
		
		assertEquals("F", gender);
		
		value = lines[5].split(":");
		data = value[1].split(" ");
		country = data[1];
		
		assertEquals("Taiwan", country);
		
		value = lines[6].split(":");
		data = value[1].split(" ");
		birthdate = data[1];
		
		assertEquals("6/24/1999", birthdate);
		
		lines = msg.split("\n\n");
		value = lines[1].split(":");
		search = value[0];
		
		assertEquals("The search took", search);
		
		msg = event.searchSpectator("5");
		
		lines = msg.split("\n");
		value = lines[0].split(":");
		data = value[1].split(" ");
		id = data[1];
		
		assertEquals("5", id);
		
		value = lines[1].split(":");
		data = value[1].split(" ");
		firstName = data[1];
		
		assertEquals("Sana", firstName);
		
		value = lines[2].split(":");
		data = value[1].split(" ");
		lastName = data[1];
		
		assertEquals("Minatozaki", lastName);
		
		value = lines[3].split(":");
		data = value[1].split(" ");
		email = data[1];
		
		assertEquals("minatozakisana@twice.com", email);
		
		value = lines[4].split(":");
		data = value[1].split(" ");
		gender = data[1];
		
		assertEquals("F", gender);
		
		value = lines[5].split(":");
		data = value[1].split(" ");
		country = data[1];
		
		assertEquals("Japan", country);
		
		value = lines[6].split(":");
		data = value[1].split(" ");
		birthdate = data[1];
		
		assertEquals("12/29/1996", birthdate);
		
		lines = msg.split("\n\n");
		value = lines[1].split(":");
		search = value[0];
		
		assertEquals("The search took", search);
		
		msg = event.searchSpectator("45");
		
		lines = msg.split("\n\n");
		value = lines[1].split(":");
		search = lines[0];
	
		assertEquals("The spectator couldn't be found.", search);
		
		search = value[0];
		
		assertEquals("The search took", search);
	}
	
	@Test
	void testSearchCompetitor() {
		
		setUpScenario5();
		
		String msg, id, firstName, lastName, email, gender, country, birthdate, search;
		String[] lines, value, data;
		
		msg = event.searchCompetitor("9");
		
		lines = msg.split("\n");
		value = lines[0].split(":");
		data = value[1].split(" ");
		id = data[1];
		
		assertEquals("9", id);
		
		value = lines[1].split(":");
		data = value[1].split(" ");
		firstName = data[1];
		
		assertEquals("Tzu-yu", firstName);
		
		value = lines[2].split(":");
		data = value[1].split(" ");
		lastName = data[1];
		
		assertEquals("Chou", lastName);
		
		value = lines[3].split(":");
		data = value[1].split(" ");
		email = data[1];
		
		assertEquals("choutzuyu@twice.com", email);
		
		value = lines[4].split(":");
		data = value[1].split(" ");
		gender = data[1];
		
		assertEquals("F", gender);
		
		value = lines[5].split(":");
		data = value[1].split(" ");
		country = data[1];
		
		assertEquals("Taiwan", country);
		
		value = lines[6].split(":");
		data = value[1].split(" ");
		birthdate = data[1];
		
		assertEquals("6/24/1999", birthdate);
		
		lines = msg.split("\n\n");
		value = lines[1].split(":");
		search = value[0];
		
		assertEquals("The search took", search);
		
		msg = event.searchCompetitor("1");
		
		lines = msg.split("\n");
		value = lines[0].split(":");
		data = value[1].split(" ");
		id = data[1];
		
		assertEquals("1", id);
		
		value = lines[1].split(":");
		data = value[1].split(" ");
		firstName = data[1];
		
		assertEquals("Ji-hyo", firstName);
		
		value = lines[2].split(":");
		data = value[1].split(" ");
		lastName = data[1];
		
		assertEquals("Park", lastName);
		
		value = lines[3].split(":");
		data = value[1].split(" ");
		email = data[1];
		
		assertEquals("parkjihyo@twice.com", email);
		
		value = lines[4].split(":");
		data = value[1].split(" ");
		gender = data[1];
		
		assertEquals("F", gender);
		
		value = lines[5].split(":");
		data = value[1].split(" ");
		country = data[1] + " " + data[2];
		
		assertEquals("South Korea", country);
		
		value = lines[6].split(":");
		data = value[1].split(" ");
		birthdate = data[1];
		
		assertEquals("2/1/1997", birthdate);
		
		lines = msg.split("\n\n");
		value = lines[1].split(":");
		search = value[0];
		
		assertEquals("The search took", search);
		
		msg = event.searchCompetitor("2");
		
		lines = msg.split("\n");
		value = lines[0].split(":");
		data = value[1].split(" ");
		id = data[1];
		
		assertEquals("2", id);
		
		value = lines[1].split(":");
		data = value[1].split(" ");
		firstName = data[1];
		
		assertEquals("Momo", firstName);
		
		value = lines[2].split(":");
		data = value[1].split(" ");
		lastName = data[1];
		
		assertEquals("Hirai", lastName);
		
		value = lines[3].split(":");
		data = value[1].split(" ");
		email = data[1];
		
		assertEquals("hiraimomo@twice.com", email);
		
		value = lines[4].split(":");
		data = value[1].split(" ");
		gender = data[1];
		
		assertEquals("F", gender);
		
		value = lines[5].split(":");
		data = value[1].split(" ");
		country = data[1];
		
		assertEquals("Japan", country);
		
		value = lines[6].split(":");
		data = value[1].split(" ");
		birthdate = data[1];
		
		assertEquals("11/9/1996", birthdate);
		
		lines = msg.split("\n\n");
		value = lines[1].split(":");
		search = value[0];
		
		assertEquals("The search took", search);
		
		msg = event.searchCompetitor("5");
		
		lines = msg.split("\n");
		value = lines[0].split(":");
		data = value[1].split(" ");
		id = data[1];
		
		assertEquals("5", id);
		
		value = lines[1].split(":");
		data = value[1].split(" ");
		firstName = data[1];
		
		assertEquals("Sana", firstName);
		
		value = lines[2].split(":");
		data = value[1].split(" ");
		lastName = data[1];
		
		assertEquals("Minatozaki", lastName);
		
		value = lines[3].split(":");
		data = value[1].split(" ");
		email = data[1];
		
		assertEquals("minatozakisana@twice.com", email);
		
		value = lines[4].split(":");
		data = value[1].split(" ");
		gender = data[1];
		
		assertEquals("F", gender);
		
		value = lines[5].split(":");
		data = value[1].split(" ");
		country = data[1];
		
		assertEquals("Japan", country);
		
		value = lines[6].split(":");
		data = value[1].split(" ");
		birthdate = data[1];
		
		assertEquals("12/29/1996", birthdate);
		
		lines = msg.split("\n\n");
		value = lines[1].split(":");
		search = value[0];
		
		assertEquals("The search took", search);
		
		msg = event.searchCompetitor("90");
		
		lines = msg.split("\n\n");
		value = lines[1].split(":");
		search = lines[0];
	
		assertEquals("The competitor couldn't be found.", search);
		
		search = value[0];
		
		assertEquals("The search took", search);
	}
	
	@Test
	void testShowCompetitorByCountry() {
		
		setUpScenario6();
		
		String msg;
		String[] lines;
		
		msg = event.showCompetitorsByCountry("South Korea");
		
		lines = msg.split("------->");
		
		assertEquals("| ID: 6, FIRST NAME: Na-yeon, LAST NAME: Im, EMAIL: imnayeon@twice.com, GENDER: F, COUNTRY: South Korea, BIRTHDATE: 9/22/1995 | ", lines[0]);
		assertEquals(" | ID: 3, FIRST NAME: Jeong-yeon, LAST NAME: Yoo, EMAIL: yoojeongyeon@twice.com, GENDER: F, COUNTRY: South Korea, BIRTHDATE: 11/1/1996 | ", lines[1]);
		assertEquals(" | ID: 8, FIRST NAME: Da-hyun, LAST NAME: Kim, EMAIL: kimdahyun@twice.com, GENDER: F, COUNTRY: South Korea, BIRTHDATE: 5/28/1998 | ", lines[2]);
		assertEquals(" | ID: 4, FIRST NAME: Chae-young, LAST NAME: Son, EMAIL: sonchaeyoung@twice.com, GENDER: F, COUNTRY: South Korea, BIRTHDATE: 4/23/1999 | ", lines[3]);
		assertEquals(" | ID: 1, FIRST NAME: Ji-hyo, LAST NAME: Park, EMAIL: parkjihyo@twice.com, GENDER: F, COUNTRY: South Korea, BIRTHDATE: 2/1/1997 | ", lines[4]);
		
		
		msg = event.showCompetitorsByCountry("England");
		
		assertEquals("", msg);
		
		msg = event.showCompetitorsByCountry("Japan");
		
		lines = msg.split("------->");
		
		assertEquals("| ID: 2, FIRST NAME: Momo, LAST NAME: Hirai, EMAIL: hiraimomo@twice.com, GENDER: F, COUNTRY: Japan, BIRTHDATE: 11/9/1996 | ", lines[0]);
		assertEquals(" | ID: 5, FIRST NAME: Sana, LAST NAME: Minatozaki, EMAIL: minatozakisana@twice.com, GENDER: F, COUNTRY: Japan, BIRTHDATE: 12/29/1996 | ", lines[1]);
	}
}
