import net.ulno.sm.AbstractFile;
import net.ulno.sm.Directory;
import net.ulno.sm.FileCounterVisitor;
import net.ulno.sm.RegularFile;
import net.ulno.sm.Root;
import net.ulno.sm.SummarizeFileSizesVisitor;


public class Runner {

	private static final String JAVA_FILES = "^.*[.]java$";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Root root = Root.getInstance();
		System.out.println("All java files:");
		for (Object file: root.findAll(JAVA_FILES)) {
			System.out.println(((AbstractFile)file).getName());
		}
		System.out.println("There are " + root.countFiles(JAVA_FILES) + " java files");
		System.out.println("There are " + root.countFiles() + "  files");
		System.out.println("Total size of the directory is " + root.getSize() + " bytes");
		
		FileCounterVisitor fcv = new FileCounterVisitor();
		
		Root.traverse(new RegularFile("."), fcv);
		
		System.out.println("Second counting gave " + fcv.getFileCount() + " files.");
		fcv = new FileCounterVisitor(JAVA_FILES);
		
		Root.traverse(new RegularFile("."), fcv);
		
		System.out.println("Second counting gave " + fcv.getFileCount() + " java files");
		
	}

}
