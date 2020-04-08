/**
 * @author mike802
 * @version 1.0 - 8/17/2013
 */
package config;

import javax.swing.JInternalFrame;

public class ConfigSetup extends JInternalFrame{
	
	/**
	 * generated serial version UID
	 */
	private static final long serialVersionUID = 6125910518058144359L;
	
	protected final int INSTRUCTIONS_BUTTON_WIDTH = 130;
	protected final int INSTRUCTIONS_BUTTON_HEIGHT = 20;
	
	protected final int HEIGHT_FIELD_WIDTH = 50;
	protected final int HEIGHT_FIELD_HEIGHT = 30;
	
	protected final int WIDTH_FIELD_WIDTH = 50;
	protected final int WIDTH_FIELD_HEIGHT = 30;
	
	protected final int START_BUTTON_WIDTH = 100;
	protected final int START_BUTTON_HEIGHT = 30;
	
	protected final int EXIT_BUTTON_WIDTH = 100;
	protected final int EXIT_BUTTON_HEIGHT = 30;

	protected final int DIFFICULTY_DEFAULT = 2;
	
	public ConfigSetup(){
		super("properties", false, true, false, false);
	}
	
}
