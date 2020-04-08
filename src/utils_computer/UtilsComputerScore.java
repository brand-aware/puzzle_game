/**
 * @author mike802
 * @version 1.0 - 8/17/2013
 */
package utils_computer;

import java.util.ArrayList;

import javax.swing.JButton;

public class UtilsComputerScore extends UtilsComputerAI{
	
	protected void recordHorizontal(
			JButton button, 
			ArrayList<JButton> horizontal, 
			ArrayList<JButton> vertical, 
			int position, 
			boolean hzl){
		
		int scoreTop = 0;
		int scoreBottom = 0;
		int size = horizontal.size();
		int levelWidth = (int)Math.floor(position / width);
		if(hzl && (position >= width)){
			scoreTop = updateGraph.recordTop(
					horizontal, 
					vertical, 
					position, 
					levelWidth);
		}
		if(hzl && (position < (size - width))){
			scoreBottom = updateGraph.recordBottom(
					horizontal, 
					vertical, 
					position, 
					levelWidth);
		}
			
		if(hzl){
			scoreGraph.update(scoreTop, scoreBottom, button, position, "HORIZONTAL");
		}
	}
	
	protected void recordVertical(
			JButton button, 
			ArrayList<JButton> horizontal, 
			ArrayList<JButton> vertical, 
			int position, 
			boolean vtl){
		
		int scoreLeft = 0;
		int scoreRight = 0;
		
		int levelHeight = (int)Math.floor(position / (width + 1));
		levelHeight++;
		int number = ((width + 1) * (levelHeight - 1)) + width;
		if(number < 0){
			number = width;
		}
		if(vtl && (position != number)){
			scoreRight = updateGraph.recordRight(
					horizontal, 
					vertical, 
					position, 
					levelHeight);
		}
		number = ((levelHeight - 1) * width) + (levelHeight - 1);
		if(vtl && (position != number)){
			scoreLeft = updateGraph.recordLeft(
					horizontal, 
					vertical, 
					position, 
					levelHeight);
		}
					
		if(vtl){
			scoreGraph.update(scoreRight, scoreLeft, button, position, "VERTICAL");
		}
	}

}
