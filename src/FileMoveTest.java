import java.io.File;

public class FileMoveTest {
	public static void main(String[] args) {
		File fl = new File("files");
		File destFolder = new File("files/output");
		File[] files = fl.listFiles();
		 
		for (File file : files) {
			if (file.getName().indexOf("test") != -1) {
				file.renameTo(new File(destFolder, file.getName()));
			}
		}
	}
}
