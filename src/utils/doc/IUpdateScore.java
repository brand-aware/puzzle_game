/**
 * @author mike802
 * @version 1.0 - 8/17/2013
 */
package utils.doc;

import java.util.ArrayList;

import javax.swing.JButton;

public interface IUpdateScore {
	
	/**
	 * Determines if the scoring area above this
	 * line can be impacted by the selection of
	 * this line.
	 * 
	 * @param ArrayList<JButton> horizontal
	 * @param ArrayList<JButton> vertical
	 * @param int position
	 * @param int levelWidth
	 */
	public void updateTop(ArrayList<JButton> horizontal, ArrayList<JButton> vertical, int position, int levelWidth);
	
	/**
	 * Determines if the scoring area below this
	 * line can be impacted by the selection of
	 * this line.
	 * 
	 * @param ArrayList<JButton> horizontal
	 * @param ArrayList<JButton> vertical
	 * @param int position
	 * @param int levelWidth
	 */
	public void updateBottom(ArrayList<JButton> horizontal, ArrayList<JButton> vertical, int position, int levelWidth);
	
	/**
	 * Determines if the scoring area to the right
	 * of this line can be impacted by the 
	 * selection of this line.
	 * 
	 * @param ArrayList<JButton> horizontal
	 * @param ArrayList<JButton> vertical
	 * @param int position
	 * @param int levelHeigt
	 */
	public void updateRight(ArrayList<JButton> horizontal, ArrayList<JButton> vertical, int position, int levelHeigt);
	
	/**
	 * Determines if the scoring area to the left
	 * of this line can be impacted by the 
	 * selection of this line.
	 * 
	 * @param ArrayList<JButton> horizontal
	 * @param ArrayList<JButton> vertical
	 * @param int position
	 * @param int levelHeight
	 */
	public void updateLeft(ArrayList<JButton> horizontal, ArrayList<JButton> vertical, int position, int levelHeight);

}
