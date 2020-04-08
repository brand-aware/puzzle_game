/**
 * @author mike802
 * @version 1.0 - 8/17/2013
 */
package utils_board;

import java.awt.Color;

import javax.swing.JButton;

public class UtilsBoardRoot extends UtilsBoardGame{

	protected void createVerticalButtons(){
		int topYStuff = TITLE_HEIGHT + PLAYER_SCORE_HEIGHT + CPU_SCORE_HEIGHT + 10 + 50;
		int numWidth = width + 1;
		for(int y = 0; y < (height * numWidth); y++){
			button = new JButton();
			int rowNum = Math.floorDiv(y, numWidth);
			int ycoord = topYStuff + (BUTTON_LONG * rowNum) + (BUTTON_NARROW * rowNum);
			int colPos = y % numWidth;
			int xcoord = (BUTTON_LONG * colPos) + (BUTTON_NARROW * (colPos + 1)) + ((totalX / 2) - (gameAreaX / 2));
			button.setBounds(xcoord, ycoord, BUTTON_NARROW, BUTTON_LONG);
			button.addActionListener(handler);
			button.setBackground(Color.LIGHT_GRAY);
			linesVertical.add(button);
			desktopPane.add(button);
			desktopPane.moveToFront(button);
		}
	}
	
	protected void createHorizontalButtons(){
		int topYStuff = TITLE_HEIGHT + PLAYER_SCORE_HEIGHT + CPU_SCORE_HEIGHT + 50;
		int numHeight = height + 1;
		for(int x = 0; x < (width * numHeight); x++){
			button = new JButton();
			int rowNum = Math.floorDiv(x, width);
			int ycoord = topYStuff + (BUTTON_LONG * rowNum) + (BUTTON_NARROW * (rowNum + 1));
			int colPos = x % width;
			int xcoord = 10 + (BUTTON_LONG * colPos) + (BUTTON_NARROW * colPos) + ((totalX / 2) - (gameAreaX / 2));
			button.setBounds(xcoord, ycoord, BUTTON_LONG, BUTTON_NARROW);
			button.addActionListener(handler);
			button.setBackground(Color.LIGHT_GRAY);
			linesHorizontal.add(button);
			desktopPane.add(button);
			desktopPane.moveToFront(button);
		}
	}
}