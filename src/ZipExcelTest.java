import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;



public class ZipExcelTest {
	public static void main(String[] args) throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet();
		sheet.createRow(0).createCell(0).setCellValue("Hello");
		
		FileOutputStream outs = new FileOutputStream("hello.zip");
		ZipOutputStream zipOuts = new ZipOutputStream(outs);
		zipOuts.putNextEntry(new ZipEntry("hello.xls"));
		wb.write(zipOuts);
		zipOuts.close();
	}
}
