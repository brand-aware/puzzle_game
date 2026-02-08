/**
 * @author mike802
 * @version 1.0 - 3/2/2013
 */
package settings;

public class ApplicationSettings {

	private String difficulty = "NORMAL";
	
	private final String[] DIFFICULTY_LIST = {"MOST_EASY", "EASY", "NORMAL", "HARD"};
	
	public String getDifficulty(){
		return difficulty;
	}
	
	public String[] getDifficultyList(){
		return DIFFICULTY_LIST;
	}
	
	public void setDifficulty(String diff){
		difficulty = diff;
	}
	
}
