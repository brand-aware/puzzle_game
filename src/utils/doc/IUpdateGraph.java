/**
 * @author mike802
 * @version 1.0 - 8/17/2013
 */
package utils.doc;

import java.util.ArrayList;

import javax.swing.JButton;

public interface IUpdateGraph {

	/**
	 * After determining that the scoring area
	 * above the line selected can be impacted,
	 * this recalculates the score that will be
	 * passed to the ScoreGraph.
	 * 
	 * @param ArrayList<JButton> horizontal
	 * @param ArrayList<JButton> vertical
	 * @param int position
	 * @param int levelWidth
	 * @return int score
	 */
	public int recordTop(ArrayList<JButton> horizontal, ArrayList<JButton> vertical, int position, int levelWidth);
	
	/**
	 * After determining that the scoring area
	 * below the line selected can be impacted,
	 * this recalculates the score that will be
	 * passed to the ScoreGraph.
	 * 
	 * @param ArrayList<JButton> horizontal
	 * @param ArrayList<JButton> vertical
	 * @param int position
	 * @param int levelWidth
	 * @return int score
	 */
	public int recordBottom(ArrayList<JButton> horizontal, ArrayList<JButton> vertical, int position, int levelWidth);
	
	/**
	 * After determining that the scoring area
	 * to the right the line selected can be 
	 * impacted, this recalculates the score that 
	 * will be passed to the ScoreGraph.
	 * 
	 * @param ArrayList<JButton> horizontal
	 * @param ArrayList<JButton> vertical
	 * @param int position
	 * @param int levelHeight
	 * @return int score
	 */
	public int recordRight(ArrayList<JButton> horizontal, ArrayList<JButton> vertical, int position, int levelHeight);
	
	/**
	 * After determining that the scoring area
	 * to the left the line selected can be 
	 * impacted, this recalculates the score that 
	 * will be passed to the ScoreGraph.
	 * 
	 * @param ArrayList<JButton> horizontal
	 * @param ArrayList<JButton> vertical
	 * @param int position
	 * @param int levelHeight
	 * @return int score
	 */
	public int recordLeft(ArrayList<JButton> horizontal, ArrayList<JButton> vertical, int position, int levelHeight);
	
}
