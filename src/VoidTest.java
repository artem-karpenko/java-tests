import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;


public class VoidTest {
	@Test
	public void testname() throws Exception {
		Assert.assertTrue(void.class == Void.TYPE);
		
		Class<?>[] arr = new Class<?>[]{ void.class };
		
		new ArrayList<Void>().add(null);
		
		Constructor<Void> ctor = Void.class.getDeclaredConstructor();
		ctor.setAccessible(true);
		System.out.println(ctor.newInstance());
		
		GregorianCalendar now = new GregorianCalendar();  
		int year = now.get(Calendar.YEAR);  
		System.out.println(year);
	}
}

interface I<T> {
	T doStuff() throws Exception;
}

class A implements I<Void> {
	@Override
	public Void doStuff() throws Exception {
		// ...
		
		Constructor<Void> ctor = Void.class.getDeclaredConstructor();
		ctor.setAccessible(true);
		
		return ctor.newInstance();
	}
}