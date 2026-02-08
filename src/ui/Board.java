/**
 * @author mike802
 * @version 1.0 - 3/2/2013
 */
package ui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import utils_board.BoardButtonHandler;
import utils_board.UtilsBoardRoot;

import core.Computer;
import core.ScoreGraph;
import settings.Properties;

public class Board extends UtilsBoardRoot{

	private JFrame page = null;
	private Properties properties;
	private Setup setup;
	private Board board;
	
	private boolean initialized = false;
	
	private MenuHandler menuHandler;
	private JMenuBar menuBar;
	private JMenu file, options, help;
	private JMenuItem exit, propertiesMenu, about;
	
	public Board(Properties props){
		page = new JFrame("puzzle_game");
		desktopPane = new JDesktopPane();
		properties = props;
		board = this;
		menuHandler = new MenuHandler();
	}
	
	private void createBoard(){		
		calcTotalX();
		calcGameAreaX();
		calcTotalY();
		desktopPane.setPreferredSize(new Dimension(totalX, totalY + 50));
		
		Image logo = Toolkit.getDefaultToolkit().getImage(properties.getCompany());
		page.setIconImage(logo);
		page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		page.setResizable(true);
		handler = new BoardButtonHandler(this);
		
		menuBar = new JMenuBar();
		file = new JMenu("file");
		options = new JMenu("options");
		help = new JMenu("help");
		
		exit = new JMenuItem("exit");
		exit.addActionListener(menuHandler);
		propertiesMenu = new JMenuItem("properties");
		propertiesMenu.addActionListener(menuHandler);
		about = new JMenuItem("about");
		about.addActionListener(menuHandler);
		
		file.add(exit);
		options.add(propertiesMenu);
		help.add(about);
		menuBar.add(file);
		menuBar.add(options);
		menuBar.add(help);
		page.setJMenuBar(menuBar);		
		
		background = new JLabel();
		background.setBounds(0, 0, totalX, totalY + 50);
		ImageIcon backgroundImage = new ImageIcon(properties.getBackground());
		background.setIcon(backgroundImage);
		desktopPane.add(background);

		JLabel title = new JLabel();
		ImageIcon titleImage = new ImageIcon(properties.getLogo());
		title.setIcon(titleImage);
		title.setBounds(((totalX / 2) - (TITLE_WIDTH / 2)), 0, TITLE_WIDTH, TITLE_HEIGHT);
		
		createHorizontalButtons();
		createVerticalButtons();
		computer = new Computer(new ScoreGraph(linesHorizontal, linesVertical));
		computer.setSize(width, height);
		
		int score1x = (TITLE_WIDTH / 2) - ((CPU_SCORE_WIDTH + 70) / 2) + ((totalX / 2) - (TITLE_WIDTH / 2)); 
		int score1y = TITLE_HEIGHT + 5;
		JLabel playerLabel = new JLabel("Player: ");
		playerLabel.setBounds(score1x, score1y, 70, PLAYER_SCORE_HEIGHT);
		JLabel cpuLabel = new JLabel("Computer: ");
		int score2y = score1y + PLAYER_SCORE_HEIGHT + 5;
		cpuLabel.setBounds(score1x, score2y, 70, CPU_SCORE_HEIGHT);
		
		int score2x = score1x + 70;
		player = new JTextField();
		player.setBounds(score2x, score1y, PLAYER_SCORE_WIDTH, PLAYER_SCORE_HEIGHT);
		player.setText(scorePlayer + "");
		player.setEditable(false);
		
		cpu = new JTextField();
		cpu.setBounds(score2x, score2y, CPU_SCORE_WIDTH, CPU_SCORE_HEIGHT);
		cpu.setText(scoreCpu + "");
		cpu.setEditable(false);
		
		desktopPane.add(title);
		desktopPane.add(playerLabel);
		desktopPane.add(cpuLabel);
		desktopPane.add(player);
		desktopPane.add(cpu);
		
		desktopPane.moveToFront(title);
		desktopPane.moveToFront(playerLabel);
		desktopPane.moveToFront(cpuLabel);
		desktopPane.moveToFront(player);
		desktopPane.moveToFront(cpu);
		
		page.add(desktopPane);
		page.pack();
		page.setVisible(true);
	}
	
