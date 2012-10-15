import org.junit.Assert;
import org.junit.Test;


public class LongThreaded {
	private long value = 1;
	
	@Test
	public void testLongReadWrite() throws Exception {
		new Thread() {
			@Override
			public void run() {
				boolean flag = true;
				while (true) { // continuously switching values  
					if (flag) {
						value = 1;
					}
					else {
						value = 1111111111111111111L;
					}
					flag = !flag;
				}
			}
		}.start();
		
		int n = 0;
		while (true) { // continuously read values
			n++;
			long v = value;
			if (v != 1 && v != 1111111111111111111L) {
				Assert.fail("value is " + v + ", failed after " + n + " checks");
			}
		}
	}
}
