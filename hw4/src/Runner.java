import net.ulno.sm.AbstractFile;
import net.ulno.sm.Directory;
import net.ulno.sm.FileCounterVisitor;
import net.ulno.sm.RegularFile;
import net.ulno.sm.Root;


public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Root root = Root.getInstance();
		for (Object file: root.findAll("^.*[.]java$")) {
			System.out.println(((AbstractFile)file).getName());
		}
		System.out.println("There are " + root.countFiles("^.*[.]java$") + " java files");
		System.out.println("There are " + root.countFiles() + "  files");
		System.out.println("Total size of the directory is " + root.getSize() + " bytes");
		
		FileCounterVisitor fcv = new FileCounterVisitor();
		
		Root.traverse(new Directory("."), fcv);
		
		System.out.println("here!");
		
		System.out.println("Second counting gave " + fcv.getFileCount() + " files.");
		
	}

}
