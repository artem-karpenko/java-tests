import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegExptst {
	public static void main(String[] args) {
		String line = "sim-control 3110/tcp simulator control port";
		Pattern p = Pattern.compile("([-a-zAz]+)(?:\\s?|\\t?)+(\\d+)\\/(tcp|udp)");
	    //String[] service = p.split(line);
	    Matcher m = p.matcher(line);
	    if(m.find()) {
	        for(int i = 1; i <= m.groupCount(); i++) {
	            System.out.println(m.group(i));
	        }
	    }
	}
}
