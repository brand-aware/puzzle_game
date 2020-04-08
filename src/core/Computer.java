/**
 * @author mike802
 * @version 1.0 - 3/2/2013
 */
package core;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;

import settings.ApplicationSettings;
import utils.CheckScore;
import utils.UpdateGraph;
import utils.UpdateScore;
import utils_computer.UtilsComputerRoot;

public class Computer extends UtilsComputerRoot{
	
	public Computer(ScoreGraph graph){
		settings = new ApplicationSettings();
		scoreGraph = graph;
		
		checkScore = new CheckScore(this);
		updateScore = new UpdateScore(this);
		updateGraph = new UpdateGraph(this);
	}
	
	public final void setSize(int x, int y){
		width = x;
		initialized = true;
	}
	
	public final void setIndex(int idx){
		index = idx;
	}
	
	public final int getIndex(){
		return index;
	}
	
	public final int getWidth(){
		return width;
	}
	
	public final boolean gameComplete(ArrayList<JButton> list1, ArrayList<JButton> list2){
		JButton button;
		for(int x = 0; x < list1.size(); x++){
			button = list1.get(x);
			if(button.getBackground() == Color.LIGHT_GRAY){
				return false;
			}
		}
		
		for(int y = 0; y < list2.size(); y++){
			button = list2.get(y);
			if(button.getBackground() == Color.LIGHT_GRAY){
				return false;
			}
		}
		
		return true;
	}
	
	public final int move(
			ArrayList<JButton> horizontal, 
			ArrayList<JButton> vertical, 
			JButton selection){
		System.out.println("GENERIC MOVE");
		if(!initialized){
			throw new Error("BOARD SIZE NOT SET");
		}
		System.out.println("STARTING: MOVE");
		
		int score = 0;
		JButton button = null;
		index = -1;
		Boolean hzl = false;
		Boolean vtl = false;
		
		hzl = checkScore.isHorizontal(horizontal, selection);
		vtl = checkScore.isVertical(vertical, selection);
		
		score = findScore(horizontal, vertical, hzl, vtl);
		
		updateScore(horizontal, vertical, button, index, hzl, vtl);
		
		return score;
	}
	
	private void updateScore(
			ArrayList<JButton> horizontal, 
			ArrayList<JButton> vertical, 
			JButton button, 
			int position, 
			boolean hzl, 
			boolean vtl){
		System.out.println("updateScore: position - " + position);
		if(hzl){
			scoreGraph.removeInvalidMove(position, "HORIZONTAL");
		}else{
			scoreGraph.removeInvalidMove(position, "VERTICAL");
		}
		
		updateHorizontal(horizontal, vertical, position, width, hzl);
		updateVertical(horizontal, vertical, position, width, vtl);
	}
	
	public void recordScore(ArrayList<JButton> horizontal, ArrayList<JButton> vertical, JButton button, int position, boolean hzl, boolean vtl){	
		recordHorizontal(button, horizontal, vertical, position, hzl);		
		
		recordVertical(button, horizontal, vertical, position, vtl);
	}
	
	public JButton cpuMove(ArrayList<JButton> horizontal, ArrayList<JButton> vertical){
		if(settings.getDifficulty().compareTo("MOST_EASY") == 0){
			return mostEasy(horizontal, vertical);
		}else if(settings.getDifficulty().compareTo("EASY") == 0){
			return easy(horizontal, vertical);		
		}else if(settings.getDifficulty().compareTo("NORMAL") == 0){
			System.out.println("STARTING CPU MOVE: NORMAL");
			return normal(horizontal, vertical);
		}else if(settings.getDifficulty().compareTo("HARD") == 0){
			return hard(horizontal, vertical);
		}
		return null;
	}
	
	public void setDifficulty(int index){
		settings.setDifficulty(settings.getDifficultyList()[index]);
	}
}