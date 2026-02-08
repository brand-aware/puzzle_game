/**
 * @author mike802
 * @version 1.0 - 8/17/2013
 */
package utils;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;

import core.Computer;

public class UpdateScore {
	
	private Computer computer;
	
	public UpdateScore(Computer cmp){
		computer = cmp;
	}
	
	public void updateTop(
			ArrayList<JButton> horizontal,
			ArrayList<JButton> vertical, 
			int position,
			int levelWidth){
		
		int width = computer.getWidth();
		int top = position - width;
		int left = position - (width - (levelWidth - 1));
		int right = position - (width - levelWidth);
		if(vertical.get(right).getBackground() != Color.RED){
			computer.recordScore(horizontal, vertical, vertical.get(right), right, false, true);
		}
		if(vertical.get(left).getBackground() != Color.RED){
			computer.recordScore(horizontal, vertical, vertical.get(left), left, false, true);
		}
		if(horizontal.get(top).getBackground() != Color.RED){
			computer.recordScore(horizontal, vertical, horizontal.get(top), top, true, false);
		}
	}
	
	public void updateBottom(
			ArrayList<JButton> horizontal, 
			ArrayList<JButton> vertical,
			int position,
			int levelWidth){
		
		levelWidth++;
		int width = computer.getWidth();
		int bottom = position + width;
		int left = position + (levelWidth - 1);
		int right = position + levelWidth;
		if(vertical.get(left).getBackground() != Color.RED){
			computer.recordScore(horizontal, vertical, vertical.get(left), left, false, true);
		}
		if(vertical.get(right).getBackground() != Color.RED){
			computer.recordScore(horizontal, vertical, vertical.get(right), right, false, true);
		}
		if(horizontal.get(bottom).getBackground() != Color.RED){
			computer.recordScore(horizontal, vertical, horizontal.get(bottom), bottom, true, false);
		}
	}
	
	public void updateRight(
			ArrayList<JButton> horizontal, 
			ArrayList<JButton> vertical, 
			int position, 
			int levelHeight){
		
		int width = computer.getWidth();
		int right = position + 1;
		int top = position - (levelHeight - 1);
		int bottom = position + (width - (levelHeight - 1));
		if(horizontal.get(top).getBackground() != Color.RED){
			computer.recordScore(horizontal, vertical, horizontal.get(top), top, true, false);
		}
		if(horizontal.get(bottom).getBackground() != Color.RED){
			computer.recordScore(horizontal, vertical, horizontal.get(bottom), bottom, true, false);
		}
		if(vertical.get(right).getBackground() != Color.RED){
			computer.recordScore(horizontal, vertical, vertical.get(right), right, false, true);
		}
	}
	
	public void updateLeft(
			ArrayList<JButton> horizontal, 
			ArrayList<JButton> vertical, 
			int position, 
			int levelHeight){
		
		int width = computer.getWidth();
		int left = position - 1;
		int top = position - levelHeight;
		int bottom = position + (width - levelHeight);
		if(horizontal.get(top).getBackground() != Color.RED) {
			computer.recordScore(horizontal, vertical, horizontal.get(top), top, true, false);
		}
		if(horizontal.get(bottom).getBackground() != Color.RED) {
			computer.recordScore(horizontal, vertical, horizontal.get(bottom), bottom, true, false);
		}
		if(vertical.get(left).getBackground() != Color.RED){
			computer.recordScore(horizontal, vertical, horizontal.get(left), left, false, true);
		}
	}
}
