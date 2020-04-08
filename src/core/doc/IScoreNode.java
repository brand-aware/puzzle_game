/**
 * @author mike802
 * @version 1.0 - 3/2/2013
 */
package core.doc;

import javax.swing.JButton;

public interface IScoreNode {

	/**
	 * Score 1 represents the number of selected
	 * lines in either the top or right box,
	 * depending on this node's direction.
	 * 
	 * @return int score1
	 */
	public int getScore1();
	
	/**
	 * Score 2 represents the number of selected
	 * lines in either the bottom or left box,
	 * depending on this node's direction
	 * 
	 * @return int score2
	 */
	public int getScore2();
	
	/**
	 * Returns the clickable object that this
	 * node's score is based around.
	 * 
	 * @return JButton button
	 */
	public JButton getButton();
	
	/**
	 * Gets the direction of the node.  This
	 * can be either horizontal or vertical.
	 * 
	 * @return String direction
	 */
	public String getDirection();
	
	/**
	 * Gets the index for this node.  The index
	 * is the linear position of the node as it
	 * corresponds to all other nodes of the same
	 * direction.
	 * 
	 * @return int index
	 */
	public int getIndex();
	
}
