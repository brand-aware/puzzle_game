/**
 * @author mike802
 * @version 1.0 - 3/2/2013
 */
package core.doc;

import java.util.ArrayList;

import core.ScoreNode;

public interface INodeList {
	
	/**
	 * Adds a positional score node to the maintained
	 * list of similar scores.
	 * 
	 * @param ScoreNode node
	 */
	public void add(ScoreNode node);
	
	/**
	 * When given a set of similar scores, sets
	 * this node's list of similar scores to the
	 * set in the param.
	 * 
	 * @param ArrayList<ScoreNode> list
	 */
	public void set(ArrayList<ScoreNode> list);
	
	/**
	 * Returns all nodes on the board with a score
	 * similar to that as initialized by this
	 * node's constructor.
	 * 
	 * @return ArrayList<ScoreNode> similar
	 */
	public ArrayList<ScoreNode> getAll();
	
	/**
	 * Returns the score corresponding to either
	 * the top or right box scoring area.  The
	 * score represents the number of sides that
	 * have been already selected.
	 * 
	 * @return int score1
	 */
	public int getScore1();
	
	/**
	 * Returns the score corresponding to either
	 * the bottom or left box scoring area.  The
	 * score represents the number of sides that
	 * have been already selected.
	 * 
	 * @return int score2
	 */
	public int getScore2();
	
}
