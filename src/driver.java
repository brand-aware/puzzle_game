/**
 * @author mike802
 * @version 1.0 - 3/2/2013
 */
import settings.Properties;
import ui.Board;

public class driver {

	/**	
	 *
	 * @param String imgDir
	 */
	public static void main(String[] args) {
		String currentDir = System.getProperty("user.dir");
		Properties properties = new Properties(currentDir);
		Board board = new Board(properties);
		board.init();
	}
}