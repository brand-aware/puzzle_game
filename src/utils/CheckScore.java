/**
 * @author mike802
 * @version 1.0 - 8/17/2013
 */
package utils;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;

import utils.doc.ICheckScore;

import core.Computer;

public class CheckScore implements ICheckScore{
	
	private Computer computer;
	
	public CheckScore(Computer cmp){
		computer = cmp;
	}

	public boolean isHorizontal(ArrayList<JButton> horizontal, JButton selection){
		boolean hzl = false;
		for(int x = 0; x < horizontal.size(); x++){
			JButton button = horizontal.get(x);
			if(button == selection){
				computer.setIndex(x);
				hzl = true;
			}
		}
		return hzl;
	}
	
	public boolean isVertical(ArrayList<JButton> vertical, JButton selection){
		boolean vtl = false;
		for(int y = 0; y < vertical.size(); y++){
			JButton button = vertical.get(y);
			if(button == selection){
				computer.setIndex(y);
				vtl = true;
			}
		}
		return vtl;
	}
	
	public int checkForScore(
			ArrayList<JButton> horizontal, 
			ArrayList<JButton> vertical, 
			int levelWidth, 
			int levelHeight,
			int sizeHorizontal,
			boolean hzl,
			boolean vtl){
		
		int score = 0;
		int index = computer.getIndex();
		int width = computer.getWidth();
		
		if(hzl && index >= width){
			score += checkTop(horizontal, vertical, levelWidth);
		}
		
		if(hzl && index < (sizeHorizontal - width)){
			score += checkBottom(horizontal, vertical, levelWidth);
		}
		
		int number = ((width + 1) * (levelHeight - 1)) + width;
		if(number < 0){
			number = width;
		}
		if(vtl && index != number){
			score += checkRight(horizontal, vertical, levelHeight);
		}
		
		number = ((levelHeight - 1) * width) + (levelHeight - 1);
		if(vtl && index != number){
			score += checkLeft(horizontal, vertical, levelHeight);
		}
		
		return score;
	}
	
	private int checkTop(
			ArrayList<JButton> horizontal,
			ArrayList<JButton> vertical, 
			int levelWidth){
		
		int score = 0;
		int index = computer.getIndex();
		int width = computer.getWidth();
		int top = index - width;
		int left = index - (width - (levelWidth - 1));
		int right = index - (width - levelWidth);
		if(vertical.get(right).getBackground() == Color.RED &&
			vertical.get(left).getBackground() == Color.RED &&
			horizontal.get(top).getBackground() == Color.RED){
			score++;
		}
		
		return score;
	}
	
	private int checkBottom(
			ArrayList<JButton> horizontal, 
			ArrayList<JButton> vertical, 
			int levelWidth){
		
		int score = 0;
		levelWidth++;
		int index = computer.getIndex();
		int width = computer.getWidth();
		int bottom = index + width;
		int left = index + (levelWidth - 1);
		int right = index + levelWidth;
		if(vertical.get(left).getBackground() == Color.RED &&
			vertical.get(right).getBackground() == Color.RED &&
			horizontal.get(bottom).getBackground() == Color.RED){
			score++;
		}
		return score;
	}
	
	private int checkRight(
			ArrayList<JButton> horizontal, 
			ArrayList<JButton> vertical, 
			int levelHeight){
		
		int score = 0;
		int index = computer.getIndex();
		int width = computer.getWidth();
		int right = index + 1;
		int top = index - (levelHeight - 1);
		int bottom = index + (width - (levelHeight - 1));
		if(horizontal.get(top).getBackground() == Color.RED &&
			horizontal.get(bottom).getBackground() == Color.RED &&
			vertical.get(right).getBackground() == Color.RED){
			score++;
		}
		return score;
	}
	
	private int checkLeft(
			ArrayList<JButton> horizontal, 
			ArrayList<JButton> vertical, 
			int levelHeight){
		
		int score = 0;
		int index = computer.getIndex();
		int width = computer.getWidth();
		int left = index - 1;
		int top = index - levelHeight;
		int bottom = index + (width - levelHeight);
		if(horizontal.get(top).getBackground() == Color.RED &&
			horizontal.get(bottom).getBackground() == Color.RED &&
			vertical.get(left).getBackground() == Color.RED){
			score++;
		}
		return score;
	}
	
}
