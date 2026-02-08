/**
 * @author mike802
 * @version 1.0 - 8/17/2013
 */
package utils_board;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import common.CommonBoard;
import core.Computer;
import core.ScoreGraph;

public class UtilsBoardGame extends CommonBoard{

	public void gameLoop(ActionEvent event){
		button = (JButton) event.getSource();
		button.setBackground(Color.RED);
		
		scorePlayer += computer.move(linesHorizontal, linesVertical, button);
		player.setText(scorePlayer + "");
		
		completeCheck();
		
		button = computer.cpuMove(linesHorizontal, linesVertical);
		button.setBackground(Color.RED);
		
		scoreCpu += computer.move(linesHorizontal, linesVertical, button);
		cpu.setText(scoreCpu + "");
		
		completeCheck();
	}
	
	protected void completeCheck(){
		if(computer.gameComplete(linesVertical, linesHorizontal)){
			String message = "";
			if(scorePlayer > scoreCpu){
				message += "GAME OVER\nPlayer wins";
				JOptionPane.showMessageDialog(null, message);
				reset();
			}else if(scoreCpu > scorePlayer){
				message += "GAME OVER\nCpu wins";
				JOptionPane.showMessageDialog(null, message);
				reset();
			}else{
				message += "GAME OVER\ntie";
				JOptionPane.showMessageDialog(null, message);
				reset();
			}
		}
	}
	
	public void reset(){
		for(int x = 0; x < linesHorizontal.size(); x++){
			linesHorizontal.get(x).setBackground(Color.LIGHT_GRAY);
		}
		
		for(int y = 0; y < linesVertical.size(); y++){
			linesVertical.get(y).setBackground(Color.LIGHT_GRAY);
		}
		
		scorePlayer = 0;
		scoreCpu = 0;
		player.setText(scorePlayer + "");
		cpu.setText(scoreCpu + "");
		
		computer = new Computer(new ScoreGraph(linesHorizontal, linesVertical));
		computer.setSize(width, height);
	}
	
}
