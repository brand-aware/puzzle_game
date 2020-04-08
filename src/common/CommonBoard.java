/**
 * @author mike802
 * @version 1.0 - 8/17/2013
 */
package common;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import utils_board.BoardButtonHandler;

import config.ConfigBoard;
import core.Computer;

public class CommonBoard extends ConfigBoard{
	
	protected Computer computer;
	protected JDesktopPane desktopPane;
	
	protected ArrayList<JButton> linesHorizontal = new ArrayList<JButton>();
	protected ArrayList<JButton> linesVertical = new ArrayList<JButton>();
	protected JButton button;
	protected JLabel background;

	protected BoardButtonHandler handler;
	
	protected int height;
	protected int width;
	
	protected int scorePlayer = 0;
	protected int scoreCpu = 0;
		
	protected int counter1 = 0;
	protected int counter2 = 0;
	
	protected int totalX = 0;
	protected int totalY = 0;
	protected int gameAreaX = 0;
	protected JLabel labelHorizontal, labelVertical;
	protected JTextField player, cpu;
}
