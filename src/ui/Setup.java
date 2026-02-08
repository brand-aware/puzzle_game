/**
 * @author mike802
 * @version 1.0 - 3/2/2013
 */
package ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import config.ConfigSetup;
import settings.Properties;

public class Setup extends ConfigSetup{
	
	/**
	 * generated serial version UID
	 */
	private static final long serialVersionUID = -7567196007045570328L;

	private ButtonHandler handler;
	private WindowHandler windowHandler;
	private ChangeListener listener;
	private Board board;
	private Properties properties;
	
	private JButton ok, cancel;
	private JComboBox<String> difficulty;
	private String[] difficultyList = {"Most Easy", "Easy", "Normal", "Hard"};
	
	private JCheckBox customCheck;
	private JTextField height, width;
	private int gameHeight, gameWidth;
	
	private boolean initialized = false;
	
	public Setup(Board b, Properties p, int ht, int wd){
		super();
		board = b;
		properties = p;
		setSize(300, 300);
		setLocation(100, 100);
		windowHandler = new WindowHandler();
		gameHeight = ht;
		gameWidth = wd;
	}
	
	private void createPage(){
		handler = new ButtonHandler();
		listener = new ChangeListener();
		addInternalFrameListener(windowHandler);
		setFrameIcon(new ImageIcon(properties.getCompanyFrame()));
		
		JLabel title = new JLabel("Welcome to Puzzle Game.  Choose a difficulty and start playing!");
		
		JLabel difficultyLabel = new JLabel("difficulty: ");
		difficulty = new JComboBox<String>(difficultyList);
		difficulty.addItemListener(listener);
		difficulty.setSelectedIndex(DIFFICULTY_DEFAULT);
		
		JLabel checkLabel = new JLabel("click to enable custom board size");
		customCheck = new JCheckBox();
		customCheck.addItemListener(listener);
		
		JLabel heightLabel = new JLabel("height: ");
		height = new JTextField();
		
		height.setText("" + gameHeight);
		height.setPreferredSize(new Dimension(HEIGHT_FIELD_WIDTH, HEIGHT_FIELD_HEIGHT));
		height.setEnabled(false);
		
		JLabel widthLabel = new JLabel("width: ");
		width = new JTextField();
		width.setText("" + gameWidth);
		width.setPreferredSize(new Dimension(WIDTH_FIELD_WIDTH, WIDTH_FIELD_HEIGHT));
		width.setEnabled(false);
		
		ok = new JButton("ok");
		ok.setPreferredSize(new Dimension(START_BUTTON_WIDTH, START_BUTTON_HEIGHT));
		ok.addActionListener(handler);
		
		cancel = new JButton("cancel");
		cancel.setPreferredSize(new Dimension(EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT));
		cancel.addActionListener(handler);
		
		JPanel panel1, panel2, panel3, panel4, panel5, panel6;
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		
		panel1.add(Box.createGlue());
		panel1.add(title);
		
		
		panel2.add(Box.createGlue());
		panel2.add(difficultyLabel);
		panel2.add(difficulty);
		
		panel3.add(Box.createGlue());
		panel3.add(customCheck);
		panel3.add(checkLabel);
		
		panel4.add(Box.createGlue());
		panel4.add(heightLabel);
		panel4.add(height);
		
		panel5.add(Box.createGlue());
		panel5.add(widthLabel);
		panel5.add(width);
		
		panel6.add(Box.createGlue());
		panel6.add(ok);
		panel6.add(cancel);
		
		Box box = Box.createVerticalBox();
		box.add(Box.createVerticalGlue());
		box.add(panel1);
		box.add(panel2);
		box.add(panel3);
		box.add(panel4);
		box.add(panel5);
		box.add(panel6);

		add(box);
		pack();
		setVisible(true);
	}
	
	private class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource()== ok){
				int index = difficulty.getSelectedIndex();
				if(customCheck.isSelected()){
					int ht = Integer.parseInt(height.getText());
					int wd = Integer.parseInt(width.getText());
					if(ht > 6 || wd > 6){
						JOptionPane.showMessageDialog(null, 
								"Max game area size exceeded...", 
								"!!!", 
								JOptionPane.INFORMATION_MESSAGE, 
								new ImageIcon(properties.getCompany()));
					}else{
						board.setSize(ht, wd);
						board.redrawGameArea();
						board.reset();
						board.setDifficulty(index);
						board.enableBackground();
						dispose();
					}
				}else{
					board.reset();
					board.setDifficulty(index);
					board.enableBackground();
					dispose();
				}
			}else if(event.getSource() == cancel){
				board.enableBackground();
				dispose();
			}
		}
	}
	
	private class ChangeListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent event) {
			if(event.getSource() == customCheck){
				if(customCheck.isSelected()){
					height.setEnabled(true);
					width.setEnabled(true);
				}else{
					height.setEnabled(false);
					width.setEnabled(false);
				}
			}else if(event.getSource() == difficulty){
				
			}
		}
	}
	
	private class WindowHandler implements InternalFrameListener {

		@Override
		public void internalFrameActivated(InternalFrameEvent arg0) {}
		@Override
		public void internalFrameClosed(InternalFrameEvent arg0) {
			board.enableBackground();			
		}
		@Override
		public void internalFrameClosing(InternalFrameEvent arg0) {}
		@Override
		public void internalFrameDeactivated(InternalFrameEvent arg0) {}
		@Override
		public void internalFrameDeiconified(InternalFrameEvent arg0) {}
		@Override
		public void internalFrameIconified(InternalFrameEvent arg0) {}
		@Override
		public void internalFrameOpened(InternalFrameEvent arg0) {}
	}
	
	public final void init(){
		if(!initialized){
			createPage();
			initialized = true;
		}
	}
}
