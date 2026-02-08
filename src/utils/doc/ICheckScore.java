/**
 * @author mike802
 * @version 1.0 - 8/17/2013
 */
package utils.doc;

import java.util.ArrayList;

import javax.swing.JButton;

public interface ICheckScore {

	/**
	 * Determines if the selected object is a
	 * horizontal line.  If so, the index is also
	 * recorded.
	 * 
	 * @param ArrayList<JButton> horizontal
	 * @param JButton selection
	 * @return boolean hzl
	 */
	public boolean isHorizontal(ArrayList<JButton> horizontal, JButton selection);
	
	/**
	 * Determines if the selected object is a
	 * vertical line.  If so, the index is also
	 * recorded.
	 * 
	 * @param ArrayList<JButton> vertical
	 * @param JButton selection
	 * @return boolean vtl
	 */
	public boolean isVertical(ArrayList<JButton> vertical, JButton selection);
	
	/**
	 * Checks surrounding boxes on either side
	 * of this line to determine if selecting this
	 * line completes either of them.  If selecting
	 * this line completes a box, the player that
	 * selected this line's score is increased.
	 * 
	 * @param ArrayList<JButton> horizontal
	 * @param ArrayList<JButton> vertical
	 * @param int levelWidth
	 * @param int levelHeight
	 * @param int sizeHorizontal
	 * @param boolean hzl
	 * @param boolean vtl
	 * @return int score
	 */
	public int checkForScore(ArrayList<JButton> horizontal, ArrayList<JButton> vertical, int levelWidth, int levelHeight, int sizeHorizontal, boolean hzl, boolean vtl);
	
}
