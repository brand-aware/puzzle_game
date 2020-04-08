/**
 * @author mike802
 * @version 1.0 - 8/17/2013
 */
package utils_computer;

import java.util.ArrayList;

import javax.swing.JButton;

public class UtilsComputerRoot extends UtilsComputerScore {
	
	protected int findScore(
			ArrayList<JButton> horizontal, 
			ArrayList<JButton> vertical, 
			boolean hzl, 
			boolean vtl){
		
		int levelWidth = (int)Math.floor(index / width);
		int sizeHorizontal = horizontal.size();
		int levelHeight = (int)Math.floor(index / (width + 1));
		levelHeight++;
		
		int score = checkScore.checkForScore(
				horizontal, 
				vertical, 
				levelWidth, 
				levelHeight, 
				sizeHorizontal, 
				hzl, 
				vtl);
		
		return score;
	}
	
	protected void updateHorizontal(
			ArrayList<JButton> horizontal, 
			ArrayList<JButton> vertical, 
			int position, 
			int width, 
			boolean hzl){
		
		int size = horizontal.size();
		int levelWidth = (int)Math.floor(position / width);
				
		if(hzl && (position >= width)){
			updateScore.updateTop(
					horizontal, 
					vertical, 
					position, 
					levelWidth);
		}
				
		if(hzl && (position < (size - width))){
			updateScore.updateBottom(
					horizontal, 
					vertical, 
					position, 
					levelWidth);
		}
	}
	
	protected void updateVertical(
			ArrayList<JButton> horizontal, 
			ArrayList<JButton> vertical, 
			int position, 
			int width, 
			boolean vtl){
		
		int levelHeight = (int)Math.floor(position / (width + 1));
		levelHeight++;
				
		int number = ((width + 1) * (levelHeight - 1)) + width;
		if(number < 0){
			number = width;
		}
		if(vtl && (position != number)){
			updateScore.updateRight(
					horizontal, 
					vertical, 
					position, 
					levelHeight);
		}
				
		number = ((levelHeight - 1) * width) + (levelHeight - 1);
		if(vtl && (position != number)){
			updateScore.updateLeft(
					horizontal, 
					vertical, 
					position, 
					levelHeight);
		}
	}

}
