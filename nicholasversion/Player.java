package nicholasversion;

import java.util.ArrayList;


public class Player {
	///playerType stores what type of player it is.
	///the score is how much score they have gotten in their games total.
	///the round stores how many rounds they have played.
	///recordKeeper stores the game values.
	///final ints are for finding which index has what value in record keeping.
	///TYPENAMES stores what name is associated with each playerType.
	private int playerType;
	private int score;
	private int round;
	public ArrayList<boolean[]> recordKeeper;
	
	private final int THISPLAYER=0,OPPONENT=1;
	
	private final String[] TYPENAMES={"Angel","Devil","TTCoop","TTDefect"};
	
	public Player(int playerType){
		this.playerType=playerType;
		score=0;
		recordKeeper=new ArrayList<boolean[]>();
		round=0;
	}

	public String getTYPENAME(){
		return TYPENAMES[playerType];
	}
	
	/**
	 * depending on what playerType the Player is, the strategy returned is different.
	 * true is cooperate
	 * false is defect.
	 * 0 Angel will always return true
	 * 1 Devil will always return false
	 * 2 TTCoop will return true the first game, then play what his opponent did the previous.
	 * 3 TTDefect will return false the first game, then play what his opponent did the previous.
	 * @return
	 */
	public boolean play(){
		boolean retBool=false;
		
		if(playerType==0){
			retBool=true;
		}
		
		if(playerType==1){
			retBool=false;
		}
		
		if(playerType==2){
			
			if(round==0){
				retBool=true;
			}
			
			else{
				retBool=recordKeeper.get(round-1)[OPPONENT];
			}
		}
		
		if(playerType==3){
			
			if(round==0){
				retBool=false;
			}
			
			else{
				retBool=recordKeeper.get(round-1)[OPPONENT];
			}
		}
		
		return retBool;
	}
	/**
	 * adds a record of game to the recordKeeper.
	 * @param record
	 */
	public void addRecord(boolean[] record){
		recordKeeper.add(record);
	}

	public void addScore(int addition){
		score+=addition;
	}
	
	public void incrementRound(){
		round++;
	}
	
	public void updateInfo(boolean[] record, int addition){
		addRecord(record);
		addScore(addition);
		incrementRound();
	}
	
	public void printScore(){
		System.out.printf("Player type %s Score: %d\n",getTYPENAME(), score);
	}
	
}

