import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class RevereseBitsTest {
	 public static void main(String args[]) {
//		 	System.out.println(bin2dec("100101"));
//	        System.out.println("Введите  число");
//	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	        String s = br.readLine();
	        String s = "6";
	        myRev(s);
	        System.out.println(
	        		new BigInteger(
	        				new StringBuilder(
	        						new BigInteger("6").toString(2)
	        				).reverse().toString(), 2
	        		).toString()
	        );
	    }

	    public static void myRev (String s){
	        try {
	            int k = Integer.parseInt(s);
	            if(k<0) {System.out.println("Число "+s+" не натуральное"); System.exit(1);}
	        }
	        catch(Exception e) {
	            System.out.println("Число "+s+" не натуральное"); System.exit(1);}

	            System.out.print(s + " Binary is : ");
	        int f = Integer.parseInt(s);
	        StringBuilder sb = new StringBuilder();
	        do {
	            sb.append(f % 2);
	            f = f / 2;
	        } while (f != 0);
	        System.out.println(sb.reverse());
	        System.out.println(bin2dec(sb.toString()));
	    }
	
	public static int bin2dec(String binNumber) {
		int result = 0;
		
		for (int i = 0; i < binNumber.length(); i++) {
			result += Math.pow(2, i) * (binNumber.charAt(i) == '1' ? 1 : 0);
		}
		return result;
	}
}
