
public class Notation {

	public static void main(String[] args) {
		System.out.println(getNotation(118924, new int[]{3,5,0,2,1,4}));
	}
	
	public static int getNotation(int decBased, int[] xBased) {
		outer: for (int base = 6; ; base++) {
			int tmp = decBased;
			int i = xBased.length - 1;
			while (tmp != 0) {
				int integral = tmp / base;
				int part = tmp % base;
				
				if (xBased[i] == part) {
					tmp = integral;
					i--;
				}
				else {
					continue outer;
				}
			}
			return base;
		}
	}
}
