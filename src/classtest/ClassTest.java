package classtest;
import junit.framework.Assert;

import org.junit.Test;

class Object {
	
}

public class ClassTest {
	@Test
	public void testClass() throws Exception {
		Class c = Object.class;
		Assert.assertTrue(c == Class.forName("Object"));
		
		System.out.println((int)"123".charAt(0));
	}
}
