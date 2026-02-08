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
		if(args.length != 1){
			System.out.println("java driver <imgDir>");
			System.exit(0);
		}
		
		Properties properties = new Properties(args[0]);
		Board board = new Board(properties);
		board.init();
	}
}