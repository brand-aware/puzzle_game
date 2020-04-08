package common;

import core.ScoreGraph;
import settings.ApplicationSettings;
import utils.CheckScore;
import utils.UpdateGraph;
import utils.UpdateScore;

public class CommonComputer {
	
	protected CheckScore checkScore;
	protected UpdateScore updateScore;
	protected UpdateGraph updateGraph;
	protected ScoreGraph scoreGraph;
	
	protected boolean initialized = false;
	protected ApplicationSettings settings;
	
	protected int width = 0;
	protected int index;
}
