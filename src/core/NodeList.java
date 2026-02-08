/**
 * @author mike802
 * @version 1.0 - 3/2/2013
 */
package core;

import java.util.ArrayList;

import core.doc.INodeList;

public class NodeList implements INodeList{
	
	private int score1 = 0;
	private int score2 = 0;
	
	private ArrayList<ScoreNode> similar = new ArrayList<ScoreNode>();
	
	public NodeList(int s1, int s2){
		score1 = s1;
		score2 = s2;
	}
	
	public void add(ScoreNode node){
		similar.add(node);
	}
	
	public void set(ArrayList<ScoreNode> list){
		similar = list;
	}
	
	public ArrayList<ScoreNode> getAll(){
		return similar;
	}
	public int getScore1(){
		return score1;
	}
	public int getScore2(){
		return score2;
	}
}
