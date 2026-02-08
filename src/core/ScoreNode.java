/**
 * @author mike802
 * @version 1.0 - 3/2/2013
 */
package core;

import javax.swing.JButton;

import core.doc.IScoreNode;

public class ScoreNode implements IScoreNode{

	private int score1 = 0;
	private int score2 = 0;
	private int index = -1;
	private String direction = "";
	
	private JButton button = null;
	
	public ScoreNode(int s1, int s2, JButton b, int position, String identifier){
		score1 = s1;
		score2 = s2;
		button = b;
		index = position;
		direction = identifier;
	}
	
	public int getScore1(){
		return score1;
	}
	public int getScore2(){
		return score2;
	}
	public JButton getButton(){
		return button;
	}
	public String getDirection(){
		return direction;
	}
	public int getIndex(){
		return index;
	}
}
