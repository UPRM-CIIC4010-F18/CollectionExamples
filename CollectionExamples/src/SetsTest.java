import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class SetsTest {

	@Test
	public void testSetInteger() {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		assertEquals(0,Sets.countUnique(temp));
		temp.add(1);
		assertEquals(1,Sets.countUnique(temp));
		temp.add(2);
		assertEquals(2,Sets.countUnique(temp));
		temp.add(2);
		assertEquals(2,Sets.countUnique(temp));
		temp.add(3);
		assertEquals(3,Sets.countUnique(temp));
	}

}
