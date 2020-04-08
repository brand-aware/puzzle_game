/**
 * @author mike802
 * @version 1.0 - 3/2/2013
 */
package core;

import java.util.ArrayList;

import javax.swing.JButton;

import core.doc.IScoreGraph;

public class ScoreGraph implements IScoreGraph{
		
	//board
	private ArrayList<JButton> horizontal, vertical;
	
	private ArrayList<NodeList> originalMoves = new ArrayList<NodeList>();
	
	public ScoreGraph(ArrayList<JButton> hzl, ArrayList<JButton> vtl){
		horizontal = hzl;
		vertical = vtl;
		initializeMoves();
	}
	
	/*public final void init(ArrayList<JButton> hzl, ArrayList<JButton> vtl){
		if(scoreGraph == null){
			scoreGraph = new ScoreGraph(hzl, vtl);
		}
	}*/
	
	private final void initializeMoves(){
		NodeList root = new NodeList(0, 0);
		ArrayList<ScoreNode> scores = root.getAll();
		
		ScoreNode node;
		JButton button;
		for(int x = 0; x < horizontal.size(); x++){
			button = horizontal.get(x);
			node = new ScoreNode(0, 0, button, x, "HORIZONTAL");
			scores.add(node);
		}
		
		for(int y = 0; y < vertical.size(); y++){
			button = vertical.get(y);
			node = new ScoreNode(0, 0, button, y, "VERTICAL");
			scores.add(node);
		}
		
		root.set(scores);
		originalMoves.add(root);
	}
	
	public final void update(int score1, int score2, JButton selection, int position, String direction){
		ScoreNode node = new ScoreNode(score1, score2, selection, position, direction);
		if(duplicateScore(node)){
			int index = index(node);
			if(duplicateNode(node, index)){
				System.out.println("SCORES NOT BEING REMOVED");
			}else{
				NodeList list = originalMoves.get(index);
				list.add(node);
			}
		}else{
			NodeList newList = new NodeList(score1, score2);
			newList.add(node);
			originalMoves.add(newList);
		}
		removeStaleScore(node, selection);
	}
	
	private final boolean duplicateScore(ScoreNode node){
		System.out.print("duplicateScore - ");
		for(int x = 0; x < originalMoves.size(); x++){
			NodeList move = originalMoves.get(x);
			int score1_1 = move.getScore1();
			int score1_2 = move.getScore2();
			
			int score2_1 = node.getScore1();
			int score2_2 = node.getScore2();
			
			if(score1_1 == score2_1 &&
					score1_2 == score2_2){
				System.out.println("found");
				return true;
			}
		}
		System.out.println("not found");
		return false;
	}
	
	private final int index(ScoreNode node){
		int index = -1;
		for(int x = 0; x < originalMoves.size(); x++){
			NodeList move = originalMoves.get(x);
			int score1_1 = move.getScore1();
			int score1_2 = move.getScore2();
			
			int score2_1 = node.getScore1();
			int score2_2 = node.getScore2();
			
			if(score1_1 == score2_1 &&
					score1_2 == score2_2){
				return x;
			}
		}
		
		return index;
	}
	
	private final boolean duplicateNode(ScoreNode node, int index){
		System.out.println("duplicateNode: " + node.getDirection() + ", " +node.getIndex() + ", " + node.getScore1() + ", " + node.getScore2() + " --- index: " + index);
		NodeList nodeList = originalMoves.get(index);
		ArrayList<ScoreNode> scores = nodeList.getAll();
		int size = scores.size();
		for(int x = 0; x < size; x++){
			ScoreNode node2 = scores.get(x);
			
			if(node.getButton() == node2.getButton()){
				return true;
			}
		}
		
		return false;
	}
	
	public final void removeInvalidMove(int index, String direction){
		for(int x = 0; x < originalMoves.size(); x++){
			NodeList list = originalMoves.get(x);
			ArrayList<ScoreNode> scores = list.getAll();
			for(int y = 0; y < scores.size(); y++){
				ScoreNode node = scores.get(y);
				int index2 = node.getIndex();
				String direction2 = node.getDirection();
				if(index == index2 &&
						direction.compareTo(direction2) == 0){
					scores.remove(y);
					y--;
					System.out.println("removing invalid move: " + index + ", " + direction);
				}
			}
			scores.trimToSize();
			if(scores.size() < 1){
				originalMoves.remove(x);
				x--;
			}
		}
	}
	
	public final ArrayList<NodeList> getMoves(){
		return originalMoves;
	}
	
	private final void removeStaleScore(ScoreNode newScore, JButton button){
		for(int x = 0; x < originalMoves.size(); x++){
			NodeList list = originalMoves.get(x);
			ArrayList<ScoreNode> scores = list.getAll();
			for(int y = 0; y < scores.size(); y++){
				ScoreNode node = scores.get(y);
				if(!same(node, newScore)){
					JButton button2 = node.getButton();
					if(button == button2){
						scores.remove(y);
						y--;
						//System.out.println("score updated");
					}
				}
			}
			scores.trimToSize();
			if(scores.size() < 1){
				originalMoves.remove(x);
				x--;
			}
		}
	}
	private final boolean same(ScoreNode node1, ScoreNode node2){
		int score1_1 = node1.getScore1();
		int score1_2 = node1.getScore2();
		int score2_1 = node2.getScore1();
		int score2_2 = node2.getScore2();
		JButton button1 = node1.getButton();
		JButton button2 = node2.getButton();
		
		if(score1_1 == score2_1 &&
				score1_2 == score2_2 &&
				button1 == button2){
			return true;
		}
		
		return false;
	}
}
