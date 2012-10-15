import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfPCell;

public class Checker {
	private static final Map<Class<?>, CellChecker> strategyMap = new HashMap<Class<?>, CellChecker>();
	static {
		strategyMap.put(String.class, new StringCellChecker());
		strategyMap.put(Integer.class, new IntegerCellChecker());
		strategyMap.put(Image.class, new ImageCellChecker());
		strategyMap.put(String[].class, new StringArrayCellChecker());
	}
	
	public static void main(String[] args) throws BadElementException, MalformedURLException, IOException {
//		String[] values = new String[]{"123", "321"};
//		Object o = values;
//		CellChecker checker = strategyMap.get(values.getClass());
//		checker.check(o, null);
		
		Object[] objects = new Object[2];
		objects[0] = "string";
		objects[1] = new Integer(1);
		
		check(objects);
	}
	
	public static void check(Object[] objs) {
		for (Object o : objs) {
			strategyMap.get(o.getClass()).check(o, null);
		}
	}
}

abstract class CellChecker {
	abstract public boolean check(Object expectedObject, PdfPCell cell);
}

class StringCellChecker extends CellChecker {
	@Override
	public boolean check(Object expectedObject, PdfPCell cell) {
		String expected = (String) expectedObject;
		System.out.println(expected);
		return false;
	}
}

class ImageCellChecker extends CellChecker {
	@Override
	public boolean check(Object expectedObject, PdfPCell cell) {
		Image expected = (Image) expectedObject;
		
		return false;
	}
}

class IntegerCellChecker extends CellChecker {
	@Override
	public boolean check(Object expectedObject, PdfPCell cell) {
		Integer expected = (Integer) expectedObject;
		System.out.println(expected);
		return false;
	}
}

class StringArrayCellChecker extends CellChecker {
	@Override
	public boolean check(Object expectedObject, PdfPCell cell) {
		String[] expected = (String[]) expectedObject;
		System.out.println(expected[1]);
		return false;
	}
}