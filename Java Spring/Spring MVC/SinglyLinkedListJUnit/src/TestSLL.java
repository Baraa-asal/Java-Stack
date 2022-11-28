import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestSLL {

	public SinglyLinkedList sll;
	@Before
	public void setUp() throws Exception {
		sll = new SinglyLinkedList();
	}
	
	@Test
	public void testHeadForNull() {
		assertNull(sll.head);
	}

	@Test
	public void testHeadForNode() {
		sll.add(8);
		assertNotNull(sll.head);
	}

	@Test
	public void testHeadNextVal() {
		sll.add(5);
		sll.add(10);
		sll.add(22);
		sll.removeFront();
		assertTrue(sll.head.value == 10);
	}

	@Test
	public void testHeadAfterRemove() {
		sll.add(10);
		sll.removeFront();
		assertNull(sll.head);
	}

}
