import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.junit.Test;

public class ExcelImageNpeTest {
	@Test
	public void test() throws IOException {
		//create a new workbook
	    Workbook wb = new HSSFWorkbook(); //or new HSSFWorkbook();

	    //add picture data to this workbook.
	    InputStream is = new FileInputStream("group-logo.jpg");
	    byte[] bytes = IOUtils.toByteArray(is);
	    int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
	    is.close();

	    CreationHelper helper = wb.getCreationHelper();

	    //create sheet
	    Sheet sheet = wb.createSheet();

	    // Create the drawing patriarch.  This is the top level container for all shapes. 
	    Drawing drawing = sheet.createDrawingPatriarch();

	    //add a picture shape
	    ClientAnchor anchor = helper.createClientAnchor();
	    //set top-left corner of the picture,
	    //subsequent call of Picture#resize() will operate relative to it
	    anchor.setCol1(10);
	    anchor.setRow1(10);
	    Picture pict = drawing.createPicture(anchor, pictureIdx);

	    //auto-size picture relative to its top-left corner
	    pict.resize();
	    
	    System.out.println(wb.getAllPictures().size()); // <-- NPE thrown
	    
	    //save workbook
//	    String file = "picture.xls";
//	    FileOutputStream fileOut = new FileOutputStream(file);
//	    wb.write(fileOut);
//	    fileOut.close();
	}
}
