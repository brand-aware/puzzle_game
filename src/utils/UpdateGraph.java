/**
 * @author mike802
 * @version 1.0 - 8/17/2013
 */
package utils;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;

import utils.doc.IUpdateGraph;

import core.Computer;

public class UpdateGraph implements IUpdateGraph{
	
	private Computer computer;
	
	public UpdateGraph(Computer cmp){
		computer = cmp;
	}
	
	public int recordTop(
			ArrayList<JButton> horizontal, 
			ArrayList<JButton> vertical, 
			int position, 
			int levelWidth){
		
		int score = 0;
		int width = computer.getWidth();
		int top = position - width;
		int left = position - (width - (levelWidth - 1));
		int right = position - (width - levelWidth);
		if(vertical.get(right).getBackground() == Color.RED){
			score++;
		}
		if(vertical.get(left).getBackground() == Color.RED){
			score++;
		}
		if(horizontal.get(top).getBackground() == Color.RED){
			score++;
		}
		return score;
	}
	
	public int recordBottom(
			ArrayList<JButton> horizontal, 
			ArrayList<JButton> vertical, 
			int position, 
			int levelWidth){
		
		int score = 0;
		levelWidth++;
		int width = computer.getWidth();
		int bottom = position + width;
		int left = position + (levelWidth - 1);
		int right = position + levelWidth;
		if(vertical.get(left).getBackground() == Color.RED){
			score++;
		}
		if(vertical.get(right).getBackground() == Color.RED){
			score++;
		}
		if(horizontal.get(bottom).getBackground() == Color.RED){
			score++;
		}
		return score;
	}
	
	public int recordRight(
			ArrayList<JButton> horizontal,
			ArrayList<JButton> vertical, 
			int position, 
			int levelHeight){
		
		int score = 0;
		int width = computer.getWidth();
		int right = position + 1;
		int top = position - (levelHeight - 1);
		int bottom = position + (width - (levelHeight - 1));
		if(horizontal.get(top).getBackground() == Color.RED){
			score++;
		}
		if(horizontal.get(bottom).getBackground() == Color.RED){
			score++;
		}
		if(vertical.get(right).getBackground() == Color.RED){
			score++;
		}
		return score;
	}
	
	public int recordLeft(
			ArrayList<JButton> horizontal, 
			ArrayList<JButton> vertical, 
			int position, 
			int levelHeight){
		
		int score = 0;
		int width = computer.getWidth();
		int left = position - 1;
		int top = position - levelHeight;
		int bottom = position + (width - levelHeight);
		if(horizontal.get(top).getBackground() == Color.RED) {
			score++;
		}
		if(horizontal.get(bottom).getBackground() == Color.RED) {
			score++;
		}
		if(vertical.get(left).getBackground() == Color.RED){
			score++;
		}
		return score;
	}

}
