import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpTest {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("MAEU\\.DHL\\.IFTSTA\\.(\\d+)");
        Matcher m = pattern.matcher("MAEU.DHL.IFTSTA.1702.198252514405201019.edi");
        m.find();
        
        System.out.println(m.group(1));
    }
}
