/**
 * @author mike802
 * @version 1.0 - 8/17/2013
 */
package utils_computer;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;

import common.CommonComputer;

import core.NodeList;
import core.ScoreNode;

public class UtilsComputerAI extends CommonComputer{
	
	protected JButton mostEasy(ArrayList<JButton> horizontal, ArrayList<JButton> vertical){
		JButton button = null;
		for(int x = 0; x < horizontal.size(); x++){
			button = horizontal.get(x);
			if(button.getBackground() == Color.LIGHT_GRAY){
				return button;
			}
		}
		for(int y = 0; y < vertical.size(); y++){
			button = vertical.get(y);
			if(button.getBackground() == Color.LIGHT_GRAY){
				return button;
			}
		}
		return button;
	}
	
	protected JButton easy(ArrayList<JButton> horizontal, ArrayList<JButton> vertical){
		JButton button = null;
		boolean one = false;
		boolean two = false;
		boolean three = false;
		boolean four = false;
		boolean five = false;
		ArrayList<NodeList> moveList = scoreGraph.getMoves();
		double random = Math.random();
		boolean skip = false;
		if(random <= .05){
			skip = true;
		}
		for(int x = 0; x < moveList.size(); x++){
			NodeList list = moveList.get(x);
			int score1 = list.getScore1();
			int score2 = list.getScore2();
			if(score1 == 3 || score2 == 3){
				if(!skip){
					button = select(list.getAll());
					one = true;
					break;
				}
			}else if(score1 == 1 && score2 != 2){
				if(!skip){
					if(!one){
						button = select(list.getAll());
						two = true;
					}
				}
			}else if(score1 != 2 && score2 == 1){
				if(!one && !two){
					button = select(list.getAll());
					three = true;
				}
			}else if(score1 == 0 && score2 != 2){
				if(!one && !two && !three){
					button = select(list.getAll());
					four = true;
				}
			}else if(score1 != 2 && score1 == 0){
				if(!one && !two && !three && !four){
					button = select(list.getAll());
					five = true;
				}
			}else{
				if(!one && !two && !three && !four && !five){
					button = select(list.getAll());
				}
			}
		}
		
		return button;
	}
	
	public JButton normal(ArrayList<JButton> horizontal, ArrayList<JButton> vertical){
		JButton button = null;
		boolean one = false;
		boolean two = false;
		boolean three = false;
		boolean four = false;
		boolean five = false;
		ArrayList<NodeList> moveList = scoreGraph.getMoves();
		for(int x = 0; x < moveList.size(); x++){
			NodeList list = moveList.get(x);
			int score1 = list.getScore1();
			int score2 = list.getScore2();
			
			if(score1 == 3 || score2 == 3){
				button = select(list.getAll());
				one = true;
				break;
			}else if(score1 == 1 && score2 != 2){
				if(!one){
					button = select(list.getAll());
					two = true;
				}
			}else if(score1 != 2 && score2 == 1){
				if(!one && !two){
					button = select(list.getAll());
					three = true;
				}
			}else if(score1 == 0 && score2 != 2){
				if(!one && !two && !three){
					button = select(list.getAll());
					four = true;
				}
			}else if(score1 != 2 && score1 == 0){
				if(!one && !two && !three && !four){
					button = select(list.getAll());
					five = true;
				}
			}else{
				if(!one && !two && !three && !four && !five){
					button = select(list.getAll());
				}
			}
		}
		
		return button;
	}
	
	public JButton hard(ArrayList<JButton> horizontal, ArrayList<JButton> vertical){
		JButton button = null;
		boolean one = false;
		boolean two = false;
		boolean three = false;
		boolean four = false;
		boolean five = false;
		ArrayList<NodeList> moveList = scoreGraph.getMoves();
		for(int x = 0; x < moveList.size(); x++){
			NodeList list = moveList.get(x);
			int score1 = list.getScore1();
			int score2 = list.getScore2();
			
			if(score1 == 3 || score2 == 3){
				button = selectHard(list.getAll(), horizontal, vertical);
				one = true;
				break;
			}else if(score1 == 1 && score2 != 2){
				if(!one){
					button = selectHard(list.getAll(), horizontal, vertical);
					two = true;
				}
			}else if(score1 != 2 && score2 == 1){
				if(!one && !two){
					button = selectHard(list.getAll(), horizontal, vertical);
					three = true;
				}
			}else if(score1 == 0 && score2 != 2){
				if(!one && !two && !three){
					button = selectHard(list.getAll(), horizontal, vertical);
					four = true;
				}
			}else if(score1 != 2 && score1 == 0){
				if(!one && !two && !three && !four){
					button = selectHard(list.getAll(), horizontal, vertical);
					five = true;
				}
			}else{
				if(!one && !two && !three && !four && !five){
					button = selectHard(list.getAll(), horizontal, vertical);
				}
			}
		}
		
		return button;
	}
		
	private JButton select(ArrayList<ScoreNode> list){
		JButton button = null;
		int size = list.size();
		int selection = (int) (Math.random() * size);
		button = list.get(selection).getButton();
		
		return button;
	}
	
	private JButton selectHard(ArrayList<ScoreNode> list, ArrayList<JButton> horizontal, ArrayList<JButton> vertical){
		int topScore = -1;
		ArrayList<ScoreNode> topList = new ArrayList<ScoreNode>();
		for(int x = 0; x < list.size(); x++){
			int score1 = list.get(x).getScore1();
			if(score1 == 2){
				score1 = -1;
			}
			int score2 = list.get(x).getScore2();
			if(score2 == 2){
				score2 = -1;
			}
			
			int score = score1 + score2;
			
			if(score > topScore){
				topList = new ArrayList<ScoreNode>();
				topList.add(list.get(x));
				topScore = score;
			}else if(score == topScore){
				topList.add(list.get(x));
			}
		}
		if(topList.size() > 0){
			int size = topList.size();
			int selection = (int) (Math.random() * size);
			return list.get(selection).getButton();
		}
		System.out.println("???");
		return mostEasy(horizontal, vertical);
	}

}
