/**
 * @author mike802
 * @version 1.0 - 8/17/2013
 */
package utils_board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.Board;

public class BoardButtonHandler implements ActionListener{
	
	Board board;
	
	public BoardButtonHandler(Board game){
		board = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().getClass() == board.getButton().getClass()){
			board.gameLoop(event);
		}
	}
}
