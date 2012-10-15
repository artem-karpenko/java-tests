import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {
	public static void main(String[] args) {
		List<A> aList = new ArrayList<A>();
		for (int i = 0; i < 393; i++) {
			aList.add(new A("321"));
			aList.add(new A("c0aam"));
			aList.add(new A("a_3"));
			aList.add(new A("_axsa"));
			aList.add(new A("XDASX"));
			aList.add(new A(".l12"));
			aList.add(new A("123"));
			aList.add(new A("0998"));
		}
		
		Collections.sort(aList, new AComparator());
		System.out.println(AComparator.callCount);
	}
	
	static class A {
		String s;

		public A(String s) {
			this.s = s;
		}
	}

	static class AComparator implements Comparator<A> {
		public static int callCount = 0;

		@Override
		public int compare(A a1, A a2) {
			callCount++;
			return a1.s.compareTo(a2.s);
		}

	}
}