	private void calcTotalX(){
		totalX = (width * BUTTON_LONG) + (width * (BUTTON_NARROW + 1)) 
				+ (BUTTON_LONG * 2);
		if(TITLE_WIDTH > totalX){
			totalX = TITLE_WIDTH + 100;
		}
	}
	private void calcTotalY(){
		totalY = TITLE_HEIGHT + PLAYER_SCORE_HEIGHT + CPU_SCORE_HEIGHT 
				+ EXIT_BUTTON_HEIGHT + (height * BUTTON_LONG) 
				+ (height * BUTTON_NARROW);
	}
	private void calcGameAreaX(){
		gameAreaX = (width * BUTTON_LONG) + (width * (BUTTON_NARROW + 1)) + 30;
	}
	
	private class MenuHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == exit){
				System.exit(0);
			}else if(event.getSource() == propertiesMenu){
				setup = new Setup(board, properties, height, width);
				setup.init();
				setup.setVisible(true);
				desktopPane.add(setup);
				disableBackground();
				try {
					setup.setSelected(true);
				} catch (PropertyVetoException e) {
					e.printStackTrace();
				}
			}else if(event.getSource() == about){
				String message = "puzzle_game\n\n\n"
				+ "board consists of a grid of varying size."
				+ "\n\nplayers take turns selecting sides of the squares "
				+ "within the grid.\n\n" 
				+ "board starts out with all sides empty.\n\n" 
				+ "players gain points by completing squares (4 filled in "
				+ "sides makes a square).\n\n" 
				+ "most points wins";
				JOptionPane.showMessageDialog(null, 
						message, 
						"INSTRUCTIONS", 
						JOptionPane.INFORMATION_MESSAGE, 
						new ImageIcon(properties.getCompany()));
			}
		}
	}
	
	public JButton getButton(){
		return button;
	}
	
	public void init(){
		width = WIDTH_DEFAULT_VALUE;
		height = HEIGHT_DEFAULT_VALUE;
		if(!initialized){
			createBoard();
			initialized = true;
		}else{
			desktopPane.setEnabled(true);
		}
	}
	
	private void disableBackground(){
		file.setEnabled(false);
		options.setEnabled(false);
		help.setEnabled(false);
		disableButtons();
	}
	
	private void disableButtons(){
		for(int x = 0; x < linesVertical.size(); x++){
			linesVertical.get(x).setEnabled(false);
		}
		for(int y = 0; y < linesHorizontal.size(); y++){
			linesHorizontal.get(y).setEnabled(false);
		}
	}
	
	public void enableBackground(){
		file.setEnabled(true);
		options.setEnabled(true);
		help.setEnabled(true);
		enableButtons();
	}
	
	public void clearBoard(){
		for(int x = 0; x < linesVertical.size(); x++){
			desktopPane.moveToBack(linesVertical.get(x));
		}
		for(int y = 0; y < linesHorizontal.size(); y++){
			desktopPane.moveToBack(linesHorizontal.get(y));
		}
	}
	
	public void showBoard(){
		linesVertical = new ArrayList<JButton>();
		linesHorizontal = new ArrayList<JButton>();
		createVerticalButtons();
		createHorizontalButtons();
	}
	
	private void enableButtons(){
		for(int x = 0; x < linesVertical.size(); x++){
			linesVertical.get(x).setEnabled(true);
		}
		for(int y = 0; y < linesHorizontal.size(); y++){
			linesHorizontal.get(y).setEnabled(true);
		}
	}
	
	public void setSize(int ht, int wd){
		height = ht;
		width = wd;
		computer.setSize(ht, wd);
	}
	
	public void redrawGameArea(){
		calcTotalX();
		calcGameAreaX();
		calcTotalY();
		desktopPane.setPreferredSize(new Dimension(totalX, totalY + 50));
		background.setBounds(0, 0, totalX, totalY + 50);
		page.pack();
		
		clearBoard();
		showBoard();
	}
	
	public void setDifficulty(int index){
		computer.setDifficulty(index);
	}
	
}
